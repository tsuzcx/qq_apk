package com.tencent.mobileqq.profilecard.base.component;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AbsProfileHeaderComponent$4
  implements ActionSheet.OnButtonClickListener
{
  AbsProfileHeaderComponent$4(AbsProfileHeaderComponent paramAbsProfileHeaderComponent, String paramString1, String paramString2, int paramInt, boolean paramBoolean, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((paramInt == 0) && (AbsProfileHeaderComponent.access$700(this.this$0) != null))
    {
      paramView = new Intent(AbsProfileHeaderComponent.access$800(this.this$0), EditInfoActivity.class);
      paramView.putExtra("title", this.val$tipsTemp);
      paramView.putExtra("default_text", this.val$strDefault);
      paramView.putExtra("uin", ((ProfileCardInfo)AbsProfileHeaderComponent.access$900(this.this$0)).jdField_a_of_type_ComTencentMobileqqDataCard.uin);
      paramView.putExtra("edit_action", this.val$editAction);
      paramView.putExtra("max_limit_mode", 1);
      paramView.putExtra("edit_type", 2);
      if (!this.val$isEditTroopCardTemp) {
        break label169;
      }
      paramView.putExtra("max_num", 60);
      paramView.putExtra("isTroopNick", true);
      paramView.putExtra("troopUin", ((ProfileCardInfo)AbsProfileHeaderComponent.access$1000(this.this$0)).jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      AbsProfileHeaderComponent.access$1100(this.this$0).startActivityForResult(paramView, 1034);
      this.val$actionSheet.dismiss();
      return;
      label169:
      paramInt = 36;
      if (this.val$editAction == 2) {
        paramInt = 60;
      }
      paramView.putExtra("max_num", paramInt);
      paramView.putExtra("support_emotion", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.component.AbsProfileHeaderComponent.4
 * JD-Core Version:    0.7.0.1
 */