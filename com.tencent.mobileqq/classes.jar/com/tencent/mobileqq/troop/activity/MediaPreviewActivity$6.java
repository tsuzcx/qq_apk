package com.tencent.mobileqq.troop.activity;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.troop.widget.MediaPreviewAdapter;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class MediaPreviewActivity$6
  implements ActionSheet.OnButtonClickListener
{
  MediaPreviewActivity$6(MediaPreviewActivity paramMediaPreviewActivity, ActionSheet paramActionSheet, URLDrawable paramURLDrawable) {}
  
  public void onClick(View paramView, int paramInt)
  {
    paramView = this.c.e.a(this.c.i);
    String str = this.a.getContent(paramInt);
    if ((this.c.getString(2131890804).equals(str)) && (paramView != null)) {
      this.c.a(this.b, paramView.b);
    } else if (this.c.getString(2131890810).equals(str)) {
      this.c.a(this.b);
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.MediaPreviewActivity.6
 * JD-Core Version:    0.7.0.1
 */