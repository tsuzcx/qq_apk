package com.tencent.mobileqq.utils;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class ShareWithPictureActionSheetBuilder$1
  implements View.OnClickListener
{
  ShareWithPictureActionSheetBuilder$1(ShareWithPictureActionSheetBuilder paramShareWithPictureActionSheetBuilder) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareWithPictureActionSheetBuilder.1
 * JD-Core Version:    0.7.0.1
 */