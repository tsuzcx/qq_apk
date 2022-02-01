package com.tencent.mobileqq.earlydownload.handler;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QavSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public abstract class QavSoDownloadHandlerBase
  extends EarlyHandler
{
  public QavSoDownloadHandlerBase(String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramString, paramQQAppInterface);
  }
  
  public static boolean a(Context paramContext, Boolean paramBoolean)
  {
    return (VcSystemInfo.getCpuArchitecture() > 2) || ((a(paramContext, "traeimp-armeabi")) && (a(paramContext, "TcVpxDec-armeabi")) && (a(paramContext, "TcVpxEnc-armeabi")));
  }
  
  @TargetApi(9)
  public static boolean a(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 9) {}
    for (paramContext = paramContext.getApplicationInfo().nativeLibraryDir + "/";; paramContext = paramContext.getApplicationInfo().dataDir + "/lib/")
    {
      paramContext = new File(paramContext + AVSoUtils.a(paramString));
      File localFile = new File(AVSoUtils.b() + AVSoUtils.a(paramString));
      if ((!paramContext.exists()) && (!localFile.exists())) {
        break;
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.e("QavSoDownloadHandlerBase", 2, "fail to find so:" + paramString);
    }
    return false;
  }
  
  public int a()
  {
    return 10048;
  }
  
  public String a()
  {
    return "qavDownloadSoDuration";
  }
  
  public void a(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavSoDownloadHandlerBase", 2, "func doOnServerResp begins, respData" + paramXmlData);
    }
    if ((paramXmlData == null) || (!(paramXmlData instanceof QavSoData)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavSoDownloadHandlerBase", 2, "func doOnServerResp ends. respData is not QavSoData");
      }
      super.a(paramXmlData);
      return;
    }
    super.a(paramXmlData);
  }
  
  public void a(String paramString)
  {
    Object localObject1 = a();
    Object localObject2;
    SharedPreferences localSharedPreferences;
    String str2;
    if (localObject1 != null)
    {
      localObject2 = "QAVSOMD5__" + ((XmlData)localObject1).getSharedPreferencesName();
      localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0);
      str2 = localSharedPreferences.getString((String)localObject2, null);
      String str1 = MD5Utils.encodeFileHexStr(paramString);
      if ((TextUtils.isEmpty(((XmlData)localObject1).MD5)) || (!((XmlData)localObject1).MD5.equalsIgnoreCase(str1)))
      {
        localObject2 = new StringBuilder().append("download success but check md5 failed. config zip file md5 = ");
        if (!TextUtils.isEmpty(((XmlData)localObject1).MD5)) {}
        for (localObject1 = ((XmlData)localObject1).MD5;; localObject1 = "null")
        {
          QLog.e("QavSoDownloadHandlerBase", 1, (String)localObject1 + ", realZipFileMd5 = " + str1);
          paramString = new File(paramString);
          if (paramString.exists()) {
            paramString.delete();
          }
          return;
        }
      }
      QLog.d("QavSoDownloadHandlerBase", 1, "download success: " + paramString + "|" + str2 + "|" + ((XmlData)localObject1).MD5 + "|" + localObject1);
      if (((TextUtils.isEmpty(((XmlData)localObject1).MD5)) || (((XmlData)localObject1).MD5.equalsIgnoreCase(str2))) && (a(this.a.getApp().getApplicationContext(), Boolean.valueOf(true)))) {}
    }
    try
    {
      FileUtils.a(paramString, AVSoUtils.b(), false);
      localSharedPreferences.edit().putString((String)localObject2, ((XmlData)localObject1).MD5).commit();
      QLog.d("QavSoDownloadHandlerBase", 1, "uncompressZip success: " + paramString + "|" + str2 + "|" + ((XmlData)localObject1).MD5 + "|" + localObject1);
      super.a(paramString);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        QLog.e("QavSoDownloadHandlerBase", 1, "uncompressZip qavso failed.");
        File localFile = new File(paramString);
        if (localFile.exists()) {
          localFile.delete();
        }
      }
    }
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.QavSoDownloadHandlerBase
 * JD-Core Version:    0.7.0.1
 */