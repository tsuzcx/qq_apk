package com.tencent.mobileqq.minigame.ui;

import NS_COMM.COMM.StCommonExt;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniGamePayFragment
  extends PublicBaseFragment
{
  public static final String MINI_EVENT_NAME = "mini_event_name";
  public static final String MINI_EVENT_SEQ = "mini_event_seq";
  public static final String MINI_RESPONSE_STR = "mini_response_str";
  public static final int PAY_CHANNEL_WECHAT = 8;
  public static final int PAY_INVOKER_RECHARGE_GAME_CURRENCY = 6;
  public static final String TAG = "PayJsPlugin_in_MiniGamePayFragment";
  AppInterface app;
  MiniGamePayFragment.PayResultRecevicer payRecevicer;
  
  private void handleNativeResponse(String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("mini_response_str", paramString2);
    localIntent.putExtra("mini_event_name", paramString1);
    localIntent.putExtra("mini_event_seq", paramInt);
    paramString1 = getBaseActivity();
    if (paramString1 != null)
    {
      paramString1.setResult(-1, localIntent);
      paramString1.finish();
    }
  }
  
  public void invokeMidasConsume(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, COMM.StCommonExt paramStCommonExt, String paramString3, int paramInt5, int paramInt6)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invokeMidasConsume prepayId= ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" starCurrency=");
    localStringBuilder.append(String.valueOf(paramInt1));
    QLog.d("PayJsPlugin_in_MiniGamePayFragment", 1, localStringBuilder.toString());
    if ((!TextUtils.isEmpty(paramString2)) && (paramInt1 > 0) && (!TextUtils.isEmpty(paramString1)))
    {
      MiniAppCmdUtil.getInstance().getMidasConsumeResult(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt6, paramStCommonExt, new MiniGamePayFragment.2(this, paramString3, paramInt5));
      return;
    }
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("resultCode", -4);
      paramString1.put("resultMsg", HardCodeUtil.a(2131706873));
      paramString1 = paramString1.toString();
      if (paramString1 != null)
      {
        handleNativeResponse(paramString3, paramString1, paramInt5);
        return;
      }
    }
    catch (JSONException paramString1)
    {
      QLog.e("PayJsPlugin_in_MiniGamePayFragment", 1, "invokeMidasConsume JSONException ", paramString1);
    }
  }
  
  public void invokeMidasQuery(String paramString1, String paramString2, int paramInt1, COMM.StCommonExt paramStCommonExt, String paramString3, int paramInt2, int paramInt3, int paramInt4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invokeMidasQuery prepayId= ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" starCurrency=");
    localStringBuilder.append(String.valueOf(paramInt1));
    localStringBuilder.append(" setEnv:");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(" payChannel:");
    localStringBuilder.append(paramInt4);
    QLog.d("PayJsPlugin_in_MiniGamePayFragment", 1, localStringBuilder.toString());
    if ((!TextUtils.isEmpty(paramString1)) && (paramInt1 > 0) && (!TextUtils.isEmpty(paramString2)))
    {
      MiniAppCmdUtil.getInstance().getMidasQueryResult(paramString1, paramString2, paramInt1, paramInt3, paramStCommonExt, new MiniGamePayFragment.1(this, paramString3, paramInt2, paramString2, paramString1, paramInt1, paramInt4, paramStCommonExt, paramInt3));
      return;
    }
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("resultCode", 1000);
      paramString1.put("errMsg", HardCodeUtil.a(2131706878));
      paramString1 = paramString1.toString();
      if (paramString1 != null) {
        try
        {
          handleNativeResponse(paramString3, paramString1, paramInt2);
          return;
        }
        catch (JSONException paramString1) {}
      } else {
        return;
      }
    }
    catch (JSONException paramString1)
    {
      QLog.e("PayJsPlugin_in_MiniGamePayFragment", 1, "invokeMidasQuery JSONException ", paramString1);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.d("PayJsPlugin_in_MiniGamePayFragment", 1, "MiniGamePayFragment onCreateView");
    paramLayoutInflater = getArguments();
    if (paramLayoutInflater != null)
    {
      this.payRecevicer = new MiniGamePayFragment.PayResultRecevicer(this, new Handler(Looper.getMainLooper()));
      this.app = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
      int i = PayBridgeActivity.newPay(this.app, getBaseActivity(), this.payRecevicer, 6, paramLayoutInflater).getInt("retCode", -1);
      int j = paramLayoutInflater.getInt("mini_event_seq", -1);
      paramViewGroup = paramLayoutInflater.getString("mini_event_name");
      if (i != 0)
      {
        paramLayoutInflater = ApiUtil.wrapCallbackFail(paramViewGroup, null);
        if (paramLayoutInflater != null) {
          paramLayoutInflater = paramLayoutInflater.toString();
        } else {
          paramLayoutInflater = "";
        }
        if (paramLayoutInflater != null)
        {
          handleNativeResponse(paramViewGroup, paramLayoutInflater, j);
          return null;
        }
      }
    }
    else
    {
      paramLayoutInflater = getBaseActivity();
      if (paramLayoutInflater != null)
      {
        paramLayoutInflater.setResult(0, null);
        paramLayoutInflater.finish();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.MiniGamePayFragment
 * JD-Core Version:    0.7.0.1
 */