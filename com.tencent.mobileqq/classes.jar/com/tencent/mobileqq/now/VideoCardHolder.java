package com.tencent.mobileqq.now;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.now.focusanchor.commonwidget.FrameAnimationView;
import com.tencent.mobileqq.now.widget.CircleImageView;
import com.tencent.mobileqq.now.widget.RoundedRectImageView;

public class VideoCardHolder
  extends RecyclerHolder
{
  public View a;
  public RoundedRectImageView b;
  public CircleImageView c;
  public TextView d;
  public FrameLayout e;
  public FrameLayout f;
  public FrameAnimationView g;
  public TextView h;
  public TextView i;
  public int j = -1;
  
  public VideoCardHolder(View paramView)
  {
    super(paramView);
    this.a = paramView;
    this.b = ((RoundedRectImageView)paramView.findViewById(2131430324));
    this.c = ((CircleImageView)paramView.findViewById(2131428314));
    this.d = ((TextView)paramView.findViewById(2131428333));
    this.e = ((FrameLayout)paramView.findViewById(2131428315));
    this.f = ((FrameLayout)paramView.findViewById(2131428335));
    this.g = ((FrameAnimationView)paramView.findViewById(2131428334));
    this.h = ((TextView)paramView.findViewById(2131450034));
    this.i = ((TextView)paramView.findViewById(2131445126));
    paramView.setTag(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.VideoCardHolder
 * JD-Core Version:    0.7.0.1
 */