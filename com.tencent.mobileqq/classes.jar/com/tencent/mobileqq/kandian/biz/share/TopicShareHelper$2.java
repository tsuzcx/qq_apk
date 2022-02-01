package com.tencent.mobileqq.kandian.biz.share;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

class TopicShareHelper$2
  implements View.OnClickListener
{
  TopicShareHelper$2(TopicShareHelper paramTopicShareHelper) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.TopicShareHelper", 2, "mShareActionSheet cancle button OnClick");
    }
    if (TopicShareHelper.b(this.a).isShowing()) {
      TopicShareHelper.b(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.TopicShareHelper.2
 * JD-Core Version:    0.7.0.1
 */