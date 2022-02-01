package com.tencent.mobileqq.profilecard.base.container;

import android.view.View;
import com.tencent.av.utils.VideoActionSheet;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.Arrays;

class ProfileBottomContainer$8
  implements ActionSheet.OnButtonClickListener
{
  ProfileBottomContainer$8(ProfileBottomContainer paramProfileBottomContainer, int[] paramArrayOfInt, VideoActionSheet paramVideoActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = this.val$showItems[paramInt];
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("videoActionSheet onClick,showItems =  ");
      paramView.append(Arrays.toString(this.val$showItems));
      paramView.append(",which = ");
      paramView.append(paramInt);
      paramView.append(",item = ");
      paramView.append(i);
      QLog.d("ProfileBottomContainer", 2, paramView.toString());
    }
    this.val$videoActionSheet.dismiss();
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      paramView = new SessionInfo();
      paramView.jdField_a_of_type_Int = ProfileCardUtil.a(((ProfileCardInfo)ProfileBottomContainer.access$2800(this.this$0)).allInOne);
      paramView.jdField_a_of_type_JavaLangString = ((ProfileCardInfo)ProfileBottomContainer.access$2900(this.this$0)).allInOne.uin;
      paramView.d = ProfileBottomContainer.access$3100((ProfileCardInfo)ProfileBottomContainer.access$3000(this.this$0), this.this$0.mQQAppInterface);
      paramView.b = ((ProfileCardInfo)ProfileBottomContainer.access$3200(this.this$0)).allInOne.troopUin;
      PlusPanelUtils.a(this.this$0.mQQAppInterface, ProfileBottomContainer.access$3300(this.this$0), paramView, false, null, null);
      ReportController.b(ProfileBottomContainer.access$3400(this.this$0), "CliOper", "", "", "0X80085D6", "0X80085D6", 9, 0, "", "", "", "");
      return;
    }
    ProfileBottomContainer.enterAudioCall(this.this$0.mQQAppInterface, ProfileBottomContainer.access$2500(this.this$0), (ProfileCardInfo)ProfileBottomContainer.access$2600(this.this$0));
    ReportController.b(ProfileBottomContainer.access$2700(this.this$0), "CliOper", "", "", "0X8008405", "0X8008405", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileBottomContainer.8
 * JD-Core Version:    0.7.0.1
 */