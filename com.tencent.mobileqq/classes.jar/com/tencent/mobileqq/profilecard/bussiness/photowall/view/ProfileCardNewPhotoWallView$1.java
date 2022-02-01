package com.tencent.mobileqq.profilecard.bussiness.photowall.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.profilecard.bussiness.photowall.bean.NowShowVideoInfo;
import com.tencent.mobileqq.profilecard.bussiness.photowall.bean.ProfilePhotoWall;
import com.tencent.mobileqq.profilecard.bussiness.photowall.bean.QZonePhotoInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.LinkedList;

class ProfileCardNewPhotoWallView$1
  implements View.OnClickListener
{
  ProfileCardNewPhotoWallView$1(ProfileCardNewPhotoWallView paramProfileCardNewPhotoWallView, ProfilePhotoWall paramProfilePhotoWall, int paramInt, URLImageView paramURLImageView) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this.val$profilePhotoWall;
    Object localObject2;
    if ((localObject1 instanceof NowShowVideoInfo))
    {
      localObject1 = (NowShowVideoInfo)localObject1;
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("hide_more_button", true);
      ((Intent)localObject2).putExtra("hide_operation_bar", true);
      ((Intent)localObject2).putExtra("url", ((NowShowVideoInfo)localObject1).mJumpUrl);
      RouteUtils.a(paramView.getContext(), (Intent)localObject2, "/base/browser");
      ReportController.b(this.this$0.mApp, "dc00899", "NOW", "", "qq_zlk", "replay_click", 0, 0, this.this$0.mUin, "", "", "");
    }
    else
    {
      localObject1 = new Intent();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("index", this.val$pos);
      Object localObject3 = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int i = 0;
      while (i < this.this$0.mPhotoList.size())
      {
        Object localObject4 = (ProfilePhotoWall)this.this$0.mPhotoList.get(i);
        if ((localObject4 instanceof QZonePhotoInfo))
        {
          ((ArrayList)localObject3).add(((ProfilePhotoWall)localObject4).getOriginUrl());
          localObject4 = (QZonePhotoInfo)localObject4;
          localArrayList1.add(((QZonePhotoInfo)localObject4).photoId);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(((QZonePhotoInfo)localObject4).time);
          localStringBuilder.append("");
          localArrayList2.add(localStringBuilder.toString());
        }
        i += 1;
      }
      ((Bundle)localObject2).putStringArrayList("seqNum", (ArrayList)localObject3);
      ((Bundle)localObject2).putBoolean("from_photo_wall", true);
      if (this.this$0.mApp.getCurrentAccountUin().equals(this.this$0.mUin))
      {
        ((Bundle)localObject2).putBoolean("delete_ability", true);
        ((Bundle)localObject2).putStringArrayList("photoIds", localArrayList1);
        ((Bundle)localObject2).putStringArrayList("photoTimes", localArrayList2);
      }
      ((Bundle)localObject2).putBoolean("SHOW_MENU", true);
      ((Bundle)localObject2).putBoolean("IS_EDIT", false);
      ((Bundle)localObject2).putBoolean("is_use_path", true);
      ((Bundle)localObject2).putBoolean("is_show_action", true);
      ((Bundle)localObject2).putBoolean("is_not_show_index", true);
      localObject3 = new int[2];
      this.val$imageView.getLocationOnScreen((int[])localObject3);
      this.this$0.mPreviewPhotoLocation = new ArrayList();
      this.this$0.mPreviewPhotoLocation.add(Integer.valueOf(localObject3[0]));
      this.this$0.mPreviewPhotoLocation.add(Integer.valueOf(localObject3[1]));
      this.this$0.mPreviewPhotoLocation.add(Integer.valueOf(this.val$imageView.getWidth()));
      this.this$0.mPreviewPhotoLocation.add(Integer.valueOf(this.val$imageView.getHeight()));
      ((Bundle)localObject2).putIntegerArrayList("mPreviewPhotoLocation", this.this$0.mPreviewPhotoLocation);
      ((Intent)localObject1).putExtras((Bundle)localObject2);
      RouteUtils.a(this.this$0.mActivity, (Intent)localObject1, "/base/troop/activity/TroopAvatarWallPreviewActivity");
      this.this$0.mActivity.overridePendingTransition(2130772168, 2130772167);
      if (this.this$0.mApp.getCurrentAccountUin().equals(this.this$0.mUin)) {
        ReportController.b(this.this$0.mApp, "CliOper", "", "", "0X8006A80", "0X8006A80", 0, 0, "", "", "", "");
      } else {
        ReportController.b(this.this$0.mApp, "CliOper", "", "", "0X8006A94", "0X8006A94", 0, 0, "", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardNewPhotoWallView.1
 * JD-Core Version:    0.7.0.1
 */