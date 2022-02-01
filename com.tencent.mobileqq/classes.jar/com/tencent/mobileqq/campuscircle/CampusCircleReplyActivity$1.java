package com.tencent.mobileqq.campuscircle;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CampusCircleReplyActivity$1
  implements CompoundButton.OnCheckedChangeListener
{
  CampusCircleReplyActivity$1(CampusCircleReplyActivity paramCampusCircleReplyActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = this.a.getResources();
    TextView localTextView = CampusCircleReplyActivity.a(this.a);
    if (paramBoolean) {}
    for (localObject = ((Resources)localObject).getColorStateList(2131166362);; localObject = ((Resources)localObject).getColorStateList(2131166364))
    {
      localTextView.setTextColor((ColorStateList)localObject);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusCircleReplyActivity.1
 * JD-Core Version:    0.7.0.1
 */