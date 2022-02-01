package com.tencent.mobileqq.settings.fragment;

import com.tencent.mobileqq.widget.FormSwitchItem;

class PrivacyShowSettingFragment$3$1
  implements Runnable
{
  PrivacyShowSettingFragment$3$1(PrivacyShowSettingFragment.3 param3, boolean paramBoolean) {}
  
  public void run()
  {
    PrivacyShowSettingFragment.a(this.b.this$0).setOnCheckedChangeListener(null);
    PrivacyShowSettingFragment.a(this.b.this$0).setChecked(this.a ^ true);
    PrivacyShowSettingFragment.a(this.b.this$0).setOnCheckedChangeListener(this.b.this$0.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.fragment.PrivacyShowSettingFragment.3.1
 * JD-Core Version:    0.7.0.1
 */