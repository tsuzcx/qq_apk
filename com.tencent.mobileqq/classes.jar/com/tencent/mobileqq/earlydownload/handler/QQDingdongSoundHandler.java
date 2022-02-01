package com.tencent.mobileqq.earlydownload.handler;

import com.tencent.av.utils.DingdongSoundUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.xmldata.QQDingdongSoundData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class QQDingdongSoundHandler
  extends EarlyHandler
{
  public QQDingdongSoundHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.dingdong.ring", paramQQAppInterface);
  }
  
  public Class<? extends XmlData> a()
  {
    return QQDingdongSoundData.class;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download success: ");
      localStringBuilder.append(paramString);
      QLog.d("QQDingdongSoundHandler", 2, localStringBuilder.toString());
    }
    try
    {
      FileUtils.uncompressZip(paramString, DingdongSoundUtil.a(), false);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    super.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    QQDingdongSoundData localQQDingdongSoundData = (QQDingdongSoundData)h();
    if ((localQQDingdongSoundData != null) && (!localQQDingdongSoundData.autoDownload))
    {
      localQQDingdongSoundData.autoDownload = true;
      EarlyDataFactory.a(localQQDingdongSoundData, new String[] { "autoDownload" });
    }
    super.a(paramBoolean);
  }
  
  public String b()
  {
    return "dingdongDownloadAudioSoundDuration";
  }
  
  public int c()
  {
    return 10050;
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
    QQDingdongSoundData localQQDingdongSoundData = (QQDingdongSoundData)h();
    if (localQQDingdongSoundData == null) {
      return super.v();
    }
    return localQQDingdongSoundData.autoDownload;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.QQDingdongSoundHandler
 * JD-Core Version:    0.7.0.1
 */