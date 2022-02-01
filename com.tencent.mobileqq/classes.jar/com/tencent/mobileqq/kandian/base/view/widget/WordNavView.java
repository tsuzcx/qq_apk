package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.FontMetrics;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordNavView
  extends View
{
  private float a = ViewUtils.dpToPx(15.0F);
  private ArrayList<String> b = new ArrayList();
  private float c;
  private Map<Float, String> d;
  private GestureDetector e;
  private TextPaint f;
  private WordNavView.OnTouchingWordChangedListener g;
  
  public WordNavView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private float a(int paramInt)
  {
    return getPaddingLeft() + getWidth() / 2 - this.f.measureText((String)this.b.get(paramInt)) / 2.0F;
  }
  
  private void a()
  {
    this.f = new TextPaint();
    this.f.setFlags(1);
    this.f.setColor(Color.parseColor("#878B99"));
    this.f.setTextSize(this.a);
    this.c = Math.abs(this.f.getFontMetrics().top);
    this.e = new GestureDetector(getContext(), new WordNavView.MySimpleGestureDetector(this, null));
  }
  
  private float b(int paramInt)
  {
    return getPaddingTop() + getHeight() / this.b.size() * (paramInt + 1) - this.c / 2.0F;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.d = new HashMap();
    int i = 0;
    while (i < this.b.size())
    {
      float f1 = b(i);
      paramCanvas.drawText((String)this.b.get(i), a(i), f1, this.f);
      this.d.put(Float.valueOf(f1), this.b.get(i));
      i += 1;
    }
    super.onDraw(paramCanvas);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    this.e.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setIndexList(ArrayList<String> paramArrayList)
  {
    this.b.clear();
    this.b.addAll(paramArrayList);
    getLayoutParams().height = (this.b.size() * (int)(this.a + ViewUtils.dpToPx(5.0F)));
    requestLayout();
    invalidate();
  }
  
  public void setOnTouchingWordChangedListener(WordNavView.OnTouchingWordChangedListener paramOnTouchingWordChangedListener)
  {
    this.g = paramOnTouchingWordChangedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.WordNavView
 * JD-Core Version:    0.7.0.1
 */