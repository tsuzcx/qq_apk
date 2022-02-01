package com.tencent.mobileqq.profile.stickynote.publish.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.etrump.mixlayout.ETTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.ScrollView;
import com.tencent.widget.XEditTextEx;

class StickyNotePublishFragment$2
  implements View.OnClickListener
{
  StickyNotePublishFragment$2(StickyNotePublishFragment paramStickyNotePublishFragment) {}
  
  public void onClick(View paramView)
  {
    StickyNotePublishFragment.a(this.a).setVisibility(8);
    StickyNotePublishFragment.a(this.a).setVisibility(8);
    StickyNotePublishFragment.a(this.a).setVisibility(8);
    StickyNotePublishFragment.a(this.a).setVisibility(0);
    StickyNotePublishFragment.a(this.a).requestFocus();
    InputMethodUtil.a(StickyNotePublishFragment.a(this.a));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.stickynote.publish.ui.StickyNotePublishFragment.2
 * JD-Core Version:    0.7.0.1
 */