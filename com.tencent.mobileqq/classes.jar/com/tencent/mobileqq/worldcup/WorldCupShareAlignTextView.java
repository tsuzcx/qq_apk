package com.tencent.mobileqq.worldcup;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import java.util.ArrayList;
import java.util.List;

public class WorldCupShareAlignTextView
  extends TextView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float = 1.0F;
  private int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float = 0.0F;
  private int jdField_d_of_type_Int;
  private int e;
  
  public WorldCupShareAlignTextView(Context paramContext)
  {
    super(paramContext);
    setTextIsSelectable(false);
  }
  
  public WorldCupShareAlignTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setTextIsSelectable(false);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16843287, 16843288 });
    this.jdField_d_of_type_Float = paramContext.getDimensionPixelSize(0, 0);
    this.jdField_c_of_type_Float = paramContext.getFloat(1, 1.0F);
    this.e = getPaddingBottom();
    paramContext.recycle();
  }
  
  private void a(Paint paramPaint, String paramString)
  {
    int j = 0;
    if (paramString.length() == 0)
    {
      this.jdField_a_of_type_JavaUtilList.add("\n");
      return;
    }
    float f = paramPaint.measureText("中");
    int k = (int)(this.jdField_a_of_type_Int / f);
    StringBuilder localStringBuilder = new StringBuilder(paramString.substring(0, Math.min(k + 1, paramString.length())));
    int i = k + 1;
    for (;;)
    {
      if (i < paramString.length()) {
        if (paramPaint.measureText(paramString.substring(j, i + 1)) > this.jdField_a_of_type_Int)
        {
          this.jdField_a_of_type_JavaUtilList.add(localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          if (paramString.length() - i > k)
          {
            localStringBuilder.append(paramString.substring(i, i + k));
            j = i;
            i = i + k - 1;
            i += 1;
            continue;
          }
          this.jdField_a_of_type_JavaUtilList.add(paramString.substring(i));
        }
      }
    }
    for (;;)
    {
      if (localStringBuilder.length() > 0) {
        this.jdField_a_of_type_JavaUtilList.add(localStringBuilder.toString());
      }
      this.jdField_b_of_type_JavaUtilList.add(Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size() - 1));
      return;
      localStringBuilder.append(paramString.charAt(i));
      break;
    }
  }
  
  private void a(String paramString, float paramFloat, int paramInt)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setText(paramString);
    localTextView.setTextSize(0, paramFloat);
    localTextView.measure(View.MeasureSpec.makeMeasureSpec(paramInt, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    this.jdField_d_of_type_Int = localTextView.getLineCount();
    this.jdField_c_of_type_Int = localTextView.getMeasuredHeight();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    TextPaint localTextPaint = getPaint();
    localTextPaint.setColor(getCurrentTextColor());
    localTextPaint.drawableState = getDrawableState();
    this.jdField_a_of_type_Int = getMeasuredWidth();
    Object localObject = localTextPaint.getFontMetrics();
    float f2 = getTextSize() - (((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).descent + ((Paint.FontMetrics)localObject).ascent - ((Paint.FontMetrics)localObject).top);
    if ((getGravity() & 0x1000) == 0) {
      f2 += (this.jdField_a_of_type_Float - f2) / 2.0F;
    }
    for (;;)
    {
      int k = getPaddingTop();
      int m = getPaddingLeft();
      int i = getPaddingRight();
      this.jdField_a_of_type_Int = (this.jdField_a_of_type_Int - m - i);
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        float f6 = i;
        float f7 = this.jdField_a_of_type_Float;
        localObject = (String)this.jdField_a_of_type_JavaUtilList.get(i);
        float f5 = m;
        float f8 = this.jdField_a_of_type_Int - localTextPaint.measureText((String)localObject);
        float f3 = f8 / (((String)localObject).length() - 1);
        float f1 = f5;
        float f4;
        if (this.jdField_b_of_type_JavaUtilList.contains(Integer.valueOf(i)))
        {
          f4 = 0.0F;
          if (this.jdField_b_of_type_Int != 1) {
            break label331;
          }
          f1 = f5 + f8 / 2.0F;
          f3 = f4;
        }
        for (;;)
        {
          int j = 0;
          while (j < ((String)localObject).length())
          {
            f4 = localTextPaint.measureText(((String)localObject).substring(0, j));
            f5 = j;
            paramCanvas.drawText(((String)localObject).substring(j, j + 1), f4 + f5 * f3 + f1, k + (f6 * f7 + f2) + this.jdField_b_of_type_Float * i, localTextPaint);
            j += 1;
          }
          label331:
          f3 = f4;
          f1 = f5;
          if (this.jdField_b_of_type_Int == 2)
          {
            f1 = f5 + f8;
            f3 = f4;
          }
        }
        i += 1;
      }
      return;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int = getMeasuredWidth();
      String str = getText().toString();
      TextPaint localTextPaint = getPaint();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.clear();
      String[] arrayOfString = str.split("\\n");
      paramInt2 = arrayOfString.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        a(localTextPaint, arrayOfString[paramInt1]);
        paramInt1 += 1;
      }
      a(str, localTextPaint.getTextSize(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      this.jdField_a_of_type_Float = (this.jdField_c_of_type_Int * 1.0F / this.jdField_d_of_type_Int);
      this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float * (this.jdField_c_of_type_Float - 1.0F) + this.jdField_d_of_type_Float);
      paramInt1 = (int)((this.jdField_b_of_type_Float + this.jdField_a_of_type_Float) * (this.jdField_a_of_type_JavaUtilList.size() - this.jdField_d_of_type_Int));
      this.jdField_b_of_type_Boolean = true;
      setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), paramInt1 + this.e);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void setAlign(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    invalidate();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.jdField_b_of_type_Boolean) {
      this.e = paramInt4;
    }
    this.jdField_b_of_type_Boolean = false;
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    this.jdField_a_of_type_Boolean = true;
    super.setText(paramCharSequence, paramBufferType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.worldcup.WorldCupShareAlignTextView
 * JD-Core Version:    0.7.0.1
 */