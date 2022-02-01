package com.tencent.mobileqq.teamworkforgroup;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;

class BaseMenuCloudFileItemBuilder$3
  implements ActionSheet.OnButtonClickListener
{
  BaseMenuCloudFileItemBuilder$3(BaseMenuCloudFileItemBuilder paramBaseMenuCloudFileItemBuilder, List paramList, ICloudFile paramICloudFile, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt < this.a.size())
    {
      paramView = (MenuItem)this.a.get(paramInt);
      if (BaseMenuCloudFileItemBuilder.a(this.d) != null) {
        BaseMenuCloudFileItemBuilder.a(this.d).a(paramView.b(), this.b);
      }
      this.c.dismiss();
      return;
    }
    this.c.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.BaseMenuCloudFileItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */