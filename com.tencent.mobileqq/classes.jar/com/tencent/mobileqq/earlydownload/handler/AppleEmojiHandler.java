package com.tencent.mobileqq.earlydownload.handler;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.xmldata.AppleEmojiData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class AppleEmojiHandler
  extends EarlyHandler
{
  public AppleEmojiHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.appleemoji", paramQQAppInterface);
  }
  
  public int a()
  {
    return 10001;
  }
  
  public Class<? extends XmlData> a()
  {
    return AppleEmojiData.class;
  }
  
  public String a()
  {
    return "AppleMojiHandler";
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnDownloadSuccess:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AppleMojiHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppleMojiHandler", 2, "doOnDownloadSuccess sorse not exists");
      }
      return;
    }
    ThreadManager.excute(new AppleEmojiHandler.1(this, (File)localObject, paramString), 64, null, true);
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
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.AppleEmojiHandler
 * JD-Core Version:    0.7.0.1
 */