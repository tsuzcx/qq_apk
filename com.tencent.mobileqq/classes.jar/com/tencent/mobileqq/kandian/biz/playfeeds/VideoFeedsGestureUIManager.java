package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class VideoFeedsGestureUIManager
{
  private ViewGroup a;
  private ViewGroup b;
  private ViewGroup c;
  private ViewGroup d;
  private ViewGroup e;
  private VideoFeedsGestureProgressView f;
  private VideoFeedsGestureProgressView g;
  private TextView h;
  private TextView i;
  private ImageView j;
  private ImageView k;
  private int l = 0;
  
  public void a()
  {
    ViewGroup localViewGroup = this.c;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(8);
    }
    localViewGroup = this.d;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(8);
    }
    localViewGroup = this.e;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(8);
    }
  }
  
  public void a(int paramInt, float paramFloat, long paramLong1, long paramLong2)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt == 3)
          {
            String str1 = VideoFeedsHelper.b(paramLong1);
            String str2 = VideoFeedsHelper.b(paramLong2);
            TextView localTextView = this.h;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(str1);
            localStringBuilder.append("/");
            localTextView.setText(localStringBuilder.toString());
            this.i.setText(str2);
            if (paramFloat > 0.0F) {
              this.k.setBackgroundResource(2130844227);
            } else {
              this.k.setBackgroundResource(2130844225);
            }
            if (this.c.getVisibility() == 8) {
              VideoFeedsHelper.a(this.c, 0, 300);
            }
          }
        }
        else
        {
          this.f.setProgress(paramFloat);
          if (this.d.getVisibility() == 8) {
            VideoFeedsHelper.a(this.d, 0, 300);
          }
        }
      }
      else
      {
        this.g.setProgress(paramFloat);
        if (paramFloat == 0.0F) {
          this.j.setBackgroundResource(2130844132);
        } else {
          this.j.setBackgroundResource(2130844133);
        }
        if (this.e.getVisibility() == 8) {
          VideoFeedsHelper.a(this.e, 0, 300);
        }
      }
    }
    else
    {
      int m = this.l;
      if (m != 0) {
        if (m == 3)
        {
          if (this.c.getVisibility() == 0) {
            VideoFeedsHelper.a(this.c, 8, 300);
          }
        }
        else if (m == 2)
        {
          if (this.d.getVisibility() == 0) {
            VideoFeedsHelper.a(this.d, 8, 300);
          }
        }
        else if ((m == 1) && (this.e.getVisibility() == 0)) {
          VideoFeedsHelper.a(this.e, 8, 300);
        }
      }
    }
    this.l = paramInt;
  }
  
  public void a(Context paramContext, ViewGroup paramViewGroup)
  {
    this.a = paramViewGroup;
    this.b = ((ViewGroup)((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131626369, paramViewGroup));
    this.c = ((ViewGroup)this.b.findViewById(2131440765));
    this.d = ((ViewGroup)this.b.findViewById(2131429735));
    this.e = ((ViewGroup)this.b.findViewById(2131449987));
    this.h = ((TextView)this.b.findViewById(2131440763));
    this.i = ((TextView)this.b.findViewById(2131440767));
    this.j = ((ImageView)this.b.findViewById(2131449986));
    this.k = ((ImageView)this.b.findViewById(2131440764));
    this.f = ((VideoFeedsGestureProgressView)this.b.findViewById(2131429736));
    this.g = ((VideoFeedsGestureProgressView)this.b.findViewById(2131449988));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsGestureUIManager
 * JD-Core Version:    0.7.0.1
 */