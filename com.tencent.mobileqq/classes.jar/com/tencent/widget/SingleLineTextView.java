package com.tencent.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.qqui.R.styleable;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.ISkinSetTypeface;
import java.util.ArrayList;

public class SingleLineTextView
  extends View
  implements Handler.Callback, ISkinSetTypeface
{
  public static final int EXTEND_TXT_LEFT = 1;
  public static final int EXTEND_TXT_RIGHT = 2;
  public static final int EXTEND_TXT_TIMESTAMP = 0;
  private static final int MAX_TXT_LEN = 168;
  private static final int MSG_CHECK_LAYOUT = 1;
  private static final int MSG_INVALIDATE = 2;
  private static final BoringLayout.Metrics UNKNOWN_BORING = new BoringLayout.Metrics();
  private static final int VERY_WIDE = 16384;
  private boolean mBlockRelayout = false;
  private BoringLayout.Metrics mBoring;
  private int mCompoundLeft;
  private int mCompoundRight;
  private int mCurTextColor;
  private int mDefaultTextColor = -16777216;
  private SingleLineTextView.Drawables mDrawables;
  private TextUtils.TruncateAt mEllipsize = null;
  private final SingleLineTextView.ExtendText[] mExtendTexts;
  private int mGravity = 16;
  private final Handler mHandler;
  private boolean mHorizontallyScrolling;
  private int mIconDrawableGap;
  ArrayList<SingleLineTextView.IconDrawableInfo> mIconDrawableInfos;
  private int mIconDrawablePadding;
  protected SingleLineTextView.IconDrawable[] mIconDrawables;
  private boolean mIncludePad = true;
  protected Layout mLayout;
  private int mMaxWidth = 2147483647;
  private BoringLayout mSavedLayout;
  private float mSpacingAdd = 0.0F;
  private float mSpacingMult = 1.0F;
  private CharSequence mText;
  private ColorStateList mTextColor;
  private int mTextDesiredWith;
  private final TextPaint mTextPaint;
  private TransformationMethod mTransformation;
  private CharSequence mTransformed;
  protected boolean needCheckIconDrawablesWhenMeasure = false;
  
  public SingleLineTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SingleLineTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SingleLineTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = getResources();
    this.mText = "";
    this.mTransformed = "";
    this.mTextPaint = new TextPaint(1);
    this.mTextPaint.setTypeface(Typeface.SANS_SERIF);
    this.mTextPaint.density = ((Resources)localObject).getDisplayMetrics().density;
    this.mTransformation = SingleLineTransformationMethod.getInstance();
    this.mEllipsize = TextUtils.TruncateAt.END;
    this.mHorizontallyScrolling = true;
    this.mTextDesiredWith = -1;
    this.mExtendTexts = new SingleLineTextView.ExtendText[3];
    this.mHandler = new Handler(Looper.getMainLooper(), this);
    this.mCompoundLeft = 0;
    this.mCompoundRight = 0;
    this.mTextColor = ColorStateList.valueOf(-16777216);
    this.mCurTextColor = this.mTextColor.getDefaultColor();
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.aH);
      paramInt = paramAttributeSet.getDimensionPixelSize(R.styleable.O, (int)DisplayUtils.a(paramContext, 12.0F));
      paramContext = paramAttributeSet.getColorStateList(R.styleable.P);
      localObject = paramAttributeSet.getString(R.styleable.R);
      this.mMaxWidth = paramAttributeSet.getDimensionPixelSize(R.styleable.Q, 2147483647);
      this.mTextPaint.setTextSize(paramInt);
      setTextColor(paramContext);
      setText((CharSequence)localObject);
      this.mIncludePad = paramAttributeSet.getBoolean(R.styleable.S, true);
      paramAttributeSet.recycle();
    }
  }
  
  private void checkForRelayout()
  {
    this.mHandler.removeMessages(1);
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (localLayoutParams.width != -2)
    {
      int i = getWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight();
      if (i > 0)
      {
        int j = this.mLayout.getHeight();
        makeSingleLayout(this.mLayout.getWidth(), UNKNOWN_BORING, i);
        if ((localLayoutParams.height != -2) && (localLayoutParams.height != -1))
        {
          invalidate();
          return;
        }
        if (this.mLayout.getHeight() == j)
        {
          invalidate();
          return;
        }
        requestLayout();
        invalidate();
        return;
      }
    }
    nullLayouts();
    requestLayout();
    invalidate();
  }
  
  private boolean checkIfNeedHideSomeIconDrawables(int paramInt)
  {
    boolean bool2 = false;
    int i = getIconDrawablesWidth();
    boolean bool1 = bool2;
    int k;
    SingleLineTextView.IconDrawable[] arrayOfIconDrawable;
    if (i > 0)
    {
      bool1 = bool2;
      if (i > (int)DisplayUtils.a(getContext(), 105.0F))
      {
        k = Math.min(getDesiredWidth(), getResources().getDimensionPixelSize(2131296830));
        bool1 = bool2;
        if (paramInt < k)
        {
          arrayOfIconDrawable = this.mIconDrawables;
          bool1 = bool2;
          if (arrayOfIconDrawable != null) {
            i = 0;
          }
        }
      }
    }
    for (int j = paramInt;; j = paramInt)
    {
      bool1 = bool2;
      if (i < arrayOfIconDrawable.length)
      {
        SingleLineTextView.IconDrawable localIconDrawable = arrayOfIconDrawable[i];
        paramInt = j;
        if (localIconDrawable != null)
        {
          paramInt = j;
          if (localIconDrawable.mDrawable != null)
          {
            paramInt = j;
            if (!localIconDrawable.can_not_be_hide)
            {
              paramInt = j;
              if (localIconDrawable.mDrawableSize > 0)
              {
                j += localIconDrawable.mDrawableSize;
                localIconDrawable.mDrawableSize = 0;
                paramInt = j;
                if (j >= k) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  private int getDesiredWidth()
  {
    if (this.mTextDesiredWith < 0) {
      this.mTextDesiredWith = ((int)Math.ceil(Layout.getDesiredWidth(this.mTransformed, this.mTextPaint)));
    }
    return this.mTextDesiredWith;
  }
  
  private int getIconDrawablesWidth()
  {
    int j = 0;
    int i = 0;
    SingleLineTextView.IconDrawable[] arrayOfIconDrawable = this.mIconDrawables;
    if (arrayOfIconDrawable != null)
    {
      int i1 = arrayOfIconDrawable.length;
      j = 0;
      int k = 0;
      while (j < i1)
      {
        SingleLineTextView.IconDrawable localIconDrawable = arrayOfIconDrawable[j];
        int n = k;
        int m = i;
        if (localIconDrawable.mDrawable != null)
        {
          n = k;
          m = i;
          if (localIconDrawable.mDrawableSize > 0)
          {
            m = i + (this.mIconDrawablePadding + localIconDrawable.mDrawableSize);
            n = 1;
          }
        }
        j += 1;
        k = n;
        i = m;
      }
      j = i;
      if (k != 0) {
        j = i + this.mIconDrawableGap;
      }
    }
    return j;
  }
  
  private int getVerticalOffset()
  {
    int j = 0;
    int k = this.mGravity & 0x70;
    Layout localLayout = this.mLayout;
    int i = j;
    int m;
    int n;
    if (k != 48)
    {
      m = getMeasuredHeight() - getExtendedPaddingTop() - getExtendedPaddingBottom();
      n = localLayout.getHeight();
      i = j;
      if (n < m)
      {
        if (k != 80) {
          break label70;
        }
        i = m - n;
      }
    }
    return i;
    label70:
    return m - n >> 1;
  }
  
  private void invlidateSpan(Object paramObject)
  {
    Object localObject = getText();
    if ((localObject instanceof Spannable))
    {
      localObject = (Spannable)localObject;
      int j = ((Spannable)localObject).getSpanStart(paramObject);
      int k = ((Spannable)localObject).getSpanEnd(paramObject);
      SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])((Spannable)localObject).getSpans(j, k, SpanWatcher.class);
      if ((arrayOfSpanWatcher != null) && (arrayOfSpanWatcher.length > 0))
      {
        int m = arrayOfSpanWatcher.length;
        int i = 0;
        for (;;)
        {
          if (i < m)
          {
            SpanWatcher localSpanWatcher = arrayOfSpanWatcher[i];
            try
            {
              localSpanWatcher.onSpanChanged((Spannable)localObject, paramObject, j, k, j, k);
              i += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("SingleLineTextView", 2, "Exception: " + localException.getMessage());
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void nullLayouts()
  {
    if (((this.mLayout instanceof BoringLayout)) && (this.mSavedLayout == null)) {
      this.mSavedLayout = ((BoringLayout)this.mLayout);
    }
    this.mLayout = null;
  }
  
  private void updateTextColors()
  {
    int[] arrayOfInt = getDrawableState();
    int i = this.mTextColor.getColorForState(arrayOfInt, this.mDefaultTextColor);
    if (QLog.isColorLevel()) {
      QLog.i("SingleLineTextView", 2, "updateTextColors, color=" + i + ", cur=" + this.mCurTextColor);
    }
    if (i != this.mCurTextColor)
    {
      this.mCurTextColor = i;
      invalidate();
    }
  }
  
  public void drawableStateChanged()
  {
    int j = 0;
    super.drawableStateChanged();
    if ((this.mTextColor != null) && (this.mTextColor.isStateful())) {
      updateTextColors();
    }
    int[] arrayOfInt = getDrawableState();
    Object localObject1 = this.mDrawables;
    if (localObject1 != null)
    {
      if ((((SingleLineTextView.Drawables)localObject1).mDrawableLeft != null) && (((SingleLineTextView.Drawables)localObject1).mDrawableLeft.isStateful())) {
        ((SingleLineTextView.Drawables)localObject1).mDrawableLeft.setState(arrayOfInt);
      }
      if ((((SingleLineTextView.Drawables)localObject1).mDrawableRight != null) && (((SingleLineTextView.Drawables)localObject1).mDrawableRight.isStateful())) {
        ((SingleLineTextView.Drawables)localObject1).mDrawableRight.setState(arrayOfInt);
      }
      if ((((SingleLineTextView.Drawables)localObject1).mDrawableRightExt != null) && (((SingleLineTextView.Drawables)localObject1).mDrawableRightExt.isStateful())) {
        ((SingleLineTextView.Drawables)localObject1).mDrawableRightExt.setState(arrayOfInt);
      }
      if ((((SingleLineTextView.Drawables)localObject1).mDrawableRight2 != null) && (((SingleLineTextView.Drawables)localObject1).mDrawableRight2.isStateful())) {
        ((SingleLineTextView.Drawables)localObject1).mDrawableRight2.setState(arrayOfInt);
      }
    }
    localObject1 = this.mIconDrawables;
    if (localObject1 != null)
    {
      int k = localObject1.length;
      i = 0;
      while (i < k)
      {
        Object localObject2 = localObject1[i];
        if ((localObject2.mDrawable != null) && (localObject2.mDrawable.isStateful())) {
          localObject2.mDrawable.setState(arrayOfInt);
        }
        i += 1;
      }
    }
    int i = 0;
    if (i < this.mExtendTexts.length)
    {
      localObject1 = this.mExtendTexts[i];
      if (localObject1 == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (((SingleLineTextView.ExtendText)localObject1).updateTextColors(arrayOfInt)) {
          j = 1;
        }
      }
    }
    if (j != 0) {
      invalidate();
    }
  }
  
  public int getCompoundDrawablePadding()
  {
    SingleLineTextView.Drawables localDrawables = this.mDrawables;
    if (localDrawables != null) {
      return localDrawables.mDrawablePadding;
    }
    return 0;
  }
  
  public int getCompoundPaddingBottom()
  {
    return getPaddingBottom();
  }
  
  public int getCompoundPaddingLeft()
  {
    int j = getPaddingLeft();
    Object localObject = this.mDrawables;
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (((SingleLineTextView.Drawables)localObject).mDrawableLeft != null)
      {
        i = ((SingleLineTextView.Drawables)localObject).mDrawablePadding;
        i = j + (((SingleLineTextView.Drawables)localObject).mDrawableSizeLeft + i);
      }
    }
    localObject = this.mExtendTexts[1];
    j = i;
    if (localObject != null)
    {
      j = i;
      if (!((SingleLineTextView.ExtendText)localObject).mEmpty)
      {
        j = ((SingleLineTextView.ExtendText)localObject).mPadding;
        j = i + (((SingleLineTextView.ExtendText)localObject).getDesiredWith() + j);
      }
    }
    return j;
  }
  
  public int getCompoundPaddingRight()
  {
    int j = getPaddingRight();
    Object localObject = this.mDrawables;
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (((SingleLineTextView.Drawables)localObject).mDrawableRight != null)
      {
        if (((SingleLineTextView.Drawables)localObject).mDrawableRightExt == null) {
          break label198;
        }
        i = j + (((SingleLineTextView.Drawables)localObject).mDrawablePadding + ((SingleLineTextView.Drawables)localObject).mDrawableSizeRight + ((SingleLineTextView.Drawables)localObject).mDrawablePadding + ((SingleLineTextView.Drawables)localObject).mDrawableSizeRightExt + ((SingleLineTextView.Drawables)localObject).mDrawablePadding);
      }
    }
    j = i;
    if (localObject != null)
    {
      j = i;
      if (((SingleLineTextView.Drawables)localObject).mDrawableRight2 != null)
      {
        if (((SingleLineTextView.Drawables)localObject).mDrawableRight == null) {
          break label221;
        }
        j = ((SingleLineTextView.Drawables)localObject).mDrawableSizeRight2;
      }
    }
    label198:
    label221:
    int k;
    for (j = i + (((SingleLineTextView.Drawables)localObject).mDrawablePadding + j);; j = i + (((SingleLineTextView.Drawables)localObject).mDrawablePadding + (j + k)))
    {
      localObject = this.mExtendTexts[2];
      i = j;
      if (localObject != null)
      {
        i = j;
        if (!((SingleLineTextView.ExtendText)localObject).mEmpty)
        {
          i = ((SingleLineTextView.ExtendText)localObject).mPadding;
          i = j + (((SingleLineTextView.ExtendText)localObject).getDesiredWith() + i);
        }
      }
      localObject = this.mExtendTexts[0];
      j = i;
      if (localObject != null)
      {
        j = i;
        if (!((SingleLineTextView.ExtendText)localObject).mEmpty)
        {
          j = ((SingleLineTextView.ExtendText)localObject).mPadding;
          j = i + (((SingleLineTextView.ExtendText)localObject).getDesiredWith() + j);
        }
      }
      return j + getIconDrawablesWidth();
      i = j + (((SingleLineTextView.Drawables)localObject).mDrawablePadding + ((SingleLineTextView.Drawables)localObject).mDrawableSizeRight + ((SingleLineTextView.Drawables)localObject).mDrawablePadding);
      break;
      j = ((SingleLineTextView.Drawables)localObject).mDrawablePadding;
      k = ((SingleLineTextView.Drawables)localObject).mDrawableSizeRight2;
    }
  }
  
  public int getCompoundPaddingTop()
  {
    return getPaddingTop();
  }
  
  public int getExtendedPaddingBottom()
  {
    int i;
    if (this.mLayout.getLineCount() <= 1) {
      i = getCompoundPaddingBottom();
    }
    int j;
    int k;
    int m;
    int n;
    do
    {
      do
      {
        return i;
        i = getCompoundPaddingTop();
        j = getCompoundPaddingBottom();
        k = getHeight() - i - j;
        m = this.mLayout.getLineTop(1);
        i = j;
      } while (m >= k);
      n = this.mGravity & 0x70;
      if (n == 48) {
        return j + k - m;
      }
      i = j;
    } while (n == 80);
    return j + (k - m) / 2;
  }
  
  public int getExtendedPaddingTop()
  {
    int i;
    if (this.mLayout.getLineCount() <= 1) {
      i = getCompoundPaddingTop();
    }
    int j;
    int k;
    int m;
    int n;
    do
    {
      do
      {
        return i;
        j = getCompoundPaddingTop();
        i = getCompoundPaddingBottom();
        k = getHeight() - j - i;
        m = this.mLayout.getLineTop(1);
        i = j;
      } while (m >= k);
      n = this.mGravity & 0x70;
      i = j;
    } while (n == 48);
    if (n == 80) {
      return j + k - m;
    }
    return j + (k - m) / 2;
  }
  
  protected Drawable getIconDrawableWithStatus(Context paramContext, SingleLineTextView.IconDrawableInfo paramIconDrawableInfo)
  {
    return null;
  }
  
  public int getLineHeight()
  {
    return Math.round(this.mTextPaint.getFontMetricsInt(null) * this.mSpacingMult + this.mSpacingAdd);
  }
  
  public final Paint getPaint()
  {
    return this.mTextPaint;
  }
  
  public Drawable getRightDrawable()
  {
    if (this.mDrawables != null) {
      return this.mDrawables.mDrawableRight;
    }
    return null;
  }
  
  public final CharSequence getText()
  {
    return this.mText;
  }
  
  public float getTextSize()
  {
    return this.mTextPaint.getTextSize();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.mLayout != null)
      {
        checkForRelayout();
        continue;
        invalidateDrawableDelayed((Drawable)paramMessage.obj);
      }
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    int i2 = 0;
    Object localObject1;
    int m;
    if (verifyDrawable(paramDrawable))
    {
      localObject1 = paramDrawable.getBounds();
      m = getScrollX();
      int k = getScrollY();
      Object localObject2 = this.mDrawables;
      int j = k;
      int i = m;
      if (localObject2 != null)
      {
        if (paramDrawable != ((SingleLineTextView.Drawables)localObject2).mDrawableLeft) {
          break label369;
        }
        j = getCompoundPaddingTop();
        n = getCompoundPaddingBottom();
        i1 = getHeight();
        i = m + getPaddingLeft();
        j = k + ((i1 - n - j - ((SingleLineTextView.Drawables)localObject2).mDrawableHeightLeft) / 2 + j);
      }
      int i3;
      int i4;
      for (;;)
      {
        localObject2 = this.mIconDrawables;
        i1 = j;
        n = i;
        if (localObject2 == null) {
          break label535;
        }
        Object localObject3 = this.mExtendTexts[0];
        n = getWidth() - getPaddingRight() - this.mIconDrawableGap;
        k = n;
        m = i2;
        if (localObject3 != null)
        {
          k = n;
          m = i2;
          if (!((SingleLineTextView.ExtendText)localObject3).mEmpty)
          {
            k = ((SingleLineTextView.ExtendText)localObject3).getDesiredWith();
            k = n - (((SingleLineTextView.ExtendText)localObject3).mPadding + k);
            m = i2;
          }
        }
        i1 = j;
        n = i;
        if (m >= localObject2.length) {
          break label535;
        }
        if (!isSameDrawable(paramDrawable, localObject2[m])) {
          break label626;
        }
        localObject3 = localObject2[m].mCompoundRect;
        paramDrawable.copyBounds((Rect)localObject3);
        localObject2[m].mDrawableSize = ((Rect)localObject3).width();
        localObject2[m].mDrawableHeight = ((Rect)localObject3).height();
        i2 = getCompoundPaddingTop();
        i3 = getCompoundPaddingBottom();
        i4 = getHeight();
        i1 = m + 1;
        n = k;
        k = i1;
        while (k < localObject2.length)
        {
          i1 = n;
          if (localObject2[k].mDrawable != null) {
            i1 = n - (localObject2[k].mDrawableSize - this.mIconDrawablePadding);
          }
          i += i1 - localObject2[m].mDrawableSize - this.mIconDrawablePadding;
          k += 1;
          n = i1;
        }
        label369:
        if (paramDrawable == ((SingleLineTextView.Drawables)localObject2).mDrawableRight)
        {
          i = m + this.mDrawables.mDrawableRightPosition[0];
          j = k + this.mDrawables.mDrawableRightPosition[1];
        }
        else if (paramDrawable == ((SingleLineTextView.Drawables)localObject2).mDrawableRightExt)
        {
          i = m + this.mDrawables.mDrawableRight2ExtPosition[0];
          j = k + this.mDrawables.mDrawableRight2ExtPosition[1];
        }
        else
        {
          j = k;
          i = m;
          if (paramDrawable == ((SingleLineTextView.Drawables)localObject2).mDrawableRight2)
          {
            i = m + this.mDrawables.mDrawableRight2Position[0];
            j = k + this.mDrawables.mDrawableRight2Position[1];
          }
        }
      }
      int n = n - localObject2[m].mDrawableSize - this.mIconDrawablePadding + i;
      int i1 = j + ((i4 - i3 - i2 - localObject2[m].mDrawableHeight) / 2 + i2);
      label535:
      if ((n == 0) && (i1 == 0)) {
        break label635;
      }
      invalidate(((Rect)localObject1).left + n, ((Rect)localObject1).top + i1, n + ((Rect)localObject1).right, i1 + ((Rect)localObject1).bottom);
    }
    for (;;)
    {
      if (ViewCompat.isAttachedToWindow(this))
      {
        localObject1 = this.mHandler.obtainMessage(2);
        ((Message)localObject1).obj = paramDrawable;
        this.mHandler.removeMessages(2);
        this.mHandler.sendMessageDelayed((Message)localObject1, 100L);
      }
      return;
      label626:
      m += 1;
      break;
      label635:
      invalidate();
    }
  }
  
  public void invalidateDrawableDelayed(Drawable paramDrawable)
  {
    Object localObject1 = getText();
    if ((localObject1 instanceof Spannable))
    {
      localObject1 = (Spannable)localObject1;
      localObject1 = (EmoticonSpan[])((Spannable)localObject1).getSpans(0, ((Spannable)localObject1).length(), EmoticonSpan.class);
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        this.mBlockRelayout = true;
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (localObject2.getDrawable() == paramDrawable) {
            invlidateSpan(localObject2);
          }
          i += 1;
        }
        this.mBlockRelayout = false;
      }
    }
  }
  
  protected boolean isSameDrawable(Drawable paramDrawable, SingleLineTextView.IconDrawable paramIconDrawable)
  {
    return paramDrawable == paramIconDrawable.mDrawable;
  }
  
  protected void makeSingleLayout(int paramInt1, BoringLayout.Metrics paramMetrics, int paramInt2)
  {
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      Layout.Alignment localAlignment;
      switch (this.mGravity & 0x7)
      {
      default: 
        localAlignment = Layout.Alignment.ALIGN_NORMAL;
      }
      while ((this.mText instanceof Spannable))
      {
        this.mLayout = new SingleLineTextView.ExtraDynamicLayout(this.mText, this.mTransformed, this.mTextPaint, paramInt1, localAlignment, this.mSpacingMult, this.mSpacingAdd, this.mIncludePad, this.mEllipsize, paramInt2);
        return;
        localAlignment = Layout.Alignment.ALIGN_CENTER;
        continue;
        localAlignment = Layout.Alignment.ALIGN_OPPOSITE;
      }
      if (paramMetrics == UNKNOWN_BORING)
      {
        BoringLayout.Metrics localMetrics = BoringLayout.isBoring(this.mTransformed, this.mTextPaint, this.mBoring);
        paramMetrics = localMetrics;
        if (localMetrics != null)
        {
          this.mBoring = localMetrics;
          paramMetrics = localMetrics;
        }
      }
      for (;;)
      {
        if (paramMetrics != null)
        {
          if ((paramMetrics.width <= paramInt1) && (paramMetrics.width <= paramInt2))
          {
            if (this.mSavedLayout != null) {}
            for (this.mLayout = this.mSavedLayout.replaceOrMake(this.mTransformed, this.mTextPaint, paramInt1, localAlignment, this.mSpacingMult, this.mSpacingAdd, paramMetrics, this.mIncludePad);; this.mLayout = BoringLayout.make(this.mTransformed, this.mTextPaint, paramInt1, localAlignment, this.mSpacingMult, this.mSpacingAdd, paramMetrics, this.mIncludePad))
            {
              this.mSavedLayout = ((BoringLayout)this.mLayout);
              return;
            }
          }
          if (paramMetrics.width <= paramInt1)
          {
            if (this.mSavedLayout != null)
            {
              this.mLayout = this.mSavedLayout.replaceOrMake(this.mTransformed, this.mTextPaint, paramInt1, localAlignment, this.mSpacingMult, this.mSpacingAdd, paramMetrics, this.mIncludePad, this.mEllipsize, paramInt2);
              return;
            }
            this.mLayout = BoringLayout.make(this.mTransformed, this.mTextPaint, paramInt1, localAlignment, this.mSpacingMult, this.mSpacingAdd, paramMetrics, this.mIncludePad, this.mEllipsize, paramInt2);
            return;
          }
          this.mLayout = new SingleLineTextView.ExtraStaticLayout(this.mTransformed, 0, this.mTransformed.length(), this.mTextPaint, paramInt1, localAlignment, this.mSpacingMult, this.mSpacingAdd, this.mIncludePad, this.mEllipsize, paramInt2);
          return;
        }
        this.mLayout = new SingleLineTextView.ExtraStaticLayout(this.mTransformed, 0, this.mTransformed.length(), this.mTextPaint, paramInt1, localAlignment, this.mSpacingMult, this.mSpacingAdd, this.mIncludePad, this.mEllipsize, paramInt2);
        return;
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int m = getCompoundPaddingLeft();
    int i1 = getCompoundPaddingTop();
    int i9 = getCompoundPaddingRight();
    int k = getCompoundPaddingBottom();
    int i4 = getScrollX();
    int i2 = getScrollY();
    int i5 = getRight();
    int i6 = getLeft();
    int n = getBottom();
    int i10 = getTop();
    int i;
    if (this.mLayout == null)
    {
      j = i5 - i6 - m - i9;
      i = j;
      if (j < 1) {
        i = 0;
      }
      if (!this.mHorizontallyScrolling) {
        break label1384;
      }
    }
    label1360:
    label1363:
    label1370:
    label1377:
    label1384:
    for (int j = 16384;; j = i)
    {
      makeSingleLayout(j, UNKNOWN_BORING, i);
      int i7 = getExtendedPaddingTop();
      int i11 = getExtendedPaddingBottom();
      int i3 = n - i10 - k - i1;
      int i8 = this.mLayout.getLineTop(1) - this.mLayout.getLineDescent(0);
      j = 0;
      k = 0;
      i = 0;
      if ((this.mGravity & 0x70) != 48)
      {
        k = getVerticalOffset();
        i = getVerticalOffset();
      }
      Object localObject1 = getDrawableState();
      Object localObject2 = this.mDrawables;
      if ((localObject2 != null) && (((SingleLineTextView.Drawables)localObject2).mDrawableLeft != null))
      {
        paramCanvas.save();
        int i12 = getPaddingLeft();
        int i13 = (i3 - ((SingleLineTextView.Drawables)localObject2).mDrawableHeightLeft) / 2;
        paramCanvas.translate(i12 + i4, i2 + i1 + i13);
        ((SingleLineTextView.Drawables)localObject2).mDrawableLeft.draw(paramCanvas);
        paramCanvas.restore();
      }
      Object localObject3 = this.mExtendTexts[1];
      Paint.FontMetrics localFontMetrics;
      float f2;
      float f1;
      if ((localObject3 != null) && (!((SingleLineTextView.ExtendText)localObject3).mEmpty))
      {
        paramCanvas.save();
        paramCanvas.translate(i4 + m - ((SingleLineTextView.ExtendText)localObject3).getDesiredWith(), i7 + k);
        localFontMetrics = ((SingleLineTextView.ExtendText)localObject3).getFontMetrics();
        f2 = i8;
        f1 = f2;
        if (localFontMetrics != null)
        {
          f1 = f2;
          if (f2 > getMeasuredHeight() - localFontMetrics.bottom) {
            f1 = (int)(getMeasuredHeight() - localFontMetrics.bottom);
          }
        }
        ((SingleLineTextView.ExtendText)localObject3).draw(paramCanvas, (int[])localObject1, 0.0F, f1);
        paramCanvas.restore();
      }
      localObject3 = this.mLayout;
      this.mTextPaint.setColor(this.mCurTextColor);
      this.mTextPaint.drawableState = getDrawableState();
      paramCanvas.save();
      paramCanvas.clipRect(m + i4, i7 + i2, i5 - i6 - i9 + i4, n - i10 - i11 + i2);
      paramCanvas.translate(m, i7 + k);
      ((Layout)localObject3).draw(paramCanvas, null, null, i - k);
      paramCanvas.restore();
      localObject3 = this.mExtendTexts[2];
      i = j;
      if (localObject3 != null)
      {
        i = j;
        if (!((SingleLineTextView.ExtendText)localObject3).mEmpty)
        {
          paramCanvas.save();
          i = getDesiredWidth() + 0 + ((SingleLineTextView.ExtendText)localObject3).mPadding;
          m = i4 + i5 - i6 - i9 + 0;
          j = 0 + (((SingleLineTextView.ExtendText)localObject3).getDesiredWith() + ((SingleLineTextView.ExtendText)localObject3).mPadding);
          if (m <= i) {
            break label1377;
          }
        }
      }
      for (;;)
      {
        paramCanvas.translate(i, i7 + k);
        localFontMetrics = ((SingleLineTextView.ExtendText)localObject3).getFontMetrics();
        f2 = i8;
        f1 = f2;
        if (localFontMetrics != null)
        {
          f1 = f2;
          if (f2 > getMeasuredHeight() - localFontMetrics.bottom) {
            f1 = (int)(((SingleLineTextView.ExtendText)localObject3).getDesiredHeight() - localFontMetrics.bottom);
          }
        }
        ((SingleLineTextView.ExtendText)localObject3).draw(paramCanvas, (int[])localObject1, 0.0F, f1);
        paramCanvas.restore();
        i = j;
        j = i;
        if (localObject2 != null)
        {
          j = i;
          if (((SingleLineTextView.Drawables)localObject2).mDrawableRight2 != null)
          {
            paramCanvas.save();
            m = getDesiredWidth() + i + ((SingleLineTextView.Drawables)localObject2).mDrawablePadding;
            n = i4 + i5 - i6 - i9 + i + ((SingleLineTextView.Drawables)localObject2).mDrawablePadding;
            j = i + (((SingleLineTextView.Drawables)localObject2).mDrawableSizeRight2 + ((SingleLineTextView.Drawables)localObject2).mDrawablePadding);
            if (n <= m) {
              break label1370;
            }
          }
        }
        for (i = m;; i = n)
        {
          m = i2 + i1 + (i3 - ((SingleLineTextView.Drawables)localObject2).mDrawableHeightRight2) / 2;
          paramCanvas.translate(i, m);
          ((SingleLineTextView.Drawables)localObject2).mDrawableRight2Position[0] = i;
          ((SingleLineTextView.Drawables)localObject2).mDrawableRight2Position[1] = m;
          ((SingleLineTextView.Drawables)localObject2).mDrawableRight2.draw(paramCanvas);
          paramCanvas.restore();
          i = j;
          if (localObject2 != null)
          {
            i = j;
            if (((SingleLineTextView.Drawables)localObject2).mDrawableRight != null)
            {
              paramCanvas.save();
              i = getDesiredWidth() + j + ((SingleLineTextView.Drawables)localObject2).mDrawablePadding;
              m = i4 + i5 - i6 - i9 + j + ((SingleLineTextView.Drawables)localObject2).mDrawablePadding;
              j += ((SingleLineTextView.Drawables)localObject2).mDrawableSizeRight + ((SingleLineTextView.Drawables)localObject2).mDrawablePadding;
              if (m <= i) {
                break label1363;
              }
            }
          }
          for (;;)
          {
            m = i2 + i1 + (i3 - ((SingleLineTextView.Drawables)localObject2).mDrawableHeightRight) / 2;
            paramCanvas.translate(i, m);
            ((SingleLineTextView.Drawables)localObject2).mDrawableRightPosition[0] = i;
            ((SingleLineTextView.Drawables)localObject2).mDrawableRightPosition[1] = m;
            ((SingleLineTextView.Drawables)localObject2).mDrawableRight.draw(paramCanvas);
            paramCanvas.restore();
            i = j;
            if ((localObject2 != null) && (((SingleLineTextView.Drawables)localObject2).mDrawableRightExt != null))
            {
              paramCanvas.save();
              j = getDesiredWidth() + i + ((SingleLineTextView.Drawables)localObject2).mDrawablePadding;
              i = i4 + i5 - i6 - i9 + i + ((SingleLineTextView.Drawables)localObject2).mDrawablePadding;
              m = ((SingleLineTextView.Drawables)localObject2).mDrawableSizeRightExt;
              m = ((SingleLineTextView.Drawables)localObject2).mDrawablePadding;
              if (i <= j) {
                break label1360;
              }
              i = j;
            }
            for (;;)
            {
              j = i2 + i1 + (i3 - ((SingleLineTextView.Drawables)localObject2).mDrawableHeightRightExt) / 2;
              paramCanvas.translate(i, j);
              ((SingleLineTextView.Drawables)localObject2).mDrawableRight2ExtPosition[0] = i;
              ((SingleLineTextView.Drawables)localObject2).mDrawableRight2ExtPosition[1] = j;
              ((SingleLineTextView.Drawables)localObject2).mDrawableRightExt.draw(paramCanvas);
              paramCanvas.restore();
              localObject2 = this.mExtendTexts[0];
              j = 0;
              i = j;
              if (localObject2 != null)
              {
                i = j;
                if (!((SingleLineTextView.ExtendText)localObject2).mEmpty)
                {
                  paramCanvas.save();
                  paramCanvas.translate(i4 + i5 - i6 - ((SingleLineTextView.ExtendText)localObject2).getDesiredWith() - getPaddingRight(), k + i7);
                  ((SingleLineTextView.ExtendText)localObject2).draw(paramCanvas, (int[])localObject1, 0.0F, i8);
                  paramCanvas.restore();
                  i = ((SingleLineTextView.ExtendText)localObject2).getDesiredWith();
                }
              }
              localObject1 = this.mIconDrawables;
              if (localObject1 != null)
              {
                j = getPaddingRight();
                m = this.mIconDrawableGap;
                k = localObject1.length;
                j = i4 + i5 - i6 - i - j - m;
                i = k - 1;
                while (i >= 0)
                {
                  k = j;
                  if (localObject1[i].mDrawable != null)
                  {
                    k = j;
                    if (localObject1[i].mDrawableSize != 0)
                    {
                      paramCanvas.save();
                      k = j - this.mIconDrawablePadding - localObject1[i].mDrawableSize;
                      j = (i3 - localObject1[i].mDrawableHeight) / 2;
                      paramCanvas.translate(k, i2 + i1 + j);
                      localObject1[i].mDrawable.draw(paramCanvas);
                      paramCanvas.restore();
                    }
                  }
                  i -= 1;
                  j = k;
                }
              }
              return;
            }
            i = m;
          }
        }
        i = m;
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int k = 0;
    if (Build.VERSION.SDK_INT < 21) {
      this.mHandler.removeMessages(1);
    }
    int n = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    Object localObject = UNKNOWN_BORING;
    if (n == 1073741824) {}
    for (;;)
    {
      paramInt2 = i - getCompoundPaddingLeft() - getCompoundPaddingRight();
      if ((this.needCheckIconDrawablesWhenMeasure) && (checkIfNeedHideSomeIconDrawables(paramInt2))) {
        paramInt2 = i - getCompoundPaddingLeft() - getCompoundPaddingRight();
      }
      for (paramInt1 = paramInt2;; paramInt1 = paramInt2)
      {
        if (this.mHorizontallyScrolling) {
          paramInt1 = 16384;
        }
        if (this.mLayout == null) {
          makeSingleLayout(paramInt1, (BoringLayout.Metrics)localObject, paramInt2);
        }
        for (;;)
        {
          if (m != 1073741824) {
            break label271;
          }
          paramInt1 = j;
          setMeasuredDimension(i, paramInt1);
          return;
          localObject = BoringLayout.isBoring(this.mTransformed, this.mTextPaint, this.mBoring);
          if (localObject != null) {
            this.mBoring = ((BoringLayout.Metrics)localObject);
          }
          if ((localObject == null) || (localObject == UNKNOWN_BORING)) {}
          for (paramInt1 = getDesiredWidth();; paramInt1 = ((BoringLayout.Metrics)localObject).width)
          {
            paramInt1 = Math.max(Math.min(paramInt1 + (getCompoundPaddingLeft() + getCompoundPaddingRight()), this.mMaxWidth), getSuggestedMinimumWidth());
            if (n != -2147483648) {
              break label498;
            }
            i = Math.min(i, paramInt1);
            break;
          }
          if ((this.mLayout.getWidth() != paramInt1) || (this.mLayout.getEllipsizedWidth() != paramInt2)) {
            makeSingleLayout(paramInt1, (BoringLayout.Metrics)localObject, paramInt2);
          }
        }
        label271:
        m = getCompoundPaddingTop() + getCompoundPaddingBottom();
        if (this.mLayout != null)
        {
          paramInt2 = this.mLayout.getLineCount();
          paramInt1 = paramInt2;
          if (paramInt2 > 1) {
            paramInt1 = 1;
          }
        }
        for (paramInt1 = this.mLayout.getLineTop(paramInt1);; paramInt1 = 0)
        {
          paramInt1 += m;
          localObject = this.mDrawables;
          paramInt2 = paramInt1;
          if (localObject != null) {
            paramInt2 = Math.max(Math.max(paramInt1, ((SingleLineTextView.Drawables)localObject).mDrawableHeightLeft), ((SingleLineTextView.Drawables)localObject).mDrawableHeightRight);
          }
          localObject = this.mIconDrawables;
          paramInt1 = paramInt2;
          if (localObject != null)
          {
            n = localObject.length;
            j = 0;
            for (;;)
            {
              paramInt1 = paramInt2;
              if (j >= n) {
                break;
              }
              paramInt2 = Math.max(paramInt2, localObject[j].mDrawableHeight);
              j += 1;
            }
          }
          j = paramInt1;
          if (paramInt1 == m)
          {
            paramInt2 = k;
            for (;;)
            {
              j = paramInt1;
              if (paramInt2 >= this.mExtendTexts.length) {
                break;
              }
              localObject = this.mExtendTexts[paramInt2];
              j = paramInt1;
              if (localObject != null)
              {
                j = paramInt1;
                if (!((SingleLineTextView.ExtendText)localObject).mEmpty) {
                  j = Math.max(paramInt1, ((SingleLineTextView.ExtendText)localObject).getDesiredHeight());
                }
              }
              paramInt2 += 1;
              paramInt1 = j;
            }
          }
          paramInt1 = Math.max(j, getSuggestedMinimumHeight());
          break;
        }
      }
      label498:
      i = paramInt1;
    }
  }
  
  public void requestLayout()
  {
    if (!this.mBlockRelayout) {
      super.requestLayout();
    }
  }
  
  public void setCompoundDrawablePadding(int paramInt)
  {
    SingleLineTextView.Drawables localDrawables2 = this.mDrawables;
    if (paramInt == 0) {
      if (localDrawables2 == null) {}
    }
    SingleLineTextView.Drawables localDrawables1;
    for (localDrawables2.mDrawablePadding = paramInt;; localDrawables1.mDrawablePadding = paramInt)
    {
      if (!this.mHandler.hasMessages(1)) {
        this.mHandler.sendEmptyMessage(1);
      }
      return;
      localDrawables1 = localDrawables2;
      if (localDrawables2 == null)
      {
        localDrawables1 = new SingleLineTextView.Drawables(null);
        this.mDrawables = localDrawables1;
      }
    }
  }
  
  public void setCompoundDrawables(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    setCompoundDrawables(paramDrawable1, paramDrawable2, null);
  }
  
  public void setCompoundDrawables(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3)
  {
    Object localObject2 = this.mDrawables;
    int i;
    if ((paramDrawable1 != null) || (paramDrawable2 != null))
    {
      i = 1;
      if (i != 0) {
        break label175;
      }
      if (localObject2 != null)
      {
        if (((SingleLineTextView.Drawables)localObject2).mDrawablePadding != 0) {
          break label67;
        }
        this.mDrawables = null;
      }
    }
    for (;;)
    {
      if (!this.mHandler.hasMessages(1)) {
        this.mHandler.sendEmptyMessage(1);
      }
      return;
      i = 0;
      break;
      label67:
      if (((SingleLineTextView.Drawables)localObject2).mDrawableLeft != null) {
        ((SingleLineTextView.Drawables)localObject2).mDrawableLeft.setCallback(null);
      }
      ((SingleLineTextView.Drawables)localObject2).mDrawableLeft = null;
      if (((SingleLineTextView.Drawables)localObject2).mDrawableRight != null) {
        ((SingleLineTextView.Drawables)localObject2).mDrawableRight.setCallback(null);
      }
      ((SingleLineTextView.Drawables)localObject2).mDrawableRight = null;
      if (((SingleLineTextView.Drawables)localObject2).mDrawableRightExt != null) {
        ((SingleLineTextView.Drawables)localObject2).mDrawableRightExt.setCallback(null);
      }
      ((SingleLineTextView.Drawables)localObject2).mDrawableRightExt = null;
      ((SingleLineTextView.Drawables)localObject2).mDrawableHeightLeft = 0;
      ((SingleLineTextView.Drawables)localObject2).mDrawableSizeLeft = 0;
      ((SingleLineTextView.Drawables)localObject2).mDrawableHeightRight = 0;
      ((SingleLineTextView.Drawables)localObject2).mDrawableSizeRight = 0;
      ((SingleLineTextView.Drawables)localObject2).mDrawableHeightRightExt = 0;
      ((SingleLineTextView.Drawables)localObject2).mDrawableSizeRightExt = 0;
      continue;
      label175:
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new SingleLineTextView.Drawables(null);
        this.mDrawables = ((SingleLineTextView.Drawables)localObject1);
      }
      if ((((SingleLineTextView.Drawables)localObject1).mDrawableLeft != paramDrawable1) && (((SingleLineTextView.Drawables)localObject1).mDrawableLeft != null)) {
        ((SingleLineTextView.Drawables)localObject1).mDrawableLeft.setCallback(null);
      }
      ((SingleLineTextView.Drawables)localObject1).mDrawableLeft = paramDrawable1;
      if ((((SingleLineTextView.Drawables)localObject1).mDrawableRight != paramDrawable1) && (((SingleLineTextView.Drawables)localObject1).mDrawableRight != null)) {
        ((SingleLineTextView.Drawables)localObject1).mDrawableRight.setCallback(null);
      }
      ((SingleLineTextView.Drawables)localObject1).mDrawableRight = paramDrawable2;
      if ((((SingleLineTextView.Drawables)localObject1).mDrawableRightExt != paramDrawable3) && (((SingleLineTextView.Drawables)localObject1).mDrawableRightExt != null)) {
        ((SingleLineTextView.Drawables)localObject1).mDrawableRightExt.setCallback(null);
      }
      ((SingleLineTextView.Drawables)localObject1).mDrawableRightExt = paramDrawable3;
      localObject2 = ((SingleLineTextView.Drawables)localObject1).mCompoundRect;
      int[] arrayOfInt = getDrawableState();
      if (paramDrawable1 != null)
      {
        paramDrawable1.setState(arrayOfInt);
        paramDrawable1.copyBounds((Rect)localObject2);
        paramDrawable1.setCallback(this);
        ((SingleLineTextView.Drawables)localObject1).mDrawableSizeLeft = ((Rect)localObject2).width();
        ((SingleLineTextView.Drawables)localObject1).mDrawableHeightLeft = ((Rect)localObject2).height();
        label351:
        if (paramDrawable2 == null) {
          break label453;
        }
        paramDrawable2.setState(arrayOfInt);
        paramDrawable2.copyBounds((Rect)localObject2);
        paramDrawable2.setCallback(this);
        ((SingleLineTextView.Drawables)localObject1).mDrawableSizeRight = ((Rect)localObject2).width();
        ((SingleLineTextView.Drawables)localObject1).mDrawableHeightRight = ((Rect)localObject2).height();
      }
      for (;;)
      {
        if (paramDrawable3 == null) {
          break label468;
        }
        paramDrawable3.setState(arrayOfInt);
        paramDrawable3.copyBounds((Rect)localObject2);
        paramDrawable3.setCallback(this);
        ((SingleLineTextView.Drawables)localObject1).mDrawableSizeRightExt = ((Rect)localObject2).width();
        ((SingleLineTextView.Drawables)localObject1).mDrawableHeightRightExt = ((Rect)localObject2).height();
        break;
        ((SingleLineTextView.Drawables)localObject1).mDrawableHeightLeft = 0;
        ((SingleLineTextView.Drawables)localObject1).mDrawableSizeLeft = 0;
        break label351;
        label453:
        ((SingleLineTextView.Drawables)localObject1).mDrawableHeightRight = 0;
        ((SingleLineTextView.Drawables)localObject1).mDrawableSizeRight = 0;
      }
      label468:
      ((SingleLineTextView.Drawables)localObject1).mDrawableHeightRightExt = 0;
      ((SingleLineTextView.Drawables)localObject1).mDrawableSizeRightExt = 0;
    }
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(int paramInt1, int paramInt2)
  {
    Drawable localDrawable2 = null;
    if ((paramInt1 == 0) && (paramInt2 == 0) && (this.mDrawables != null) && ((this.mDrawables.mDrawableLeft != null) || (this.mDrawables.mDrawableRight != null)))
    {
      this.mCompoundLeft = 0;
      this.mCompoundRight = 0;
      setCompoundDrawablesWithIntrinsicBounds(null, null);
    }
    while ((this.mCompoundLeft == paramInt1) && (this.mCompoundRight == paramInt2)) {
      return;
    }
    this.mCompoundLeft = paramInt1;
    this.mCompoundRight = paramInt2;
    Resources localResources = getContext().getResources();
    if (paramInt1 != 0) {}
    for (Drawable localDrawable1 = localResources.getDrawable(paramInt1);; localDrawable1 = null)
    {
      if (paramInt2 != 0) {
        localDrawable2 = localResources.getDrawable(paramInt2);
      }
      setCompoundDrawablesWithIntrinsicBounds(localDrawable1, localDrawable2);
      return;
    }
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (paramDrawable1 != null) {
      paramDrawable1.setBounds(0, 0, paramDrawable1.getIntrinsicWidth(), paramDrawable1.getIntrinsicHeight());
    }
    if (paramDrawable2 != null) {
      paramDrawable2.setBounds(0, 0, paramDrawable2.getIntrinsicWidth(), paramDrawable2.getIntrinsicHeight());
    }
    setCompoundDrawables(paramDrawable1, paramDrawable2);
  }
  
  public void setDefaultTextColor(int paramInt)
  {
    this.mDefaultTextColor = paramInt;
    updateTextColors();
  }
  
  public void setDrawableRight2(Drawable paramDrawable)
  {
    Object localObject2 = this.mDrawables;
    if (paramDrawable == null) {
      if (localObject2 != null)
      {
        if (((SingleLineTextView.Drawables)localObject2).mDrawableRight2 != null) {
          ((SingleLineTextView.Drawables)localObject2).mDrawableRight2.setCallback(null);
        }
        ((SingleLineTextView.Drawables)localObject2).mDrawableRight2 = null;
        ((SingleLineTextView.Drawables)localObject2).mDrawableHeightRight2 = 0;
        ((SingleLineTextView.Drawables)localObject2).mDrawableSizeRight2 = 0;
      }
    }
    for (;;)
    {
      if (!this.mHandler.hasMessages(1)) {
        this.mHandler.sendEmptyMessage(1);
      }
      return;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new SingleLineTextView.Drawables(null);
        this.mDrawables = ((SingleLineTextView.Drawables)localObject1);
      }
      if ((((SingleLineTextView.Drawables)localObject1).mDrawableRight2 != paramDrawable) && (((SingleLineTextView.Drawables)localObject1).mDrawableRight2 != null)) {
        ((SingleLineTextView.Drawables)localObject1).mDrawableRight2.setCallback(null);
      }
      ((SingleLineTextView.Drawables)localObject1).mDrawableRight2 = paramDrawable;
      localObject2 = ((SingleLineTextView.Drawables)localObject1).mCompoundRect;
      paramDrawable.setState(getDrawableState());
      paramDrawable.copyBounds((Rect)localObject2);
      paramDrawable.setCallback(this);
      ((SingleLineTextView.Drawables)localObject1).mDrawableSizeRight2 = ((Rect)localObject2).width();
      ((SingleLineTextView.Drawables)localObject1).mDrawableHeightRight2 = ((Rect)localObject2).height();
    }
  }
  
  public void setDrawableRight2WithIntrinsicBounds(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    }
    setDrawableRight2(paramDrawable);
  }
  
  public void setExtendText(String paramString, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mExtendTexts.length)) {}
    SingleLineTextView.ExtendText localExtendText2;
    boolean bool;
    do
    {
      return;
      localExtendText2 = this.mExtendTexts[paramInt];
      bool = TextUtils.isEmpty(paramString);
    } while ((bool) && ((localExtendText2 == null) || (localExtendText2.mEmpty)));
    int i;
    if ((bool) && (localExtendText2 != null) && (!localExtendText2.mEmpty))
    {
      localExtendText2.reset();
      i = 1;
    }
    for (;;)
    {
      if ((paramInt == 0) && (i != 0)) {
        postInvalidate();
      }
      if ((i == 0) || (this.mHandler.hasMessages(1))) {
        break;
      }
      this.mHandler.sendEmptyMessage(1);
      return;
      if (!bool)
      {
        SingleLineTextView.ExtendText localExtendText1 = localExtendText2;
        if (localExtendText2 == null)
        {
          localExtendText1 = new SingleLineTextView.ExtendText(getResources());
          this.mExtendTexts[paramInt] = localExtendText1;
        }
        if (!paramString.equals(localExtendText1.mText))
        {
          localExtendText1.mText = paramString;
          localExtendText1.mDesiredTextWidth = -1;
          localExtendText1.mEmpty = false;
          i = 1;
          continue;
        }
      }
      i = 0;
    }
  }
  
  public void setExtendTextColor(ColorStateList paramColorStateList, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mExtendTexts.length)) {}
    SingleLineTextView.ExtendText localExtendText1;
    do
    {
      return;
      SingleLineTextView.ExtendText localExtendText2 = this.mExtendTexts[paramInt];
      localExtendText1 = localExtendText2;
      if (localExtendText2 == null)
      {
        localExtendText1 = new SingleLineTextView.ExtendText(getResources());
        this.mExtendTexts[paramInt] = localExtendText1;
      }
    } while (!localExtendText1.setTextColor(paramColorStateList, getDrawableState()));
    postInvalidate();
  }
  
  public void setExtendTextPadding(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 0) || (paramInt2 >= this.mExtendTexts.length)) {}
    SingleLineTextView.ExtendText localExtendText2;
    do
    {
      return;
      localExtendText2 = this.mExtendTexts[paramInt2];
    } while ((paramInt1 <= 0) && ((localExtendText2 == null) || (localExtendText2.mEmpty)));
    SingleLineTextView.ExtendText localExtendText1 = localExtendText2;
    if (localExtendText2 == null)
    {
      localExtendText1 = new SingleLineTextView.ExtendText(getResources());
      this.mExtendTexts[paramInt2] = localExtendText1;
    }
    localExtendText1.mPadding = paramInt1;
  }
  
  public void setExtendTextSize(float paramFloat, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mExtendTexts.length)) {}
    SingleLineTextView.ExtendText localExtendText1;
    do
    {
      return;
      SingleLineTextView.ExtendText localExtendText2 = this.mExtendTexts[paramInt];
      localExtendText1 = localExtendText2;
      if (localExtendText2 == null)
      {
        localExtendText1 = new SingleLineTextView.ExtendText(getResources());
        this.mExtendTexts[paramInt] = localExtendText1;
      }
    } while ((!localExtendText1.setTextSize(paramFloat, getContext())) || (this.mHandler.hasMessages(1)));
    this.mHandler.sendEmptyMessage(1);
  }
  
  public void setGravity(int paramInt)
  {
    if ((paramInt & 0x7) == 0) {
      paramInt |= 0x3;
    }
    for (;;)
    {
      int i = paramInt;
      if ((paramInt & 0x70) == 0) {
        i = paramInt | 0x30;
      }
      paramInt = 0;
      if ((i & 0x7) != (this.mGravity & 0x7)) {
        paramInt = 1;
      }
      if (i != this.mGravity) {
        invalidate();
      }
      this.mGravity = i;
      if ((this.mLayout != null) && (paramInt != 0))
      {
        paramInt = this.mLayout.getWidth();
        i = getWidth();
        int j = getCompoundPaddingLeft();
        int k = getCompoundPaddingRight();
        makeSingleLayout(paramInt, UNKNOWN_BORING, i - j - k);
      }
      return;
    }
  }
  
  public void setIconDrawablePadding(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == this.mIconDrawablePadding) && (paramInt2 == this.mIconDrawableGap)) {}
    do
    {
      return;
      this.mIconDrawablePadding = paramInt1;
      this.mIconDrawableGap = paramInt2;
    } while (this.mHandler.hasMessages(1));
    this.mHandler.sendEmptyMessage(1);
  }
  
  public void setIconDrawables(Drawable[] paramArrayOfDrawable, boolean paramBoolean)
  {
    Object localObject2 = this.mIconDrawables;
    int i;
    if ((!paramBoolean) || (paramArrayOfDrawable == null) || (paramArrayOfDrawable.length == 0)) {
      if (localObject2 != null)
      {
        int j = localObject2.length;
        i = 0;
        while (i < j)
        {
          paramArrayOfDrawable = localObject2[i];
          if (paramArrayOfDrawable.mDrawable != null) {
            paramArrayOfDrawable.mDrawable.setCallback(null);
          }
          paramArrayOfDrawable.mDrawable = null;
          paramArrayOfDrawable.mDrawableSize = 0;
          paramArrayOfDrawable.mDrawableHeight = 0;
          paramArrayOfDrawable.can_not_be_hide = false;
          i += 1;
        }
      }
    }
    Object localObject1;
    for (this.mIconDrawables = null;; this.mIconDrawables = ((SingleLineTextView.IconDrawable[])localObject1))
    {
      if (!this.mHandler.hasMessages(1)) {
        this.mHandler.sendEmptyMessage(1);
      }
      return;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (localObject2.length == paramArrayOfDrawable.length) {}
      }
      else
      {
        localObject1 = new SingleLineTextView.IconDrawable[paramArrayOfDrawable.length];
        i = 0;
        while (i < localObject1.length)
        {
          localObject1[i] = new SingleLineTextView.IconDrawable();
          i += 1;
        }
      }
      localObject2 = getDrawableState();
      i = 0;
      if (i < localObject1.length)
      {
        if ((localObject1[i].mDrawable != null) && (localObject1[i].mDrawable != paramArrayOfDrawable[i])) {
          localObject1[i].mDrawable.setCallback(null);
        }
        localObject1[i].mDrawable = paramArrayOfDrawable[i];
        localObject1[i].can_not_be_hide = false;
        Rect localRect = localObject1[i].mCompoundRect;
        if (paramArrayOfDrawable[i] != null)
        {
          paramArrayOfDrawable[i].setState((int[])localObject2);
          paramArrayOfDrawable[i].copyBounds(localRect);
          paramArrayOfDrawable[i].setCallback(this);
          localObject1[i].mDrawableSize = localRect.width();
          localObject1[i].mDrawableHeight = localRect.height();
        }
        for (;;)
        {
          i += 1;
          break;
          localRect = localObject1[i];
          localObject1[i].mDrawableHeight = 0;
          localRect.mDrawableSize = 0;
        }
      }
    }
  }
  
  public void setIconDrawablesWithIntrinsicBounds(ArrayList<SingleLineTextView.IconDrawableInfo> paramArrayList)
  {
    int k = 0;
    if (paramArrayList != null) {}
    for (int j = paramArrayList.size();; j = 0)
    {
      if (this.mIconDrawableInfos != null) {}
      for (int i = this.mIconDrawableInfos.size();; i = 0)
      {
        if (j == i)
        {
          if ((j <= 0) || (paramArrayList == null) || (this.mIconDrawableInfos == null)) {
            break label262;
          }
          i = 0;
          if (i >= j) {
            break label262;
          }
          if (!((SingleLineTextView.IconDrawableInfo)this.mIconDrawableInfos.get(i)).equals((SingleLineTextView.IconDrawableInfo)paramArrayList.get(i))) {
            i = 1;
          }
        }
        for (;;)
        {
          label81:
          Object localObject;
          boolean bool;
          if (i != 0)
          {
            localObject = null;
            if (j <= 0) {
              break label256;
            }
            localObject = new Drawable[j];
            i = 0;
            bool = false;
            for (;;)
            {
              if (i < j)
              {
                SingleLineTextView.IconDrawableInfo localIconDrawableInfo = (SingleLineTextView.IconDrawableInfo)paramArrayList.get(i);
                localObject[i] = getIconDrawableWithStatus(getContext(), localIconDrawableInfo);
                if (localObject[i] == null) {
                  break label253;
                }
                bool = true;
                i += 1;
                continue;
                i += 1;
                break;
                i = 1;
                break label81;
              }
            }
          }
          for (;;)
          {
            this.mIconDrawableInfos = paramArrayList;
            setIconDrawables((Drawable[])localObject, bool);
            localObject = this.mIconDrawables;
            if ((localObject != null) && (paramArrayList != null))
            {
              i = k;
              while ((i < localObject.length) && (i < paramArrayList.size()))
              {
                if ((localObject[i] != null) && (paramArrayList.get(i) != null)) {
                  localObject[i].can_not_be_hide = ((SingleLineTextView.IconDrawableInfo)paramArrayList.get(i)).can_not_be_hide;
                }
                i += 1;
              }
            }
            this.needCheckIconDrawablesWhenMeasure = true;
            return;
            label253:
            break;
            label256:
            bool = false;
          }
          label262:
          i = 0;
        }
      }
    }
  }
  
  protected void setLayoutChecked()
  {
    this.mHandler.removeMessages(1);
  }
  
  public final void setMaxWidth(int paramInt)
  {
    if (this.mMaxWidth != paramInt)
    {
      this.mMaxWidth = paramInt;
      requestLayout();
      invalidate();
    }
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    int i = 0;
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (localObject.equals(this.mText)) {
      return;
    }
    if (((CharSequence)localObject).length() > 168) {}
    for (;;)
    {
      try
      {
        paramCharSequence = ((CharSequence)localObject).subSequence(0, 168);
        this.mText = paramCharSequence;
        this.mTransformed = this.mTransformation.getTransformation(paramCharSequence, this);
        if ((paramCharSequence instanceof Spannable))
        {
          int j = paramCharSequence.length();
          ((Spannable)paramCharSequence).setSpan(this.mTransformation, 0, j, 18);
        }
        this.mTextDesiredWith = -1;
        if (this.mLayout != null) {
          checkForRelayout();
        }
        getText();
        if (!(getText() instanceof Spannable)) {
          break;
        }
        paramCharSequence = (Spannable)getText();
        paramCharSequence = (EmoticonSpan[])paramCharSequence.getSpans(0, paramCharSequence.length(), EmoticonSpan.class);
        if (i >= paramCharSequence.length) {
          break;
        }
        localObject = paramCharSequence[i].getDrawable();
        if (localObject != null) {
          ((Drawable)localObject).setCallback(this);
        }
        i += 1;
        continue;
        paramCharSequence = (CharSequence)localObject;
      }
      catch (Exception paramCharSequence)
      {
        if (QLog.isDevelopLevel()) {
          paramCharSequence.printStackTrace();
        }
      }
    }
  }
  
  public void setTextColor(int paramInt)
  {
    this.mTextColor = ColorStateList.valueOf(paramInt);
    updateTextColors();
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    if (paramColorStateList == null) {
      return;
    }
    this.mTextColor = paramColorStateList;
    updateTextColors();
  }
  
  public void setTextSize(float paramFloat)
  {
    Object localObject = getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      paramFloat = TypedValue.applyDimension(1, paramFloat, ((Resources)localObject).getDisplayMetrics());
      if (paramFloat != this.mTextPaint.getTextSize())
      {
        this.mTextPaint.setTextSize(paramFloat);
        this.mTextDesiredWith = -1;
        if (!this.mHandler.hasMessages(1)) {
          this.mHandler.sendEmptyMessage(1);
        }
      }
      return;
    }
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    if (this.mTextPaint.getTypeface() != paramTypeface)
    {
      this.mTextPaint.setTypeface(paramTypeface);
      SingleLineTextView.ExtendText[] arrayOfExtendText = this.mExtendTexts;
      int j = arrayOfExtendText.length;
      int i = 0;
      while (i < j)
      {
        SingleLineTextView.ExtendText localExtendText = arrayOfExtendText[i];
        if (localExtendText != null) {
          localExtendText.mTextPaint.setTypeface(paramTypeface);
        }
        i += 1;
      }
      requestLayout();
      invalidate();
    }
  }
  
  public boolean verifyDrawable(Drawable paramDrawable)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.SingleLineTextView
 * JD-Core Version:    0.7.0.1
 */