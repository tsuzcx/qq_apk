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
import com.tencent.mtt.hippy.dom.DomManager;
import com.tencent.mtt.hippy.dom.node.TextNode;
import com.tencent.mtt.hippy.dom.node.f;
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
  private f mNativeGestureSpan;
  private int mNativeTextColor = 0;
  private boolean mTextBold = false;
  
  public HippyTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  private f findNativeGestureSpanForTouch(MotionEvent paramMotionEvent)
  {
    Object localObject1 = this.mLayout;
    MotionEvent localMotionEvent = null;
    if (localObject1 == null) {
      return null;
    }
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    int k = HippyTextView.1.$SwitchMap$android$text$Layout$Alignment[this.mLayout.getAlignment().ordinal()];
    int n;
    int i1;
    if (k != 1)
    {
      if (k == 2) {
        i -= getWidth() - getPaddingRight() - this.mLayout.getWidth();
      }
    }
    else
    {
      k = getHeight();
      m = getPaddingTop();
      n = getPaddingBottom();
      i1 = this.mLayout.getHeight();
      i -= (getWidth() - this.mLayout.getWidth()) / 2;
      j -= (k + m + n - i1) / 2;
    }
    paramMotionEvent = this.mLayout;
    j = paramMotionEvent.getLineForVertical(j);
    k = (int)paramMotionEvent.getLineLeft(j);
    int m = (int)paramMotionEvent.getLineRight(j);
    localObject1 = paramMotionEvent.getText();
    boolean bool = localObject1 instanceof Spanned;
    paramMotionEvent = localMotionEvent;
    Object localObject2;
    if (bool)
    {
      paramMotionEvent = localMotionEvent;
      if (i >= k)
      {
        paramMotionEvent = localMotionEvent;
        if (i <= m)
        {
          localObject2 = (Spanned)localObject1;
          n = this.mLayout.getOffsetForHorizontal(j, i);
          f[] arrayOff = (f[])((Spanned)localObject2).getSpans(n, n, f.class);
          paramMotionEvent = localMotionEvent;
          if (arrayOff != null)
          {
            paramMotionEvent = localMotionEvent;
            if (arrayOff.length > 0)
            {
              j = ((CharSequence)localObject1).length();
              paramMotionEvent = null;
              i = 0;
              while (i < arrayOff.length)
              {
                m = ((Spanned)localObject2).getSpanStart(arrayOff[i]);
                i1 = ((Spanned)localObject2).getSpanEnd(arrayOff[i]);
                localMotionEvent = paramMotionEvent;
                k = j;
                if (i1 > n)
                {
                  m = i1 - m;
                  localMotionEvent = paramMotionEvent;
                  k = j;
                  if (m <= j)
                  {
                    localMotionEvent = arrayOff[i];
                    k = m;
                  }
                }
                i += 1;
                paramMotionEvent = localMotionEvent;
                j = k;
              }
            }
          }
        }
      }
    }
    localMotionEvent = paramMotionEvent;
    if (paramMotionEvent == null)
    {
      localMotionEvent = paramMotionEvent;
      if (bool)
      {
        localObject2 = (Spanned)localObject1;
        localObject1 = (f[])((Spanned)localObject2).getSpans(0, ((Spanned)localObject2).length(), f.class);
        localMotionEvent = paramMotionEvent;
        if (localObject1.length == 1)
        {
          localObject2 = (AbsoluteSizeSpan[])((Spanned)localObject2).getSpans(0, ((Spanned)localObject2).length(), AbsoluteSizeSpan.class);
          localMotionEvent = paramMotionEvent;
          if (!localObject1[0].a())
          {
            localMotionEvent = paramMotionEvent;
            if (localObject2.length == 1) {
              localMotionEvent = localObject1[0];
            }
          }
        }
      }
    }
    return localMotionEvent;
  }
  
  private CommonBackgroundDrawable getBackGround()
  {
    if (this.mBGDrawable == null)
    {
      this.mBGDrawable = new CommonBackgroundDrawable();
      Drawable localDrawable = getBackground();
      super.setBackgroundDrawable(null);
      if (localDrawable == null) {
        super.setBackgroundDrawable(this.mBGDrawable);
      } else {
        super.setBackgroundDrawable(new LayerDrawable(new Drawable[] { this.mBGDrawable, localDrawable }));
      }
    }
    return this.mBGDrawable;
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
    f localf = this.mNativeGestureSpan;
    if (localf != null)
    {
      if (localf.b(this, paramMotionEvent))
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
      localObject = this.mLayout;
      if (localObject != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("id: ");
        ((StringBuilder)localObject).append(getId());
        ((StringBuilder)localObject).append(" mExtra : ");
        ((StringBuilder)localObject).append(this.mLayout.getText());
        ((StringBuilder)localObject).append("layout : w:");
        ((StringBuilder)localObject).append(this.mLayout.getWidth());
        ((StringBuilder)localObject).append(" h:");
        ((StringBuilder)localObject).append(this.mLayout.getHeight());
        ((StringBuilder)localObject).append(" view : w:");
        ((StringBuilder)localObject).append(getWidth());
        ((StringBuilder)localObject).append(" h:");
        ((StringBuilder)localObject).append(getHeight());
        ((StringBuilder)localObject).append(" textColor:");
        ((StringBuilder)localObject).append(this.mLayout.getPaint().getColor());
        LogUtils.d("HippyText", ((StringBuilder)localObject).toString());
        paramCanvas.save();
        int i = HippyTextView.1.$SwitchMap$android$text$Layout$Alignment[this.mLayout.getAlignment().ordinal()];
        if (i != 1)
        {
          if (i != 2) {
            paramCanvas.translate(getPaddingLeft(), getPaddingTop());
          } else {
            paramCanvas.translate(getWidth() - getPaddingRight() - this.mLayout.getWidth(), 0.0F);
          }
        }
        else
        {
          i = getHeight();
          int j = getPaddingTop();
          int k = getPaddingBottom();
          int m = this.mLayout.getHeight();
          paramCanvas.translate((getWidth() - this.mLayout.getWidth()) / 2, (i + j + k - m) / 2.0F);
        }
        localObject = this.mLayout.getPaint();
        if (localObject != null) {
          ((Paint)localObject).setFakeBoldText(this.mTextBold);
        }
        this.mLayout.draw(paramCanvas);
        paramCanvas.restore();
        return;
      }
      paramCanvas = new StringBuilder();
      paramCanvas.append("id: ");
      paramCanvas.append(getId());
      paramCanvas.append(" mExtra :  is  null ");
      LogUtils.d("HippyText", paramCanvas.toString());
      return;
    }
    catch (Throwable paramCanvas)
    {
      Object localObject = getContext();
      if ((localObject instanceof HippyInstanceContext))
      {
        localObject = ((HippyInstanceContext)localObject).getEngineContext().getGlobalConfigs().getExceptionHandler();
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("hippyTextView onDraw");
          localStringBuilder.append(paramCanvas.getMessage());
          ((HippyExceptionHandlerAdapter)localObject).handleNativeException(new RuntimeException(localStringBuilder.toString()), true);
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = super.onTouchEvent(paramMotionEvent);
    f localf = this.mNativeGestureSpan;
    boolean bool1 = bool2;
    if (localf != null) {
      bool1 = bool2 | localf.a(this, paramMotionEvent);
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
  
  public void setId(int paramInt)
  {
    super.setId(paramInt);
    Object localObject = getContext();
    if ((localObject instanceof HippyInstanceContext))
    {
      localObject = ((HippyInstanceContext)localObject).getEngineContext();
      if (localObject != null)
      {
        localObject = ((HippyEngineContext)localObject).getDomManager().b(paramInt);
        if ((localObject instanceof TextNode)) {
          ((TextNode)localObject).setTextView(this);
        }
      }
    }
  }
  
  public void setLayout(Layout paramLayout)
  {
    if (this.mLayout != null) {
      invalidate();
    }
    this.mLayout = paramLayout;
    if (this.mHasSetNativeTextColor)
    {
      int i = this.mNativeTextColor;
      if (i != 0) {
        setTextColor(i);
      }
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
    Object localObject = this.mLayout;
    if ((localObject != null) && ((((Layout)localObject).getText() instanceof SpannableStringBuilder)))
    {
      localObject = (SpannableStringBuilder)this.mLayout.getText();
      ForegroundColorSpan[] arrayOfForegroundColorSpan = (ForegroundColorSpan[])((SpannableStringBuilder)localObject).getSpans(0, this.mLayout.getText().length(), ForegroundColorSpan.class);
      if (arrayOfForegroundColorSpan != null)
      {
        int k = arrayOfForegroundColorSpan.length;
        int i = 0;
        while (i < k)
        {
          ForegroundColorSpan localForegroundColorSpan = arrayOfForegroundColorSpan[i];
          int m = ((SpannableStringBuilder)localObject).getSpanStart(localForegroundColorSpan);
          int n = ((SpannableStringBuilder)localObject).getSpanEnd(localForegroundColorSpan);
          ((SpannableStringBuilder)localObject).removeSpan(localForegroundColorSpan);
          int j;
          if (m == 0) {
            j = 18;
          } else {
            j = 34;
          }
          ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(paramInt), m, n, j);
          i += 1;
        }
      }
      if ((arrayOfForegroundColorSpan == null) || (arrayOfForegroundColorSpan.length == 0)) {
        ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(paramInt), 0, ((SpannableStringBuilder)localObject).toString().length(), 34);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.text.HippyTextView
 * JD-Core Version:    0.7.0.1
 */