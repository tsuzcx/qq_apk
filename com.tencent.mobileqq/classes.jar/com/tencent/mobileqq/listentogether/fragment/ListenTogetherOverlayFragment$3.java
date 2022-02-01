package com.tencent.mobileqq.listentogether.fragment;

import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.listentogether.ListenTogetherUtils;
import com.tencent.mobileqq.listentogether.lyrics.FloatParams;
import com.tencent.mobileqq.listentogether.lyrics.LyricsController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ListenTogetherOverlayFragment$3
  implements ActionSheet.OnButtonClickListener
{
  ListenTogetherOverlayFragment$3(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment, boolean paramBoolean, LyricsController paramLyricsController) {}
  
  public void onClick(View paramView, int paramInt)
  {
    ListenTogetherOverlayFragment.b(this.c).dismiss();
    if (this.a)
    {
      if (paramInt != 0)
      {
        if (paramInt == 1) {
          this.b.i();
        }
      }
      else {
        ListenTogetherUtils.a(ListenTogetherOverlayFragment.a(this.c), this.b.l().m, this.b.l().n);
      }
    }
    else {
      this.b.i();
    }
    this.b.b(false);
    if (!ListenTogetherOverlayFragment.a(this.c).isFinishing()) {
      ListenTogetherOverlayFragment.a(this.c).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment.3
 * JD-Core Version:    0.7.0.1
 */