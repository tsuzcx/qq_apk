package com.tencent.mobileqq.kandian.base.view.widget.ticker;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.TypedValue;
import com.tencent.mobileqq.kandian.api.R.styleable;

class TickerView$StyledAttributes
{
  int a;
  int b;
  float c;
  float d;
  float e;
  String f;
  int g = -16777216;
  float h;
  int i;
  
  TickerView$StyledAttributes(TickerView paramTickerView, Resources paramResources)
  {
    this.h = TypedValue.applyDimension(2, 12.0F, paramResources.getDisplayMetrics());
    this.a = 8388611;
  }
  
  void a(TypedArray paramTypedArray)
  {
    this.a = paramTypedArray.getInt(R.styleable.cv, this.a);
    this.b = paramTypedArray.getColor(R.styleable.cx, this.b);
    this.c = paramTypedArray.getFloat(R.styleable.cy, this.c);
    this.d = paramTypedArray.getFloat(R.styleable.cz, this.d);
    this.e = paramTypedArray.getFloat(R.styleable.cA, this.e);
    this.f = paramTypedArray.getString(R.styleable.cw);
    this.g = paramTypedArray.getColor(R.styleable.cu, this.g);
    this.h = paramTypedArray.getDimension(R.styleable.cs, this.h);
    this.i = paramTypedArray.getInt(R.styleable.ct, this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ticker.TickerView.StyledAttributes
 * JD-Core Version:    0.7.0.1
 */