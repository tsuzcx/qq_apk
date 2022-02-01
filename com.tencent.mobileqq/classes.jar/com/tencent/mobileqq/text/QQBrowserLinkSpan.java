package com.tencent.mobileqq.text;

import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import java.lang.ref.WeakReference;

public class QQBrowserLinkSpan
  extends ClickableSpan
{
  private WeakReference<Context> a;
  private String b;
  private boolean c = false;
  
  public QQBrowserLinkSpan(Context paramContext, String paramString, boolean paramBoolean)
  {
    this.a = new WeakReference(paramContext);
    this.b = paramString;
    this.c = paramBoolean;
  }
  
  public void onClick(View paramView)
  {
    paramView = (Context)this.a.get();
    if (paramView != null) {
      paramView.startActivity(new Intent(paramView, QQBrowserActivity.class).putExtra("url", this.b));
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQBrowserLinkSpan
 * JD-Core Version:    0.7.0.1
 */