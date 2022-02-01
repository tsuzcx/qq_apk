package com.tencent.mobileqq.nearby.profilecard.moment;

import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;

class BaseMomentItemBuilder$6
  extends ClickableSpan
{
  public void onClick(View paramView)
  {
    paramView = new Intent(this.b.a, QQBrowserActivity.class);
    paramView.putExtra("url", this.a);
    this.b.a.startActivity(paramView);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(-16776992);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.BaseMomentItemBuilder.6
 * JD-Core Version:    0.7.0.1
 */