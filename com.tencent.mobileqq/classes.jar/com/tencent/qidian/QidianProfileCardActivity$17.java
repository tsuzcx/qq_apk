package com.tencent.qidian;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class QidianProfileCardActivity$17
  implements ActionSheet.OnButtonClickListener
{
  QidianProfileCardActivity$17(QidianProfileCardActivity paramQidianProfileCardActivity, String paramString) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (this.b.m == 1)
    {
      if (paramInt == 0) {
        this.b.f(this.a);
      } else if (paramInt == 1) {
        this.b.f();
      }
    }
    else if (paramInt == 0) {
      this.b.f(this.a);
    }
    QidianProfileCardActivity.d(this.b).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.17
 * JD-Core Version:    0.7.0.1
 */