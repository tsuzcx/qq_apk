package com.tencent.mobileqq.kandian.biz.follow.popup;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.repo.account.api.Ox978RespCallBack;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isSuccess", "", "distUin", "", "kotlin.jvm.PlatformType", "dataResp", "", "handleResp"}, k=3, mv={1, 1, 16})
final class RIJFollowPackUtils$requestFollow$1
  implements Ox978RespCallBack
{
  RIJFollowPackUtils$requestFollow$1(RecommendFollowInfo paramRecommendFollowInfo, RIJFollowPackUtils.RIJFollowPackData paramRIJFollowPackData) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    String str = RIJFollowPackUtils.a.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestFollow, isSuccess=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", distUin=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", dataResp=");
    localStringBuilder.append(paramInt);
    QLog.d(str, 1, localStringBuilder.toString());
    if (paramBoolean)
    {
      this.a.isFollowed = true;
      RIJFollowPackUtils.a.a(this.b);
      return;
    }
    QQToast.makeText((Context)BaseApplicationImpl.getContext(), 1, 2131915450, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.follow.popup.RIJFollowPackUtils.requestFollow.1
 * JD-Core Version:    0.7.0.1
 */