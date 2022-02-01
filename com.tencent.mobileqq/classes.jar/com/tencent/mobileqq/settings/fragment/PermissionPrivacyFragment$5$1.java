package com.tencent.mobileqq.settings.fragment;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;

class PermissionPrivacyFragment$5$1
  implements Runnable
{
  PermissionPrivacyFragment$5$1(PermissionPrivacyFragment.5 param5, int paramInt) {}
  
  public void run()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateIntimateRelationshipFriendCount number:");
      ((StringBuilder)localObject).append(this.a);
      QLog.i("PermissionPrivacyFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a > 0)
    {
      localObject = this.b.this$0.l;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append(HardCodeUtil.a(2131899102));
      ((FormSimpleItem)localObject).setRightText(localStringBuilder.toString());
      return;
    }
    this.b.this$0.l.setRightText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment.5.1
 * JD-Core Version:    0.7.0.1
 */