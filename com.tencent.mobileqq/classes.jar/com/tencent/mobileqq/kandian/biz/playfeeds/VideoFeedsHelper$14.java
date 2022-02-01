package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.qphone.base.util.QLog;

final class VideoFeedsHelper$14
  implements View.OnClickListener
{
  VideoFeedsHelper$14(String paramString, Context paramContext, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleKingCardHintTextView span is clicked, guideUrl=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("big_brother_source_key", RIJJumpUtils.a(0));
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    }
    Object localObject = this.jdField_a_of_type_AndroidViewView$OnClickListener;
    if (localObject != null) {
      ((View.OnClickListener)localObject).onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper.14
 * JD-Core Version:    0.7.0.1
 */