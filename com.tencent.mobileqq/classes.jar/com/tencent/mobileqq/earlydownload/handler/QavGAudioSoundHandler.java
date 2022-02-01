package com.tencent.mobileqq.earlydownload.handler;

import com.tencent.av.utils.GAudioSoundUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.xmldata.QavGAudioSoundData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class QavGAudioSoundHandler
  extends EarlyHandler
{
  public QavGAudioSoundHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.qav.muteaudio", paramQQAppInterface);
  }
  
  public int a()
  {
    return 10046;
  }
  
  public Class<? extends XmlData> a()
  {
    return QavGAudioSoundData.class;
  }
  
  public String a()
  {
    return "qavDownloadGAudioSoundDuration";
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QavGAudioSoundHandler", 2, "download success: " + paramString);
    }
    try
    {
      FileUtils.a(paramString, GAudioSoundUtil.a(), false);
      super.a(paramString);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QavGAudioSoundData localQavGAudioSoundData = (QavGAudioSoundData)a();
    if ((localQavGAudioSoundData != null) && (!localQavGAudioSoundData.autoDownload))
    {
      localQavGAudioSoundData.autoDownload = true;
      EarlyDataFactory.a(localQavGAudioSoundData, new String[] { "autoDownload" });
    }
    super.a(paramBoolean);
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
    QavGAudioSoundData localQavGAudioSoundData = (QavGAudioSoundData)a();
    if (localQavGAudioSoundData == null) {
      return super.h();
    }
    return localQavGAudioSoundData.autoDownload;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.QavGAudioSoundHandler
 * JD-Core Version:    0.7.0.1
 */