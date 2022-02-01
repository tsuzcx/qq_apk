package com.tencent.mobileqq.emoticonview;

import afrk;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import asiq;
import asir;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class StickerGrayTipLayout
  extends LinearLayout
{
  private boolean autoDismiss;
  private int bubbleLeft;
  private boolean doubleClicked;
  private MotionEvent lastUpEvent;
  MessageRecord message;
  public asir stickerDoubleClickListener;
  private ArrayList<asiq> stickers;
  
  public StickerGrayTipLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public StickerGrayTipLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public StickerGrayTipLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void doAutomaticDismiss()
  {
    boolean bool;
    asiq localasiq;
    if ((this.autoDismiss) && (this.stickers != null) && (this.stickers.size() > 0))
    {
      Iterator localIterator = this.stickers.iterator();
      bool = false;
      if (localIterator.hasNext())
      {
        localasiq = (asiq)localIterator.next();
        if (localasiq.jdField_a_of_type_Int + this.bubbleLeft + localasiq.c / 2 < getMeasuredWidth() / 2) {
          if (Math.abs(localasiq.e) > 200)
          {
            localasiq.e -= EmojiStickerManager.i;
            localasiq.f -= Math.abs(EmojiStickerManager.i / 2);
            localasiq.f = Math.min(255, Math.max(0, localasiq.f));
            label138:
            if (localasiq.e > 0)
            {
              localasiq.e = 0;
              localasiq.f = 255;
              this.autoDismiss = false;
              bool = false;
            }
            label164:
            if (localasiq.e < -400)
            {
              localasiq.e = -400;
              localasiq.f = 0;
              this.autoDismiss = false;
              bool = true;
            }
            if (localasiq.e <= 400) {
              break label434;
            }
            localasiq.e = 400;
            localasiq.f = 0;
            this.autoDismiss = false;
            bool = true;
          }
        }
      }
    }
    label412:
    label434:
    for (;;)
    {
      break;
      localasiq.f += Math.abs(EmojiStickerManager.i / 2);
      localasiq.f = Math.min(255, Math.max(0, localasiq.f));
      localasiq.e += EmojiStickerManager.i;
      break label138;
      if (Math.abs(localasiq.e) < 200)
      {
        localasiq.f += Math.abs(EmojiStickerManager.i / 2);
        localasiq.f = Math.min(255, Math.max(0, localasiq.f));
      }
      for (localasiq.e -= EmojiStickerManager.i;; localasiq.e += EmojiStickerManager.i)
      {
        if (localasiq.e >= 0) {
          break label412;
        }
        localasiq.e = 0;
        localasiq.f = 255;
        this.autoDismiss = false;
        bool = false;
        break;
        localasiq.f -= Math.abs(EmojiStickerManager.i / 2);
        localasiq.f = Math.min(255, Math.max(0, localasiq.f));
      }
      break label164;
      if (this.message != null) {
        this.message.stickerHidden = bool;
      }
      invalidate();
      return;
    }
  }
  
  private boolean isConsideredDoubleTap(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    if (paramMotionEvent2.getEventTime() - paramMotionEvent1.getEventTime() > 200L) {}
    int i;
    int j;
    do
    {
      return false;
      i = (int)paramMotionEvent1.getX() - (int)paramMotionEvent2.getX();
      j = (int)paramMotionEvent1.getY() - (int)paramMotionEvent2.getY();
    } while (i * i + j * j >= 10000);
    return true;
  }
  
  private boolean isTouchedOnStickers(float paramFloat1, float paramFloat2)
  {
    if ((this.stickers != null) && (this.stickers.size() > 0))
    {
      Iterator localIterator = this.stickers.iterator();
      while (localIterator.hasNext())
      {
        asiq localasiq = (asiq)localIterator.next();
        int j = localasiq.jdField_a_of_type_Int;
        int k = this.bubbleLeft;
        int m = (int)((localasiq.jdField_a_of_type_Float - 1.0F) * localasiq.c);
        int i = (int)((localasiq.jdField_a_of_type_Float - 1.0F) * localasiq.d);
        j = j + k + localasiq.e - m / 2;
        i = localasiq.b - i / 2;
        if ((paramFloat1 > j) && (paramFloat1 < j + localasiq.jdField_a_of_type_Float * localasiq.c) && (paramFloat2 > i))
        {
          float f1 = i;
          float f2 = localasiq.jdField_a_of_type_Float;
          if (paramFloat2 < localasiq.d * f2 + f1) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public boolean addSticker(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble, String paramString)
  {
    if (this.stickers == null) {
      this.stickers = new ArrayList();
    }
    if (this.stickers.size() < EmojiStickerManager.f)
    {
      asiq localasiq = new asiq();
      if (paramDrawable != null)
      {
        localasiq.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable.mutate();
        paramDrawable.setCallback(this);
      }
      localasiq.jdField_a_of_type_Int = paramInt1;
      localasiq.b = paramInt2;
      localasiq.c = paramInt3;
      localasiq.d = paramInt4;
      localasiq.jdField_a_of_type_Double = paramDouble;
      localasiq.jdField_a_of_type_JavaLangString = paramString;
      this.stickers.add(localasiq);
      return true;
    }
    return false;
  }
  
  public void adjustStickersVerticalPosition(int paramInt)
  {
    if (this.stickers != null)
    {
      Iterator localIterator = this.stickers.iterator();
      while (localIterator.hasNext())
      {
        asiq localasiq = (asiq)localIterator.next();
        localasiq.b += paramInt;
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    Object localObject = getParent();
    if (((localObject instanceof ViewGroup)) && ((((ViewGroup)localObject).getTag() instanceof afrk))) {
      this.message = ((afrk)((ViewGroup)localObject).getTag()).a;
    }
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      localObject = getChildAt(i);
      if (((View)localObject).getId() == 2131367837) {
        this.bubbleLeft = ((View)localObject).getLeft();
      }
      i -= 1;
    }
    if (this.stickers != null)
    {
      i = 0;
      if (i <= this.stickers.size() - 1)
      {
        localObject = (asiq)this.stickers.get(i);
        if ((this.message != null) && (this.message.stickerHidden)) {
          if (((asiq)localObject).jdField_a_of_type_Int + this.bubbleLeft + ((asiq)localObject).c / 2 >= getMeasuredWidth() / 2) {
            break label307;
          }
        }
        label307:
        for (int j = -400;; j = 400)
        {
          ((asiq)localObject).e = j;
          ((asiq)localObject).f = 0;
          j = paramCanvas.getSaveCount();
          paramCanvas.save();
          paramCanvas.translate(((asiq)localObject).jdField_a_of_type_Int + this.bubbleLeft + ((asiq)localObject).e, ((asiq)localObject).b);
          paramCanvas.rotate((float)((asiq)localObject).jdField_a_of_type_Double, ((asiq)localObject).c / 2, ((asiq)localObject).d / 2);
          ((asiq)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(((asiq)localObject).f);
          ((asiq)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ((asiq)localObject).c, ((asiq)localObject).d);
          ((asiq)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
          paramCanvas.restoreToCount(j);
          i += 1;
          break;
        }
      }
    }
    doAutomaticDismiss();
  }
  
  public void doDismiss(int paramInt1, int paramInt2)
  {
    if ((this.stickers != null) && (this.stickers.size() > 0))
    {
      int i;
      label45:
      asiq localasiq;
      int j;
      if ((this.message != null) && (this.message.stickerHidden))
      {
        i = 1;
        Iterator localIterator = this.stickers.iterator();
        if (!localIterator.hasNext()) {
          break label447;
        }
        localasiq = (asiq)localIterator.next();
        if ((this.message != null) && (i != 0))
        {
          if (localasiq.jdField_a_of_type_Int + this.bubbleLeft + localasiq.c / 2 >= getMeasuredWidth() / 2) {
            break label279;
          }
          j = -400;
          label110:
          localasiq.e = j;
          localasiq.f = 0;
        }
        if ((paramInt2 != EmojiStickerManager.h) || (localasiq.e != 0))
        {
          if (paramInt2 != EmojiStickerManager.g) {
            break label302;
          }
          if (localasiq.jdField_a_of_type_Int + this.bubbleLeft + localasiq.c / 2 >= getMeasuredWidth() / 2) {
            break label287;
          }
          localasiq.e -= paramInt1;
          localasiq.f -= Math.abs(paramInt1 / 2);
          localasiq.f = Math.min(255, Math.max(0, localasiq.f));
        }
      }
      label279:
      label287:
      label302:
      while (paramInt2 != EmojiStickerManager.h) {
        for (;;)
        {
          if (localasiq.e < -400)
          {
            localasiq.e = -400;
            localasiq.f = 0;
          }
          if (localasiq.e <= 400) {
            break label45;
          }
          localasiq.e = 400;
          localasiq.f = 0;
          break label45;
          i = 0;
          break;
          j = 400;
          break label110;
          localasiq.e += paramInt1;
        }
      }
      if (localasiq.jdField_a_of_type_Int + this.bubbleLeft + localasiq.c / 2 < getMeasuredWidth() / 2)
      {
        localasiq.e += paramInt1;
        if (localasiq.e > 0)
        {
          localasiq.e = 0;
          localasiq.f = 255;
        }
      }
      for (;;)
      {
        localasiq.f += Math.abs(paramInt1 / 2);
        localasiq.f = Math.min(255, Math.max(0, localasiq.f));
        break;
        localasiq.e -= paramInt1;
        if (localasiq.e < 0)
        {
          localasiq.e = 0;
          localasiq.f = 255;
        }
      }
      label447:
      if ((i != 0) && (this.message != null)) {
        this.message.stickerHidden = false;
      }
      invalidate();
    }
  }
  
  public int getStickerCount()
  {
    if (this.stickers == null) {
      return 0;
    }
    return this.stickers.size();
  }
  
  public boolean haveStickers()
  {
    return (this.stickers != null) && (this.stickers.size() > 0);
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidate();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (isTouchedOnStickers(paramMotionEvent.getX(), paramMotionEvent.getY())) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.stickers != null) && (this.stickers.size() > 0))
    {
      this.autoDismiss = false;
      paramInt2 = getMeasuredHeight();
      paramInt1 = 0;
      int j = 0;
      while (paramInt1 < this.stickers.size())
      {
        asiq localasiq = (asiq)this.stickers.get(paramInt1);
        localasiq.f = 255;
        localasiq.e = 0;
        int i = paramInt2;
        if (localasiq.b + localasiq.d > paramInt2)
        {
          j = 1;
          i = localasiq.b + localasiq.d;
        }
        paramInt1 += 1;
        paramInt2 = i;
      }
      if (j != 0)
      {
        setMeasuredDimension(getMeasuredWidth(), paramInt2);
        if (QLog.isColorLevel()) {
          QLog.d("StickerGrayTipLayout", 2, "onMeasure bubbleBottm = " + paramInt2);
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (isTouchedOnStickers(paramMotionEvent.getX(), paramMotionEvent.getY()))
    {
      if (paramMotionEvent.getAction() == 0) {
        if ((this.lastUpEvent != null) && (isConsideredDoubleTap(this.lastUpEvent, paramMotionEvent)))
        {
          this.doubleClicked = true;
          if (this.stickerDoubleClickListener != null) {
            this.stickerDoubleClickListener.a(this);
          }
        }
      }
      do
      {
        do
        {
          return true;
        } while (paramMotionEvent.getAction() != 1);
        this.lastUpEvent = MotionEvent.obtain(paramMotionEvent);
      } while (!this.doubleClicked);
      this.doubleClicked = false;
      this.lastUpEvent = null;
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void removeAllStickers()
  {
    if (this.stickers != null)
    {
      this.autoDismiss = false;
      this.stickers.clear();
    }
  }
  
  public void startAutoDismiss()
  {
    this.autoDismiss = true;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.StickerGrayTipLayout
 * JD-Core Version:    0.7.0.1
 */