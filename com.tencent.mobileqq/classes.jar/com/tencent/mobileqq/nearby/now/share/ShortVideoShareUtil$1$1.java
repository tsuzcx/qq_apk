package com.tencent.mobileqq.nearby.now.share;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.INearbyCardManager;

class ShortVideoShareUtil$1$1
  implements IShortVideoShareUtil.OnShareCallBack
{
  ShortVideoShareUtil$1$1(ShortVideoShareUtil.1 param1) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      ThreadManagerV2.excute(new ShortVideoShareUtil.1.1.1(this, (INearbyCardManager)this.a.h.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 16, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.share.ShortVideoShareUtil.1.1
 * JD-Core Version:    0.7.0.1
 */