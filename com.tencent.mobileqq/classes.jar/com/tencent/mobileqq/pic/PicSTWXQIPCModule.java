package com.tencent.mobileqq.pic;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class PicSTWXQIPCModule
  extends QIPCModule
{
  private static volatile PicSTWXQIPCModule a;
  
  public PicSTWXQIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static PicSTWXQIPCModule a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new PicSTWXQIPCModule("PicSTWXQIPCModule");
        }
      }
      finally {}
    }
    return a;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCall, action = ");
      localStringBuilder.append(paramString);
      QLog.d("PicSTWXQIPCModule", 2, localStringBuilder.toString());
    }
    paramString = paramBundle.getString("param_pic_path", "");
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PicSTWXQIPCModule", 2, "path is empty");
      }
      return null;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCall, path = ");
      localStringBuilder.append(paramString);
      QLog.d("PicSTWXQIPCModule", 2, localStringBuilder.toString());
    }
    int i = paramBundle.getInt("param_from_type", 0);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCall, fromType = ");
      paramBundle.append(i);
      QLog.d("PicSTWXQIPCModule", 2, paramBundle.toString());
    }
    paramBundle = BaseApplicationImpl.getApplication().getRuntime();
    if (!(paramBundle instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PicSTWXQIPCModule", 2, "cannot get QQAppInterface.");
      }
      return null;
    }
    paramBundle = (QQAppInterface)paramBundle;
    PicShareToWX.a().a(this, paramInt, paramBundle, paramString, i);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicSTWXQIPCModule
 * JD-Core Version:    0.7.0.1
 */