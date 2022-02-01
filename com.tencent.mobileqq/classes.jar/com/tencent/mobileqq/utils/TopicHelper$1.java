package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.now.model.TopicInfo;
import com.tencent.qphone.base.util.QLog;

final class TopicHelper$1
  extends ClickableSpan
{
  TopicHelper$1(Context paramContext, TopicInfo paramTopicInfo) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, QQBrowserActivity.class);
    paramView.putExtra("url", this.b.b());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mVideoData.topicInfo.getTopicJumpUrl() :");
      localStringBuilder.append(this.b.b());
      QLog.i("TopicHelper", 2, localStringBuilder.toString());
    }
    this.a.startActivity(paramView);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#00aced"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.TopicHelper.1
 * JD-Core Version:    0.7.0.1
 */