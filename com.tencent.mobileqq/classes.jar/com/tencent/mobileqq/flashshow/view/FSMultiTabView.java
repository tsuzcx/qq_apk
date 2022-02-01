package com.tencent.mobileqq.flashshow.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class FSMultiTabView
{
  private FrameLayout a;
  private TextView b;
  private View c;
  
  public FSMultiTabView(ViewGroup paramViewGroup)
  {
    this.a = ((FrameLayout)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131624801, paramViewGroup, false));
    this.b = ((TextView)this.a.findViewById(16908308));
    this.c = this.a.findViewById(2131433874);
  }
  
  public View a()
  {
    return this.a;
  }
  
  public void b()
  {
    View localView = this.c;
    if (localView == null) {
      return;
    }
    localView.setVisibility(0);
  }
  
  public void c()
  {
    View localView = this.c;
    if (localView == null) {
      return;
    }
    localView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.view.FSMultiTabView
 * JD-Core Version:    0.7.0.1
 */