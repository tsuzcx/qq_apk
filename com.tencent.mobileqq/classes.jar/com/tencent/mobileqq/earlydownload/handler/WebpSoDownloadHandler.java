package com.tencent.mobileqq.earlydownload.handler;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.WebpSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class WebpSoDownloadHandler
  extends EarlyHandler
{
  QQAppInterface h = null;
  
  public WebpSoDownloadHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.pic.webp.so", paramQQAppInterface);
    this.h = paramQQAppInterface;
  }
  
  public Class<? extends XmlData> a()
  {
    return WebpSoData.class;
  }
  
  public void a(String paramString)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onDownload success: ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("QWebpSoDownloadHandler", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = WebpSoLoader.a(BaseApplicationImpl.getContext());
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        FileUtils.uncompressZip(paramString, (String)localObject, false);
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWebpSoDownloadHandler", 2, localException.getMessage());
      }
    }
    super.a(paramString);
  }
  
  public String b()
  {
    return "QWebpSoDownloadDuration";
  }
  
  public int c()
  {
    return 10056;
  }
  
  public String d()
  {
    return null;
  }
  
  public boolean e()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.WebpSoDownloadHandler
 * JD-Core Version:    0.7.0.1
 */