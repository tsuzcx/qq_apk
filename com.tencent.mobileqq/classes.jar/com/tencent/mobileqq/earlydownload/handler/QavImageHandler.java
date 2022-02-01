package com.tencent.mobileqq.earlydownload.handler;

import com.tencent.av.utils.ImageResUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.xmldata.QavImageData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class QavImageHandler
  extends EarlyHandler
{
  QQAppInterface h = null;
  
  public QavImageHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.qav.image2", paramQQAppInterface);
    this.h = paramQQAppInterface;
  }
  
  public Class<? extends XmlData> a()
  {
    return QavImageData.class;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download success: ");
      localStringBuilder.append(paramString);
      QLog.d("QavImageHandler", 2, localStringBuilder.toString());
    }
    try
    {
      FileUtils.uncompressZip(paramString, ImageResUtil.a(), false);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    super.a(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    QavImageData localQavImageData = (QavImageData)h();
    if ((localQavImageData != null) && (!localQavImageData.autoDownload))
    {
      localQavImageData.autoDownload = true;
      EarlyDataFactory.a(localQavImageData, new String[] { "autoDownload" });
    }
    super.a(paramBoolean);
  }
  
  public String b()
  {
    return "qavDownloadImageDuration";
  }
  
  public int c()
  {
    return 10047;
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
    return ((QavImageData)h()).autoDownload;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.QavImageHandler
 * JD-Core Version:    0.7.0.1
 */