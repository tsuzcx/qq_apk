package com.tencent.mobileqq.utils;

import android.view.View;
import android.view.View.OnClickListener;
import bjnw;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ShareActionSheetBuilder$1
  implements View.OnClickListener
{
  ShareActionSheetBuilder$1(ShareActionSheetBuilder paramShareActionSheetBuilder) {}
  
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
 * Qualified Name:     com.tencent.mobileqq.utils.ShareActionSheetBuilder.1
 * JD-Core Version:    0.7.0.1
 */