package com.tencent.mobileqq.listentogether.fragment;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.listentogether.lyrics.LyricsController;
import com.tencent.widget.ActionSheet.OnDismissListener;

class ListenTogetherOverlayFragment$1
  implements ActionSheet.OnDismissListener
{
  ListenTogetherOverlayFragment$1(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment, LyricsController paramLyricsController) {}
  
  public void onDismiss()
  {
    this.a.b(false);
    if (!ListenTogetherOverlayFragment.a(this.b).isFinishing()) {
      ListenTogetherOverlayFragment.a(this.b).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment.1
 * JD-Core Version:    0.7.0.1
 */