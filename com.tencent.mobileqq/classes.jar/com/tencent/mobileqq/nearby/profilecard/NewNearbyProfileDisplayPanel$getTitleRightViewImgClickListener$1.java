package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class NewNearbyProfileDisplayPanel$getTitleRightViewImgClickListener$1
  implements View.OnClickListener
{
  NewNearbyProfileDisplayPanel$getTitleRightViewImgClickListener$1(NewNearbyProfileDisplayPanel paramNewNearbyProfileDisplayPanel) {}
  
  public final void onClick(View paramView)
  {
    paramView = ActionSheet.create((Context)this.a.e);
    paramView.addButton(2131914943, 1);
    if (this.a.T) {
      paramView.addButton(2131894141, 1);
    }
    paramView.addCancelButton(2131887648);
    paramView.setOnButtonClickListener((ActionSheet.OnButtonClickListener)new NewNearbyProfileDisplayPanel.getTitleRightViewImgClickListener.1.1(this, paramView));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NewNearbyProfileDisplayPanel.getTitleRightViewImgClickListener.1
 * JD-Core Version:    0.7.0.1
 */