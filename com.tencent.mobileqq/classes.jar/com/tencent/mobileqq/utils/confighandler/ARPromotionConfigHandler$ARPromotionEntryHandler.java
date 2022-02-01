package com.tencent.mobileqq.utils.confighandler;

import apgc;
import apgj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;

public class ARPromotionConfigHandler$ARPromotionEntryHandler
  extends NormalConfigHandler<PromotionConfigInfo>
{
  public ARPromotionConfigHandler$ARPromotionEntryHandler(String paramString)
  {
    super(apgj.a + 365, paramString, "config_qq.android.ar_", "config", "ver");
  }
  
  public void onGetConfigFinish(QQAppInterface paramQQAppInterface, String paramString, PromotionConfigInfo paramPromotionConfigInfo)
  {
    apgj.a(paramQQAppInterface).a(paramQQAppInterface, paramString, paramPromotionConfigInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.ARPromotionConfigHandler.ARPromotionEntryHandler
 * JD-Core Version:    0.7.0.1
 */