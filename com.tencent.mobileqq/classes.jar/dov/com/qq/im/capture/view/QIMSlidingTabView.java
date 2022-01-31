package dov.com.qq.im.capture.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bmbj;
import bmbk;
import bmbl;
import bmbm;
import bmbn;
import bnsm;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.widget.RedDotTextView;
import java.util.ArrayList;

public class QIMSlidingTabView
  extends HorizontalScrollView
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842901, 16842904 };
  private int jdField_a_of_type_Int = -7829368;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private LinearLayout.LayoutParams jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private bmbm jdField_a_of_type_Bmbm;
  private ArrayList<View> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  private boolean jdField_a_of_type_Boolean;
  private int b = -16777216;
  private int c = Color.parseColor("#E62555");
  private int d = 14;
  private int e;
  private int f = 15;
  private int g;
  private int h = 52;
  private int i;
  private int j = 4;
  private int k = -16776961;
  private int l = 1;
  private int m = -3355444;
  private int n;
  private int o;
  private int p = 2;
  private int q = 2;
  private int r = -1;
  
  public QIMSlidingTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public QIMSlidingTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private int a(int paramInt, View paramView)
  {
    if (paramInt < 0) {
      return -1;
    }
    paramView.setOnClickListener(new bmbk(this, paramInt));
    this.jdField_a_of_type_JavaUtilArrayList.add(paramInt, paramView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView, paramInt);
    return 0;
  }
  
  private void a()
  {
    int i2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int i1 = 0;
    if (i1 < i2)
    {
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i1);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
      if (i1 == 0) {
        localLayoutParams.setMargins(this.e, 0, 0, 0);
      }
      for (;;)
      {
        localView.setLayoutParams(localLayoutParams);
        i1 += 1;
        break;
        if (i1 == i2 - 1) {
          localLayoutParams.setMargins(0, 0, this.e, 0);
        }
      }
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(-2, -1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.e = ((int)TypedValue.applyDimension(1, this.e, localDisplayMetrics));
    this.h = ((int)TypedValue.applyDimension(1, this.h, localDisplayMetrics));
    this.j = ((int)TypedValue.applyDimension(1, this.j, localDisplayMetrics));
    this.l = ((int)TypedValue.applyDimension(1, this.l, localDisplayMetrics));
    this.f = ((int)TypedValue.applyDimension(1, this.f, localDisplayMetrics));
    this.d = ((int)TypedValue.applyDimension(1, this.d, localDisplayMetrics));
    this.g = ((int)TypedValue.applyDimension(1, this.g, localDisplayMetrics));
    paramContext.obtainStyledAttributes(paramAttributeSet, jdField_a_of_type_ArrayOfInt).recycle();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QIMSlidingTabViewStyle);
    this.e = paramContext.getDimensionPixelSize(4, this.e);
    this.f = paramContext.getDimensionPixelSize(3, this.f);
    this.k = paramContext.getColor(0, this.k);
    this.j = paramContext.getDimensionPixelSize(1, this.j);
    this.jdField_a_of_type_Int = paramContext.getColor(6, this.jdField_a_of_type_Int);
    this.b = paramContext.getColor(5, this.b);
    this.m = paramContext.getColor(8, this.m);
    this.l = paramContext.getDimensionPixelSize(9, this.l);
    this.d = paramContext.getDimensionPixelSize(7, this.d);
    this.g = paramContext.getDimensionPixelSize(2, this.g);
    paramContext.recycle();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.k);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    setFillViewport(true);
    setWillNotDraw(false);
    setHorizontalScrollBarEnabled(false);
    this.q = bnsm.a(this.p);
  }
  
  @TargetApi(11)
  private void b()
  {
    if (this.o != this.n)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.o);
      View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.n);
      int i1;
      int i2;
      if ((localObject != null) && (localView != null))
      {
        i1 = ((View)localObject).getLeft();
        i2 = localView.getLeft();
        if ((i1 == 0) && (i2 == 0)) {
          this.jdField_a_of_type_Boolean = true;
        }
      }
      else
      {
        return;
      }
      this.jdField_a_of_type_Boolean = false;
      localObject = ValueAnimator.ofInt(new int[] { i1, i2 });
      ((ValueAnimator)localObject).setDuration(100L);
      ((ValueAnimator)localObject).addUpdateListener(new bmbl(this));
      ((ValueAnimator)localObject).start();
      return;
    }
    this.i = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.n).getLeft();
    this.jdField_a_of_type_Boolean = true;
    invalidate();
  }
  
  private void b(int paramInt)
  {
    int i2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int i1 = 0;
    if (i1 < i2)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i1);
      View localView;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (i1 < this.jdField_a_of_type_JavaUtilArrayList.size()))
      {
        localView = (View)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if (i1 != paramInt) {
          break label212;
        }
        if (!(localView instanceof ImageView)) {
          break label110;
        }
        localObject = (Bundle)localView.getTag();
        if (localObject != null) {
          ((ImageView)localView).setImageResource(((Bundle)localObject).getInt("checked_image_bg_id", 2130846206));
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        label110:
        if ((localView instanceof RedDotTextView))
        {
          if (this.r == i1) {
            ((RedDotTextView)localObject).setTextColor(this.c);
          }
          for (;;)
          {
            ((RedDotTextView)localObject).a(false);
            break;
            ((RedDotTextView)localObject).setTextColor(this.b);
          }
        }
        if ((localView instanceof TextView))
        {
          ((TextView)localObject).setTextColor(this.b);
        }
        else if ((localView instanceof QIMSlidingItemView))
        {
          ((QIMSlidingItemView)localObject).a(this.b, true);
          continue;
          label212:
          if ((localView instanceof ImageView))
          {
            localObject = (Bundle)localView.getTag();
            if (localObject != null) {
              ((ImageView)localView).setImageResource(((Bundle)localObject).getInt("normal_image_bg_id", 2130846205));
            }
          }
          else if ((localView instanceof RedDotTextView))
          {
            ((RedDotTextView)localObject).setTextColor(this.jdField_a_of_type_Int);
          }
          else if ((localView instanceof TextView))
          {
            ((TextView)localObject).setTextColor(this.jdField_a_of_type_Int);
          }
          else if ((localView instanceof QIMSlidingItemView))
          {
            ((QIMSlidingItemView)localObject).a(this.jdField_a_of_type_Int, false);
          }
        }
      }
    }
  }
  
  private void c(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
    int i1;
    if (localView != null)
    {
      paramInt = getScrollX();
      i1 = this.f * 4;
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
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return;
    }
    this.n = paramInt;
    b(paramInt);
    c(paramInt);
    b();
    if (this.jdField_a_of_type_Bmbm != null) {
      this.jdField_a_of_type_Bmbm.a(paramInt);
    }
    this.o = this.n;
  }
  
  public void a(ArrayList<bmbn> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    int i1 = 0;
    int i2 = -1;
    while (i1 < paramArrayList.size())
    {
      RedDotTextView localRedDotTextView = new RedDotTextView(getContext());
      localRedDotTextView.setText(((bmbn)paramArrayList.get(i1)).jdField_a_of_type_JavaLangString);
      localRedDotTextView.setGravity(17);
      localRedDotTextView.setSingleLine();
      localRedDotTextView.setTextSize(0, this.d);
      localRedDotTextView.setPadding(this.f, 0, this.f, 0);
      localRedDotTextView.a(((bmbn)paramArrayList.get(i1)).jdField_a_of_type_Boolean);
      String str = ((bmbn)paramArrayList.get(i1)).jdField_b_of_type_JavaLangString;
      if (!TextUtils.isEmpty(str)) {
        localRedDotTextView.setContentDescription(str);
      }
      if (((bmbn)paramArrayList.get(i1)).jdField_b_of_type_Boolean) {
        i2 = i1;
      }
      a(i1, localRedDotTextView);
      i1 += 1;
    }
    this.r = i2;
    a();
  }
  
  public ArrayList<View> b()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void b(ArrayList<String> paramArrayList)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      TextView localTextView = new TextView(getContext());
      localTextView.setText((CharSequence)paramArrayList.get(i1));
      localTextView.setGravity(17);
      localTextView.setSingleLine();
      localTextView.setTextSize(0, this.d);
      localTextView.setPadding(this.f, 0, this.f, 0);
      a(i1, localTextView);
      i1 += 1;
    }
    a();
    a(0);
  }
  
  public void c(ArrayList<bmbj> paramArrayList)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    int i1 = 0;
    if (i1 < paramArrayList.size())
    {
      Object localObject;
      if (((bmbj)paramArrayList.get(i1)).jdField_a_of_type_Int == 0)
      {
        localObject = new TextView(getContext());
        ((TextView)localObject).setText(((bmbj)paramArrayList.get(i1)).jdField_a_of_type_JavaLangString);
        ((TextView)localObject).setGravity(17);
        ((TextView)localObject).setSingleLine();
        ((TextView)localObject).setTextSize(0, this.d);
        ((TextView)localObject).setPadding(this.f, 0, this.f, 0);
        a(i1, (View)localObject);
      }
      for (;;)
      {
        i1 += 1;
        break;
        localObject = new QIMSlidingItemView(getContext());
        ((QIMSlidingItemView)localObject).a(this.d, this.f);
        ((QIMSlidingItemView)localObject).setData((bmbj)paramArrayList.get(i1));
        a(i1, (View)localObject);
      }
    }
    a();
    a(0);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i2 = getHeight();
    View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(this.n);
    if (localView != null)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.i = localView.getLeft();
        c(this.n);
        this.jdField_a_of_type_Boolean = false;
      }
      if ((this.n == 0) && (this.i < localView.getLeft())) {
        this.i = localView.getLeft();
      }
      if (this.r != this.n) {
        break label183;
      }
    }
    label183:
    for (int i1 = this.c;; i1 = this.k)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i1);
      float f1 = this.i + this.g;
      float f2 = i2 - this.j;
      i1 = this.i;
      paramCanvas.drawRoundRect(new RectF(f1, f2, localView.getWidth() + i1 - this.g, i2), this.q, this.q, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
  }
  
  public void setIndicateColor(int paramInt)
  {
    this.k = paramInt;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.k);
    invalidate();
  }
  
  public void setTabCheckListener(bmbm parambmbm)
  {
    this.jdField_a_of_type_Bmbm = parambmbm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMSlidingTabView
 * JD-Core Version:    0.7.0.1
 */