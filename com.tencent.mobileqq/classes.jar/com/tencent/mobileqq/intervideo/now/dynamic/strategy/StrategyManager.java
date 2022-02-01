package com.tencent.mobileqq.intervideo.now.dynamic.strategy;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.lite_now_biz.config.NowBizConfigManager;

public class StrategyManager
{
  private IEnterRoomStrategy a;
  private KanDianStrategy b;
  private NowLiteStrategy c;
  private NowDefaultStrategy d;
  private NowBizConfigManager e;
  
  private IEnterRoomStrategy a(QQAppInterface paramQQAppInterface)
  {
    if (this.b == null) {
      this.b = new KanDianStrategy(paramQQAppInterface);
    }
    return this.b;
  }
  
  public static StrategyManager a()
  {
    return StrategyManager.HOLDER.a();
  }
  
  private boolean a(Bundle paramBundle)
  {
    if ("1014".equals(paramBundle.getString("appid"))) {
      return true;
    }
    paramBundle = paramBundle.getString("fromid");
    if (TextUtils.isEmpty(paramBundle)) {
      return false;
    }
    String str = paramBundle.toLowerCase();
    paramBundle = str;
    if (str.startsWith("share_msg_")) {
      paramBundle = str.substring(10);
    }
    if (!paramBundle.startsWith("kandian_")) {
      return (paramBundle.compareTo("3000") >= 0) && (paramBundle.compareTo("5999") <= 0);
    }
    return true;
  }
  
  private IEnterRoomStrategy b(QQAppInterface paramQQAppInterface)
  {
    if (this.c == null) {
      this.c = new NowLiteStrategy(paramQQAppInterface);
    }
    return this.c;
  }
  
  private boolean b(Bundle paramBundle)
  {
    if (this.e == null) {
      this.e = NowBizConfigManager.a();
    }
    return this.e.a(paramBundle);
  }
  
  private IEnterRoomStrategy c()
  {
    if (this.d == null) {
      this.d = new NowDefaultStrategy();
    }
    return this.d;
  }
  
  public IEnterRoomStrategy a(Bundle paramBundle, QQAppInterface paramQQAppInterface)
  {
    if (a(paramBundle)) {
      this.a = a(paramQQAppInterface);
    } else if (b(paramBundle)) {
      this.a = b(paramQQAppInterface);
    } else {
      this.a = c();
    }
    return this.a;
  }
  
  public void b()
  {
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.strategy.StrategyManager
 * JD-Core Version:    0.7.0.1
 */