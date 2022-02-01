package com.tencent.mobileqq.weiyun.api.impl;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.qphone.base.util.QLog;

public class WeiyunResponseHandlerImpl
  implements IWeiyunResponseHandler
{
  private static final String TAG = "ResponseHandler";
  private static final int TIMEOUT = 60000;
  private static WeiyunResponseHandlerImpl.TimeOutHandler mHandler = new WeiyunResponseHandlerImpl.TimeOutHandler(Looper.getMainLooper());
  private static volatile int sErrorCode;
  private static volatile String sFriendUin;
  private static volatile int sIsTroop;
  private static volatile String sSenderUin;
  private static volatile int sWeiyunRequestCounter;
  
  private void sendShowGrayMsg(AppInterface paramAppInterface)
  {
    Message localMessage = mHandler.obtainMessage();
    localMessage.what = 1;
    localMessage.obj = paramAppInterface;
    mHandler.sendMessageDelayed(localMessage, 1000L);
  }
  
  public boolean endSave2Weiyun(int paramInt)
  {
    try
    {
      if ((needShowGrayTips(paramInt)) && (!isSpaceOverErrorCode(sErrorCode))) {
        sErrorCode = paramInt;
      }
      if (sWeiyunRequestCounter == 0)
      {
        mHandler.removeMessages(0);
        return true;
      }
      sWeiyunRequestCounter -= 1;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("end count=");
      localStringBuilder.append(sWeiyunRequestCounter);
      QLog.d("ResponseHandler", 2, localStringBuilder.toString());
      if (sWeiyunRequestCounter <= 0)
      {
        mHandler.removeMessages(0);
        sWeiyunRequestCounter = 0;
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public String getErrorMsg(Context paramContext)
  {
    try
    {
      if (sErrorCode == 1127)
      {
        paramContext = paramContext.getString(2131892177);
        return paramContext;
      }
      if (sErrorCode == 22000)
      {
        paramContext = paramContext.getString(2131892177);
        return paramContext;
      }
      if ((sErrorCode != 1053) && (sErrorCode != -20001))
      {
        if (sErrorCode == 22081)
        {
          paramContext = paramContext.getString(2131917938);
          return paramContext;
        }
        if (sErrorCode == 22121)
        {
          paramContext = paramContext.getString(2131916949);
          return paramContext;
        }
        return null;
      }
      paramContext = paramContext.getString(2131892178);
      return paramContext;
    }
    finally {}
  }
  
  public boolean isAllRequestFinished()
  {
    try
    {
      int i = sWeiyunRequestCounter;
      return i == 0;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isFlowOverErrorCode(int paramInt)
  {
    return (paramInt == 1127) || (paramInt == 22000);
  }
  
  public boolean isSpaceOverErrorCode(int paramInt)
  {
    return (paramInt == 1053) || (paramInt == 22081) || (paramInt == 22121) || (sErrorCode == -20001);
  }
  
  public boolean needShowGrayTips()
  {
    return needShowGrayTips(sErrorCode);
  }
  
  public boolean needShowGrayTips(int paramInt)
  {
    return (!TextUtils.isEmpty(sFriendUin)) && (!TextUtils.isEmpty(sSenderUin)) && ((isFlowOverErrorCode(paramInt)) || (isSpaceOverErrorCode(paramInt)));
  }
  
  void reset()
  {
    sFriendUin = null;
    sSenderUin = null;
    sIsTroop = 0;
    sErrorCode = 0;
  }
  
  public void setRequestData(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      sFriendUin = paramString1;
      sSenderUin = paramString2;
      sIsTroop = paramInt;
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void showGrayTips(AppInterface paramAppInterface)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sFriendUin =");
      localStringBuilder.append(sFriendUin);
      localStringBuilder.append(";  sSenderUin=");
      localStringBuilder.append(sSenderUin);
      QLog.d("ResponseHandler", 2, localStringBuilder.toString());
      if ((!TextUtils.isEmpty(sFriendUin)) && (!TextUtils.isEmpty(sSenderUin))) {
        sendShowGrayMsg(paramAppInterface);
      }
      return;
    }
    finally
    {
      paramAppInterface = finally;
      throw paramAppInterface;
    }
  }
  
  public void startSave2Weiyun()
  {
    try
    {
      sWeiyunRequestCounter += 1;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start count=");
      localStringBuilder.append(sWeiyunRequestCounter);
      QLog.d("ResponseHandler", 2, localStringBuilder.toString());
      mHandler.removeMessages(0);
      mHandler.sendEmptyMessageDelayed(0, 60000L);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.impl.WeiyunResponseHandlerImpl
 * JD-Core Version:    0.7.0.1
 */