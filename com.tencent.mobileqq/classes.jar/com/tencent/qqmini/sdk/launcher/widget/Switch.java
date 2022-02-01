package com.tencent.qqmini.sdk.launcher.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.CompoundButton;
import com.tencent.qqmini.sdk.launcher.R.attr;
import com.tencent.qqmini.sdk.launcher.R.style;
import com.tencent.qqmini.sdk.launcher.R.styleable;

public class Switch
  extends CompoundButton
{
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  private static final int MONOSPACE = 3;
  private static final int SANS = 1;
  private static final int SERIF = 2;
  private static final int TOUCH_MODE_DOWN = 1;
  private static final int TOUCH_MODE_DRAGGING = 2;
  private static final int TOUCH_MODE_IDLE = 0;
  private int mMinFlingVelocity;
  private Layout mOffLayout;
  private Layout mOnLayout;
  private int mSwitchBottom;
  private int mSwitchHeight;
  private int mSwitchLeft;
  private int mSwitchMinWidth;
  private int mSwitchPadding;
  private int mSwitchRight;
  private int mSwitchTop;
  private TransformationMethod2 mSwitchTransformationMethod;
  private int mSwitchWidth;
  private final Rect mTempRect = new Rect();
  private ColorStateList mTextColors;
  private CharSequence mTextOff;
  private CharSequence mTextOn;
  private TextPaint mTextPaint = new TextPaint(1);
  private Drawable mThumbDrawable;
  private float mThumbPosition;
  private int mThumbTextPadding;
  private int mThumbWidth;
  private int mTouchMode;
  private int mTouchSlop;
  private float mTouchX;
  private float mTouchY;
  private Drawable mTrackDrawable;
  private VelocityTracker mVelocityTracker = VelocityTracker.obtain();
  
  public Switch(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Switch(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.mini_sdk_switchStyle);
  }
  
  public Switch(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Resources localResources = getResources();
    this.mTextPaint.density = localResources.getDisplayMetrics().density;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.mini_sdk_Switch, paramInt, R.style.mini_sdk_switch_optimus);
    this.mThumbDrawable = paramAttributeSet.getDrawable(R.styleable.mini_sdk_Switch_mini_sdk_thumb);
    this.mTrackDrawable = paramAttributeSet.getDrawable(R.styleable.mini_sdk_Switch_mini_sdk_track);
    this.mTextOn = paramAttributeSet.getText(R.styleable.mini_sdk_Switch_mini_sdk_textOn);
    if (this.mTextOn == null) {
      this.mTextOn = "";
    }
    this.mTextOff = paramAttributeSet.getText(R.styleable.mini_sdk_Switch_mini_sdk_textOff);
    if (this.mTextOff == null) {
      this.mTextOff = "";
    }
    this.mThumbTextPadding = paramAttributeSet.getDimensionPixelSize(R.styleable.mini_sdk_Switch_mini_sdk_thumbTextPadding, 0);
    this.mSwitchMinWidth = paramAttributeSet.getDimensionPixelSize(R.styleable.mini_sdk_Switch_mini_sdk_switchMinWidth, 0);
    this.mSwitchPadding = paramAttributeSet.getDimensionPixelSize(R.styleable.mini_sdk_Switch_mini_sdk_switchPadding, 0);
    paramInt = paramAttributeSet.getResourceId(R.styleable.mini_sdk_Switch_mini_sdk_switchTextAppearance, 0);
    if (paramInt != 0) {
      setSwitchTextAppearance(paramContext, paramInt);
    }
    paramAttributeSet.recycle();
    paramContext = ViewConfiguration.get(paramContext);
    this.mTouchSlop = paramContext.getScaledTouchSlop();
    this.mMinFlingVelocity = paramContext.getScaledMinimumFlingVelocity();
    refreshDrawableState();
    setChecked(isChecked());
    setOnClickListener(new Switch.1(this));
  }
  
  private void animateThumbToCheckedState(boolean paramBoolean)
  {
    setChecked(paramBoolean);
  }
  
  private void cancelSuperTouch(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.setAction(3);
    super.onTouchEvent(paramMotionEvent);
    paramMotionEvent.recycle();
  }
  
  private boolean getTargetCheckedState()
  {
    return this.mThumbPosition >= getThumbScrollRange() / 2;
  }
  
  private int getThumbScrollRange()
  {
    Drawable localDrawable = this.mTrackDrawable;
    if (localDrawable == null) {
      return 0;
    }
    localDrawable.getPadding(this.mTempRect);
    return this.mSwitchWidth - this.mThumbWidth - this.mTempRect.left - this.mTempRect.right;
  }
  
  private boolean hitThumb(float paramFloat1, float paramFloat2)
  {
    this.mThumbDrawable.getPadding(this.mTempRect);
    int i = this.mSwitchTop;
    int j = this.mTouchSlop;
    int k = this.mSwitchLeft + (int)(this.mThumbPosition + 0.5F) - j;
    int m = this.mThumbWidth;
    int n = this.mTempRect.left;
    int i1 = this.mTempRect.right;
    int i2 = this.mTouchSlop;
    int i3 = this.mSwitchBottom;
    return (paramFloat1 > k) && (paramFloat1 < m + k + n + i1 + i2) && (paramFloat2 > i - j) && (paramFloat2 < i3 + i2);
  }
  
  private Layout makeLayout(CharSequence paramCharSequence)
  {
    TransformationMethod2 localTransformationMethod2 = this.mSwitchTransformationMethod;
    CharSequence localCharSequence = paramCharSequence;
    if (localTransformationMethod2 != null) {
      localCharSequence = localTransformationMethod2.getTransformation(paramCharSequence, this);
    }
    paramCharSequence = this.mTextPaint;
    return new StaticLayout(localCharSequence, paramCharSequence, (int)Math.ceil(Layout.getDesiredWidth(localCharSequence, paramCharSequence)), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
  }
  
  private void setSwitchTypefaceByIndex(int paramInt1, int paramInt2)
  {
    Typeface localTypeface;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3) {
          localTypeface = null;
        } else {
          localTypeface = Typeface.MONOSPACE;
        }
      }
      else {
        localTypeface = Typeface.SERIF;
      }
    }
    else {
      localTypeface = Typeface.SANS_SERIF;
    }
    setSwitchTypeface(localTypeface, paramInt2);
  }
  
  private void setThumbPosition(boolean paramBoolean)
  {
    float f;
    if (paramBoolean) {
      f = getThumbScrollRange();
    } else {
      f = 0.0F;
    }
    this.mThumbPosition = f;
  }
  
  private void stopDrag(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    this.mTouchMode = 0;
    int i;
    if ((paramMotionEvent.getAction() == 1) && (isEnabled())) {
      i = 1;
    } else {
      i = 0;
    }
    cancelSuperTouch(paramMotionEvent);
    if (i != 0)
    {
      this.mVelocityTracker.computeCurrentVelocity(1000);
      float f = this.mVelocityTracker.getXVelocity();
      if (Math.abs(f) > this.mMinFlingVelocity)
      {
        if (f > 0.0F) {
          bool = true;
        }
      }
      else {
        bool = getTargetCheckedState();
      }
      animateThumbToCheckedState(bool);
      return;
    }
    animateThumbToCheckedState(isChecked());
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Drawable localDrawable = this.mThumbDrawable;
    if (localDrawable != null) {
      localDrawable.setState(arrayOfInt);
    }
    localDrawable = this.mTrackDrawable;
    if (localDrawable != null) {
      localDrawable.setState(arrayOfInt);
    }
    invalidate();
  }
  
  public int getCompoundPaddingRight()
  {
    int j = super.getCompoundPaddingRight() + this.mSwitchWidth;
    int i = j;
    if (!TextUtils.isEmpty(getText())) {
      i = j + this.mSwitchPadding;
    }
    return i;
  }
  
  public int getSwitchMinWidth()
  {
    return this.mSwitchMinWidth;
  }
  
  public int getSwitchPadding()
  {
    return this.mSwitchPadding;
  }
  
  public CharSequence getTextOff()
  {
    return this.mTextOff;
  }
  
  public CharSequence getTextOn()
  {
    return this.mTextOn;
  }
  
  public Drawable getThumbDrawable()
  {
    return this.mThumbDrawable;
  }
  
  public int getThumbTextPadding()
  {
    return this.mThumbTextPadding;
  }
  
  public Drawable getTrackDrawable()
  {
    return this.mTrackDrawable;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, CHECKED_STATE_SET);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int k = this.mSwitchLeft;
    int i = this.mSwitchTop;
    int i1 = this.mSwitchRight;
    int j = this.mSwitchBottom;
    this.mTrackDrawable.setBounds(k, i, i1, j);
    this.mTrackDrawable.draw(paramCanvas);
    paramCanvas.save();
    this.mTrackDrawable.getPadding(this.mTempRect);
    int n = k + this.mTempRect.left;
    k = this.mTempRect.top;
    int i2 = this.mTempRect.right;
    int m = this.mTempRect.bottom;
    paramCanvas.clipRect(n, i, i1 - i2, j);
    this.mThumbDrawable.getPadding(this.mTempRect);
    i2 = (int)this.mThumbPosition;
    i1 = n - this.mTempRect.left + i2;
    n = n + i2 + this.mThumbWidth + this.mTempRect.right;
    this.mThumbDrawable.setBounds(i1, i, n, j);
    this.mThumbDrawable.draw(paramCanvas);
    Object localObject = this.mTextColors;
    if (localObject != null) {
      this.mTextPaint.setColor(((ColorStateList)localObject).getColorForState(getDrawableState(), this.mTextColors.getDefaultColor()));
    }
    this.mTextPaint.drawableState = getDrawableState();
    if (getTargetCheckedState()) {
      localObject = this.mOnLayout;
    } else {
      localObject = this.mOffLayout;
    }
    if (localObject != null)
    {
      paramCanvas.translate((i1 + n) / 2 - ((Layout)localObject).getWidth() / 2, (k + i + (j - m)) / 2 - ((Layout)localObject).getHeight() / 2);
      ((Layout)localObject).draw(paramCanvas);
    }
    paramCanvas.restore();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    setThumbPosition(isChecked());
    paramInt3 = getWidth() - getPaddingRight();
    paramInt4 = this.mSwitchWidth;
    paramInt1 = getGravity() & 0x70;
    if (paramInt1 != 16) {
      if (paramInt1 != 80)
      {
        paramInt1 = getPaddingTop();
        paramInt2 = this.mSwitchHeight;
      }
    }
    for (;;)
    {
      paramInt2 += paramInt1;
      break;
      paramInt2 = getHeight() - getPaddingBottom();
      paramInt1 = paramInt2 - this.mSwitchHeight;
      break;
      paramInt1 = (getPaddingTop() + getHeight() - getPaddingBottom()) / 2;
      paramInt2 = this.mSwitchHeight;
      paramInt1 -= paramInt2 / 2;
    }
    this.mSwitchLeft = (paramInt3 - paramInt4);
    this.mSwitchTop = paramInt1;
    this.mSwitchBottom = paramInt2;
    this.mSwitchRight = paramInt3;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mOnLayout == null) {
      this.mOnLayout = makeLayout(this.mTextOn);
    }
    if (this.mOffLayout == null) {
      this.mOffLayout = makeLayout(this.mTextOff);
    }
    this.mTrackDrawable.getPadding(this.mTempRect);
    int i = Math.max(Math.max(this.mOnLayout.getWidth(), this.mOffLayout.getWidth()), this.mThumbDrawable.getIntrinsicWidth());
    int j = Math.max(Math.max(this.mSwitchMinWidth, this.mTrackDrawable.getIntrinsicWidth()), this.mThumbTextPadding * 4 + i + this.mTempRect.left + this.mTempRect.right);
    int k = this.mTrackDrawable.getIntrinsicHeight();
    this.mThumbWidth = (i + this.mThumbTextPadding * 2);
    this.mSwitchWidth = j;
    this.mSwitchHeight = k;
    super.onMeasure(paramInt1, paramInt2);
    if (getMeasuredHeight() < k) {
      setMeasuredDimension(getMeasuredWidth(), k);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    float f1;
    float f2;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            break label266;
          }
        }
        else
        {
          i = this.mTouchMode;
          if (i == 0) {
            break label266;
          }
          if (i != 1)
          {
            if (i != 2) {
              break label266;
            }
            f1 = paramMotionEvent.getX();
            f2 = this.mTouchX;
            f2 = Math.max(0.0F, Math.min(this.mThumbPosition + (f1 - f2), getThumbScrollRange()));
            if (f2 != this.mThumbPosition)
            {
              this.mThumbPosition = f2;
              this.mTouchX = f1;
              invalidate();
            }
            return true;
          }
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if ((Math.abs(f1 - this.mTouchX) <= this.mTouchSlop) && (Math.abs(f2 - this.mTouchY) <= this.mTouchSlop)) {
            break label266;
          }
          this.mTouchMode = 2;
          getParent().requestDisallowInterceptTouchEvent(true);
          this.mTouchX = f1;
          this.mTouchY = f2;
          return true;
        }
      }
      if (this.mTouchMode == 2)
      {
        stopDrag(paramMotionEvent);
        return true;
      }
      this.mTouchMode = 0;
      this.mVelocityTracker.clear();
    }
    else
    {
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      if ((isEnabled()) && (hitThumb(f1, f2)))
      {
        this.mTouchMode = 1;
        this.mTouchX = f1;
        this.mTouchY = f2;
      }
    }
    label266:
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    super.setChecked(paramBoolean);
    setThumbPosition(isChecked());
    invalidate();
  }
  
  public void setSwitchMinWidth(int paramInt)
  {
    this.mSwitchMinWidth = paramInt;
    requestLayout();
  }
  
  public void setSwitchPadding(int paramInt)
  {
    this.mSwitchPadding = paramInt;
    requestLayout();
  }
  
  public void setSwitchTextAppearance(Context paramContext, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramInt, R.styleable.mini_sdk_TextAppearanceSwitch);
    ColorStateList localColorStateList = paramContext.getColorStateList(R.styleable.mini_sdk_TextAppearanceSwitch_mini_sdk_textColor);
    if (localColorStateList != null) {
      this.mTextColors = localColorStateList;
    } else {
      this.mTextColors = getTextColors();
    }
    paramInt = paramContext.getDimensionPixelSize(R.styleable.mini_sdk_TextAppearanceSwitch_mini_sdk_textSize, 0);
    if (paramInt != 0)
    {
      float f = paramInt;
      if (f != this.mTextPaint.getTextSize())
      {
        this.mTextPaint.setTextSize(f);
        requestLayout();
      }
    }
    setSwitchTypefaceByIndex(paramContext.getInt(R.styleable.mini_sdk_TextAppearanceSwitch_mini_sdk_typeface, -1), paramContext.getInt(R.styleable.mini_sdk_TextAppearanceSwitch_mini_sdk_textStyle, -1));
    if (paramContext.getBoolean(R.styleable.mini_sdk_TextAppearanceSwitch_mini_sdk_textAllCaps, false))
    {
      this.mSwitchTransformationMethod = new AllCapsTransformationMethod(getContext());
      this.mSwitchTransformationMethod.setLengthChangesAllowed(true);
    }
    else
    {
      this.mSwitchTransformationMethod = null;
    }
    paramContext.recycle();
  }
  
  public void setSwitchTypeface(Typeface paramTypeface)
  {
    if (this.mTextPaint.getTypeface() != paramTypeface)
    {
      this.mTextPaint.setTypeface(paramTypeface);
      requestLayout();
      invalidate();
    }
  }
  
  public void setSwitchTypeface(Typeface paramTypeface, int paramInt)
  {
    float f = 0.0F;
    boolean bool = false;
    if (paramInt > 0)
    {
      if (paramTypeface == null) {
        paramTypeface = Typeface.defaultFromStyle(paramInt);
      } else {
        paramTypeface = Typeface.create(paramTypeface, paramInt);
      }
      setSwitchTypeface(paramTypeface);
      int i;
      if (paramTypeface != null) {
        i = paramTypeface.getStyle();
      } else {
        i = 0;
      }
      paramInt = (i ^ 0xFFFFFFFF) & paramInt;
      paramTypeface = this.mTextPaint;
      if ((paramInt & 0x1) != 0) {
        bool = true;
      }
      paramTypeface.setFakeBoldText(bool);
      paramTypeface = this.mTextPaint;
      if ((paramInt & 0x2) != 0) {
        f = -0.25F;
      }
      paramTypeface.setTextSkewX(f);
      return;
    }
    this.mTextPaint.setFakeBoldText(false);
    this.mTextPaint.setTextSkewX(0.0F);
    setSwitchTypeface(paramTypeface);
  }
  
  public void setTextOff(CharSequence paramCharSequence)
  {
    this.mTextOff = paramCharSequence;
    requestLayout();
  }
  
  public void setTextOn(CharSequence paramCharSequence)
  {
    this.mTextOn = paramCharSequence;
    requestLayout();
  }
  
  public void setThumbDrawable(Drawable paramDrawable)
  {
    this.mThumbDrawable = paramDrawable;
    requestLayout();
  }
  
  public void setThumbResource(int paramInt)
  {
    setThumbDrawable(getContext().getResources().getDrawable(paramInt));
  }
  
  public void setThumbTextPadding(int paramInt)
  {
    this.mThumbTextPadding = paramInt;
    requestLayout();
  }
  
  public void setTrackDrawable(Drawable paramDrawable)
  {
    this.mTrackDrawable = paramDrawable;
    requestLayout();
  }
  
  public void setTrackResource(int paramInt)
  {
    setTrackDrawable(getContext().getResources().getDrawable(paramInt));
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.mThumbDrawable) || (paramDrawable == this.mTrackDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.widget.Switch
 * JD-Core Version:    0.7.0.1
 */