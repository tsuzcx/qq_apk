package com.tencent.mobileqq.earlydownload.handler;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.PttSilkAndChangeVoiceSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.qqaudio.silk.SilkSoLoader;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class PttSilkAndChangeVoiceSoHandler
  extends EarlyHandler
{
  public PttSilkAndChangeVoiceSoHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.ptt.so.658", paramQQAppInterface);
  }
  
  public int a()
  {
    return 10007;
  }
  
  public Class<? extends XmlData> a()
  {
    return PttSilkAndChangeVoiceSoData.class;
  }
  
  public String a()
  {
    return "actEarlyPttSilkAndChangeVoiceSo";
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PttSilkAndChangeVoiceSoHandler", 2, "download success: " + paramString);
    }
    for (;;)
    {
      try
      {
        str = SilkSoLoader.a();
        if ((str != null) && (!str.equals("")))
        {
          FileUtils.a(str);
          if (new File(str).mkdir())
          {
            FileUtils.a(paramString, str, false);
            if (QLog.isColorLevel()) {
              QLog.d("PttSilkAndChangeVoiceSoHandler", 2, "uncompressZip success: " + paramString);
            }
          }
        }
      }
      catch (Exception localException)
      {
        String str;
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PttSilkAndChangeVoiceSoHandler", 2, "uncompressZip failed: " + localException.getMessage());
        continue;
      }
      try
      {
        if (!SilkSoLoader.a)
        {
          FileUtils.a(SilkSoLoader.b());
          FileUtils.c(str, SilkSoLoader.b());
        }
        super.a(paramString);
        return;
      }
      finally {}
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return null;
  }
  
  public boolean h()
  {
    Object localObject = (PttSilkAndChangeVoiceSoData)a();
    if (localObject == null) {
      return false;
    }
    int i = VcSystemInfo.getCpuArchitecture();
    if (QLog.isColorLevel()) {
      QLog.d("PttSilkAndChangeVoiceSoHandler", 2, "isUserNeedDownload cpuArch = " + i + " isUserNeedDownload try match version=" + "8.5.5" + " data.version=" + ((PttSilkAndChangeVoiceSoData)localObject).version);
    }
    localObject = this.a.getPreferences();
    if (!((SharedPreferences)localObject).getBoolean("hasReportedCpuArch", false))
    {
      PttInfoCollector.reportMyCpuArch();
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("hasReportedCpuArch", true);
      ((SharedPreferences.Editor)localObject).commit();
    }
    if (i > 2) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PttSilkAndChangeVoiceSoHandler", 2, "isUserNeedDownload return " + bool);
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.PttSilkAndChangeVoiceSoHandler
 * JD-Core Version:    0.7.0.1
 */