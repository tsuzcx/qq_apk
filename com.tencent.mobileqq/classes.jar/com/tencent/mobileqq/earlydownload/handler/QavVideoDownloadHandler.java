package com.tencent.mobileqq.earlydownload.handler;

import com.tencent.av.utils.ImageResUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.xmldata.QavVideoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class QavVideoDownloadHandler
  extends EarlyHandler
{
  public QavVideoDownloadHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.qav.video", paramQQAppInterface);
  }
  
  public Class<? extends XmlData> a()
  {
    return QavVideoData.class;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download success: ");
      localStringBuilder.append(paramString);
      QLog.d("QavVideoDownloadHandler", 2, localStringBuilder.toString());
    }
    try
    {
      FileUtils.uncompressZip(paramString, ImageResUtil.b(), false);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QavVideoData localQavVideoData = (QavVideoData)h();
    if ((localQavVideoData != null) && (!localQavVideoData.autoDownload))
    {
      localQavVideoData.autoDownload = true;
      EarlyDataFactory.a(localQavVideoData, new String[] { "autoDownload" });
    }
    super.a(paramBoolean);
  }
  
  public String b()
  {
    return "qavDownloadVideoDuration";
  }
  
  public int c()
  {
    return 10049;
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
    return ((QavVideoData)h()).autoDownload;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.QavVideoDownloadHandler
 * JD-Core Version:    0.7.0.1
 */