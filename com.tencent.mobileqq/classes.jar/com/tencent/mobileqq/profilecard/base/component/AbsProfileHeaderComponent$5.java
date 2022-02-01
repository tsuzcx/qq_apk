package com.tencent.mobileqq.profilecard.base.component;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AbsProfileHeaderComponent$5
  implements ActionSheet.OnButtonClickListener
{
  AbsProfileHeaderComponent$5(AbsProfileHeaderComponent paramAbsProfileHeaderComponent, String paramString1, String paramString2, int paramInt, boolean paramBoolean, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((paramInt == 0) && (AbsProfileHeaderComponent.access$1200(this.this$0) != null))
    {
      paramView = new Intent();
      paramView.putExtra("title", this.val$tipsTemp);
      paramView.putExtra("default_text", this.val$strDefault);
      paramView.putExtra("uin", ((ProfileCardInfo)AbsProfileHeaderComponent.access$1300(this.this$0)).card.uin);
      paramView.putExtra("edit_type", this.val$editAction);
      paramView.putExtra("max_limit_mode", 1);
      paramView.putExtra("edit_mode", 2);
      if (this.val$isEditTroopCardTemp)
      {
        paramView.putExtra("max_num", 60);
        paramView.putExtra("troopUin", ((ProfileCardInfo)AbsProfileHeaderComponent.access$1400(this.this$0)).troopUin);
      }
      else
      {
        paramInt = 36;
        if (this.val$editAction == 4) {
          paramInt = 60;
        }
        paramView.putExtra("max_num", paramInt);
      }
      RouteUtils.a(AbsProfileHeaderComponent.access$1500(this.this$0), paramView, "/base/activity/editInfoActivity", 1034);
    }
    this.val$actionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent.5
 * JD-Core Version:    0.7.0.1
 */