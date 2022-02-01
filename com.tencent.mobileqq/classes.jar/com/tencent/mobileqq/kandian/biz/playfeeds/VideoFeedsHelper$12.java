package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.qphone.base.util.QLog;

final class VideoFeedsHelper$12
  extends ClickableSpan
{
  VideoFeedsHelper$12(String paramString, Context paramContext, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleKingCardHintTextView span is clicked, guideUrl=");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(this.a))
    {
      localObject = new Intent(this.b, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.a);
      ((Intent)localObject).putExtra("big_brother_source_key", RIJJumpUtils.a(0));
      this.b.startActivity((Intent)localObject);
    }
    Object localObject = this.c;
    if (localObject != null) {
      ((View.OnClickListener)localObject).onClick(paramView);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(18, 183, 245));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper.12
 * JD-Core Version:    0.7.0.1
 */