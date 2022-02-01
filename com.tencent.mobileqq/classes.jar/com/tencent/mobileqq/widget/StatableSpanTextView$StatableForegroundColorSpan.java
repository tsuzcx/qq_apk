package com.tencent.mobileqq.widget;

import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.util.StateSet;
import java.util.ArrayList;
import java.util.Arrays;

public class StatableSpanTextView$StatableForegroundColorSpan
  extends ForegroundColorSpan
{
  public static final int[] a = { 16842919 };
  ArrayList<int[]> b;
  ArrayList<Integer> c;
  private int[] d;
  private int e;
  
  public StatableSpanTextView$StatableForegroundColorSpan(int paramInt)
  {
    super(paramInt);
    this.e = paramInt;
  }
  
  public StatableSpanTextView$StatableForegroundColorSpan(int paramInt1, int paramInt2)
  {
    this(paramInt1);
    a(a, Integer.valueOf(paramInt2));
  }
  
  private int b(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = this.b;
    if (localArrayList == null) {
      return super.getForegroundColor();
    }
    int j = this.c.size();
    int i = 0;
    while (i < j)
    {
      if (StateSet.stateSetMatches((int[])localArrayList.get(i), paramArrayOfInt)) {
        return ((Integer)this.c.get(i)).intValue();
      }
      i += 1;
    }
    return super.getForegroundColor();
  }
  
  public int a(int[] paramArrayOfInt, Integer paramInteger)
  {
    if (this.b == null)
    {
      this.b = new ArrayList();
      this.c = new ArrayList();
    }
    this.b.add(paramArrayOfInt);
    this.c.add(paramInteger);
    return this.c.size();
  }
  
  public void a(int[] paramArrayOfInt)
  {
    if (!Arrays.equals(this.d, paramArrayOfInt))
    {
      this.d = paramArrayOfInt;
      this.e = b(paramArrayOfInt);
    }
  }
  
  public int getForegroundColor()
  {
    return this.e;
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan
 * JD-Core Version:    0.7.0.1
 */