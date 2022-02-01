package com.tencent.mobileqq.kandian.base.view.widget.ticker;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.kandian.api.R.styleable;
import java.util.ArrayList;

public class TickerView
  extends View
{
  private static final Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new AccelerateDecelerateInterpolator();
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F });
  protected final Paint a;
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private final TickerColumnManager jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerColumnManager = new TickerColumnManager(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerDrawMetrics);
  private final TickerDrawMetrics jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerDrawMetrics = new TickerDrawMetrics(this.jdField_a_of_type_AndroidGraphicsPaint);
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private Interpolator jdField_b_of_type_AndroidViewAnimationInterpolator;
  private String jdField_b_of_type_JavaLangString;
  private int c;
  private int d;
  private int e;
  
  public TickerView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsPaint = new TextPaint(1);
    a(paramContext, null, 0, 0);
  }
  
  public TickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsPaint = new TextPaint(1);
    a(paramContext, paramAttributeSet, 0, 0);
  }
  
  public TickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsPaint = new TextPaint(1);
    a(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  private int a()
  {
    float f;
    if (this.jdField_a_of_type_Boolean) {
      f = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerColumnManager.b();
    } else {
      f = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerColumnManager.a();
    }
    return (int)f + getPaddingLeft() + getPaddingRight();
  }
  
  private void a()
  {
    int i = this.jdField_a_of_type_Int;
    int k = a();
    int j = 1;
    if (i != k) {
      i = 1;
    } else {
      i = 0;
    }
    if (this.jdField_b_of_type_Int == b()) {
      j = 0;
    }
    if ((i != 0) || (j != 0)) {
      requestLayout();
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    float f1 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerColumnManager.b();
    float f2 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerDrawMetrics.a();
    a(paramCanvas, this.jdField_c_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect, f1, f2);
  }
  
  static void a(Canvas paramCanvas, int paramInt, Rect paramRect, float paramFloat1, float paramFloat2)
  {
    int i = paramRect.width();
    int j = paramRect.height();
    float f2;
    if ((paramInt & 0x10) == 16) {
      f2 = paramRect.top + (j - paramFloat2) / 2.0F;
    } else {
      f2 = 0.0F;
    }
    float f1;
    if ((paramInt & 0x1) == 1) {
      f1 = paramRect.left + (i - paramFloat1) / 2.0F;
    } else {
      f1 = 0.0F;
    }
    if ((paramInt & 0x30) == 48) {
      f2 = 0.0F;
    }
    if ((paramInt & 0x50) == 80) {
      f2 = paramRect.top + (j - paramFloat2);
    }
    if ((paramInt & 0x800003) == 8388611) {
      f1 = 0.0F;
    }
    if ((paramInt & 0x800005) == 8388613) {
      f1 = paramRect.left + (i - paramFloat1);
    }
    paramCanvas.translate(f1, f2);
    paramCanvas.clipRect(0.0F, 0.0F, paramFloat1, paramFloat2);
  }
  
  private int b()
  {
    return (int)this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerDrawMetrics.a() + getPaddingTop() + getPaddingBottom();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerDrawMetrics.a();
    a();
    invalidate();
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    TickerView.StyledAttributes localStyledAttributes = new TickerView.StyledAttributes(this, paramContext.getResources());
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.bW, paramInt1, paramInt2);
    paramInt1 = paramAttributeSet.getResourceId(R.styleable.e, -1);
    if (paramInt1 != -1)
    {
      paramContext = paramContext.obtainStyledAttributes(paramInt1, R.styleable.bW);
      localStyledAttributes.a(paramContext);
      paramContext.recycle();
    }
    localStyledAttributes.a(paramAttributeSet);
    this.jdField_b_of_type_AndroidViewAnimationInterpolator = jdField_a_of_type_AndroidViewAnimationInterpolator;
    this.jdField_b_of_type_Long = paramAttributeSet.getInt(R.styleable.p, 350);
    this.jdField_a_of_type_Boolean = paramAttributeSet.getBoolean(R.styleable.o, false);
    this.jdField_c_of_type_Int = localStyledAttributes.jdField_a_of_type_Int;
    if (localStyledAttributes.jdField_b_of_type_Int != 0) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(localStyledAttributes.jdField_c_of_type_Float, localStyledAttributes.jdField_a_of_type_Float, localStyledAttributes.jdField_b_of_type_Float, localStyledAttributes.jdField_b_of_type_Int);
    }
    if (localStyledAttributes.jdField_d_of_type_Int != 0)
    {
      this.e = localStyledAttributes.jdField_d_of_type_Int;
      setTypeface(this.jdField_a_of_type_AndroidGraphicsPaint.getTypeface());
    }
    setTextColor(localStyledAttributes.jdField_c_of_type_Int);
    setTextSize(localStyledAttributes.jdField_d_of_type_Float);
    paramInt1 = paramAttributeSet.getInt(R.styleable.q, 0);
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (isInEditMode()) {
          setCharacterLists(new String[] { TickerUtils.a() });
        }
      }
      else {
        setCharacterLists(new String[] { TickerUtils.b() });
      }
    }
    else {
      setCharacterLists(new String[] { TickerUtils.a() });
    }
    paramInt1 = paramAttributeSet.getInt(R.styleable.r, 0);
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 == 2)
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerDrawMetrics.a(2);
        }
        else
        {
          paramContext = new StringBuilder();
          paramContext.append("Unsupported ticker_defaultPreferredScrollingDirection: ");
          paramContext.append(paramInt1);
          throw new IllegalArgumentException(paramContext.toString());
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerDrawMetrics.a(1);
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerDrawMetrics.a(0);
    }
    if (a()) {
      setText(localStyledAttributes.jdField_a_of_type_JavaLangString, false);
    } else {
      this.jdField_b_of_type_JavaLangString = localStyledAttributes.jdField_a_of_type_JavaLangString;
    }
    paramAttributeSet.recycle();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new TickerView.1(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new TickerView.2(this));
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerColumnManager.a() != null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    a(paramCanvas);
    paramCanvas.translate(0.0F, this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerDrawMetrics.b());
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerColumnManager.a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = a();
    this.jdField_b_of_type_Int = b();
    setMeasuredDimension(resolveSize(this.jdField_a_of_type_Int, paramInt1), resolveSize(this.jdField_b_of_type_Int, paramInt2));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_AndroidGraphicsRect.set(getPaddingLeft(), getPaddingTop(), paramInt1 - getPaddingRight(), paramInt2 - getPaddingBottom());
  }
  
  public void setAnimateMeasurementChange(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setAnimationDelay(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void setAnimationDuration(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void setAnimationInterpolator(Interpolator paramInterpolator)
  {
    this.jdField_b_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
  }
  
  public void setCharacterLists(String... paramVarArgs)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerColumnManager.a(paramVarArgs);
    paramVarArgs = this.jdField_b_of_type_JavaLangString;
    if (paramVarArgs != null)
    {
      setText(paramVarArgs, false);
      this.jdField_b_of_type_JavaLangString = null;
    }
  }
  
  public void setCustomCharacterList(ArrayList<String> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerColumnManager.a(paramArrayList);
  }
  
  public void setDigitalAnimWidthSpeedIncrement(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerColumnManager.a(paramBoolean);
  }
  
  public void setGravity(int paramInt)
  {
    if (this.jdField_c_of_type_Int != paramInt)
    {
      this.jdField_c_of_type_Int = paramInt;
      invalidate();
    }
  }
  
  public void setIgnoreWidthAnim(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerColumnManager.b(paramBoolean);
  }
  
  public void setPreferredScrollingDirection(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerDrawMetrics.a(paramInt);
  }
  
  public void setText(String paramString)
  {
    setText(paramString, TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString) ^ true);
  }
  
  public void setText(String paramString, boolean paramBoolean)
  {
    if (TextUtils.equals(paramString, this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    char[] arrayOfChar;
    if (paramString == null) {
      arrayOfChar = new char[0];
    } else {
      arrayOfChar = paramString.toCharArray();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerColumnManager.a(arrayOfChar);
    setContentDescription(paramString);
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      }
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setStartDelay(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(this.jdField_b_of_type_Long);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(this.jdField_b_of_type_AndroidViewAnimationInterpolator);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerColumnManager.a(1.0F);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetTickerTickerColumnManager.a();
    a();
    invalidate();
  }
  
  public void setTextColor(int paramInt)
  {
    if (this.jdField_d_of_type_Int != paramInt)
    {
      this.jdField_d_of_type_Int = paramInt;
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_d_of_type_Int);
      invalidate();
    }
  }
  
  public void setTextSize(float paramFloat)
  {
    if (this.jdField_a_of_type_Float != paramFloat)
    {
      this.jdField_a_of_type_Float = paramFloat;
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(paramFloat);
      b();
    }
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    int i = this.e;
    Typeface localTypeface;
    if (i == 3)
    {
      localTypeface = Typeface.create(paramTypeface, 3);
    }
    else if (i == 1)
    {
      localTypeface = Typeface.create(paramTypeface, 1);
    }
    else
    {
      localTypeface = paramTypeface;
      if (i == 2) {
        localTypeface = Typeface.create(paramTypeface, 2);
      }
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(localTypeface);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ticker.TickerView
 * JD-Core Version:    0.7.0.1
 */