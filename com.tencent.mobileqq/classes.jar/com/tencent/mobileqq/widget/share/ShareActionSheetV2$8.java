package com.tencent.mobileqq.widget.share;

import android.view.View;
import android.view.View.OnClickListener;
import bkzi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ShareActionSheetV2$8
  implements View.OnClickListener
{
  ShareActionSheetV2$8(ShareActionSheetV2 paramShareActionSheetV2) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.mDialog.isShowing())
    {
      this.this$0.mDialog.cancel();
      this.this$0.mDialog.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2.8
 * JD-Core Version:    0.7.0.1
 */