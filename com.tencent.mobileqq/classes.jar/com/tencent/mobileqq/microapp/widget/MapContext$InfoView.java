package com.tencent.mobileqq.microapp.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

class MapContext$InfoView
  extends LinearLayout
{
  TextView a;
  
  public MapContext$InfoView(MapContext paramMapContext, Context paramContext)
  {
    super(paramContext);
    this.a = new TextView(paramContext);
    this.a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    this.a.setTextColor(-16777216);
    this.a.setTextSize(12.0F);
    setOrientation(1);
    setBackgroundColor(-1);
    addView(this.a);
  }
  
  public void a(String paramString1, String paramString2, float paramFloat1, float paramFloat2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    this.a.setText(paramString1);
    if (!TextUtils.isEmpty(paramString2)) {}
    try
    {
      this.a.setTextColor(Color.parseColor(paramString2));
      label26:
      if (paramFloat1 > 0.0F) {
        this.a.setTextSize(paramFloat1);
      }
      paramFloat1 = paramFloat2;
      if (paramFloat2 < 1.0F) {
        paramFloat1 = 2.0F;
      }
      int j = -1;
      int k = (int)(MapContext.a(this.b) * paramFloat1 + 0.5F);
      int i = j;
      if (!TextUtils.isEmpty(paramString3)) {}
      try
      {
        i = Color.parseColor(paramString3);
        paramString1 = new i(i, Paint.Style.FILL, 0.0F, 255, k);
        if (Build.VERSION.SDK_INT >= 16)
        {
          this.a.setBackground(paramString1);
          if (paramInt > 0) {
            this.a.setPadding(paramInt, paramInt, paramInt, paramInt);
          }
          if (!"left".equals(paramString5)) {
            break label194;
          }
          this.a.setGravity(3);
        }
        for (;;)
        {
          if ("center".equals(paramString5)) {
            this.a.setGravity(17);
          }
          return;
          this.a.setBackgroundDrawable(paramString1);
          break;
          label194:
          if ("right".equals(paramString5)) {
            this.a.setGravity(5);
          }
        }
      }
      catch (IllegalArgumentException paramString1)
      {
        for (;;)
        {
          i = j;
        }
      }
    }
    catch (IllegalArgumentException paramString1)
    {
      break label26;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.MapContext.InfoView
 * JD-Core Version:    0.7.0.1
 */