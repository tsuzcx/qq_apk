package com.tencent.mobileqq.utils.confighandler;

import akyq;
import akyx;
import com.tencent.mobileqq.app.QQAppInterface;

public class ARPromotionConfigHandler$ARPromotionResHandler
  extends NormalConfigHandler<DefaultConfigInfo>
{
  public ARPromotionConfigHandler$ARPromotionResHandler(String paramString)
  {
    super(akyx.a + 364, paramString, "res_qq.android.ar_", "config", "ver");
  }
  
  public void onGetConfigFinish(QQAppInterface paramQQAppInterface, String paramString, DefaultConfigInfo paramDefaultConfigInfo)
  {
    akyx.a(paramQQAppInterface).a(paramQQAppInterface, paramString, paramDefaultConfigInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.ARPromotionConfigHandler.ARPromotionResHandler
 * JD-Core Version:    0.7.0.1
 */