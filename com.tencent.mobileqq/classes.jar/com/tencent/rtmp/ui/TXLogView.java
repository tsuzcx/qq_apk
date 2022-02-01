package com.tencent.rtmp.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;

public class TXLogView
  extends LinearLayout
{
  StringBuffer a = new StringBuffer("");
  private TextView b;
  private TextView c;
  private ScrollView d;
  private ScrollView e;
  private final int f = 3000;
  private boolean g = false;
  
  public TXLogView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TXLogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    this.b = new TextView(paramContext);
    this.c = new TextView(paramContext);
    this.d = new ScrollView(paramContext);
    this.e = new ScrollView(paramContext);
    paramAttributeSet = new LinearLayout.LayoutParams(-1, 0);
    paramAttributeSet.weight = 0.2F;
    this.d.setLayoutParams(paramAttributeSet);
    this.d.setBackgroundColor(1627389951);
    this.d.setVerticalScrollBarEnabled(true);
    this.d.setScrollbarFadingEnabled(true);
    paramAttributeSet = new LinearLayout.LayoutParams(-1, -1);
    this.b.setLayoutParams(paramAttributeSet);
    this.b.setTextSize(2, 11.0F);
    this.b.setTextColor(-16777216);
    this.b.setTypeface(Typeface.MONOSPACE, 1);
    this.b.setLineSpacing(4.0F, 1.0F);
    this.b.setPadding(a(paramContext, 2.0F), a(paramContext, 2.0F), a(paramContext, 2.0F), a(paramContext, 2.0F));
    this.d.addView(this.b);
    paramAttributeSet = new LinearLayout.LayoutParams(-1, 0);
    paramAttributeSet.weight = 0.8F;
    paramAttributeSet.topMargin = a(paramContext, 2.0F);
    this.e.setLayoutParams(paramAttributeSet);
    this.e.setBackgroundColor(1627389951);
    this.e.setVerticalScrollBarEnabled(true);
    this.e.setScrollbarFadingEnabled(true);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -1);
    this.c.setLayoutParams(paramAttributeSet);
    this.c.setTextSize(2, 13.0F);
    this.c.setTextColor(-16777216);
    this.c.setPadding(a(paramContext, 2.0F), a(paramContext, 2.0F), a(paramContext, 2.0F), a(paramContext, 2.0F));
    this.e.addView(this.c);
    addView(this.d);
    addView(this.e);
    setVisibility(8);
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.ui.TXLogView
 * JD-Core Version:    0.7.0.1
 */