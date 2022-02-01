package com.tencent.mobileqq.troop.widget;

import android.util.Pair;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.freshnews.feed.NearbyImgLoader;
import java.util.HashMap;
import java.util.Queue;
import mqq.os.MqqHandler;

class HotChatPostItemView$1$1
  implements Runnable
{
  HotChatPostItemView$1$1(HotChatPostItemView.1 param1) {}
  
  public void run()
  {
    if (((this.this$0.a.getTag() instanceof String)) && (!((String)this.this$0.a.getTag()).endsWith(this.this$0.e))) {
      return;
    }
    try
    {
      localPair = NearbyImgLoader.a().a(null, HotChatPostItemView.a(this.this$0.f), 1);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Pair localPair;
      label65:
      break label65;
    }
    HotChatPostItemView.o.clear();
    HotChatPostItemView.n.clear();
    localPair = NearbyImgLoader.a().a(null, HotChatPostItemView.a(this.this$0.f), 1);
    ThreadManager.getUIHandler().post(new HotChatPostItemView.1.1.1(this, localPair));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.HotChatPostItemView.1.1
 * JD-Core Version:    0.7.0.1
 */