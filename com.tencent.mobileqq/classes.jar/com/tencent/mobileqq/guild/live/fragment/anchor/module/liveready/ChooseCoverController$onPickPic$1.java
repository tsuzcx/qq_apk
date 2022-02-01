package com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k=3, mv={1, 1, 16})
final class ChooseCoverController$onPickPic$1
  implements ActionSheet.OnButtonClickListener
{
  ChooseCoverController$onPickPic$1(ChooseCoverController paramChooseCoverController, ActionSheet paramActionSheet) {}
  
  public final void onClick(View paramView, int paramInt)
  {
    paramInt = ChooseCoverController.a(this.a)[paramInt];
    if (paramInt != 13)
    {
      if (paramInt != 14)
      {
        if (paramInt != 16) {}
      }
      else {
        ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).startPhotoListEdit((Activity)ChooseCoverController.c(this.a), ChooseCoverController.d(this.a));
      }
    }
    else {
      ChooseCoverController.b(this.a);
    }
    try
    {
      this.b.dismiss();
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.ChooseCoverController.onPickPic.1
 * JD-Core Version:    0.7.0.1
 */