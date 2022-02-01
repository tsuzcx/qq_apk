package com.tencent.mobileqq.settings.fragment;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;

class PermissionPrivacyFragment$3$1
  implements Runnable
{
  PermissionPrivacyFragment$3$1(PermissionPrivacyFragment.3 param3) {}
  
  public void run()
  {
    if (PermissionPrivacyFragment.a(this.a.this$0) == 0)
    {
      this.a.this$0.a.setVisibility(8);
      return;
    }
    FormSimpleItem localFormSimpleItem = this.a.this$0.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(PermissionPrivacyFragment.a(this.a.this$0));
    localStringBuilder.append(HardCodeUtil.a(2131707925));
    localFormSimpleItem.setRightText(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment.3.1
 * JD-Core Version:    0.7.0.1
 */