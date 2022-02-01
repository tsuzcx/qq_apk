package com.tencent.mobileqq.intervideo.groupvideo;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class GVideoLoadingUI
  implements View.OnClickListener
{
  private LinearLayout a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private LinearLayout f;
  private TextView g;
  private TextView h;
  private ProgressBar i;
  private Button j;
  private Activity k;
  
  public static String a(long paramLong)
  {
    double d1 = paramLong;
    if (d1 > 107374182.40000001D) {
      return String.format("%.1f G", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F / 1024.0F) });
    }
    if (d1 > 104857.60000000001D) {
      return String.format("%.1f M", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F) });
    }
    return String.format("%.1f K", new Object[] { Float.valueOf((float)paramLong / 1024.0F) });
  }
  
  public void a()
  {
    this.a.setVisibility(0);
    this.b.setVisibility(8);
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.f.setVisibility(0);
    this.j.setVisibility(8);
    if (paramLong == 0L) {
      this.g.setVisibility(4);
    } else {
      this.g.setText(String.format("%1$s/%2$s", new Object[] { a(paramInt * paramLong / 100L), a(paramLong) }));
    }
    this.i.setProgress(paramInt);
  }
  
  public void a(Activity paramActivity, View paramView)
  {
    this.a = ((LinearLayout)paramView.findViewById(2131434778));
    this.b = ((TextView)paramView.findViewById(2131434785));
    this.c = ((TextView)paramView.findViewById(2131434786));
    this.d = ((TextView)paramView.findViewById(2131434779));
    this.e = ((TextView)paramView.findViewById(2131434784));
    this.f = ((LinearLayout)paramView.findViewById(2131434780));
    this.g = ((TextView)paramView.findViewById(2131434781));
    this.i = ((ProgressBar)paramView.findViewById(2131434782));
    this.j = ((Button)paramView.findViewById(2131434783));
    this.h = ((TextView)paramView.findViewById(2131434777));
    this.k = paramActivity;
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
  }
  
  public void a(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.f.setVisibility(8);
    this.j.setVisibility(0);
    this.j.setText(paramString);
    this.j.setOnClickListener(paramOnClickListener);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.d.setText(paramString1);
    this.e.setText(paramString2);
  }
  
  public void b()
  {
    this.a.setVisibility(8);
    this.b.setVisibility(0);
  }
  
  public void c()
  {
    this.j.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == this.a) || (paramView == this.b)) {
      this.k.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.GVideoLoadingUI
 * JD-Core Version:    0.7.0.1
 */