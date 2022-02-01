package com.tencent.mobileqq.selectmember;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.av.share.api.IShareChatApi;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.transaction.IToPayManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppActivity;

class SelectMemberActivity$6
  implements View.OnClickListener
{
  SelectMemberActivity$6(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this.a.mIntent;
    int k = 0;
    Object localObject2;
    Object localObject3;
    if (((Intent)localObject1).getBooleanExtra("show_invite_entry", false))
    {
      localObject1 = (IShareChatApi)QRoute.api(IShareChatApi.class);
      localObject2 = (BaseQQAppInterface)this.a.app;
      localObject3 = this.a;
      ((IShareChatApi)localObject1).share((BaseQQAppInterface)localObject2, (QBaseActivity)localObject3, paramView, ((SelectMemberActivity)localObject3).mIntent);
    }
    else
    {
      if (this.a.mEntrance == 11) {
        if (this.a.mInnerFrameManager.getCurrentPage() == 0) {
          ReportController.b(this.a.app, "CliOper", "", "", "0X8005527", "0X8005527", 0, 0, "", "", "", "");
        } else if (this.a.mInnerFrameManager.getCurrentPage() == 1) {
          ReportController.b(this.a.app, "CliOper", "", "", "0X8005526", "0X8005526", 0, 0, "", "", "", "");
        }
      }
      if (this.a.mSubType == 3)
      {
        localObject2 = this.a.getIntent().getStringExtra("group_uin");
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getMemberType(this.a.app, this.a.app.getCurrentAccountUin(), (String)localObject2));
        ((StringBuilder)localObject1).append("");
        localObject3 = ((StringBuilder)localObject1).toString();
        if ("发起视频".equals(this.a.mRightBtn.getText().toString())) {
          localObject1 = "0";
        } else {
          localObject1 = "1";
        }
        ReportController.b(null, "dc00899", "Grp_video", "", "invite", "Clk_call", 0, 0, (String)localObject2, (String)localObject3, (String)localObject1, "");
      }
      if (this.a.mEntrance == 33)
      {
        localObject1 = SelectMemberActivity.access$000(this.a);
        localObject2 = this.a;
        ((IToPayManager)localObject1).topay((AppActivity)localObject2, ((SelectMemberActivity)localObject2).mResultList);
      }
      else if (((this.a.mEntrance == 32) || (this.a.mEntrance == 43)) && (this.a.mResultList.size() > this.a.mMaxSelectNumber))
      {
        localObject1 = MessageFormat.format(this.a.getString(2131916219), new Object[] { Integer.valueOf(this.a.mMaxSelectNumber) });
        QQToast.makeText(this.a, (CharSequence)localObject1, 0).show(this.a.mTitleBar.getHeight());
      }
      else if (!NetworkUtil.isNetSupport(this.a))
      {
        localObject1 = this.a;
        QQToast.makeText((Context)localObject1, ((SelectMemberActivity)localObject1).getString(2131889169), 0).show(this.a.mTitleBar.getHeight());
      }
      else
      {
        if ((this.a.mIsForbidOnlyChooseMySelf) && (this.a.mResultList.size() == 1) && (this.a.mResultList.get(0) != null))
        {
          localObject1 = (ResultRecord)this.a.mResultList.get(0);
          localObject2 = this.a.app.getCurrentUin();
          if ((localObject2 != null) && (((ResultRecord)localObject1).uin != null) && (((String)localObject2).equals(((ResultRecord)localObject1).uin)))
          {
            localObject1 = this.a;
            QQToast.makeText((Context)localObject1, ((SelectMemberActivity)localObject1).getString(2131916217), 0).show(this.a.mTitleBar.getHeight());
            break label1883;
          }
        }
        localObject1 = this.a.mResultList.iterator();
        while (((Iterator)localObject1).hasNext()) {
          if (((ResultRecord)((Iterator)localObject1).next()).type != 5)
          {
            bool = true;
            break label686;
          }
        }
        boolean bool = false;
        label686:
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("right btn click entrance[");
          ((StringBuilder)localObject1).append(this.a.mEntrance);
          ((StringBuilder)localObject1).append("], uinType[");
          ((StringBuilder)localObject1).append(this.a.mType);
          ((StringBuilder)localObject1).append("], nopstn[");
          ((StringBuilder)localObject1).append(bool);
          ((StringBuilder)localObject1).append("]");
          QLog.i("SelectMemberActivity", 2, ((StringBuilder)localObject1).toString());
        }
        if (((this.a.mEntrance == 36) || (this.a.mEntrance == 11)) && (bool))
        {
          localObject1 = this.a;
          DialogUtil.a((Context)localObject1, 230, ((SelectMemberActivity)localObject1).getString(2131893450), this.a.getString(2131917362), 2131893167, 2131888010, new SelectMemberActivity.6.1(this), new SelectMemberActivity.6.2(this)).show();
          ReportController.b(null, "CliOper", "", "", "0X8004CED", "0X8004CED", 0, 0, "", "", "", "");
        }
        else
        {
          int i;
          Object localObject4;
          int j;
          if ((this.a.mEntrance == 12) && (this.a.mMaxSelectNumber == 1))
          {
            if (this.a.mResultList.size() == 1)
            {
              localObject2 = (ResultRecord)this.a.mResultList.get(0);
              localObject3 = new Intent();
              ((Intent)localObject3).putExtra("select_memeber_single_friend", true);
              ((Intent)localObject3).putExtra("select_memeber_single_friend_type", ((ResultRecord)localObject2).type);
              localObject1 = null;
              i = ((ResultRecord)localObject2).type;
              if (((ResultRecord)localObject2).type == 1)
              {
                localObject1 = this.a.getTroopCodeFromTroopUin(((ResultRecord)localObject2).groupUin);
                i = 1000;
              }
              else
              {
                i = 0;
              }
              if (((ResultRecord)localObject2).type == 2)
              {
                i = 1004;
                localObject1 = ((ResultRecord)localObject2).groupUin;
              }
              if (((ResultRecord)localObject2).type == 3) {
                i = 1021;
              } else if (((ResultRecord)localObject2).type == 4) {
                i = 1006;
              }
              localObject4 = SelectMemberActivity.access$100(this.a, ((ResultRecord)localObject2).uin);
              j = i;
              if (localObject4 != null)
              {
                j = i;
                if (((Friends)localObject4).isFriend()) {
                  j = 0;
                }
              }
              localObject4 = new Bundle();
              ((Bundle)localObject4).putString("uin", ((ResultRecord)localObject2).uin);
              ((Bundle)localObject4).putInt("uintype", j);
              ((Bundle)localObject4).putString("uinname", ((ResultRecord)localObject2).name);
              ((Bundle)localObject4).putString("troop_uin", (String)localObject1);
              ((Intent)localObject3).putExtras((Bundle)localObject4);
              this.a.setResult(-1, (Intent)localObject3);
              this.a.finish();
            }
            else
            {
              this.a.startCreateOrAdd();
            }
            ReportController.b(this.a.app, "CliOper", "", "", "0X8006664", "0X8006664", 0, 0, "", "", "", "");
          }
          else if (this.a.mEntrance == 23)
          {
            localObject1 = new Intent();
            localObject2 = new Bundle();
            localObject3 = new ArrayList();
            localObject4 = this.a.mResultList.iterator();
            while (((Iterator)localObject4).hasNext())
            {
              ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject4).next();
              if (localResultRecord.type == 1) {
                ((ArrayList)localObject3).add(localResultRecord.uin);
              }
            }
            ((Bundle)localObject2).putStringArrayList("troopMemList", (ArrayList)localObject3);
            ((Intent)localObject1).putExtras((Bundle)localObject2);
            this.a.setResult(-1, (Intent)localObject1);
            this.a.finish();
          }
          else if (this.a.mEntrance == 24)
          {
            localObject1 = new Intent();
            localObject2 = new Bundle();
            ((Bundle)localObject2).putParcelableArrayList("friendsSelected", this.a.mResultList);
            ((Intent)localObject1).putExtras((Bundle)localObject2);
            this.a.setResult(-1, (Intent)localObject1);
            if (this.a.isStoryNotSee) {
              SelectMemberActivity.reportEventByStoryReportor("set_notsee", "clk_done", 0, 0, new String[] { "", "", "", "" });
            } else {
              SelectMemberActivity.reportEventByStoryReportor("set_notletsee", "clk_done", 0, 0, new String[] { "", "", "", "" });
            }
            this.a.finish();
          }
          else if (this.a.mEntrance == 37)
          {
            this.a.mIntent.putParcelableArrayListExtra("result_set", this.a.mResultList);
            localObject1 = this.a;
            ((SelectMemberActivity)localObject1).setResult(-1, ((SelectMemberActivity)localObject1).mIntent);
            this.a.finish();
          }
          else if ((this.a.mType == 3000) && (this.a.mSubType == 0))
          {
            this.a.createNewTypeDiscussion();
          }
          else
          {
            this.a.startCreateOrAdd();
          }
          if (this.a.mSubType == 1)
          {
            localObject1 = this.a.mResultList.iterator();
            j = 0;
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (ResultRecord)((Iterator)localObject1).next();
              if ((((ResultRecord)localObject2).type == 1) || (((ResultRecord)localObject2).type == 2)) {
                j += 1;
              }
            }
            if (j > 0)
            {
              localObject1 = this.a;
              localObject1 = ((SelectMemberActivity)localObject1).getTroopInfo(((SelectMemberActivity)localObject1).mGroupCode);
              if (localObject1 != null)
              {
                localObject2 = this.a.app.getCurrentUin();
                if (((TroopInfo)localObject1).isTroopOwner((String)localObject2)) {
                  i = k;
                } else if (((TroopInfo)localObject1).isTroopAdmin((String)localObject2)) {
                  i = 1;
                } else {
                  i = 2;
                }
                ReportController.b(this.a.app, "dc00899", "invite_friend", "", "friend_list", "invite_friend", 0, 0, this.a.mGroupCode, String.valueOf(i), String.valueOf(j), "");
              }
            }
          }
          if (((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(this.a)) {
            ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).reportFinishClick(this.a.mIntent.getStringExtra("group_uin"), SelectMemberActivity.convertToGameTroopSelectMemberInfoList(this.a.mResultList), this.a.mIntent.getStringExtra("GAME_H5_SELECT_GAME_APPID"));
          }
        }
      }
    }
    label1883:
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectMemberActivity.6
 * JD-Core Version:    0.7.0.1
 */