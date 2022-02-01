package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "clickedView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k=3, mv={1, 1, 16})
final class NearbyProfileImageDisplayAdapter$onBindViewHolder$1$1
  implements ActionSheet.OnButtonClickListener
{
  NearbyProfileImageDisplayAdapter$onBindViewHolder$1$1(NearbyProfileImageDisplayAdapter.onBindViewHolder.1 param1, NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity, ActionSheet paramActionSheet) {}
  
  public final void onClick(View paramView, int paramInt)
  {
    Object localObject1;
    if (!NearbyProfileImageDisplayAdapter.a(this.a.a).J())
    {
      paramView = this.b;
      localObject1 = (Context)paramView;
      Intrinsics.checkExpressionValueIsNotNull(paramView, "activity");
      QQToast.makeText((Context)localObject1, 0, (CharSequence)paramView.getResources().getString(1946615842), 0).show();
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        this.b.selectPhotoFromQZone();
      }
    }
    else
    {
      paramView = new ActivityURIRequest((Context)this.b, "/base/album/photolist");
      paramInt = NearbyProfileCardConstants.a;
      int i = this.a.b.size();
      localObject1 = paramView.extra();
      ((Bundle)localObject1).putInt("PhotoConst.MAXUM_SELECTED_NUM", paramInt - i);
      ((Bundle)localObject1).putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.b.getClass().getName());
      ((Bundle)localObject1).putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      ((Bundle)localObject1).putBoolean("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
      ((Bundle)localObject1).putBoolean("PhotoConst.IS_SINGLE_MODE", false);
      ((Bundle)localObject1).putBoolean("PhotoConst.IS_SINGLE_NEED_EDIT", true);
      ((Bundle)localObject1).putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
      ((Bundle)localObject1).putBoolean("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(AppConstants.SDCARD_PATH);
      ((StringBuilder)localObject2).append("nearby_people_photo/");
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append(".jpg");
      ((Bundle)localObject1).putString("PhotoConst.TARGET_PATH", localStringBuilder.toString());
      ((Bundle)localObject1).putInt("PhotoConst.CLIP_WIDTH", 640);
      ((Bundle)localObject1).putInt("PhotoConst.CLIP_HEIGHT", 640);
      ((Bundle)localObject1).putInt("PhotoConst.TARGET_WIDTH", 640);
      ((Bundle)localObject1).putInt("PhotoConst.TARGET_HEIGHT", 640);
      ((Bundle)localObject1).putInt("enter_from", 30);
      ((Bundle)localObject1).putString("KEY_PHOTO_LIST_CLASS_NAME", NearbyProfileEditPanel.W);
      QRoute.startUri((URIRequest)paramView);
      NearbyProfileImageDisplayAdapter.a(this.a.a).K();
    }
    this.c.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileImageDisplayAdapter.onBindViewHolder.1.1
 * JD-Core Version:    0.7.0.1
 */