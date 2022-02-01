package com.tencent.mobileqq.kandian.biz.fastweb;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.widget.BubblePopupWindow;

class ReadInJoyFastWebBottomSocialView$5
  implements Runnable
{
  ReadInJoyFastWebBottomSocialView$5(ReadInJoyFastWebBottomSocialView paramReadInJoyFastWebBottomSocialView) {}
  
  public void run()
  {
    Context localContext = ReadInJoyFastWebBottomSocialView.a(this.this$0).getContentView().getContext();
    if (((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing())) {
      ReadInJoyFastWebBottomSocialView.a(this.this$0).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.ReadInJoyFastWebBottomSocialView.5
 * JD-Core Version:    0.7.0.1
 */