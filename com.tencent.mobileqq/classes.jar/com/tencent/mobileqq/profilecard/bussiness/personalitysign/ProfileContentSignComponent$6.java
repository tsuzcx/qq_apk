package com.tencent.mobileqq.profilecard.bussiness.personalitysign;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profile.SigTopicManager;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.mobileqq.richstatus.topic.TopicUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ProfileContentSignComponent$6
  implements View.OnClickListener
{
  ProfileContentSignComponent$6(ProfileContentSignComponent paramProfileContentSignComponent, String paramString, int paramInt, View paramView) {}
  
  public void onClick(View paramView)
  {
    if ((TopicUtil.a(this.val$recommendTagName)) && (this.val$recommendTagId >= 0))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("key_sign_topic_name", this.val$recommendTagName);
      localBundle.putInt("key_sign_topic_id", this.val$recommendTagId);
      localBundle.putInt("from_type", 2);
      if (ProfileContentSignComponent.access$2600(this.this$0) != null) {
        SignTextEditFragment.a(ProfileContentSignComponent.access$2700(this.this$0), null, null, localBundle, -1);
      }
      this.val$root.setVisibility(8);
      SigTopicManager.a().c(ProfileContentSignComponent.access$2800(this.this$0));
      ReportController.b(null, "dc00898", "", "", "0X800A4D5", "0X800A4D5", 0, 0, "2", "0", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.personalitysign.ProfileContentSignComponent.6
 * JD-Core Version:    0.7.0.1
 */