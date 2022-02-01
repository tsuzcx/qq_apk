package com.tencent.mobileqq.kandian.biz.pts.view.impl;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;

public class NativeMiddleBodyView
  extends RelativeLayout
  implements IView
{
  private static String h = "NativeMiddleBodyView";
  boolean a = false;
  View b = null;
  NativeMiddleBodyView.RadiusView c = null;
  String d;
  String e;
  String f;
  String g;
  
  public NativeMiddleBodyView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    this.b = paramView;
    if (paramLayoutParams != null) {
      super.addView(paramView, paramLayoutParams);
    } else {
      super.addView(paramView);
    }
    if (this.a)
    {
      if (this.c == null)
      {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (paramLayoutParams != null) {
          localLayoutParams.setMargins(paramLayoutParams.leftMargin, paramLayoutParams.topMargin, paramLayoutParams.rightMargin, paramLayoutParams.bottomMargin);
        }
        this.c = new NativeMiddleBodyView.RadiusView(getContext());
        this.c.setLeftTopRadius(this.d);
        this.c.setRightTopRadius(this.e);
        this.c.setBottomRightRadius(this.f);
        this.c.setBottomLeftRadius(this.g);
        addView(this.c, localLayoutParams);
      }
      paramView.addOnLayoutChangeListener(this.c.getLayoutChangeListener());
    }
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public View getContent()
  {
    return this.b;
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void setRadius(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = true;
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramString3;
    this.g = paramString4;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeMiddleBodyView
 * JD-Core Version:    0.7.0.1
 */