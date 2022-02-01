package com.tencent.mobileqq.utils.confighandler;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionMgr;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionUtil;

public class ARPromotionConfigHandler$ARPromotionEntryHandler
  extends NormalConfigHandler<PromotionConfigInfo>
{
  public ARPromotionConfigHandler$ARPromotionEntryHandler(String paramString)
  {
    super(localStringBuilder.toString(), paramString, "config_qq.android.ar_", "config", "ver");
  }
  
  public void onGetConfigFinish(QQAppInterface paramQQAppInterface, String paramString, PromotionConfigInfo paramPromotionConfigInfo)
  {
    PromotionUtil.b(paramQQAppInterface).a(paramQQAppInterface, paramString, paramPromotionConfigInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.ARPromotionConfigHandler.ARPromotionEntryHandler
 * JD-Core Version:    0.7.0.1
 */