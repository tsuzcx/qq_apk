package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.DynamicDrawableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView.BufferType;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder;
import com.tencent.mobileqq.activity.selectable.SelectableComponent;
import com.tencent.mobileqq.activity.selectable.SelectableDelegate;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.VipBubbleDrawable;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.text.style.ISmallEmojiSpan;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

public class AnimationTextView
  extends PatchedTextView
  implements Handler.Callback, SelectableComponent
{
  private static final int MSG_INVALIDATE = 1;
  private static final String TAG = "AnimationTextView";
  public boolean doublleClicked = false;
  private boolean hasStroke;
  private Drawable[] hold;
  private Drawable[] hold2;
  public boolean isSingleClick = true;
  private boolean mBlockRelayout = false;
  private MotionEvent mCurrentDownEvent;
  private final Handler mHandler = new WeakReferenceHandler(ThreadManager.a().getLooper(), this);
  private boolean mHasSelected = false;
  private int mHighlightBackgroundColor = -5250572;
  private Paint mHighlightPaint;
  private Path mHighlightPath;
  private boolean mIsHighlight = false;
  private boolean mIsSelectable = true;
  private MotionEvent mPreviousUpEvent;
  protected SelectableDelegate mSelectDelegate;
  private int mSelectEnd;
  private int mSelectStart;
  private int mStrokeColor;
  private final int[] mTempLocation = new int[2];
  Runnable mTimerForSecondClick = new AnimationTextView.1(this);
  public AnimationTextView.OnDoubleClick onDoubleClick;
  public AnimationTextView.OnSingleClick onSingleClick;
  public float touchL;
  public float touchT;
  
  public AnimationTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AnimationTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AnimationTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void checkDelegateBound()
  {
    if (this.mSelectDelegate != null) {
      return;
    }
    throw new RuntimeException("Select delegate has not bound.");
  }
  
  private void checkHighlightPaintAvailable()
  {
    if (this.mHighlightPaint == null)
    {
      this.mHighlightPaint = new Paint();
      this.mHighlightPaint.setAntiAlias(true);
      this.mHighlightPaint.setStyle(Paint.Style.FILL);
    }
  }
  
  private void checkHighlightPathAvailable()
  {
    if (this.mHighlightPath == null) {
      this.mHighlightPath = new Path();
    }
  }
  
  private void dealSmallEmojiClick()
  {
    float f1 = this.touchL - BaseChatItemLayout.getTextBubblePaddingAlignHead();
    float f2 = this.touchT - TextItemBuilder.y;
    BubbleInfo localBubbleInfo = (BubbleInfo)getTag(2131430083);
    Object localObject = (ChatMessage)getTag(2131430627);
    int i = 0;
    boolean bool;
    if (localObject != null) {
      bool = ((ChatMessage)localObject).isSend();
    } else {
      bool = false;
    }
    if (bool) {
      f1 = this.touchL - BaseChatItemLayout.getTextBubblePaddingAlignError();
    }
    localObject = getText();
    if ((localObject instanceof QQText))
    {
      localObject = (QQText)localObject;
      localObject = (EmoticonSpan[])((QQText)localObject).getSpans(0, ((QQText)localObject).length(), EmoticonSpan.class);
      int k;
      for (int j = 0; i < localObject.length; j = k)
      {
        ISmallEmojiSpan localISmallEmojiSpan = localObject[i];
        k = j;
        if ((localISmallEmojiSpan instanceof ISmallEmojiSpan))
        {
          localISmallEmojiSpan = (ISmallEmojiSpan)localISmallEmojiSpan;
          float f3 = localISmallEmojiSpan.getLeft();
          float f4 = localISmallEmojiSpan.getTop();
          float f5 = localISmallEmojiSpan.getRight();
          float f6 = localISmallEmojiSpan.getBottom();
          k = j;
          if (f1 >= f3)
          {
            k = j;
            if (f1 <= f5)
            {
              k = j;
              if (f2 >= f4)
              {
                k = j;
                if (f2 <= f6)
                {
                  k = j;
                  if (j == 0) {
                    k = 1;
                  }
                }
              }
            }
          }
        }
        i += 1;
      }
      if (j != 0)
      {
        localObject = getBackground();
        if ((localObject != null) && ((localObject instanceof VipBubbleDrawable)))
        {
          ((VipBubbleDrawable)localObject).a = true;
          return;
        }
        if ((localObject != null) && (localBubbleInfo != null))
        {
          localObject = getResources();
          if (bool) {
            i = 2130852126;
          } else {
            i = 2130851944;
          }
          localBubbleInfo.a(this, ((Resources)localObject).getDrawable(i));
        }
      }
    }
  }
  
  private int detectIndexByOffset(int paramInt1, int paramInt2)
  {
    Layout localLayout = getLayout();
    if (localLayout != null)
    {
      int i = localLayout.getOffsetForHorizontal(localLayout.getLineForVertical(paramInt2), paramInt1);
      paramInt2 = i;
      if ((int)localLayout.getPrimaryHorizontal(i) > paramInt1) {
        paramInt2 = localLayout.getOffsetToLeftOf(i);
      }
      return paramInt2;
    }
    return -1;
  }
  
  private int detectIndexByOffsetSpring(int paramInt1, int paramInt2)
  {
    checkDelegateBound();
    int i = this.mSelectDelegate.g();
    if (i == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AnimationTextView", 2, "detectIndexByOffsetSpring backport to detectIndexByOffset");
      }
      return detectIndexByOffset(paramInt1, paramInt2);
    }
    Layout localLayout = getLayout();
    if (localLayout != null)
    {
      if (i == 1) {
        i = this.mSelectDelegate.e();
      } else {
        i = this.mSelectDelegate.f();
      }
      int k = localLayout.getLineForVertical(paramInt2);
      int j = i;
      if (isFirstIndexOnEndLine(i))
      {
        m = i - 1;
        n = (int)localLayout.getPrimaryHorizontal(m);
        i1 = (int)localLayout.getLineRight(k);
        j = i;
        if (paramInt1 > i1 - (i1 - n) / 2) {
          j = m;
        }
      }
      j = localLayout.getLineForOffset(j);
      int m = localLayout.getLineTop(j);
      int n = localLayout.getLineBottom(j);
      int i1 = (n - m) / 2;
      if (k == j + 1)
      {
        i = j;
        if (paramInt2 - n < i1) {}
      }
      else if ((k == j - 1) && (m - paramInt2 < i1))
      {
        i = j;
      }
      else
      {
        i = k;
      }
      j = localLayout.getOffsetForHorizontal(i, paramInt1);
      paramInt2 = j;
      if (j < contentLength() - 1)
      {
        k = j + 1;
        paramInt2 = j;
        if (isFirstIndexOnEndLine(k))
        {
          m = (int)localLayout.getPrimaryHorizontal(j);
          i = (int)localLayout.getLineRight(i);
          paramInt2 = j;
          if (paramInt1 > i - (i - m) / 2) {
            paramInt2 = k;
          }
        }
      }
      return paramInt2;
    }
    return -1;
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
              QLog.e("AnimationTextView", 2, localStringBuilder.toString());
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public static boolean isConsideredDoubleTap(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, MotionEvent paramMotionEvent3)
  {
    long l1 = paramMotionEvent3.getEventTime();
    long l2 = paramMotionEvent2.getEventTime();
    boolean bool = false;
    if (l1 - l2 > 200L) {
      return false;
    }
    int i = (int)paramMotionEvent2.getX() - (int)paramMotionEvent3.getX();
    int j = (int)paramMotionEvent2.getY() - (int)paramMotionEvent3.getY();
    if (i * i + j * j < 10000) {
      bool = true;
    }
    return bool;
  }
  
  private boolean isFirstIndexOnEndLine(int paramInt)
  {
    Layout localLayout = getLayout();
    if (localLayout != null) {
      return (paramInt > 0) && (localLayout.getLineForOffset(paramInt) == localLayout.getLineForOffset(paramInt - 1) + 1);
    }
    throw new RuntimeException("Has no layout.");
  }
  
  public void bind(@Nullable SelectableDelegate paramSelectableDelegate)
  {
    this.mSelectDelegate = paramSelectableDelegate;
  }
  
  public void clearHighlightContent()
  {
    this.mIsHighlight = false;
    invalidate();
  }
  
  @Nullable
  public CharSequence content()
  {
    CharSequence localCharSequence = getText();
    if (localCharSequence != null) {
      return localCharSequence.toString();
    }
    return null;
  }
  
  public int contentLength()
  {
    return getText().length();
  }
  
  @Nullable
  public SelectableDelegate delegate()
  {
    return this.mSelectDelegate;
  }
  
  public void doSelecting(ChatMessage paramChatMessage)
  {
    SelectableDelegate localSelectableDelegate = this.mSelectDelegate;
    if (localSelectableDelegate != null)
    {
      localSelectableDelegate.a(paramChatMessage);
      ReportController.b(null, "dc00898", "", "", "0X800AE7A", "0X800AE7A", 1, 0, "", "", "", "");
      return;
    }
    throw new IllegalStateException("Has no bound delegate!");
  }
  
  public int endIndex()
  {
    return this.mSelectEnd;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return true;
    }
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
          if (localObject2.getDrawable() == paramMessage.obj) {
            invlidateSpan(localObject2);
          }
          i += 1;
        }
        this.mBlockRelayout = false;
      }
    }
    return true;
  }
  
  public void hasSelected(boolean paramBoolean) {}
  
  public boolean hasSelected()
  {
    return this.mHasSelected;
  }
  
  public boolean hasTouchSelectableArea(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public int highlightBackgroundColor()
  {
    return this.mHighlightBackgroundColor;
  }
  
  public void highlightBackgroundColor(@ColorInt int paramInt)
  {
    this.mHighlightBackgroundColor = paramInt;
  }
  
  public void highlightContent()
  {
    if (!hasSelected()) {
      clearHighlightContent();
    }
    Layout localLayout = getLayout();
    if (localLayout == null) {
      return;
    }
    checkHighlightPaintAvailable();
    checkHighlightPathAvailable();
    this.mIsHighlight = true;
    this.mHighlightPath.reset();
    this.mHighlightPaint.setColor(this.mHighlightBackgroundColor);
    localLayout.getSelectionPath(this.mSelectStart, this.mSelectEnd, this.mHighlightPath);
    invalidate();
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    Message localMessage = this.mHandler.obtainMessage(1);
    localMessage.obj = paramDrawable;
    this.mHandler.removeMessages(1);
    this.mHandler.sendMessageDelayed(localMessage, 100L);
  }
  
  public void isSelectable(boolean paramBoolean)
  {
    this.mIsSelectable = paramBoolean;
  }
  
  public boolean isSelectable()
  {
    return this.mIsSelectable;
  }
  
  public void locationByIndex(int paramInt, @NonNull int[] paramArrayOfInt, boolean paramBoolean)
  {
    Layout localLayout = getLayout();
    if (localLayout == null)
    {
      paramArrayOfInt[0] = -1;
      paramArrayOfInt[1] = -1;
      return;
    }
    getLocationInWindow(paramArrayOfInt);
    paramArrayOfInt[0] = (paramArrayOfInt[0] + (int)localLayout.getPrimaryHorizontal(paramInt) + getPaddingLeft());
    paramArrayOfInt[1] = (paramArrayOfInt[1] + localLayout.getLineBottom(localLayout.getLineForOffset(paramInt)) + getPaddingTop());
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mHandler.removeMessages(1);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mIsHighlight)
    {
      paramCanvas.translate(getPaddingLeft(), getPaddingTop());
      paramCanvas.drawPath(this.mHighlightPath, this.mHighlightPaint);
      paramCanvas.translate(-getPaddingLeft(), -getPaddingTop());
    }
    if (this.hasStroke)
    {
      int i = getCurrentTextColor();
      getPaint().setStyle(Paint.Style.STROKE);
      getPaint().setStrokeWidth(3.0F);
      setTextColor(this.mStrokeColor);
      super.onDraw(paramCanvas);
      getPaint().setStyle(Paint.Style.FILL);
      setTextColor(i);
      super.onDraw(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.onDoubleClick != null) {
      if ((this.mPreviousUpEvent != null) && (paramMotionEvent.getAction() == 0))
      {
        this.touchL = paramMotionEvent.getX();
        this.touchT = paramMotionEvent.getY();
        dealSmallEmojiClick();
        this.mCurrentDownEvent = MotionEvent.obtain(paramMotionEvent);
        Object localObject = this.mPreviousUpEvent;
        if (localObject != null)
        {
          MotionEvent localMotionEvent = this.mCurrentDownEvent;
          if ((localMotionEvent != null) && (isConsideredDoubleTap(localMotionEvent, (MotionEvent)localObject, paramMotionEvent)))
          {
            this.isSingleClick = false;
            this.mCurrentDownEvent = null;
            this.mPreviousUpEvent = null;
            localObject = this.onDoubleClick;
            if (localObject != null)
            {
              ((AnimationTextView.OnDoubleClick)localObject).a(this);
              this.doublleClicked = true;
              if (QLog.isColorLevel()) {
                QLog.d("AnimationTextView", 2, "DoubleClick invoked");
              }
              return true;
            }
          }
        }
      }
      else if ((this.mPreviousUpEvent == null) && (paramMotionEvent.getAction() == 0))
      {
        this.isSingleClick = true;
        this.touchL = paramMotionEvent.getX();
        this.touchT = paramMotionEvent.getY();
        dealSmallEmojiClick();
        if (QLog.isColorLevel()) {
          QLog.d("AnimationTextView", 2, "reserve to initial status");
        }
      }
      else if (paramMotionEvent.getAction() == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AnimationTextView", 2, "action up");
        }
        if (getLayout() == null) {
          return super.onTouchEvent(paramMotionEvent);
        }
        this.mPreviousUpEvent = MotionEvent.obtain(paramMotionEvent);
        if (this.doublleClicked)
        {
          this.doublleClicked = false;
          this.mPreviousUpEvent = null;
        }
        postDelayed(this.mTimerForSecondClick, 200L);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void requestLayout()
  {
    if (!this.mBlockRelayout) {
      super.requestLayout();
    }
  }
  
  @Nullable
  public CharSequence selectContent()
  {
    CharSequence localCharSequence = content();
    if (localCharSequence != null) {
      return localCharSequence.subSequence(this.mSelectStart, this.mSelectEnd);
    }
    return null;
  }
  
  public void selectContent(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != -1) && (paramInt2 != -1))
    {
      if (paramInt1 > paramInt2)
      {
        this.mSelectStart = paramInt2;
        this.mSelectEnd = paramInt1;
      }
      else
      {
        this.mSelectStart = paramInt1;
        this.mSelectEnd = paramInt2;
      }
      if (this.mSelectEnd - this.mSelectStart > 0) {
        this.mHasSelected = true;
      }
    }
    else
    {
      this.mSelectStart = -1;
      this.mSelectEnd = -1;
      this.mHasSelected = false;
    }
  }
  
  public void setStrokeColor(boolean paramBoolean, int paramInt)
  {
    this.hasStroke = paramBoolean;
    this.mStrokeColor = paramInt;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    Object localObject = getText();
    super.setText(paramCharSequence, paramBufferType);
    this.hold = null;
    this.hold2 = null;
    if ((localObject != paramCharSequence) && ((getText() instanceof Spanned)))
    {
      paramCharSequence = (Spanned)getText();
      int i = paramCharSequence.length();
      int j = 0;
      paramBufferType = (EmoticonSpan[])paramCharSequence.getSpans(0, i, EmoticonSpan.class);
      localObject = new Drawable[paramBufferType.length];
      i = 0;
      while (i < paramBufferType.length)
      {
        localObject[i] = paramBufferType[i].getDrawable();
        if (localObject[i] != null) {
          localObject[i].setCallback(this);
        }
        i += 1;
      }
      this.hold = ((Drawable[])localObject);
      paramCharSequence = (DynamicDrawableSpan[])paramCharSequence.getSpans(0, paramCharSequence.length(), DynamicDrawableSpan.class);
      paramBufferType = new Drawable[paramCharSequence.length];
      i = j;
      while (i < paramCharSequence.length)
      {
        paramBufferType[i] = paramCharSequence[i].getDrawable();
        if (paramBufferType[i] != null) {
          paramBufferType[i].setCallback(this);
        }
        i += 1;
      }
      this.hold2 = paramBufferType;
    }
  }
  
  public int startIndex()
  {
    return this.mSelectStart;
  }
  
  public int touchIndex(int paramInt1, int paramInt2)
  {
    getLocationInWindow(this.mTempLocation);
    paramInt1 = paramInt1 - this.mTempLocation[0] - getPaddingLeft();
    paramInt2 = paramInt2 - this.mTempLocation[1] - getPaddingTop();
    if (this.mSelectDelegate == null) {
      return detectIndexByOffset(paramInt1, paramInt2);
    }
    return detectIndexByOffsetSpring(paramInt1, paramInt2);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return true;
  }
  
  @Nullable
  public View view()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AnimationTextView
 * JD-Core Version:    0.7.0.1
 */