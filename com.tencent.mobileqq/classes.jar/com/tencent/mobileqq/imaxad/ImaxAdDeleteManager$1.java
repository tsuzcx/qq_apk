package com.tencent.mobileqq.imaxad;

import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.mobileqq.app.QQAppInterface;

class ImaxAdDeleteManager$1
  implements Runnable
{
  ImaxAdDeleteManager$1(ImaxAdDeleteManager paramImaxAdDeleteManager, AdvertisementItem paramAdvertisementItem, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    AdvertisementItem localAdvertisementItem2 = this.a;
    AdvertisementItem localAdvertisementItem1 = localAdvertisementItem2;
    if (localAdvertisementItem2 == null) {
      localAdvertisementItem1 = AdvertisementItem.a(ImaxAdUtil.d(this.b.getCurrentUin(), this.c));
    }
    ImaxAdDeleteManager.a(this.b.getCurrentUin(), localAdvertisementItem1, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdDeleteManager.1
 * JD-Core Version:    0.7.0.1
 */