package com.tencent.mobileqq.settings.fragment;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;

class PermissionPrivacyFragment$4$1
  implements Runnable
{
  PermissionPrivacyFragment$4$1(PermissionPrivacyFragment.4 param4, int paramInt) {}
  
  public void run()
  {
    if (this.a > 0)
    {
      FormSimpleItem localFormSimpleItem = this.b.this$0.h;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append(HardCodeUtil.a(2131899102));
      localFormSimpleItem.setRightText(localStringBuilder.toString());
      return;
    }
    this.b.this$0.h.setRightText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PermissionPrivacyFragment.4.1
 * JD-Core Version:    0.7.0.1
 */