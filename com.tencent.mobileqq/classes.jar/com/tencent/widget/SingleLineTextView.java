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
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.dT);
      paramInt = paramAttributeSet.getDimensionPixelSize(R.styleable.dU, (int)DisplayUtils.a(paramContext, 12.0F));
      paramContext = paramAttributeSet.getColorStateList(R.styleable.dV);
      localObject = paramAttributeSet.getString(R.styleable.dX);
      this.mMaxWidth = paramAttributeSet.getDimensionPixelSize(R.styleable.dW, 2147483647);
      this.mTextPaint.setTextSize(paramInt);
      setTextColor(paramContext);
      setText((CharSequence)localObject);
      this.mIncludePad = paramAttributeSet.getBoolean(R.styleable.dY, true);
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
    int i = getIconDrawablesWidth();
    if ((i > 0) && (i > (int)DisplayUtils.a(getContext(), 105.0F)))
    {
      int k = Math.min(getDesiredWidth(), getResources().getDimensionPixelSize(2131297141));
      if (paramInt < k)
      {
        SingleLineTextView.IconDrawable[] arrayOfIconDrawable = this.mIconDrawables;
        if (arrayOfIconDrawable != null)
        {
          int j = paramInt;
          paramInt = 0;
          while (paramInt < arrayOfIconDrawable.length)
          {
            SingleLineTextView.IconDrawable localIconDrawable = arrayOfIconDrawable[paramInt];
            i = j;
            if (localIconDrawable != null)
            {
              i = j;
              if (localIconDrawable.mDrawable != null)
              {
                i = j;
                if (!localIconDrawable.can_not_be_hide)
                {
                  i = j;
                  if (localIconDrawable.mDrawableSize > 0)
                  {
                    j += localIconDrawable.mDrawableSize;
                    localIconDrawable.mDrawableSize = 0;
                    i = j;
                    if (j >= k) {
                      return true;
                    }
                  }
                }
              }
            }
            paramInt += 1;
            j = i;
          }
        }
      }
    }
    return false;
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
    SingleLineTextView.IconDrawable[] arrayOfIconDrawable = this.mIconDrawables;
    int i = 0;
    int j = 0;
    if (arrayOfIconDrawable != null)
    {
      int i1 = arrayOfIconDrawable.length;
      int m = 0;
      int k;
      for (i = 0; j < i1; i = k)
      {
        SingleLineTextView.IconDrawable localIconDrawable = arrayOfIconDrawable[j];
        int n = m;
        k = i;
        if (localIconDrawable.mDrawable != null)
        {
          n = m;
          k = i;
          if (localIconDrawable.mDrawableSize > 0)
          {
            k = i + (this.mIconDrawablePadding + localIconDrawable.mDrawableSize);
            n = 1;
          }
        }
        j += 1;
        m = n;
      }
      if (m != 0) {
        return i + this.mIconDrawableGap;
      }
    }
    return i;
  }
  
  private int getVerticalOffset()
  {
    int i = this.mGravity & 0x70;
    Layout localLayout = this.mLayout;
    if (i != 48)
    {
      int j = getMeasuredHeight() - getExtendedPaddingTop() - getExtendedPaddingBottom();
      int k = localLayout.getHeight();
      if (k < j)
      {
        if (i == 80) {
          return j - k;
        }
        return j - k >> 1;
      }
    }
    return 0;
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
        while (i < m)
        {
          SpanWatcher localSpanWatcher = arrayOfSpanWatcher[i];
          try
          {
            localSpanWatcher.onSpanChanged((Spannable)localObject, paramObject, j, k, j, k);
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Exception: ");
              localStringBuilder.append(localException.getMessage());
              QLog.e("SingleLineTextView", 2, localStringBuilder.toString());
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void nullLayouts()
  {
    Layout localLayout = this.mLayout;
    if (((localLayout instanceof BoringLayout)) && (this.mSavedLayout == null)) {
      this.mSavedLayout = ((BoringLayout)localLayout);
    }
    this.mLayout = null;
  }
  
  private void updateTextColors()
  {
    Object localObject = getDrawableState();
    int i = this.mTextColor.getColorForState((int[])localObject, this.mDefaultTextColor);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateTextColors, color=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", cur=");
      ((StringBuilder)localObject).append(this.mCurTextColor);
      QLog.i("SingleLineTextView", 2, ((StringBuilder)localObject).toString());
    }
    if (i != this.mCurTextColor)
    {
      this.mCurTextColor = i;
      invalidate();
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Object localObject1 = this.mTextColor;
    if ((localObject1 != null) && (((ColorStateList)localObject1).isStateful())) {
      updateTextColors();
    }
    localObject1 = getDrawableState();
    Object localObject2 = this.mDrawables;
    if (localObject2 != null)
    {
      if ((((SingleLineTextView.Drawables)localObject2).mDrawableLeft != null) && (((SingleLineTextView.Drawables)localObject2).mDrawableLeft.isStateful())) {
        ((SingleLineTextView.Drawables)localObject2).mDrawableLeft.setState((int[])localObject1);
      }
      if ((((SingleLineTextView.Drawables)localObject2).mDrawableRight != null) && (((SingleLineTextView.Drawables)localObject2).mDrawableRight.isStateful())) {
        ((SingleLineTextView.Drawables)localObject2).mDrawableRight.setState((int[])localObject1);
      }
      if ((((SingleLineTextView.Drawables)localObject2).mDrawableRightExt != null) && (((SingleLineTextView.Drawables)localObject2).mDrawableRightExt.isStateful())) {
        ((SingleLineTextView.Drawables)localObject2).mDrawableRightExt.setState((int[])localObject1);
      }
      if ((((SingleLineTextView.Drawables)localObject2).mDrawableRight2 != null) && (((SingleLineTextView.Drawables)localObject2).mDrawableRight2.isStateful())) {
        ((SingleLineTextView.Drawables)localObject2).mDrawableRight2.setState((int[])localObject1);
      }
    }
    localObject2 = this.mIconDrawables;
    int j = 0;
    if (localObject2 != null)
    {
      k = localObject2.length;
      i = 0;
      while (i < k)
      {
        Object localObject3 = localObject2[i];
        if ((localObject3.mDrawable != null) && (localObject3.mDrawable.isStateful())) {
          localObject3.mDrawable.setState((int[])localObject1);
        }
        i += 1;
      }
    }
    int k = 0;
    int i = j;
    j = k;
    for (;;)
    {
      localObject2 = this.mExtendTexts;
      if (i >= localObject2.length) {
        break;
      }
      localObject2 = localObject2[i];
      if ((localObject2 != null) && (((SingleLineTextView.ExtendText)localObject2).updateTextColors((int[])localObject1))) {
        j = 1;
      }
      i += 1;
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
      if (((SingleLineTextView.Drawables)localObject).mDrawableLeft != null) {
        i = j + (((SingleLineTextView.Drawables)localObject).mDrawablePadding + ((SingleLineTextView.Drawables)localObject).mDrawableSizeLeft);
      }
    }
    localObject = this.mExtendTexts[1];
    j = i;
    if (localObject != null)
    {
      j = i;
      if (!((SingleLineTextView.ExtendText)localObject).mEmpty) {
        j = i + (((SingleLineTextView.ExtendText)localObject).mPadding + ((SingleLineTextView.ExtendText)localObject).getDesiredWith());
      }
    }
    return j;
  }
  
  public int getCompoundPaddingRight()
  {
    int k = getPaddingRight();
    Object localObject = this.mDrawables;
    int i = k;
    if (localObject != null)
    {
      i = k;
      if (((SingleLineTextView.Drawables)localObject).mDrawableRight != null)
      {
        if (((SingleLineTextView.Drawables)localObject).mDrawableRightExt != null)
        {
          i = ((SingleLineTextView.Drawables)localObject).mDrawablePadding + ((SingleLineTextView.Drawables)localObject).mDrawableSizeRight + ((SingleLineTextView.Drawables)localObject).mDrawablePadding + ((SingleLineTextView.Drawables)localObject).mDrawableSizeRightExt;
          j = ((SingleLineTextView.Drawables)localObject).mDrawablePadding;
        }
        else
        {
          i = ((SingleLineTextView.Drawables)localObject).mDrawablePadding + ((SingleLineTextView.Drawables)localObject).mDrawableSizeRight;
          j = ((SingleLineTextView.Drawables)localObject).mDrawablePadding;
        }
        i = k + (i + j);
      }
    }
    int j = i;
    if (localObject != null)
    {
      j = i;
      if (((SingleLineTextView.Drawables)localObject).mDrawableRight2 != null)
      {
        if (((SingleLineTextView.Drawables)localObject).mDrawableRight != null)
        {
          k = ((SingleLineTextView.Drawables)localObject).mDrawableSizeRight2;
          j = ((SingleLineTextView.Drawables)localObject).mDrawablePadding;
        }
        else
        {
          k = ((SingleLineTextView.Drawables)localObject).mDrawablePadding + ((SingleLineTextView.Drawables)localObject).mDrawableSizeRight2;
          j = ((SingleLineTextView.Drawables)localObject).mDrawablePadding;
        }
        j = i + (k + j);
      }
    }
    localObject = this.mExtendTexts[2];
    i = j;
    if (localObject != null)
    {
      i = j;
      if (!((SingleLineTextView.ExtendText)localObject).mEmpty) {
        i = j + (((SingleLineTextView.ExtendText)localObject).mPadding + ((SingleLineTextView.ExtendText)localObject).getDesiredWith());
      }
    }
    localObject = this.mExtendTexts[0];
    j = i;
    if (localObject != null)
    {
      j = i;
      if (!((SingleLineTextView.ExtendText)localObject).mEmpty) {
        j = i + (((SingleLineTextView.ExtendText)localObject).mPadding + ((SingleLineTextView.ExtendText)localObject).getDesiredWith());
      }
    }
    return j + getIconDrawablesWidth();
  }
  
  public int getCompoundPaddingTop()
  {
    return getPaddingTop();
  }
  
  public int getExtendedPaddingBottom()
  {
    if (this.mLayout.getLineCount() <= 1) {
      return getCompoundPaddingBottom();
    }
    int j = getCompoundPaddingTop();
    int i = getCompoundPaddingBottom();
    j = getHeight() - j - i;
    int k = this.mLayout.getLineTop(1);
    if (k >= j) {
      return i;
    }
    int m = this.mGravity & 0x70;
    if (m == 48) {
      return i + j - k;
    }
    if (m == 80) {
      return i;
    }
    return i + (j - k) / 2;
  }
  
  public int getExtendedPaddingTop()
  {
    if (this.mLayout.getLineCount() <= 1) {
      return getCompoundPaddingTop();
    }
    int i = getCompoundPaddingTop();
    int j = getCompoundPaddingBottom();
    j = getHeight() - i - j;
    int k = this.mLayout.getLineTop(1);
    if (k >= j) {
      return i;
    }
    int m = this.mGravity & 0x70;
    if (m == 48) {
      return i;
    }
    if (m == 80) {
      return i + j - k;
    }
    return i + (j - k) / 2;
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
    SingleLineTextView.Drawables localDrawables = this.mDrawables;
    if (localDrawables != null) {
      return localDrawables.mDrawableRight;
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
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return true;
      }
      invalidateDrawableDelayed((Drawable)paramMessage.obj);
      return true;
    }
    if (this.mLayout != null) {
      checkForRelayout();
    }
    return true;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (verifyDrawable(paramDrawable))
    {
      Object localObject1 = paramDrawable.getBounds();
      int m = getScrollX();
      int k = getScrollY();
      Object localObject2 = this.mDrawables;
      int i2 = 0;
      int i = m;
      int j = k;
      if (localObject2 != null) {
        if (paramDrawable == ((SingleLineTextView.Drawables)localObject2).mDrawableLeft)
        {
          j = getCompoundPaddingTop();
          n = getCompoundPaddingBottom();
          i1 = getHeight();
          i = m + getPaddingLeft();
          j = k + (j + (i1 - n - j - ((SingleLineTextView.Drawables)localObject2).mDrawableHeightLeft) / 2);
        }
        else
        {
          if (paramDrawable == ((SingleLineTextView.Drawables)localObject2).mDrawableRight)
          {
            i = m + this.mDrawables.mDrawableRightPosition[0];
            j = this.mDrawables.mDrawableRightPosition[1];
          }
          for (;;)
          {
            j = k + j;
            break;
            if (paramDrawable == ((SingleLineTextView.Drawables)localObject2).mDrawableRightExt)
            {
              i = m + this.mDrawables.mDrawableRight2ExtPosition[0];
              j = this.mDrawables.mDrawableRight2ExtPosition[1];
            }
            else
            {
              i = m;
              j = k;
              if (paramDrawable != ((SingleLineTextView.Drawables)localObject2).mDrawableRight2) {
                break;
              }
              i = m + this.mDrawables.mDrawableRight2Position[0];
              j = this.mDrawables.mDrawableRight2Position[1];
            }
          }
        }
      }
      localObject2 = this.mIconDrawables;
      int n = i;
      int i1 = j;
      if (localObject2 != null)
      {
        Object localObject3 = this.mExtendTexts[0];
        n = getWidth() - getPaddingRight() - this.mIconDrawableGap;
        m = i2;
        k = n;
        if (localObject3 != null)
        {
          m = i2;
          k = n;
          if (!((SingleLineTextView.ExtendText)localObject3).mEmpty)
          {
            k = n - (((SingleLineTextView.ExtendText)localObject3).getDesiredWith() + ((SingleLineTextView.ExtendText)localObject3).mPadding);
            m = i2;
          }
        }
        for (;;)
        {
          n = i;
          i1 = j;
          if (m >= localObject2.length) {
            break;
          }
          if (isSameDrawable(paramDrawable, localObject2[m]))
          {
            localObject3 = localObject2[m].mCompoundRect;
            paramDrawable.copyBounds((Rect)localObject3);
            localObject2[m].mDrawableSize = ((Rect)localObject3).width();
            localObject2[m].mDrawableHeight = ((Rect)localObject3).height();
            i2 = getCompoundPaddingTop();
            int i3 = getCompoundPaddingBottom();
            int i4 = getHeight();
            n = m + 1;
            while (n < localObject2.length)
            {
              i1 = k;
              if (localObject2[n].mDrawable != null) {
                i1 = k - (localObject2[n].mDrawableSize - this.mIconDrawablePadding);
              }
              i += i1 - localObject2[m].mDrawableSize - this.mIconDrawablePadding;
              n += 1;
              k = i1;
            }
            n = i + (k - localObject2[m].mDrawableSize - this.mIconDrawablePadding);
            i1 = j + (i2 + (i4 - i3 - i2 - localObject2[m].mDrawableHeight) / 2);
            break;
          }
          m += 1;
        }
      }
      if ((n == 0) && (i1 == 0)) {
        invalidate();
      } else {
        invalidate(((Rect)localObject1).left + n, ((Rect)localObject1).top + i1, ((Rect)localObject1).right + n, ((Rect)localObject1).bottom + i1);
      }
      if (ViewCompat.isAttachedToWindow(this))
      {
        localObject1 = this.mHandler.obtainMessage(2);
        ((Message)localObject1).obj = paramDrawable;
        this.mHandler.removeMessages(2);
        this.mHandler.sendMessageDelayed((Message)localObject1, 100L);
      }
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
    int i = this.mGravity & 0x7;
    Layout.Alignment localAlignment;
    if (i != 1) {
      if (i != 5) {
        localAlignment = Layout.Alignment.ALIGN_NORMAL;
      }
    }
    for (;;)
    {
      break;
      localAlignment = Layout.Alignment.ALIGN_OPPOSITE;
      continue;
      localAlignment = Layout.Alignment.ALIGN_CENTER;
    }
    Object localObject = this.mText;
    if ((localObject instanceof Spannable))
    {
      this.mLayout = new SingleLineTextView.ExtraDynamicLayout((CharSequence)localObject, this.mTransformed, this.mTextPaint, paramInt1, localAlignment, this.mSpacingMult, this.mSpacingAdd, this.mIncludePad, this.mEllipsize, paramInt2);
      return;
    }
    localObject = paramMetrics;
    if (paramMetrics == UNKNOWN_BORING)
    {
      paramMetrics = BoringLayout.isBoring(this.mTransformed, this.mTextPaint, this.mBoring);
      localObject = paramMetrics;
      if (paramMetrics != null)
      {
        this.mBoring = paramMetrics;
        localObject = paramMetrics;
      }
    }
    if (localObject != null)
    {
      if ((((BoringLayout.Metrics)localObject).width <= paramInt1) && (((BoringLayout.Metrics)localObject).width <= paramInt2))
      {
        paramMetrics = this.mSavedLayout;
        if (paramMetrics != null) {
          this.mLayout = paramMetrics.replaceOrMake(this.mTransformed, this.mTextPaint, paramInt1, localAlignment, this.mSpacingMult, this.mSpacingAdd, (BoringLayout.Metrics)localObject, this.mIncludePad);
        } else {
          this.mLayout = BoringLayout.make(this.mTransformed, this.mTextPaint, paramInt1, localAlignment, this.mSpacingMult, this.mSpacingAdd, (BoringLayout.Metrics)localObject, this.mIncludePad);
        }
        this.mSavedLayout = ((BoringLayout)this.mLayout);
        return;
      }
      if (((BoringLayout.Metrics)localObject).width <= paramInt1)
      {
        paramMetrics = this.mSavedLayout;
        if (paramMetrics != null)
        {
          this.mLayout = paramMetrics.replaceOrMake(this.mTransformed, this.mTextPaint, paramInt1, localAlignment, this.mSpacingMult, this.mSpacingAdd, (BoringLayout.Metrics)localObject, this.mIncludePad, this.mEllipsize, paramInt2);
          return;
        }
        this.mLayout = BoringLayout.make(this.mTransformed, this.mTextPaint, paramInt1, localAlignment, this.mSpacingMult, this.mSpacingAdd, (BoringLayout.Metrics)localObject, this.mIncludePad, this.mEllipsize, paramInt2);
        return;
      }
      paramMetrics = this.mTransformed;
      this.mLayout = new SingleLineTextView.ExtraStaticLayout(paramMetrics, 0, paramMetrics.length(), this.mTextPaint, paramInt1, localAlignment, this.mSpacingMult, this.mSpacingAdd, this.mIncludePad, this.mEllipsize, paramInt2);
      return;
    }
    paramMetrics = this.mTransformed;
    this.mLayout = new SingleLineTextView.ExtraStaticLayout(paramMetrics, 0, paramMetrics.length(), this.mTextPaint, paramInt1, localAlignment, this.mSpacingMult, this.mSpacingAdd, this.mIncludePad, this.mEllipsize, paramInt2);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mHandler.removeCallbacksAndMessages(null);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i1 = getCompoundPaddingLeft();
    int m = getCompoundPaddingTop();
    int i7 = getCompoundPaddingRight();
    int k = getCompoundPaddingBottom();
    int i4 = getScrollX();
    int i3 = getScrollY();
    int i5 = getRight();
    int i6 = getLeft();
    int n = getBottom();
    int i9 = getTop();
    int i;
    if (this.mLayout == null)
    {
      j = i5 - i6 - i1 - i7;
      i = j;
      if (j < 1) {
        i = 0;
      }
      if (this.mHorizontallyScrolling) {
        j = 16384;
      } else {
        j = i;
      }
      makeSingleLayout(j, UNKNOWN_BORING, i);
    }
    int i2 = getExtendedPaddingTop();
    int i8 = getExtendedPaddingBottom();
    i9 = n - i9;
    n = i9 - k - m;
    k = this.mLayout.getLineTop(1) - this.mLayout.getLineDescent(0);
    if ((this.mGravity & 0x70) != 48)
    {
      i = getVerticalOffset();
      j = getVerticalOffset();
    }
    else
    {
      i = 0;
      j = 0;
    }
    int[] arrayOfInt = getDrawableState();
    Object localObject1 = this.mDrawables;
    if (localObject1 != null) {
      if (((SingleLineTextView.Drawables)localObject1).mDrawableLeft != null)
      {
        paramCanvas.save();
        int i10 = getPaddingLeft();
        int i11 = (n - ((SingleLineTextView.Drawables)localObject1).mDrawableHeightLeft) / 2;
        paramCanvas.translate(i10 + i4, i3 + m + i11);
        ((SingleLineTextView.Drawables)localObject1).mDrawableLeft.draw(paramCanvas);
        paramCanvas.restore();
      }
      else {}
    }
    Object localObject2 = this.mExtendTexts[1];
    Paint.FontMetrics localFontMetrics;
    float f2;
    if ((localObject2 != null) && (!((SingleLineTextView.ExtendText)localObject2).mEmpty))
    {
      paramCanvas.save();
      paramCanvas.translate(i4 + i1 - ((SingleLineTextView.ExtendText)localObject2).getDesiredWith(), i2 + i);
      localFontMetrics = ((SingleLineTextView.ExtendText)localObject2).getFontMetrics();
      f2 = k;
      if (localFontMetrics != null)
      {
        f1 = f2;
        if (f2 > getMeasuredHeight() - localFontMetrics.bottom) {
          f1 = (int)(getMeasuredHeight() - localFontMetrics.bottom);
        }
      }
      else
      {
        f1 = f2;
      }
      ((SingleLineTextView.ExtendText)localObject2).draw(paramCanvas, arrayOfInt, 0.0F, f1);
      paramCanvas.restore();
    }
    localObject2 = this.mLayout;
    this.mTextPaint.setColor(this.mCurTextColor);
    this.mTextPaint.drawableState = getDrawableState();
    paramCanvas.save();
    paramCanvas.clipRect(i1 + i4, i2 + i3, i5 - i6 - i7 + i4, i9 - i8 + i3);
    float f1 = i1;
    float f3 = i2 + i;
    paramCanvas.translate(f1, f3);
    ((Layout)localObject2).draw(paramCanvas, null, null, j - i);
    paramCanvas.restore();
    localObject2 = this.mExtendTexts[2];
    if ((localObject2 != null) && (!((SingleLineTextView.ExtendText)localObject2).mEmpty))
    {
      paramCanvas.save();
      i = getDesiredWidth() + 0 + ((SingleLineTextView.ExtendText)localObject2).mPadding;
      i1 = i4 + i5 - i6 - i7 + 0;
      j = 0 + (((SingleLineTextView.ExtendText)localObject2).getDesiredWith() + ((SingleLineTextView.ExtendText)localObject2).mPadding);
      if (i1 <= i) {
        i = i1;
      }
      paramCanvas.translate(i, f3);
      localFontMetrics = ((SingleLineTextView.ExtendText)localObject2).getFontMetrics();
      f2 = k;
      f1 = f2;
      if (localFontMetrics != null)
      {
        f1 = f2;
        if (f2 > getMeasuredHeight() - localFontMetrics.bottom) {
          f1 = (int)(((SingleLineTextView.ExtendText)localObject2).getDesiredHeight() - localFontMetrics.bottom);
        }
      }
      ((SingleLineTextView.ExtendText)localObject2).draw(paramCanvas, arrayOfInt, 0.0F, f1);
      paramCanvas.restore();
    }
    else
    {
      j = 0;
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      i = j;
      if (((SingleLineTextView.Drawables)localObject2).mDrawableRight2 != null)
      {
        paramCanvas.save();
        i = getDesiredWidth() + j + ((SingleLineTextView.Drawables)localObject2).mDrawablePadding;
        i1 = i4 + i5 - i6 - i7 + j + ((SingleLineTextView.Drawables)localObject2).mDrawablePadding;
        j += ((SingleLineTextView.Drawables)localObject2).mDrawableSizeRight2 + ((SingleLineTextView.Drawables)localObject2).mDrawablePadding;
        if (i1 <= i) {
          i = i1;
        }
        i1 = i3 + m + (n - ((SingleLineTextView.Drawables)localObject2).mDrawableHeightRight2) / 2;
        paramCanvas.translate(i, i1);
        ((SingleLineTextView.Drawables)localObject2).mDrawableRight2Position[0] = i;
        ((SingleLineTextView.Drawables)localObject2).mDrawableRight2Position[1] = i1;
        ((SingleLineTextView.Drawables)localObject2).mDrawableRight2.draw(paramCanvas);
        paramCanvas.restore();
        i = j;
      }
    }
    else
    {
      i = j;
    }
    int j = i;
    if (localObject1 != null)
    {
      j = i;
      if (((SingleLineTextView.Drawables)localObject1).mDrawableRight != null)
      {
        paramCanvas.save();
        i1 = getDesiredWidth() + i + ((SingleLineTextView.Drawables)localObject1).mDrawablePadding;
        i2 = i4 + i5 - i6 - i7 + i + ((SingleLineTextView.Drawables)localObject1).mDrawablePadding;
        j = i + (((SingleLineTextView.Drawables)localObject1).mDrawableSizeRight + ((SingleLineTextView.Drawables)localObject1).mDrawablePadding);
        if (i2 > i1) {
          i = i1;
        } else {
          i = i2;
        }
        i1 = i3 + m + (n - ((SingleLineTextView.Drawables)localObject1).mDrawableHeightRight) / 2;
        paramCanvas.translate(i, i1);
        ((SingleLineTextView.Drawables)localObject1).mDrawableRightPosition[0] = i;
        ((SingleLineTextView.Drawables)localObject1).mDrawableRightPosition[1] = i1;
        ((SingleLineTextView.Drawables)localObject1).mDrawableRight.draw(paramCanvas);
        paramCanvas.restore();
      }
    }
    if ((localObject1 != null) && (((SingleLineTextView.Drawables)localObject1).mDrawableRightExt != null))
    {
      paramCanvas.save();
      i = getDesiredWidth() + j + ((SingleLineTextView.Drawables)localObject1).mDrawablePadding;
      j = ((SingleLineTextView.Drawables)localObject1).mDrawablePadding + (i4 + i5 - i6 - i7 + j);
      i1 = ((SingleLineTextView.Drawables)localObject1).mDrawableSizeRightExt;
      i1 = ((SingleLineTextView.Drawables)localObject1).mDrawablePadding;
      if (j <= i) {
        i = j;
      }
      j = i3 + m + (n - ((SingleLineTextView.Drawables)localObject1).mDrawableHeightRightExt) / 2;
      paramCanvas.translate(i, j);
      ((SingleLineTextView.Drawables)localObject1).mDrawableRight2ExtPosition[0] = i;
      ((SingleLineTextView.Drawables)localObject1).mDrawableRight2ExtPosition[1] = j;
      ((SingleLineTextView.Drawables)localObject1).mDrawableRightExt.draw(paramCanvas);
      paramCanvas.restore();
    }
    localObject1 = this.mExtendTexts[0];
    if ((localObject1 != null) && (!((SingleLineTextView.ExtendText)localObject1).mEmpty))
    {
      paramCanvas.save();
      paramCanvas.translate(i4 + i5 - i6 - ((SingleLineTextView.ExtendText)localObject1).getDesiredWith() - getPaddingRight(), f3);
      ((SingleLineTextView.ExtendText)localObject1).draw(paramCanvas, arrayOfInt, 0.0F, k);
      paramCanvas.restore();
      i = ((SingleLineTextView.ExtendText)localObject1).getDesiredWith();
    }
    else
    {
      i = 0;
    }
    localObject1 = this.mIconDrawables;
    if (localObject1 != null)
    {
      j = i4 + i5 - i6 - i - getPaddingRight() - this.mIconDrawableGap;
      i = localObject1.length - 1;
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
            j = (n - localObject1[i].mDrawableHeight) / 2;
            paramCanvas.translate(k, i3 + m + j);
            localObject1[i].mDrawable.draw(paramCanvas);
            paramCanvas.restore();
          }
        }
        i -= 1;
        j = k;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT < 21) {
      this.mHandler.removeMessages(1);
    }
    int m = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    Object localObject = UNKNOWN_BORING;
    if (m != 1073741824)
    {
      localObject = BoringLayout.isBoring(this.mTransformed, this.mTextPaint, this.mBoring);
      if (localObject != null) {
        this.mBoring = ((BoringLayout.Metrics)localObject);
      }
      if ((localObject != null) && (localObject != UNKNOWN_BORING)) {
        paramInt1 = ((BoringLayout.Metrics)localObject).width;
      } else {
        paramInt1 = getDesiredWidth();
      }
      paramInt1 = Math.max(Math.min(paramInt1 + (getCompoundPaddingLeft() + getCompoundPaddingRight()), this.mMaxWidth), getSuggestedMinimumWidth());
      if (m == -2147483648) {
        i = Math.min(i, paramInt1);
      } else {
        i = paramInt1;
      }
    }
    paramInt2 = i - getCompoundPaddingLeft() - getCompoundPaddingRight();
    paramInt1 = paramInt2;
    if (this.needCheckIconDrawablesWhenMeasure)
    {
      paramInt1 = paramInt2;
      if (checkIfNeedHideSomeIconDrawables(paramInt2)) {
        paramInt1 = i - getCompoundPaddingLeft() - getCompoundPaddingRight();
      }
    }
    if (this.mHorizontallyScrolling) {
      paramInt2 = 16384;
    } else {
      paramInt2 = paramInt1;
    }
    Layout localLayout = this.mLayout;
    if (localLayout == null) {
      makeSingleLayout(paramInt2, (BoringLayout.Metrics)localObject, paramInt1);
    } else if ((localLayout.getWidth() != paramInt2) || (this.mLayout.getEllipsizedWidth() != paramInt1)) {
      makeSingleLayout(paramInt2, (BoringLayout.Metrics)localObject, paramInt1);
    }
    if (k == 1073741824)
    {
      paramInt1 = j;
    }
    else
    {
      m = getCompoundPaddingTop() + getCompoundPaddingBottom();
      localObject = this.mLayout;
      k = 0;
      if (localObject != null)
      {
        paramInt2 = ((Layout)localObject).getLineCount();
        paramInt1 = paramInt2;
        if (paramInt2 > 1) {
          paramInt1 = 1;
        }
        paramInt1 = this.mLayout.getLineTop(paramInt1);
      }
      else
      {
        paramInt1 = 0;
      }
      paramInt2 = paramInt1 + m;
      localObject = this.mDrawables;
      paramInt1 = paramInt2;
      if (localObject != null) {
        paramInt1 = Math.max(Math.max(paramInt2, ((SingleLineTextView.Drawables)localObject).mDrawableHeightLeft), ((SingleLineTextView.Drawables)localObject).mDrawableHeightRight);
      }
      localObject = this.mIconDrawables;
      paramInt2 = paramInt1;
      if (localObject != null)
      {
        j = localObject.length;
        paramInt2 = 0;
        while (paramInt2 < j)
        {
          paramInt1 = Math.max(paramInt1, localObject[paramInt2].mDrawableHeight);
          paramInt2 += 1;
        }
        paramInt2 = paramInt1;
      }
      j = paramInt2;
      if (paramInt2 == m)
      {
        paramInt1 = k;
        for (;;)
        {
          localObject = this.mExtendTexts;
          j = paramInt2;
          if (paramInt1 >= localObject.length) {
            break;
          }
          localObject = localObject[paramInt1];
          j = paramInt2;
          if (localObject != null)
          {
            j = paramInt2;
            if (!((SingleLineTextView.ExtendText)localObject).mEmpty) {
              j = Math.max(paramInt2, ((SingleLineTextView.ExtendText)localObject).getDesiredHeight());
            }
          }
          paramInt1 += 1;
          paramInt2 = j;
        }
      }
      paramInt1 = Math.max(j, getSuggestedMinimumHeight());
    }
    setMeasuredDimension(i, paramInt1);
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
    if (paramInt == 0)
    {
      if (localDrawables2 != null) {
        localDrawables2.mDrawablePadding = paramInt;
      }
    }
    else
    {
      SingleLineTextView.Drawables localDrawables1 = localDrawables2;
      if (localDrawables2 == null)
      {
        localDrawables1 = new SingleLineTextView.Drawables(null);
        this.mDrawables = localDrawables1;
      }
      localDrawables1.mDrawablePadding = paramInt;
    }
    if (!this.mHandler.hasMessages(1)) {
      this.mHandler.sendEmptyMessage(1);
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
    if ((paramDrawable1 == null) && (paramDrawable2 == null)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      if (localObject2 != null) {
        if (((SingleLineTextView.Drawables)localObject2).mDrawablePadding == 0)
        {
          this.mDrawables = null;
        }
        else
        {
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
        }
      }
    }
    else
    {
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
      }
      else
      {
        ((SingleLineTextView.Drawables)localObject1).mDrawableHeightLeft = 0;
        ((SingleLineTextView.Drawables)localObject1).mDrawableSizeLeft = 0;
      }
      if (paramDrawable2 != null)
      {
        paramDrawable2.setState(arrayOfInt);
        paramDrawable2.copyBounds((Rect)localObject2);
        paramDrawable2.setCallback(this);
        ((SingleLineTextView.Drawables)localObject1).mDrawableSizeRight = ((Rect)localObject2).width();
        ((SingleLineTextView.Drawables)localObject1).mDrawableHeightRight = ((Rect)localObject2).height();
      }
      else
      {
        ((SingleLineTextView.Drawables)localObject1).mDrawableHeightRight = 0;
        ((SingleLineTextView.Drawables)localObject1).mDrawableSizeRight = 0;
      }
      if (paramDrawable3 != null)
      {
        paramDrawable3.setState(arrayOfInt);
        paramDrawable3.copyBounds((Rect)localObject2);
        paramDrawable3.setCallback(this);
        ((SingleLineTextView.Drawables)localObject1).mDrawableSizeRightExt = ((Rect)localObject2).width();
        ((SingleLineTextView.Drawables)localObject1).mDrawableHeightRightExt = ((Rect)localObject2).height();
      }
      else
      {
        ((SingleLineTextView.Drawables)localObject1).mDrawableHeightRightExt = 0;
        ((SingleLineTextView.Drawables)localObject1).mDrawableSizeRightExt = 0;
      }
    }
    if (!this.mHandler.hasMessages(1)) {
      this.mHandler.sendEmptyMessage(1);
    }
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = null;
    Object localObject;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      localObject = this.mDrawables;
      if ((localObject != null) && ((((SingleLineTextView.Drawables)localObject).mDrawableLeft != null) || (this.mDrawables.mDrawableRight != null)))
      {
        this.mCompoundLeft = 0;
        this.mCompoundRight = 0;
        setCompoundDrawablesWithIntrinsicBounds(null, null);
        return;
      }
    }
    if ((this.mCompoundLeft == paramInt1) && (this.mCompoundRight == paramInt2)) {
      return;
    }
    this.mCompoundLeft = paramInt1;
    this.mCompoundRight = paramInt2;
    Resources localResources = getContext().getResources();
    if (paramInt1 != 0) {
      localObject = localResources.getDrawable(paramInt1);
    } else {
      localObject = null;
    }
    if (paramInt2 != 0) {
      localDrawable = localResources.getDrawable(paramInt2);
    }
    setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, localDrawable);
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
    if (paramDrawable == null)
    {
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
    else
    {
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
    if (!this.mHandler.hasMessages(1)) {
      this.mHandler.sendEmptyMessage(1);
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
    if (paramInt >= 0)
    {
      Object localObject1 = this.mExtendTexts;
      if (paramInt >= localObject1.length) {
        return;
      }
      Object localObject2 = localObject1[paramInt];
      boolean bool = TextUtils.isEmpty(paramString);
      if ((bool) && ((localObject2 == null) || (localObject2.mEmpty))) {
        return;
      }
      int j = 0;
      if ((bool) && (localObject2 != null) && (!localObject2.mEmpty)) {
        localObject2.reset();
      }
      int i;
      for (;;)
      {
        i = 1;
        break;
        i = j;
        if (bool) {
          break;
        }
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new SingleLineTextView.ExtendText(getResources());
          this.mExtendTexts[paramInt] = localObject1;
        }
        i = j;
        if (paramString.equals(((SingleLineTextView.ExtendText)localObject1).mText)) {
          break;
        }
        ((SingleLineTextView.ExtendText)localObject1).mText = paramString;
        ((SingleLineTextView.ExtendText)localObject1).mDesiredTextWidth = -1;
        ((SingleLineTextView.ExtendText)localObject1).mEmpty = false;
      }
      if ((paramInt == 0) && (i != 0)) {
        postInvalidate();
      }
      if ((i != 0) && (!this.mHandler.hasMessages(1))) {
        this.mHandler.sendEmptyMessage(1);
      }
    }
  }
  
  public void setExtendTextColor(ColorStateList paramColorStateList, int paramInt)
  {
    if (paramInt >= 0)
    {
      Object localObject1 = this.mExtendTexts;
      if (paramInt >= localObject1.length) {
        return;
      }
      Object localObject2 = localObject1[paramInt];
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new SingleLineTextView.ExtendText(getResources());
        this.mExtendTexts[paramInt] = localObject1;
      }
      if (((SingleLineTextView.ExtendText)localObject1).setTextColor(paramColorStateList, getDrawableState())) {
        postInvalidate();
      }
    }
  }
  
  public void setExtendTextPadding(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0)
    {
      Object localObject1 = this.mExtendTexts;
      if (paramInt2 >= localObject1.length) {
        return;
      }
      Object localObject2 = localObject1[paramInt2];
      if ((paramInt1 <= 0) && ((localObject2 == null) || (localObject2.mEmpty))) {
        return;
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new SingleLineTextView.ExtendText(getResources());
        this.mExtendTexts[paramInt2] = localObject1;
      }
      ((SingleLineTextView.ExtendText)localObject1).mPadding = paramInt1;
    }
  }
  
  public void setExtendTextSize(float paramFloat, int paramInt)
  {
    if (paramInt >= 0)
    {
      Object localObject1 = this.mExtendTexts;
      if (paramInt >= localObject1.length) {
        return;
      }
      Object localObject2 = localObject1[paramInt];
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new SingleLineTextView.ExtendText(getResources());
        this.mExtendTexts[paramInt] = localObject1;
      }
      if ((((SingleLineTextView.ExtendText)localObject1).setTextSize(paramFloat, getContext())) && (!this.mHandler.hasMessages(1))) {
        this.mHandler.sendEmptyMessage(1);
      }
    }
  }
  
  public void setGravity(int paramInt)
  {
    int i = paramInt;
    if ((paramInt & 0x7) == 0) {
      i = paramInt | 0x3;
    }
    paramInt = i;
    if ((i & 0x70) == 0) {
      paramInt = i | 0x30;
    }
    i = 0;
    if ((paramInt & 0x7) != (this.mGravity & 0x7)) {
      i = 1;
    }
    if (paramInt != this.mGravity) {
      invalidate();
    }
    this.mGravity = paramInt;
    Layout localLayout = this.mLayout;
    if ((localLayout != null) && (i != 0))
    {
      paramInt = localLayout.getWidth();
      i = getWidth();
      int j = getCompoundPaddingLeft();
      int k = getCompoundPaddingRight();
      makeSingleLayout(paramInt, UNKNOWN_BORING, i - j - k);
    }
  }
  
  public void setIconDrawablePadding(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == this.mIconDrawablePadding) && (paramInt2 == this.mIconDrawableGap)) {
      return;
    }
    this.mIconDrawablePadding = paramInt1;
    this.mIconDrawableGap = paramInt2;
    if (!this.mHandler.hasMessages(1)) {
      this.mHandler.sendEmptyMessage(1);
    }
  }
  
  public void setIconDrawables(Drawable[] paramArrayOfDrawable, boolean paramBoolean)
  {
    Object localObject2 = this.mIconDrawables;
    int i;
    if ((paramBoolean) && (paramArrayOfDrawable != null) && (paramArrayOfDrawable.length != 0))
    {
      Object localObject1;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (localObject2.length == paramArrayOfDrawable.length) {}
      }
      else
      {
        localObject2 = new SingleLineTextView.IconDrawable[paramArrayOfDrawable.length];
        i = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (i >= localObject2.length) {
            break;
          }
          localObject2[i] = new SingleLineTextView.IconDrawable();
          i += 1;
        }
      }
      localObject2 = getDrawableState();
      i = 0;
      while (i < localObject1.length)
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
        else
        {
          localRect = localObject1[i];
          localObject1[i].mDrawableHeight = 0;
          localRect.mDrawableSize = 0;
        }
        i += 1;
      }
      this.mIconDrawables = localObject1;
    }
    else if (localObject2 != null)
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
      this.mIconDrawables = null;
    }
    if (!this.mHandler.hasMessages(1)) {
      this.mHandler.sendEmptyMessage(1);
    }
  }
  
  public void setIconDrawablesWithIntrinsicBounds(ArrayList<SingleLineTextView.IconDrawableInfo> paramArrayList)
  {
    int k = 0;
    int i;
    if (paramArrayList != null) {
      i = paramArrayList.size();
    } else {
      i = 0;
    }
    Object localObject = this.mIconDrawableInfos;
    int j;
    if (localObject != null) {
      j = ((ArrayList)localObject).size();
    } else {
      j = 0;
    }
    if (i == j)
    {
      if ((i > 0) && (paramArrayList != null) && (this.mIconDrawableInfos != null))
      {
        j = 0;
        while (j < i)
        {
          if (!((SingleLineTextView.IconDrawableInfo)this.mIconDrawableInfos.get(j)).equals((SingleLineTextView.IconDrawableInfo)paramArrayList.get(j))) {
            break label106;
          }
          j += 1;
        }
      }
      j = 0;
    }
    else
    {
      label106:
      j = 1;
    }
    if (j != 0)
    {
      localObject = null;
      if (i > 0)
      {
        Drawable[] arrayOfDrawable = new Drawable[i];
        j = 0;
        boolean bool1 = false;
        for (;;)
        {
          localObject = arrayOfDrawable;
          bool2 = bool1;
          if (j >= i) {
            break;
          }
          localObject = (SingleLineTextView.IconDrawableInfo)paramArrayList.get(j);
          arrayOfDrawable[j] = getIconDrawableWithStatus(getContext(), (SingleLineTextView.IconDrawableInfo)localObject);
          if (arrayOfDrawable[j] != null) {
            bool1 = true;
          }
          j += 1;
        }
      }
      boolean bool2 = false;
      this.mIconDrawableInfos = paramArrayList;
      setIconDrawables((Drawable[])localObject, bool2);
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
    }
    this.needCheckIconDrawablesWhenMeasure = true;
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
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (localObject.equals(this.mText)) {
      return;
    }
    int j = ((CharSequence)localObject).length();
    int i = 0;
    paramCharSequence = (CharSequence)localObject;
    if (j > 168) {
      try
      {
        paramCharSequence = ((CharSequence)localObject).subSequence(0, 168);
      }
      catch (Exception localException)
      {
        paramCharSequence = (CharSequence)localObject;
        if (QLog.isDevelopLevel())
        {
          localException.printStackTrace();
          paramCharSequence = (CharSequence)localObject;
        }
      }
    }
    this.mText = paramCharSequence;
    this.mTransformed = this.mTransformation.getTransformation(paramCharSequence, this);
    if ((paramCharSequence instanceof Spannable))
    {
      j = paramCharSequence.length();
      ((Spannable)paramCharSequence).setSpan(this.mTransformation, 0, j, 18);
    }
    this.mTextDesiredWith = -1;
    if (this.mLayout != null) {
      checkForRelayout();
    }
    getText();
    if ((getText() instanceof Spannable))
    {
      paramCharSequence = (Spannable)getText();
      paramCharSequence = (EmoticonSpan[])paramCharSequence.getSpans(0, paramCharSequence.length(), EmoticonSpan.class);
      while (i < paramCharSequence.length)
      {
        localObject = paramCharSequence[i].getDrawable();
        if (localObject != null) {
          ((Drawable)localObject).setCallback(this);
        }
        i += 1;
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
    if (localObject == null) {
      localObject = Resources.getSystem();
    } else {
      localObject = ((Context)localObject).getResources();
    }
    paramFloat = TypedValue.applyDimension(1, paramFloat, ((Resources)localObject).getDisplayMetrics());
    if (paramFloat != this.mTextPaint.getTextSize())
    {
      this.mTextPaint.setTextSize(paramFloat);
      this.mTextDesiredWith = -1;
      if (!this.mHandler.hasMessages(1)) {
        this.mHandler.sendEmptyMessage(1);
      }
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
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.SingleLineTextView
 * JD-Core Version:    0.7.0.1
 */