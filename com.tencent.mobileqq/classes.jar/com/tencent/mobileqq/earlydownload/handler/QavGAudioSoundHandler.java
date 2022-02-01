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
  
  public Class<? extends XmlData> a()
  {
    return QavGAudioSoundData.class;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download success: ");
      localStringBuilder.append(paramString);
      QLog.d("QavGAudioSoundHandler", 2, localStringBuilder.toString());
    }
    try
    {
      FileUtils.uncompressZip(paramString, GAudioSoundUtil.a(), false);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    super.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    QavGAudioSoundData localQavGAudioSoundData = (QavGAudioSoundData)h();
    if ((localQavGAudioSoundData != null) && (!localQavGAudioSoundData.autoDownload))
    {
      localQavGAudioSoundData.autoDownload = true;
      EarlyDataFactory.a(localQavGAudioSoundData, new String[] { "autoDownload" });
    }
    super.a(paramBoolean);
  }
  
  public String b()
  {
    return "qavDownloadGAudioSoundDuration";
  }
  
  public int c()
  {
    return 10046;
  }
  
  public String d()
  {
    return null;
  }
  
  public boolean e()
  {
    return true;
  }
  
  public boolean v()
  {
    QavGAudioSoundData localQavGAudioSoundData = (QavGAudioSoundData)h();
    if (localQavGAudioSoundData == null) {
      return super.v();
    }
    return localQavGAudioSoundData.autoDownload;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.QavGAudioSoundHandler
 * JD-Core Version:    0.7.0.1
 */