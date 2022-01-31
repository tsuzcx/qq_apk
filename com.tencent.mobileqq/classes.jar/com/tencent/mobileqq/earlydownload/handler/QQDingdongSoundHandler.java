package com.tencent.mobileqq.earlydownload.handler;

import com.tencent.av.utils.DingdongSoundUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.xmldata.QQDingdongSoundData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class QQDingdongSoundHandler
  extends EarlyHandler
{
  public QQDingdongSoundHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.dingdong.ring", paramQQAppInterface);
  }
  
  public int a()
  {
    return 10050;
  }
  
  public Class a()
  {
    return QQDingdongSoundData.class;
  }
  
  public String a()
  {
    return "dingdongDownloadAudioSoundDuration";
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQDingdongSoundHandler", 2, "download success: " + paramString);
    }
    try
    {
      FileUtils.a(paramString, DingdongSoundUtil.a(), false);
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
    QQDingdongSoundData localQQDingdongSoundData = (QQDingdongSoundData)a();
    if ((localQQDingdongSoundData != null) && (!localQQDingdongSoundData.autoDownload))
    {
      localQQDingdongSoundData.autoDownload = true;
      EarlyDataFactory.a(localQQDingdongSoundData, new String[] { "autoDownload" });
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
  
  public boolean i()
  {
    QQDingdongSoundData localQQDingdongSoundData = (QQDingdongSoundData)a();
    if (localQQDingdongSoundData == null) {
      return super.i();
    }
    return localQQDingdongSoundData.autoDownload;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.QQDingdongSoundHandler
 * JD-Core Version:    0.7.0.1
 */