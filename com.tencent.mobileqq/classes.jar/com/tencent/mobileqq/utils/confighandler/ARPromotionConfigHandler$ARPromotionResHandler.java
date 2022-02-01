package com.tencent.mobileqq.utils.confighandler;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionMgr;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionUtil;

public class ARPromotionConfigHandler$ARPromotionResHandler
  extends NormalConfigHandler<DefaultConfigInfo>
{
  public ARPromotionConfigHandler$ARPromotionResHandler(String paramString)
  {
    super(localStringBuilder.toString(), paramString, "res_qq.android.ar_", "config", "ver");
  }
  
  public void onGetConfigFinish(QQAppInterface paramQQAppInterface, String paramString, DefaultConfigInfo paramDefaultConfigInfo)
  {
    PromotionUtil.a(paramQQAppInterface).a(paramQQAppInterface, paramString, paramDefaultConfigInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.ARPromotionConfigHandler.ARPromotionResHandler
 * JD-Core Version:    0.7.0.1
 */