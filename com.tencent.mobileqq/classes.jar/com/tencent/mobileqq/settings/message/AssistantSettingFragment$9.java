package com.tencent.mobileqq.settings.message;

import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSwitchItem;

class AssistantSettingFragment$9
  implements Runnable
{
  AssistantSettingFragment$9(AssistantSettingFragment paramAssistantSettingFragment) {}
  
  public void run()
  {
    if ((this.this$0.getBaseActivity() != null) && ("haibao".equals(this.this$0.getBaseActivity().getIntent().getStringExtra("jumpTo"))) && (AssistantSettingFragment.i(this.this$0) != null) && (AssistantSettingFragment.i(this.this$0).getVisibility() == 0)) {
      this.this$0.b.scrollTo(0, AssistantSettingFragment.i(this.this$0).getTop());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.AssistantSettingFragment.9
 * JD-Core Version:    0.7.0.1
 */