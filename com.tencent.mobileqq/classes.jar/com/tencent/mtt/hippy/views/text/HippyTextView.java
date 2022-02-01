package com.tencent.mtt.hippy.views.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter;
import com.tencent.mtt.hippy.dom.node.e;
import com.tencent.mtt.hippy.uimanager.HippyViewBase;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.views.common.CommonBackgroundDrawable;
import com.tencent.mtt.hippy.views.common.CommonBorder;
import com.tencent.mtt.hippy.views.list.HippyRecycler;

public class HippyTextView
  extends View
  implements HippyViewBase, CommonBorder, HippyRecycler
{
  private CommonBackgroundDrawable mBGDrawable;
  private NativeGestureDispatcher mGestureDispatcher;
  private boolean mHasSetNativeTextColor = false;
  protected Layout mLayout = null;
  private boolean mNativeGestureEnable = false;
  private e mNativeGestureSpan;
  private int mNativeTextColor = 0;
  private boolean mTextBold = false;
  
  public HippyTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  private e findNativeGestureSpanForTouch(MotionEvent paramMotionEvent)
  {
    Object localObject1 = null;
    if (this.mLayout == null) {
      return null;
    }
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    switch (HippyTextView.1.$SwitchMap$android$text$Layout$Alignment[this.mLayout.getAlignment().ordinal()])
    {
    }
    Object localObject2;
    for (;;)
    {
      paramMotionEvent = this.mLayout;
      j = paramMotionEvent.getLineForVertical(j);
      int k = (int)paramMotionEvent.getLineLeft(j);
      int m = (int)paramMotionEvent.getLineRight(j);
      localObject2 = paramMotionEvent.getText();
      if ((!(localObject2 instanceof Spanned)) || (i < k) || (i > m)) {
        break label448;
      }
      Spanned localSpanned = (Spanned)localObject2;
      m = this.mLayout.getOffsetForHorizontal(j, i);
      e[] arrayOfe = (e[])localSpanned.getSpans(m, m, e.class);
      if ((arrayOfe == null) || (arrayOfe.length <= 0)) {
        break label448;
      }
      j = ((CharSequence)localObject2).length();
      i = 0;
      for (paramMotionEvent = (MotionEvent)localObject1; i < arrayOfe.length; paramMotionEvent = (MotionEvent)localObject1)
      {
        n = localSpanned.getSpanStart(arrayOfe[i]);
        i1 = localSpanned.getSpanEnd(arrayOfe[i]);
        k = j;
        localObject1 = paramMotionEvent;
        if (i1 > m)
        {
          k = j;
          localObject1 = paramMotionEvent;
          if (i1 - n <= j)
          {
            localObject1 = arrayOfe[i];
            k = i1 - n;
          }
        }
        i += 1;
        j = k;
      }
      m = getHeight();
      int n = getPaddingTop();
      int i1 = getPaddingBottom();
      int i2 = this.mLayout.getHeight();
      k = (getWidth() - this.mLayout.getWidth()) / 2;
      j -= (m + n + i1 - i2) / 2;
      i -= k;
      continue;
      i -= getWidth() - getPaddingRight() - this.mLayout.getWidth();
    }
    for (;;)
    {
      if ((paramMotionEvent == null) && ((localObject2 instanceof Spanned)))
      {
        localObject2 = (Spanned)localObject2;
        localObject1 = (e[])((Spanned)localObject2).getSpans(0, ((Spanned)localObject2).length(), e.class);
        if (localObject1.length == 1)
        {
          localObject2 = (AbsoluteSizeSpan[])((Spanned)localObject2).getSpans(0, ((Spanned)localObject2).length(), AbsoluteSizeSpan.class);
          if ((!localObject1[0].a()) && (localObject2.length == 1)) {
            paramMotionEvent = localObject1[0];
          }
        }
      }
      for (;;)
      {
        return paramMotionEvent;
      }
      label448:
      paramMotionEvent = null;
    }
  }
  
  private CommonBackgroundDrawable getBackGround()
  {
    Drawable localDrawable;
    if (this.mBGDrawable == null)
    {
      this.mBGDrawable = new CommonBackgroundDrawable();
      localDrawable = getBackground();
      super.setBackgroundDrawable(null);
      if (localDrawable != null) {
        break label45;
      }
      super.setBackgroundDrawable(this.mBGDrawable);
    }
    for (;;)
    {
      return this.mBGDrawable;
      label45:
      super.setBackgroundDrawable(new LayerDrawable(new Drawable[] { this.mBGDrawable, localDrawable }));
    }
  }
  
  public void clear()
  {
    this.mLayout = null;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mNativeGestureEnable) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (paramMotionEvent.getAction() == 0) {
      this.mNativeGestureSpan = findNativeGestureSpanForTouch(paramMotionEvent);
    }
    if (this.mNativeGestureSpan != null)
    {
      if (this.mNativeGestureSpan.b(this, paramMotionEvent))
      {
        super.dispatchTouchEvent(paramMotionEvent);
        return true;
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public NativeGestureDispatcher getGestureDispatcher()
  {
    return this.mGestureDispatcher;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      if (this.mLayout != null)
      {
        LogUtils.d("HippyText", "id: " + getId() + " mExtra : " + this.mLayout.getText() + "layout : w:" + this.mLayout.getWidth() + " h:" + this.mLayout.getHeight() + " view : w:" + getWidth() + " h:" + getHeight() + " textColor:" + this.mLayout.getPaint().getColor());
        paramCanvas.save();
        switch (HippyTextView.1.$SwitchMap$android$text$Layout$Alignment[this.mLayout.getAlignment().ordinal()])
        {
        case 1: 
          paramCanvas.translate(getPaddingLeft(), getPaddingTop());
          for (;;)
          {
            localObject = this.mLayout.getPaint();
            if (localObject != null) {
              ((Paint)localObject).setFakeBoldText(this.mTextBold);
            }
            this.mLayout.draw(paramCanvas);
            paramCanvas.restore();
            return;
            int i = getHeight();
            int j = getPaddingTop();
            int k = getPaddingBottom();
            int m = this.mLayout.getHeight();
            paramCanvas.translate((getWidth() - this.mLayout.getWidth()) / 2, (i + j + k - m) / 2);
          }
        }
      }
    }
    catch (Throwable paramCanvas)
    {
      for (;;)
      {
        Object localObject = getContext();
        if (!(localObject instanceof HippyInstanceContext)) {
          break;
        }
        localObject = ((HippyInstanceContext)localObject).getEngineContext().getGlobalConfigs().getExceptionHandler();
        if (localObject == null) {
          break;
        }
        ((HippyExceptionHandlerAdapter)localObject).handleNativeException(new RuntimeException("hippyTextView onDraw" + paramCanvas.getMessage()), true);
        return;
        paramCanvas.translate(getWidth() - getPaddingRight() - this.mLayout.getWidth(), 0.0F);
        continue;
        LogUtils.d("HippyText", "id: " + getId() + " mExtra :  is  null ");
        return;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = super.onTouchEvent(paramMotionEvent);
    boolean bool1 = bool2;
    if (this.mNativeGestureSpan != null) {
      bool1 = bool2 | this.mNativeGestureSpan.a(this, paramMotionEvent);
    }
    return bool1;
  }
  
  public void resetProps()
  {
    setPadding(0, 0, 0, 0);
    this.mNativeGestureEnable = false;
    this.mBGDrawable = null;
    setBackgroundDrawable(null);
    this.mTextBold = false;
    this.mGestureDispatcher = null;
    this.mNativeGestureSpan = null;
    this.mNativeTextColor = 0;
    this.mHasSetNativeTextColor = false;
    this.mLayout = null;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    getBackGround().setBackgroundColor(paramInt);
  }
  
  public void setBorderColor(int paramInt1, int paramInt2)
  {
    getBackGround().setBorderColor(paramInt1, paramInt2);
  }
  
  public void setBorderRadius(float paramFloat, int paramInt)
  {
    getBackGround().setBorderRadius(paramFloat, paramInt);
  }
  
  public void setBorderStyle(int paramInt) {}
  
  public void setBorderWidth(float paramFloat, int paramInt)
  {
    getBackGround().setBorderWidth(paramFloat, paramInt);
  }
  
  public void setCustomColor(int paramInt)
  {
    this.mHasSetNativeTextColor = true;
    this.mNativeTextColor = paramInt;
    setTextColor(paramInt);
  }
  
  public void setGestureDispatcher(NativeGestureDispatcher paramNativeGestureDispatcher)
  {
    this.mGestureDispatcher = paramNativeGestureDispatcher;
  }
  
  public void setLayout(Layout paramLayout)
  {
    if (this.mLayout != null) {
      invalidate();
    }
    this.mLayout = paramLayout;
    if ((this.mHasSetNativeTextColor) && (this.mNativeTextColor != 0)) {
      setTextColor(this.mNativeTextColor);
    }
  }
  
  public void setNativeGestureEnable(boolean paramBoolean)
  {
    this.mNativeGestureEnable = paramBoolean;
  }
  
  public void setTextBold(boolean paramBoolean)
  {
    this.mTextBold = paramBoolean;
    postInvalidate();
  }
  
  protected void setTextColor(int paramInt)
  {
    SpannableStringBuilder localSpannableStringBuilder;
    ForegroundColorSpan[] arrayOfForegroundColorSpan;
    int i;
    int m;
    int n;
    if ((this.mLayout != null) && ((this.mLayout.getText() instanceof SpannableStringBuilder)))
    {
      localSpannableStringBuilder = (SpannableStringBuilder)this.mLayout.getText();
      arrayOfForegroundColorSpan = (ForegroundColorSpan[])localSpannableStringBuilder.getSpans(0, this.mLayout.getText().length(), ForegroundColorSpan.class);
      if (arrayOfForegroundColorSpan != null)
      {
        int k = arrayOfForegroundColorSpan.length;
        i = 0;
        if (i < k)
        {
          ForegroundColorSpan localForegroundColorSpan = arrayOfForegroundColorSpan[i];
          m = localSpannableStringBuilder.getSpanStart(localForegroundColorSpan);
          n = localSpannableStringBuilder.getSpanEnd(localForegroundColorSpan);
          localSpannableStringBuilder.removeSpan(localForegroundColorSpan);
          if (m != 0) {
            break label176;
          }
        }
      }
    }
    label176:
    for (int j = 18;; j = 34)
    {
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(paramInt), m, n, j);
      i += 1;
      break;
      if ((arrayOfForegroundColorSpan == null) || (arrayOfForegroundColorSpan.length == 0)) {
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(paramInt), 0, localSpannableStringBuilder.toString().length(), 34);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.text.HippyTextView
 * JD-Core Version:    0.7.0.1
 */