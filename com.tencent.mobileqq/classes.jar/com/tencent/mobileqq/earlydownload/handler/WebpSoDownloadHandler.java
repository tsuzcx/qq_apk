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
  QQAppInterface a = null;
  
  public WebpSoDownloadHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.pic.webp.so", paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  public int a()
  {
    return 10056;
  }
  
  public Class<? extends XmlData> a()
  {
    return WebpSoData.class;
  }
  
  public String a()
  {
    return "QWebpSoDownloadDuration";
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
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.WebpSoDownloadHandler
 * JD-Core Version:    0.7.0.1
 */