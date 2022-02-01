package com.tencent.mobileqq.kandian.biz.pts.component;

import android.widget.TextView;
import com.tencent.mobileqq.kandian.repo.account.api.Ox978RespCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.PolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;

class ComponentHeaderPolymeric$1
  implements Ox978RespCallBack
{
  ComponentHeaderPolymeric$1(ComponentHeaderPolymeric paramComponentHeaderPolymeric, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("978 resp, result : ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", data : ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", distUin : ");
      localStringBuilder.append(paramString);
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
      if (this.a.mPolymericInfo.p == 1) {
        ComponentHeaderPolymeric.b(this.b, true);
      } else if (this.a.mPolymericInfo.p == 2) {
        ComponentHeaderPolymeric.b(this.b, false);
      }
      if ((this.a.mPolymericInfo.p != 1) && (this.a.mPolymericInfo.p != 2))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("978 resp error, result : ");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append(", data : ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", distUin : ");
        localStringBuilder.append(paramString);
        QLog.e("ComponentHeaderPolymeric", 2, localStringBuilder.toString());
        return;
      }
      if (this.a.mPolymericInfo.p == 1)
      {
        ComponentHeaderPolymeric.a(this.b, this.a, 2);
        return;
      }
      if (this.a.mPolymericInfo.p == 2) {
        ComponentHeaderPolymeric.a(this.b, this.a, 1);
      }
    }
    else
    {
      if (this.a.mPolymericInfo.p == 1)
      {
        ComponentHeaderPolymeric.a(this.b, 1);
        return;
      }
      if (this.a.mPolymericInfo.p == 2) {
        ComponentHeaderPolymeric.a(this.b, 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderPolymeric.1
 * JD-Core Version:    0.7.0.1
 */