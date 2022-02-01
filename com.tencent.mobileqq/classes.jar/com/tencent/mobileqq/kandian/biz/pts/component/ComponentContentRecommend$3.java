package com.tencent.mobileqq.kandian.biz.pts.component;

import android.widget.BaseAdapter;
import com.tencent.mobileqq.kandian.repo.account.api.Ox978RespCallBack;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ComponentContentRecommend$3
  implements Ox978RespCallBack
{
  ComponentContentRecommend$3(ComponentContentRecommend paramComponentContentRecommend, RecommendFollowInfo paramRecommendFollowInfo) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = ComponentContentRecommend.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("978 resp, result : ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", data : ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", distUin : ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    boolean bool = false;
    if (paramBoolean)
    {
      paramString = this.a;
      paramBoolean = bool;
      if (paramInt == 2) {
        paramBoolean = true;
      }
      paramString.isFollowed = paramBoolean;
      this.b.b(this.a);
      ComponentContentRecommend.e(this.b).notifyDataSetChanged();
      return;
    }
    QQToast.makeText(this.b.getContext(), 1, 2131915450, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentRecommend.3
 * JD-Core Version:    0.7.0.1
 */