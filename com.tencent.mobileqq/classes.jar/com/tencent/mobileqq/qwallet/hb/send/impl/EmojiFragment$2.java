package com.tencent.mobileqq.qwallet.hb.send.impl;

import com.qwallet.temp.IQWalletApiProxy;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRoute;

class EmojiFragment$2
  implements Runnable
{
  EmojiFragment$2(EmojiFragment paramEmojiFragment, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    ((IQWalletApiProxy)QRoute.api(IQWalletApiProxy.class)).decodeDrawable(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.impl.EmojiFragment.2
 * JD-Core Version:    0.7.0.1
 */