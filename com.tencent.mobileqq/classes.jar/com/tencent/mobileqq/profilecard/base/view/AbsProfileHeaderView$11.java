package com.tencent.mobileqq.profilecard.base.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profile.SigTopicManager;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.mobileqq.richstatus.topic.TopicUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AbsProfileHeaderView$11
  implements View.OnClickListener
{
  AbsProfileHeaderView$11(AbsProfileHeaderView paramAbsProfileHeaderView, String paramString, int paramInt, View paramView) {}
  
  public void onClick(View paramView)
  {
    if ((TopicUtil.a(this.val$recommendTagName)) && (this.val$recommendTagId >= 0))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("key_sign_topic_name", this.val$recommendTagName);
      localBundle.putInt("key_sign_topic_id", this.val$recommendTagId);
      localBundle.putInt("from_type", 2);
      if ((this.this$0.mActivity != null) && (this.this$0.mApp != null)) {
        SignTextEditFragment.a(this.this$0.mActivity, null, null, localBundle, -1);
      }
      this.val$topicView.setVisibility(8);
      SigTopicManager.a().f(this.this$0.mApp);
      ReportController.b(null, "dc00898", "", "", "0X800A4D5", "0X800A4D5", 0, 0, "2", "0", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.11
 * JD-Core Version:    0.7.0.1
 */