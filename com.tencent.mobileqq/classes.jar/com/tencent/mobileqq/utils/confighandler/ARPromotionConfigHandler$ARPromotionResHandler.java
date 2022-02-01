package com.tencent.mobileqq.utils.confighandler;

import aosm;
import aost;
import com.tencent.mobileqq.app.QQAppInterface;

public class ARPromotionConfigHandler$ARPromotionResHandler
  extends NormalConfigHandler<DefaultConfigInfo>
{
  public ARPromotionConfigHandler$ARPromotionResHandler(String paramString)
  {
    super(aost.a + 364, paramString, "res_qq.android.ar_", "config", "ver");
  }
  
  public void onGetConfigFinish(QQAppInterface paramQQAppInterface, String paramString, DefaultConfigInfo paramDefaultConfigInfo)
  {
    aost.a(paramQQAppInterface).a(paramQQAppInterface, paramString, paramDefaultConfigInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.ARPromotionConfigHandler.ARPromotionResHandler
 * JD-Core Version:    0.7.0.1
 */