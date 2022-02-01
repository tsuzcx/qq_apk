package com.tencent.qqmini.sdk.launcher.core.proxy;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

public abstract class PayProxy
{
  public static final String MINI_EVENT_NAME = "mini_event_name";
  public static final String MINI_EVENT_SEQ = "mini_event_seq";
  public static final String MINI_RESPONSE_STR = "mini_response_str";
  
  public static String getPayStateMsg(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case -1: 
      return "支付状态未知";
    case 0: 
      return "支付成功";
    case 1: 
      return "用户取消";
    }
    return "支付出错";
  }
  
  public static String getResultCodeMsg(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return "";
    case -1: 
      return "支付流程失败";
    case 0: 
      return "支付流程成功";
    case 2: 
      return "用户取消";
    }
    return "参数错误";
  }
  
  public void callJs(String paramString, View paramView) {}
  
  public View getPayForFriendView(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    return null;
  }
  
  public abstract Bundle midasPay(Activity paramActivity, String paramString, PayProxy.IPayResultCallBack paramIPayResultCallBack, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy
 * JD-Core Version:    0.7.0.1
 */