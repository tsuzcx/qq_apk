package com.tencent.mobileqq.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class KPLScoreView
  extends LinearLayout
{
  LinearLayout a;
  LinearLayout b;
  LinearLayout c;
  LinearLayout d;
  TextView e;
  TextView f;
  TextView g;
  TextView h;
  private Context i;
  
  public KPLScoreView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public KPLScoreView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.i = paramContext;
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(this.i).inflate(2131627481, this, true);
    this.a = ((LinearLayout)findViewById(2131439091));
    this.e = ((TextView)this.a.findViewById(2131448547));
    this.b = ((LinearLayout)findViewById(2131446633));
    this.f = ((TextView)this.b.findViewById(2131448550));
    this.c = ((LinearLayout)findViewById(2131444172));
    this.g = ((TextView)this.c.findViewById(2131448548));
    this.d = ((LinearLayout)findViewById(2131445173));
    this.h = ((TextView)this.d.findViewById(2131448549));
  }
  
  public void setKplValue(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramString1.length() > 0) {
      j = paramString1.length() - 1;
    } else {
      j = 0;
    }
    if (paramString2.length() > 0) {
      k = paramString2.length() - 1;
    } else {
      k = 0;
    }
    if (paramString3.length() > 0) {
      m = paramString3.length() - 1;
    } else {
      m = 0;
    }
    if (paramString4.length() > 0) {
      n = paramString4.length() - 1;
    } else {
      n = 0;
    }
    paramString1 = new SpannableString(paramString1);
    paramString2 = new SpannableString(paramString2);
    paramString3 = new SpannableString(paramString3);
    paramString4 = new SpannableString(paramString4);
    AbsoluteSizeSpan localAbsoluteSizeSpan1 = new AbsoluteSizeSpan(27, true);
    AbsoluteSizeSpan localAbsoluteSizeSpan2 = new AbsoluteSizeSpan(14, true);
    StyleSpan localStyleSpan = new StyleSpan(1);
    paramString1.setSpan(localAbsoluteSizeSpan1, 0, j, 17);
    paramString1.setSpan(localAbsoluteSizeSpan2, j, j + 1, 17);
    paramString1.setSpan(localStyleSpan, 0, j, 17);
    paramString2.setSpan(localAbsoluteSizeSpan1, 0, k, 17);
    paramString2.setSpan(localAbsoluteSizeSpan2, k, k + 1, 17);
    paramString2.setSpan(localStyleSpan, 0, k, 17);
    paramString3.setSpan(localAbsoluteSizeSpan1, 0, m, 17);
    paramString3.setSpan(localAbsoluteSizeSpan2, m, m + 1, 17);
    paramString3.setSpan(localStyleSpan, 0, m, 17);
    paramString4.setSpan(localAbsoluteSizeSpan1, 0, n, 17);
    paramString4.setSpan(localAbsoluteSizeSpan2, n, n + 1, 17);
    paramString4.setSpan(localStyleSpan, 0, n, 17);
    this.e.setText(paramString1);
    this.f.setText(paramString2);
    this.g.setText(paramString3);
    this.h.setText(paramString4);
    this.e.measure(0, 0);
    this.f.measure(0, 0);
    this.g.measure(0, 0);
    this.h.measure(0, 0);
    int j = this.e.getMeasuredWidth();
    int k = this.f.getMeasuredWidth();
    int m = this.g.getMeasuredWidth();
    int n = this.h.getMeasuredWidth();
    j = (((WindowManager)this.i.getSystemService("window")).getDefaultDisplay().getWidth() - (j + k + m + n) - AIOUtils.b(24.0F, this.i.getResources())) / 3;
    paramString1 = new LinearLayout.LayoutParams(-2, -2);
    paramString1.setMargins(j, 0, 0, 0);
    this.b.setLayoutParams(paramString1);
    this.c.setLayoutParams(paramString1);
    this.d.setLayoutParams(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.KPLScoreView
 * JD-Core Version:    0.7.0.1
 */