package com.tencent.mobileqq.widget.share;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class ShareActionSheetV2$8
  implements View.OnClickListener
{
  ShareActionSheetV2$8(ShareActionSheetV2 paramShareActionSheetV2) {}
  
  public void onClick(View paramView)
  {
    if (this.a.c.isShowing())
    {
      this.a.c.cancel();
      this.a.c.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2.8
 * JD-Core Version:    0.7.0.1
 */