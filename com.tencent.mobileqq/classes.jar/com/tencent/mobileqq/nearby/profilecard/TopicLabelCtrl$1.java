package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TopicLabelCtrl$1
  implements View.OnClickListener
{
  TopicLabelCtrl$1(TopicLabelCtrl paramTopicLabelCtrl) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(TopicLabelCtrl.a(this.a), QQBrowserActivity.class);
    localIntent.putExtra("url", "https://nearby.qq.com/nearby-topic/topicTags.html");
    TopicLabelCtrl.a(this.a).startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.TopicLabelCtrl.1
 * JD-Core Version:    0.7.0.1
 */