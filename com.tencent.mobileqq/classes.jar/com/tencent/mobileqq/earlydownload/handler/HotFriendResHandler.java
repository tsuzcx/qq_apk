package com.tencent.mobileqq.earlydownload.handler;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.xmldata.HotFriendResData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.mutualmark.oldlogic.HotReactiveHelper;
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
  
  public Class<? extends XmlData> a()
  {
    return HotFriendResData.class;
  }
  
  public void a(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doOnDownloadSuccess:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("HotFriendResHandler", 2, ((StringBuilder)localObject).toString());
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
      localObject = HotReactiveHelper.c();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doOnDownloadSuccess imagePath=");
        localStringBuilder.append((String)localObject);
        QLog.d("HotFriendResHandler", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        FileUtils.uncompressZip(paramString, (String)localObject, false);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    super.a(paramString);
  }
  
  public String b()
  {
    return "HotFriendResHandler";
  }
  
  public int c()
  {
    return 10042;
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
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.HotFriendResHandler
 * JD-Core Version:    0.7.0.1
 */