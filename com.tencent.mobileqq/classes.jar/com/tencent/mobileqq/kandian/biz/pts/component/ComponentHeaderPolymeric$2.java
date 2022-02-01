package com.tencent.mobileqq.kandian.biz.pts.component;

import android.widget.TextView;
import com.tencent.mobileqq.kandian.repo.account.api.Ox978RespCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.PolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;

class ComponentHeaderPolymeric$2
  implements Ox978RespCallBack
{
  ComponentHeaderPolymeric$2(ComponentHeaderPolymeric paramComponentHeaderPolymeric, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("followPubAccount() onFollowPublicAccount uin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", isSuccess=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" followStatus = ");
      localStringBuilder.append(this.a.mPolymericInfo.p);
      QLog.d("ComponentHeaderPolymeric", 2, localStringBuilder.toString());
    }
    if (!paramString.equals(ComponentHeaderPolymeric.a(this.b).getTag())) {
      return;
    }
    ComponentHeaderPolymeric.a(this.b, true);
    if (paramBoolean)
    {
      ComponentHeaderPolymeric.b(this.b, true);
      ComponentHeaderPolymeric.a(this.b, this.a, 2);
      return;
    }
    ComponentHeaderPolymeric.a(this.b, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderPolymeric.2
 * JD-Core Version:    0.7.0.1
 */