package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ViewerMoreRelativeLayout
  extends RelativeLayout
{
  RelativeLayout a = null;
  TextView b;
  Context c;
  
  public ViewerMoreRelativeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ViewerMoreRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ViewerMoreRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131627055, this);
    this.a = ((RelativeLayout)findViewById(2131449792));
    this.b = ((TextView)findViewById(2131449882));
    this.c = paramContext;
  }
  
  public void setGone()
  {
    this.a.setVisibility(8);
    this.b.setVisibility(8);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.a.setOnClickListener(paramOnClickListener);
  }
  
  public void setText(int paramInt)
  {
    this.b.setText(paramInt);
  }
  
  public void setVisible()
  {
    this.a.setVisibility(0);
    this.b.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.ViewerMoreRelativeLayout
 * JD-Core Version:    0.7.0.1
 */