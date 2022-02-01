package com.tencent.mobileqq.managers;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;

public class CUOpenCardGuideMng$CUOpenCardClickableSpan
  extends ClickableSpan
{
  final Context a;
  final String b;
  final String c;
  final int d;
  final int e;
  
  public CUOpenCardGuideMng$CUOpenCardClickableSpan(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    this.a = paramContext;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramInt;
    this.e = Color.parseColor("#00a5e0");
    ThreadManager.post(new CUOpenCardGuideMng.CUOpenCardClickableSpan.1(this), 5, null, false);
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, QQBrowserActivity.class);
    paramView.putExtra("uin", this.c);
    paramView.putExtra("url", this.b);
    paramView.putExtra("hide_more_button", true);
    this.a.startActivity(paramView);
    ThreadManager.post(new CUOpenCardGuideMng.CUOpenCardClickableSpan.2(this), 5, null, false);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.e);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.CUOpenCardGuideMng.CUOpenCardClickableSpan
 * JD-Core Version:    0.7.0.1
 */