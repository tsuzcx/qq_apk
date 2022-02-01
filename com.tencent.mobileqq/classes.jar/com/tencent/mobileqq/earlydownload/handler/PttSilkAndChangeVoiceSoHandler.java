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
import mqq.app.AppRuntime;

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
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("download success: ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("PttSilkAndChangeVoiceSoHandler", 2, ((StringBuilder)localObject1).toString());
    }
    try
    {
      localObject1 = SilkSoLoader.a();
      StringBuilder localStringBuilder;
      if ((localObject1 != null) && (!((String)localObject1).equals("")))
      {
        FileUtils.deleteDirectory((String)localObject1);
        if (new File((String)localObject1).mkdir())
        {
          FileUtils.uncompressZip(paramString, (String)localObject1, false);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("uncompressZip success: ");
            localStringBuilder.append(paramString);
            QLog.d("PttSilkAndChangeVoiceSoHandler", 2, localStringBuilder.toString());
          }
          try
          {
            if (!SilkSoLoader.a)
            {
              FileUtils.deleteDirectory(SilkSoLoader.b());
              FileUtils.rename((String)localObject1, SilkSoLoader.b());
            }
          }
          finally {}
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("uncompressZip failed: ");
        localStringBuilder.append(localException.getMessage());
        QLog.d("PttSilkAndChangeVoiceSoHandler", 2, localStringBuilder.toString());
      }
      super.a(paramString);
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
    boolean bool = false;
    if (localObject == null) {
      return false;
    }
    int i = VcSystemInfo.getCpuArchitecture();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isUserNeedDownload cpuArch = ");
      localStringBuilder.append(i);
      localStringBuilder.append(" isUserNeedDownload try match version=");
      localStringBuilder.append("8.7.0");
      localStringBuilder.append(" data.version=");
      localStringBuilder.append(((PttSilkAndChangeVoiceSoData)localObject).version);
      QLog.d("PttSilkAndChangeVoiceSoHandler", 2, localStringBuilder.toString());
    }
    localObject = this.a.getPreferences();
    if (!((SharedPreferences)localObject).getBoolean("hasReportedCpuArch", false))
    {
      PttInfoCollector.reportMyCpuArch();
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("hasReportedCpuArch", true);
      ((SharedPreferences.Editor)localObject).commit();
    }
    if (i > 2) {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isUserNeedDownload return ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("PttSilkAndChangeVoiceSoHandler", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.PttSilkAndChangeVoiceSoHandler
 * JD-Core Version:    0.7.0.1
 */