package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import bnne;
import bnsm;
import com.tencent.mobileqq.R.styleable;
import java.util.ArrayList;

public class QQSlidingTabView
  extends HorizontalScrollView
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842901, 16842904 };
  private int jdField_a_of_type_Int = -7829368;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private bnne jdField_a_of_type_Bnne;
  private ArrayList<View> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private boolean jdField_a_of_type_Boolean;
  private int b = -16777216;
  private int c = 14;
  private int d;
  private int e = 15;
  private int f = 5;
  private int g = 52;
  private int h;
  private int i = 4;
  private int j = -16776961;
  private int k = 1;
  private int l = -3355444;
  private int m;
  private int n = 0;
  private int o = 0;
  
  public QQSlidingTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public QQSlidingTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
    int i1;
    if (localView != null)
    {
      paramInt = getScrollX();
      i1 = this.e * 4;
      int i2 = localView.getRight() - paramInt - getWidth() + i1;
      if (i2 <= 0) {
        break label53;
      }
      smoothScrollBy(i2, 0);
    }
    label53:
    do
    {
      return;
      paramInt = localView.getLeft() - paramInt - i1;
    } while (paramInt >= 0);
    smoothScrollBy(paramInt, 0);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(-2, -1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.d = ((int)TypedValue.applyDimension(1, this.d, localDisplayMetrics));
    this.g = ((int)TypedValue.applyDimension(1, this.g, localDisplayMetrics));
    this.i = ((int)TypedValue.applyDimension(1, this.i, localDisplayMetrics));
    this.k = ((int)TypedValue.applyDimension(1, this.k, localDisplayMetrics));
    this.e = ((int)TypedValue.applyDimension(1, this.e, localDisplayMetrics));
    this.c = ((int)TypedValue.applyDimension(1, this.c, localDisplayMetrics));
    this.f = ((int)TypedValue.applyDimension(1, this.f, localDisplayMetrics));
    paramContext.obtainStyledAttributes(paramAttributeSet, jdField_a_of_type_ArrayOfInt).recycle();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QIMSlidingTabViewStyle);
    this.d = paramContext.getDimensionPixelSize(4, this.d);
    this.e = paramContext.getDimensionPixelSize(3, this.e);
    this.j = paramContext.getColor(0, this.j);
    this.i = paramContext.getDimensionPixelSize(1, this.i);
    this.jdField_a_of_type_Int = paramContext.getColor(6, this.jdField_a_of_type_Int);
    this.b = paramContext.getColor(5, this.b);
    this.l = paramContext.getColor(8, this.l);
    this.k = paramContext.getDimensionPixelSize(9, this.k);
    this.c = paramContext.getDimensionPixelSize(7, this.c);
    this.f = paramContext.getDimensionPixelSize(2, this.f);
    paramContext.recycle();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.j);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    setFillViewport(true);
    setWillNotDraw(false);
    setHorizontalScrollBarEnabled(false);
    this.o = bnsm.a(this.n);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i1 = getHeight();
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.m);
    if (localView != null)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.h = localView.getLeft();
        a(this.m);
        this.jdField_a_of_type_Boolean = false;
      }
      if ((this.m == 0) && (this.h < localView.getLeft())) {
        this.h = localView.getLeft();
      }
      float f1 = this.h + this.f;
      float f2 = i1 - this.i;
      int i2 = this.h;
      paramCanvas.drawRoundRect(new RectF(f1, f2, localView.getWidth() + i2 - this.f, i1), this.o, this.o, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void setIndicateColor(int paramInt)
  {
    this.j = paramInt;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.j);
    invalidate();
  }
  
  public void setTabCheckListener(bnne parambnne)
  {
    this.jdField_a_of_type_Bnne = parambnne;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.QQSlidingTabView
 * JD-Core Version:    0.7.0.1
 */