package com.tencent.mobileqq.listentogether.lyrics;

import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.listentogether.ListenTogetherUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class LyricsController$10
  implements ActionSheet.OnButtonClickListener
{
  LyricsController$10(LyricsController paramLyricsController, ActionSheet paramActionSheet, boolean paramBoolean) {}
  
  public void onClick(View paramView, int paramInt)
  {
    this.a.dismiss();
    if (this.b)
    {
      if (paramInt != 0)
      {
        if (paramInt == 1) {
          this.c.i();
        }
      }
      else {
        ListenTogetherUtils.a(BaseActivity.sTopActivity, this.c.l().m, this.c.l().n);
      }
    }
    else {
      this.c.i();
    }
    this.c.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.LyricsController.10
 * JD-Core Version:    0.7.0.1
 */