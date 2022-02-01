package com.tencent.tbs.one.impl.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;

public final class a
  extends FrameLayout
{
  private final String a;
  private Handler b = new Handler(Looper.getMainLooper());
  private TextView c;
  
  public a(@NonNull Context paramContext, String paramString)
  {
    super(paramContext);
    this.a = paramString;
    this.c = new TextView(paramContext);
    paramString = new FrameLayout.LayoutParams(-2, -2);
    paramString.gravity = 17;
    addView(this.c, paramString);
    com.tencent.tbs.one.impl.common.a.a(paramContext, new a.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.one.impl.b.a
 * JD-Core Version:    0.7.0.1
 */