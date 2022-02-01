package com.tencent.mobileqq.data;

import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import java.lang.ref.SoftReference;

class MessageForQQWalletTips$3
  extends ClickableSpan
{
  MessageForQQWalletTips$3(MessageForQQWalletTips paramMessageForQQWalletTips, String paramString, SoftReference paramSoftReference, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (TextUtils.isEmpty(this.a)) {
      return;
    }
    paramView = (Context)this.b.get();
    if (paramView == null) {
      return;
    }
    Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
    localIntent.putExtra("url", this.a);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    paramView.startActivity(localIntent);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(this.c);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQQWalletTips.3
 * JD-Core Version:    0.7.0.1
 */