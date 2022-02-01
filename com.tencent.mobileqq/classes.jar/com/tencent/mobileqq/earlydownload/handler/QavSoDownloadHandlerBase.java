package com.tencent.mobileqq.earlydownload.handler;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.QavSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;

public abstract class QavSoDownloadHandlerBase
  extends EarlyHandler
{
  public QavSoDownloadHandlerBase(String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramString, paramQQAppInterface);
  }
  
  public static boolean a(Context paramContext, Boolean paramBoolean)
  {
    if (VcSystemInfo.getCpuArchitecture() <= 2) {
      return (a(paramContext, "traeimp-armeabi")) && (a(paramContext, "TcVpxDec-armeabi")) && (a(paramContext, "TcVpxEnc-armeabi"));
    }
    return true;
  }
  
  @TargetApi(9)
  public static boolean a(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 9)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext.getApplicationInfo().nativeLibraryDir);
      ((StringBuilder)localObject).append("/");
      paramContext = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext.getApplicationInfo().dataDir);
      ((StringBuilder)localObject).append("/lib/");
      paramContext = ((StringBuilder)localObject).toString();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext);
    ((StringBuilder)localObject).append(AVSoUtils.a(paramString));
    paramContext = new File(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AVSoUtils.b());
    ((StringBuilder)localObject).append(AVSoUtils.a(paramString));
    localObject = new File(((StringBuilder)localObject).toString());
    if ((!paramContext.exists()) && (!((File)localObject).exists()))
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("fail to find so:");
        paramContext.append(paramString);
        QLog.e("QavSoDownloadHandlerBase", 2, paramContext.toString());
      }
      return false;
    }
    return true;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("func doOnServerResp begins, respData");
      localStringBuilder.append(paramXmlData);
      QLog.d("QavSoDownloadHandlerBase", 2, localStringBuilder.toString());
    }
    if ((paramXmlData != null) && ((paramXmlData instanceof QavSoData)))
    {
      super.a(paramXmlData);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QavSoDownloadHandlerBase", 2, "func doOnServerResp ends. respData is not QavSoData");
    }
    super.a(paramXmlData);
  }
  
  public void a(String paramString)
  {
    XmlData localXmlData = a();
    if (localXmlData != null)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("QAVSOMD5__");
      ((StringBuilder)localObject2).append(localXmlData.getSharedPreferencesName());
      String str = ((StringBuilder)localObject2).toString();
      SharedPreferences localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0);
      Object localObject3 = localSharedPreferences.getString(str, null);
      localObject2 = MD5Utils.encodeFileHexStr(paramString);
      Object localObject1;
      if ((!TextUtils.isEmpty(localXmlData.MD5)) && (localXmlData.MD5.equalsIgnoreCase((String)localObject2)))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("download success: ");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append((String)localObject3);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(localXmlData.MD5);
        ((StringBuilder)localObject2).append("|");
        ((StringBuilder)localObject2).append(localXmlData);
        QLog.d("QavSoDownloadHandlerBase", 1, ((StringBuilder)localObject2).toString());
        if (((!TextUtils.isEmpty(localXmlData.MD5)) && (!localXmlData.MD5.equalsIgnoreCase((String)localObject3))) || (!a(this.a.getApp().getApplicationContext(), Boolean.valueOf(true))))
        {
          try
          {
            FileUtils.uncompressZip(paramString, AVSoUtils.b(), false);
            localSharedPreferences.edit().putString(str, localXmlData.MD5).commit();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("uncompressZip success: ");
            ((StringBuilder)localObject2).append(paramString);
            ((StringBuilder)localObject2).append("|");
            ((StringBuilder)localObject2).append((String)localObject3);
            ((StringBuilder)localObject2).append("|");
            ((StringBuilder)localObject2).append(localXmlData.MD5);
            ((StringBuilder)localObject2).append("|");
            ((StringBuilder)localObject2).append(localXmlData);
            QLog.d("QavSoDownloadHandlerBase", 1, ((StringBuilder)localObject2).toString());
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            QLog.e("QavSoDownloadHandlerBase", 1, "uncompressZip qavso failed.");
            localObject1 = new File(paramString);
            if (!((File)localObject1).exists()) {
              break label446;
            }
          }
          ((File)localObject1).delete();
        }
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("download success but check md5 failed. config zip file md5 = ");
        if (!TextUtils.isEmpty(((XmlData)localObject1).MD5)) {
          localObject1 = ((XmlData)localObject1).MD5;
        } else {
          localObject1 = "null";
        }
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(", realZipFileMd5 = ");
        ((StringBuilder)localObject3).append((String)localObject2);
        QLog.e("QavSoDownloadHandlerBase", 1, ((StringBuilder)localObject3).toString());
        paramString = new File(paramString);
        if (paramString.exists()) {
          paramString.delete();
        }
        return;
      }
    }
    label446:
    super.a(paramString);
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.QavSoDownloadHandlerBase
 * JD-Core Version:    0.7.0.1
 */