package com.tencent.mobileqq.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;

public class WXPayHelper
  implements IWXAPIEventHandler
{
  private static final byte[] a = new byte[0];
  private static WXPayHelper b = null;
  private final String c = "wxf0a80d0ac2e82aa7";
  private final IWXAPI d = WXAPIFactory.createWXAPI(BaseApplication.getContext(), this.c, true);
  private final ArrayList<Handler> e = new ArrayList(1);
  
  public static WXPayHelper getInstance()
  {
    if (b == null) {
      synchronized (a)
      {
        if (b == null) {
          b = new WXPayHelper();
        }
      }
    }
    return b;
  }
  
  public void addObserver(Handler paramHandler)
  {
    synchronized (this.e)
    {
      if (!this.e.contains(paramHandler)) {
        this.e.add(paramHandler);
      }
      return;
    }
  }
  
  public int getWXAppSupportAPI()
  {
    return this.d.getWXAppSupportAPI();
  }
  
  public void handleIntent(Intent paramIntent)
  {
    this.d.handleIntent(paramIntent, this);
  }
  
  public boolean isWXinstalled()
  {
    return this.d.isWXAppInstalled();
  }
  
  public boolean isWXsupportApi()
  {
    return this.d.getWXAppSupportAPI() >= 553779201;
  }
  
  public boolean isWXsupportPayApi()
  {
    return this.d.getWXAppSupportAPI() >= 570425345;
  }
  
  public void onReq(BaseReq paramBaseReq) {}
  
  public void onResp(BaseResp paramBaseResp)
  {
    synchronized (this.e)
    {
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
      {
        Handler localHandler = (Handler)localIterator.next();
        Message localMessage = new Message();
        localMessage.what = 10;
        Bundle localBundle = new Bundle();
        localBundle.putInt("errCode", paramBaseResp.errCode);
        localBundle.putString("errStr", paramBaseResp.errStr);
        localBundle.putString("openId", paramBaseResp.openId);
        localBundle.putString("transaction", paramBaseResp.transaction);
        localMessage.setData(localBundle);
        localHandler.sendMessage(localMessage);
      }
      return;
    }
    for (;;)
    {
      throw paramBaseResp;
    }
  }
  
  public void registerApp()
  {
    this.d.registerApp(this.c);
  }
  
  public void registerApp(String paramString)
  {
    this.d.registerApp(paramString);
  }
  
  public void removeObserver(Handler paramHandler)
  {
    synchronized (this.e)
    {
      this.e.remove(paramHandler);
      return;
    }
  }
  
  public void sendReq(Bundle paramBundle)
  {
    PayReq localPayReq = new PayReq();
    String str2 = paramBundle.getString("appid");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.c;
    }
    localPayReq.appId = str1;
    localPayReq.partnerId = paramBundle.getString("partnerid");
    localPayReq.prepayId = paramBundle.getString("prepayid");
    localPayReq.nonceStr = paramBundle.getString("noncestr");
    localPayReq.timeStamp = paramBundle.getString("timestamp");
    localPayReq.packageValue = paramBundle.getString("package");
    localPayReq.sign = paramBundle.getString("sign");
    this.d.sendReq(localPayReq);
  }
  
  public void unRegisterApp()
  {
    this.d.unregisterApp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wxapi.WXPayHelper
 * JD-Core Version:    0.7.0.1
 */