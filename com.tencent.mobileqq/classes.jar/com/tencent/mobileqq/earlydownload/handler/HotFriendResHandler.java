package com.tencent.mobileqq.earlydownload.handler;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.HotReactiveHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.HotFriendResData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class HotFriendResHandler
  extends EarlyHandler
{
  public HotFriendResHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.hotfriend.res", paramQQAppInterface);
  }
  
  public int a()
  {
    return 10042;
  }
  
  public Class a()
  {
    return HotFriendResData.class;
  }
  
  public String a()
  {
    return "HotFriendResHandler";
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotFriendResHandler", 2, "doOnDownloadSuccess:" + paramString);
    }
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotFriendResHandler", 2, "doOnDownloadSuccess sorse not exists");
      }
      return;
    }
    try
    {
      String str = HotReactiveHelper.a();
      if (QLog.isColorLevel()) {
        QLog.d("HotFriendResHandler", 2, "doOnDownloadSuccess imagePath=" + str);
      }
      if (!TextUtils.isEmpty(str)) {
        FileUtils.a(paramString, str, false);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.HotFriendResHandler
 * JD-Core Version:    0.7.0.1
 */