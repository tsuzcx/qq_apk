package com.tencent.mobileqq.profile.stickynote.publish.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StickyNotePublishFragment$7
  implements View.OnClickListener
{
  StickyNotePublishFragment$7(StickyNotePublishFragment paramStickyNotePublishFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.a(0);
    this.a.b(false);
    StickyNotePublishFragment.g(this.a).setImageResource(2130846244);
    StickyNotePublishFragment.g(this.a).setContentDescription(this.a.getBaseActivity().getString(2131887157));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment.7
 * JD-Core Version:    0.7.0.1
 */