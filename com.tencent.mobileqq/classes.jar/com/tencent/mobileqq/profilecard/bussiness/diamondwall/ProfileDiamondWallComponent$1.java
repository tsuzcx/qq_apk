package com.tencent.mobileqq.profilecard.bussiness.diamondwall;

import QQService.PrivilegeInfo;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ProfileDiamondWallComponent$1
  implements View.OnClickListener
{
  ProfileDiamondWallComponent$1(ProfileDiamondWallComponent paramProfileDiamondWallComponent) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 instanceof DataTag))
    {
      localObject1 = (DataTag)localObject1;
      int i = ((DataTag)localObject1).a;
      Object localObject2;
      if (i != 26)
      {
        if (i == 93) {
          if (!(((DataTag)localObject1).b instanceof PrivilegeInfo))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("DATA_TYPE_BIG_DIAMOND url is not string:");
            ((StringBuilder)localObject2).append(((DataTag)localObject1).b);
            QLog.e("DIYProfileTemplate.ProfileDiamondWallComponent", 1, ((StringBuilder)localObject2).toString());
          }
          else
          {
            localObject2 = (PrivilegeInfo)((DataTag)localObject1).b;
            localObject1 = ((PrivilegeInfo)localObject2).strJumpUrl;
            Intent localIntent = new Intent(ProfileDiamondWallComponent.access$1300(this.this$0), QQBrowserActivity.class);
            localIntent.putExtra("url", (String)localObject1);
            localIntent.putExtra("hide_operation_bar", true);
            localIntent.putExtra("hide_more_button", true);
            localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
            ProfileDiamondWallComponent.access$1400(this.this$0).startActivity(localIntent);
            if (QLog.isColorLevel()) {
              QLog.d("DIYProfileTemplate.ProfileDiamondWallComponent", 1, "DATA_TYPE_BIG_DIAMOND click");
            }
            if (((ProfileCardInfo)ProfileDiamondWallComponent.access$1500(this.this$0)).allInOne.pa == 0) {
              i = 1;
            } else {
              i = 0;
            }
            int j = ((PrivilegeInfo)localObject2).iType;
            if (j != 1) {
              if (j != 102) {
                if (j != 113) {
                  if (i != 0) {
                    localObject1 = "0X800A137";
                  } else {
                    localObject1 = "0X800A12F";
                  }
                }
              }
            }
            for (;;)
            {
              break;
              if (i != 0)
              {
                localObject1 = "0X800A131";
              }
              else
              {
                localObject1 = "0X800A129";
                continue;
                if (i != 0)
                {
                  localObject1 = "0X800A135";
                }
                else
                {
                  localObject1 = "0X800A12D";
                  continue;
                  if (i != 0) {
                    localObject1 = "0X800A133";
                  } else {
                    localObject1 = "0X800A12B";
                  }
                }
              }
            }
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              if (((PrivilegeInfo)localObject2).iIsBig == 1)
              {
                if (((PrivilegeInfo)localObject2).isOpen) {
                  i = 1;
                } else {
                  i = 2;
                }
              }
              else if (((PrivilegeInfo)localObject2).isOpen) {
                i = 3;
              } else {
                i = 4;
              }
              if (((PrivilegeInfo)localObject2).iType == 1)
              {
                j = VipInfoHandler.a(ProfileDiamondWallComponent.access$1600(this.this$0), ProfileDiamondWallComponent.access$1700(this.this$0).getCurrentUin(), false);
                if ((AnimatorHandler.playing) && (ProfileDiamondWallComponent.access$1800(this.this$0, ((PrivilegeInfo)localObject2).iRemindTime, ((PrivilegeInfo)localObject2).iType))) {
                  ProfileDiamondWallComponent.access$1900(this.this$0, "0X800B27E", j);
                } else if (AnimatorHandler.playing) {
                  ProfileDiamondWallComponent.access$1900(this.this$0, "0X800B27C", j);
                }
                localObject2 = String.valueOf(j);
              }
              else
              {
                localObject2 = "";
              }
              ReportController.b(ProfileDiamondWallComponent.access$2000(this.this$0), "dc00898", "", "", "qvip", (String)localObject1, i, 0, (String)localObject2, "", "", "");
            }
          }
        }
      }
      else
      {
        localObject2 = ((ProfileCardInfo)ProfileDiamondWallComponent.access$000(this.this$0)).card.privilegeJumpUrl;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          if (((ProfileCardInfo)ProfileDiamondWallComponent.access$100(this.this$0)).allInOne.pa == 0)
          {
            localObject1 = "https://mc.vip.qq.com/privilegelist/index";
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("https://mc.vip.qq.com/privilegelist/other?friend=");
            ((StringBuilder)localObject1).append(((ProfileCardInfo)ProfileDiamondWallComponent.access$200(this.this$0)).allInOne.uin);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
        localObject2 = new Intent(ProfileDiamondWallComponent.access$300(this.this$0), QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        ((Intent)localObject2).putExtra("hide_operation_bar", true);
        ((Intent)localObject2).putExtra("hide_more_button", true);
        ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
        ProfileDiamondWallComponent.access$400(this.this$0).startActivity((Intent)localObject2);
        ReportController.b(ProfileDiamondWallComponent.access$500(this.this$0), "P_CliOper", "Pb_account_lifeservice", "", "ziliaoka_qqtequan", "tab-click", 0, 1, 0, "", "", "", "");
        if (((ProfileCardInfo)ProfileDiamondWallComponent.access$600(this.this$0)).allInOne.pa == 0)
        {
          ReportController.b(ProfileDiamondWallComponent.access$700(this.this$0), "CliOper", "", "", "0X8006A7B", "0X8006A7B", 0, 0, "", "", "", "");
          ReportController.b(ProfileDiamondWallComponent.access$800(this.this$0), "dc00898", "", "", "qvip", "0X800A12F", 0, 0, "", "", "", "");
        }
        else
        {
          ReportController.b(ProfileDiamondWallComponent.access$900(this.this$0), "CliOper", "", "", "0X8006A8F", "0X8006A8F", 0, 0, "", "", "", "");
          i = VipInfoHandler.a(ProfileDiamondWallComponent.access$1000(this.this$0), ProfileDiamondWallComponent.access$1100(this.this$0).getCurrentUin(), false);
          ReportController.b(ProfileDiamondWallComponent.access$1200(this.this$0), "dc00898", "", "", "qvip", "0X800A137", 0, 0, String.valueOf(i), "", "", "");
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.diamondwall.ProfileDiamondWallComponent.1
 * JD-Core Version:    0.7.0.1
 */