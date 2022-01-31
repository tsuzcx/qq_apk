package com.tencent.mobileqq.utils.confighandler;

import akkf;
import akkm;
import com.tencent.mobileqq.app.QQAppInterface;

public class ARPromotionConfigHandler$ARPromotionResHandler
  extends NormalConfigHandler<DefaultConfigInfo>
{
  public ARPromotionConfigHandler$ARPromotionResHandler(String paramString)
  {
    super(akkm.a + 364, paramString, "res_qq.android.ar_", "config", "ver");
  }
  
  public void onGetConfigFinish(QQAppInterface paramQQAppInterface, String paramString, DefaultConfigInfo paramDefaultConfigInfo)
  {
    akkm.a(paramQQAppInterface).a(paramQQAppInterface, paramString, paramDefaultConfigInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.ARPromotionConfigHandler.ARPromotionResHandler
 * JD-Core Version:    0.7.0.1
 */