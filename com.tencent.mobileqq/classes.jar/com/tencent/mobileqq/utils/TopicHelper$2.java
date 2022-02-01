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

final class TopicHelper$2
  extends ClickableSpan
{
  TopicHelper$2(Context paramContext, TopicInfo paramTopicInfo) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelTopicInfo.b());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mVideoData.topicInfo.getTopicJumpUrl() :");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelTopicInfo.b());
      QLog.i("TopicHelper", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(Color.parseColor("#00aced"));
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.TopicHelper.2
 * JD-Core Version:    0.7.0.1
 */