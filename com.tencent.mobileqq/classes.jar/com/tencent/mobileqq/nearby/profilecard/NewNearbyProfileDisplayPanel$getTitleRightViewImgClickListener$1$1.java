package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "clickedView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k=3, mv={1, 1, 16})
final class NewNearbyProfileDisplayPanel$getTitleRightViewImgClickListener$1$1
  implements ActionSheet.OnButtonClickListener
{
  NewNearbyProfileDisplayPanel$getTitleRightViewImgClickListener$1$1(NewNearbyProfileDisplayPanel.getTitleRightViewImgClickListener.1 param1, ActionSheet paramActionSheet) {}
  
  public final void onClick(View paramView, int paramInt)
  {
    if ((this.a.a.T) && (paramInt == 1))
    {
      paramView = NewNearbyProfileDisplayPanel.c(this.a.a);
      if (paramView != null)
      {
        paramView.setVisibility(0);
        this.a.a.onClick(paramView);
      }
      this.b.dismiss();
      return;
    }
    this.a.a.a(this.b, paramView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NewNearbyProfileDisplayPanel.getTitleRightViewImgClickListener.1.1
 * JD-Core Version:    0.7.0.1
 */