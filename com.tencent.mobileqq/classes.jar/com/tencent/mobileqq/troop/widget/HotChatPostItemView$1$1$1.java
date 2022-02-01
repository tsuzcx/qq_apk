package com.tencent.mobileqq.troop.widget;

import android.graphics.Bitmap;
import android.util.Pair;
import android.widget.ImageView;

class HotChatPostItemView$1$1$1
  implements Runnable
{
  HotChatPostItemView$1$1$1(HotChatPostItemView.1.1 param1, Pair paramPair) {}
  
  public void run()
  {
    if ((this.b.this$0.a.getTag() instanceof String))
    {
      String str = (String)this.b.this$0.a.getTag();
      if ((this.a != null) && (str.endsWith(this.b.this$0.e)))
      {
        this.b.this$0.a.setImageBitmap((Bitmap)this.a.first);
        HotChatPostItemView.a(this.b.this$0.e, (Bitmap)this.a.first);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.HotChatPostItemView.1.1.1
 * JD-Core Version:    0.7.0.1
 */