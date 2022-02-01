package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.kandian.base.view.widget.SquareCornerTextImageView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCPicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.util.List;

public class ComponentContentPgcShortContentGridImage
  extends ComponentContentGridImage
{
  public ComponentContentPgcShortContentGridImage(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentPgcShortContentGridImage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    if (getCount() == 1)
    {
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      PGCPicInfo localPGCPicInfo = (PGCPicInfo)((IReadInJoyModel)this.a).a().mSocialFeedInfo.a.a.get(0);
      localLayoutParams.height = ((int)((DeviceInfoUtil.k() - DisplayUtil.a(getContext(), 54.0F)) / 2L));
      if (localPGCPicInfo.b > localPGCPicInfo.a * 1.5F) {
        localLayoutParams.width = ((int)((DeviceInfoUtil.k() - DisplayUtil.a(getContext(), 54.0F)) / 3L));
      } else if (localPGCPicInfo.b >= localPGCPicInfo.a * 1.0F) {
        localLayoutParams.width = (localPGCPicInfo.a * localLayoutParams.height / localPGCPicInfo.b);
      } else if (localPGCPicInfo.b > localPGCPicInfo.a * 0.6666667F) {
        localLayoutParams.width = (localPGCPicInfo.a * localLayoutParams.height / localPGCPicInfo.b);
      } else {
        localLayoutParams.width = ((int)((DeviceInfoUtil.k() - DisplayUtil.a(getContext(), 54.0F)) / 2L * 3L / 2L));
      }
      paramView.setLayoutParams(localLayoutParams);
      ((SquareCornerTextImageView)paramView).a = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentPgcShortContentGridImage
 * JD-Core Version:    0.7.0.1
 */