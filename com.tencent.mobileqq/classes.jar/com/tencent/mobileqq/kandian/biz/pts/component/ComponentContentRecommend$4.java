package com.tencent.mobileqq.kandian.biz.pts.component;

import android.widget.BaseAdapter;
import com.tencent.mobileqq.kandian.repo.account.api.Ox978RespCallBack;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ComponentContentRecommend$4
  implements Ox978RespCallBack
{
  ComponentContentRecommend$4(ComponentContentRecommend paramComponentContentRecommend, RecommendFollowInfo paramRecommendFollowInfo) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = ComponentContentRecommend.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("followPubAccount() onFollowPublicAccount uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", isSuccess=");
      localStringBuilder.append(paramBoolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      paramString = this.a;
      paramString.isFollowed = true;
      this.b.b(paramString);
      ComponentContentRecommend.e(this.b).notifyDataSetChanged();
      return;
    }
    QQToast.makeText(this.b.getContext(), 1, 2131915450, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommend.4
 * JD-Core Version:    0.7.0.1
 */