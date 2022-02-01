package com.tencent.mobileqq.nearby.profilecard;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.newnearby.util.NearbyStatusBarHelper;
import com.tencent.mobileqq.picbrowser.PicInfo;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/nearby/profilecard/NewNearbyProfileDisplayPanel$initViews$2$2"}, k=3, mv={1, 1, 16})
final class NewNearbyProfileDisplayPanel$initViews$$inlined$apply$lambda$1
  implements View.OnClickListener
{
  NewNearbyProfileDisplayPanel$initViews$$inlined$apply$lambda$1(ImageView paramImageView, NewNearbyProfileDisplayPanel paramNewNearbyProfileDisplayPanel, View paramView) {}
  
  public final void onClick(View paramView)
  {
    paramView = NewNearbyProfileDisplayPanel.a(this.b);
    if (paramView != null)
    {
      Rect localRect = AnimationUtils.a((View)this.a);
      ArrayList localArrayList = this.b.e.mPicInfo;
      Intrinsics.checkExpressionValueIsNotNull(localArrayList, "mActivity.mPicInfo");
      int m = ((Collection)localArrayList).size();
      int k = 0;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= m) {
          break;
        }
        if (this.b.f.nowUserType == 0 ? paramView.a == ((PicInfo)this.b.e.mPicInfo.get(i)).a : TextUtils.equals((CharSequence)paramView.b, (CharSequence)((PicInfo)this.b.e.mPicInfo.get(i)).b))
        {
          j = i;
          break;
        }
        i += 1;
      }
      NearbyStatusBarHelper.b(this.c);
      this.b.e.showBigPhoto(j, localRect);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NewNearbyProfileDisplayPanel.initViews..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */