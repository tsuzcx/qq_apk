package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyPrivacyListFragment;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PrivacyShowInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;

public class OnPivacyClickListener
  implements ViewBase.OnClickListener
{
  private Context a;
  private AbsBaseArticleInfo b;
  
  public OnPivacyClickListener(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.a = paramContext;
    this.b = paramAbsBaseArticleInfo;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.b;
    if ((paramViewBase != null) && (paramViewBase.mSocialFeedInfo != null))
    {
      if (this.b.mSocialFeedInfo.B == null) {
        return;
      }
      paramViewBase = this.b.mSocialFeedInfo.B;
      if (RIJQQAppInterfaceUtil.c() != this.b.mSocialFeedInfo.B.b) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("privacy type is  ");
      ((StringBuilder)localObject).append(paramViewBase.a);
      ((StringBuilder)localObject).append("| feedsid is ");
      ((StringBuilder)localObject).append(paramViewBase.c);
      QLog.d("OnPivacyClickListener", 2, ((StringBuilder)localObject).toString());
      if (paramViewBase.a == 1)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("feeds_id", paramViewBase.c);
        PublicFragmentActivity.a(this.a, (Intent)localObject, ReadInJoyPrivacyListFragment.class);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnPivacyClickListener
 * JD-Core Version:    0.7.0.1
 */