package com.tencent.mobileqq.kandian.biz.feeds.activity;

import android.app.Activity;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.mobileqq.kandian.biz.skin.GuideData;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinGuideView;

class ReadInJoyNewFeedsActivity$5
  implements Runnable
{
  ReadInJoyNewFeedsActivity$5(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity, GuideData paramGuideData, String paramString, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.k == null)
    {
      FrameLayout localFrameLayout = (FrameLayout)this.this$0.getActivity().getWindow().getDecorView();
      ReadInJoyNewFeedsActivity localReadInJoyNewFeedsActivity = this.this$0;
      localReadInJoyNewFeedsActivity.k = new ReadInJoySkinGuideView(0, localReadInJoyNewFeedsActivity, localReadInJoyNewFeedsActivity.app, this.a.id, this.b, this.c, new ReadInJoyNewFeedsActivity.5.1(this, localFrameLayout), new ReadInJoyNewFeedsActivity.5.2(this, localFrameLayout));
      if (this.this$0.r() == 0)
      {
        localFrameLayout.addView(this.this$0.k, -1, -1);
        return;
      }
      ReadInJoyNewFeedsActivity.a(this.this$0, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity.5
 * JD-Core Version:    0.7.0.1
 */