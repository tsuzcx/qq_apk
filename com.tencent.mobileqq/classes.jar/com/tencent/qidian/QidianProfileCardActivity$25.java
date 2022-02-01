package com.tencent.qidian;

import android.text.TextUtils;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class QidianProfileCardActivity$25
  implements ActionSheet.OnButtonClickListener
{
  QidianProfileCardActivity$25(QidianProfileCardActivity paramQidianProfileCardActivity, ActionSheet paramActionSheet, URLDrawable paramURLDrawable, String paramString) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramView == null)
    {
      this.a.dismiss();
      return;
    }
    paramView = this.a.getContent(paramInt);
    if (TextUtils.isEmpty(paramView))
    {
      this.a.dismiss();
      return;
    }
    if (paramView.equals(this.d.getString(2131890804)))
    {
      QidianProfileCardActivity.a(this.d, this.b);
      return;
    }
    if (paramView.equals(this.d.getString(2131890810)))
    {
      QidianProfileCardActivity.b(this.d, this.b);
      return;
    }
    if (paramView.equals(this.d.getString(2131896249))) {
      QidianProfileCardActivity.c(this.d, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.25
 * JD-Core Version:    0.7.0.1
 */