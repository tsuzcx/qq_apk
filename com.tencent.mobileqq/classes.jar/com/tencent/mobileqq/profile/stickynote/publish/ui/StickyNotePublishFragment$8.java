package com.tencent.mobileqq.profile.stickynote.publish.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StickyNotePublishFragment$8
  implements View.OnClickListener
{
  StickyNotePublishFragment$8(StickyNotePublishFragment paramStickyNotePublishFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.a(1);
    StickyNotePublishFragment.a(this.a).setImageResource(2130837622);
    StickyNotePublishFragment.a(this.a).setContentDescription(this.a.getBaseActivity().getString(2131690247));
    ReportController.b(null, "dc00898", "", "", "0X800AB2D", "0X800AB2D", 0, 0, "0", "0", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment.8
 * JD-Core Version:    0.7.0.1
 */