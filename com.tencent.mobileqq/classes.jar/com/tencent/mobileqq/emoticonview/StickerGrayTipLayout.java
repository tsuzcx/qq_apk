package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.Sticker;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerDoubleClickListener;
import com.tencent.mobileqq.vas.config.business.qvip.QVipStickerProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class StickerGrayTipLayout
  extends LinearLayout
{
  private boolean autoDismiss = false;
  private int bubbleLeft = 0;
  private boolean doubleClicked = false;
  private MotionEvent lastUpEvent;
  MessageRecord message;
  public EmojiStickerManager.StickerDoubleClickListener stickerDoubleClickListener;
  private ArrayList<EmojiStickerManager.Sticker> stickers;
  
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
    if (this.autoDismiss)
    {
      Object localObject = this.stickers;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = this.stickers.iterator();
        boolean bool = false;
        while (((Iterator)localObject).hasNext())
        {
          EmojiStickerManager.Sticker localSticker = (EmojiStickerManager.Sticker)((Iterator)localObject).next();
          if (localSticker.jdField_a_of_type_Int + this.bubbleLeft + localSticker.c / 2 < getMeasuredWidth() / 2)
          {
            if (Math.abs(localSticker.e) > 200)
            {
              localSticker.e -= EmojiStickerManager.f;
              localSticker.f -= Math.abs(EmojiStickerManager.f / 2);
              localSticker.f = Math.min(255, Math.max(0, localSticker.f));
            }
            else
            {
              localSticker.f += Math.abs(EmojiStickerManager.f / 2);
              localSticker.f = Math.min(255, Math.max(0, localSticker.f));
              localSticker.e += EmojiStickerManager.f;
            }
            if (localSticker.e <= 0) {
              break label350;
            }
            localSticker.e = 0;
            localSticker.f = 255;
            this.autoDismiss = false;
          }
          else
          {
            if (Math.abs(localSticker.e) < 200)
            {
              localSticker.f += Math.abs(EmojiStickerManager.f / 2);
              localSticker.f = Math.min(255, Math.max(0, localSticker.f));
              localSticker.e -= EmojiStickerManager.f;
            }
            else
            {
              localSticker.f -= Math.abs(EmojiStickerManager.f / 2);
              localSticker.f = Math.min(255, Math.max(0, localSticker.f));
              localSticker.e += EmojiStickerManager.f;
            }
            if (localSticker.e >= 0) {
              break label350;
            }
            localSticker.e = 0;
            localSticker.f = 255;
            this.autoDismiss = false;
          }
          bool = false;
          label350:
          if (localSticker.e < -400)
          {
            localSticker.e = -400;
            localSticker.f = 0;
            this.autoDismiss = false;
            bool = true;
          }
          if (localSticker.e > 400)
          {
            localSticker.e = 400;
            localSticker.f = 0;
            this.autoDismiss = false;
            bool = true;
          }
        }
        localObject = this.message;
        if (localObject != null) {
          ((MessageRecord)localObject).stickerHidden = bool;
        }
        invalidate();
      }
    }
  }
  
  private boolean isConsideredDoubleTap(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    long l1 = paramMotionEvent2.getEventTime();
    long l2 = paramMotionEvent1.getEventTime();
    boolean bool = false;
    if (l1 - l2 > 200L) {
      return false;
    }
    int i = (int)paramMotionEvent1.getX() - (int)paramMotionEvent2.getX();
    int j = (int)paramMotionEvent1.getY() - (int)paramMotionEvent2.getY();
    if (i * i + j * j < 10000) {
      bool = true;
    }
    return bool;
  }
  
  private boolean isTouchedOnStickers(float paramFloat1, float paramFloat2)
  {
    Object localObject = this.stickers;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = this.stickers.iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmojiStickerManager.Sticker localSticker = (EmojiStickerManager.Sticker)((Iterator)localObject).next();
        int i = localSticker.jdField_a_of_type_Int;
        int j = this.bubbleLeft;
        int n = (int)((localSticker.jdField_a_of_type_Float - 1.0F) * localSticker.c);
        int m = (int)((localSticker.jdField_a_of_type_Float - 1.0F) * localSticker.d);
        int k = localSticker.e;
        n /= 2;
        int i1 = localSticker.b;
        m /= 2;
        float f = i + j + k - n;
        if ((paramFloat1 > f) && (paramFloat1 < f + localSticker.jdField_a_of_type_Float * localSticker.c))
        {
          f = i1 - m;
          if ((paramFloat2 > f) && (paramFloat2 < f + localSticker.jdField_a_of_type_Float * localSticker.d)) {
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
    if (this.stickers.size() < QVipStickerProcessor.c)
    {
      EmojiStickerManager.Sticker localSticker = new EmojiStickerManager.Sticker();
      if (paramDrawable != null)
      {
        localSticker.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable.mutate();
        paramDrawable.setCallback(this);
      }
      localSticker.jdField_a_of_type_Int = paramInt1;
      localSticker.b = paramInt2;
      localSticker.c = paramInt3;
      localSticker.d = paramInt4;
      localSticker.jdField_a_of_type_Double = paramDouble;
      localSticker.jdField_a_of_type_JavaLangString = paramString;
      this.stickers.add(localSticker);
      return true;
    }
    return false;
  }
  
  public void adjustStickersVerticalPosition(int paramInt)
  {
    Object localObject = this.stickers;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmojiStickerManager.Sticker localSticker = (EmojiStickerManager.Sticker)((Iterator)localObject).next();
        localSticker.b += paramInt;
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    Object localObject = getParent();
    if ((localObject instanceof ViewGroup))
    {
      localObject = (ViewGroup)localObject;
      if ((((ViewGroup)localObject).getTag() instanceof ChatItemBuilder.BaseHolder)) {
        this.message = ((ChatItemBuilder.BaseHolder)((ViewGroup)localObject).getTag()).a;
      }
    }
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      localObject = getChildAt(i);
      if (((View)localObject).getId() == 2131367798) {
        this.bubbleLeft = ((View)localObject).getLeft();
      }
      i -= 1;
    }
    if (this.stickers != null)
    {
      i = 0;
      while (i <= this.stickers.size() - 1)
      {
        localObject = (EmojiStickerManager.Sticker)this.stickers.get(i);
        MessageRecord localMessageRecord = this.message;
        if ((localMessageRecord != null) && (localMessageRecord.stickerHidden))
        {
          if (((EmojiStickerManager.Sticker)localObject).jdField_a_of_type_Int + this.bubbleLeft + ((EmojiStickerManager.Sticker)localObject).c / 2 < getMeasuredWidth() / 2) {
            j = -400;
          } else {
            j = 400;
          }
          ((EmojiStickerManager.Sticker)localObject).e = j;
          ((EmojiStickerManager.Sticker)localObject).f = 0;
        }
        int j = paramCanvas.getSaveCount();
        paramCanvas.save();
        paramCanvas.translate(((EmojiStickerManager.Sticker)localObject).jdField_a_of_type_Int + this.bubbleLeft + ((EmojiStickerManager.Sticker)localObject).e, ((EmojiStickerManager.Sticker)localObject).b);
        paramCanvas.rotate((float)((EmojiStickerManager.Sticker)localObject).jdField_a_of_type_Double, ((EmojiStickerManager.Sticker)localObject).c / 2, ((EmojiStickerManager.Sticker)localObject).d / 2);
        ((EmojiStickerManager.Sticker)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(((EmojiStickerManager.Sticker)localObject).f);
        ((EmojiStickerManager.Sticker)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, ((EmojiStickerManager.Sticker)localObject).c, ((EmojiStickerManager.Sticker)localObject).d);
        ((EmojiStickerManager.Sticker)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        paramCanvas.restoreToCount(j);
        i += 1;
      }
    }
    doAutomaticDismiss();
  }
  
  public void doDismiss(int paramInt1, int paramInt2)
  {
    Object localObject = this.stickers;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = this.message;
      int i;
      if ((localObject != null) && (((MessageRecord)localObject).stickerHidden)) {
        i = 1;
      } else {
        i = 0;
      }
      localObject = this.stickers.iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmojiStickerManager.Sticker localSticker = (EmojiStickerManager.Sticker)((Iterator)localObject).next();
        if ((this.message != null) && (i != 0))
        {
          int j;
          if (localSticker.jdField_a_of_type_Int + this.bubbleLeft + localSticker.c / 2 < getMeasuredWidth() / 2) {
            j = -400;
          } else {
            j = 400;
          }
          localSticker.e = j;
          localSticker.f = 0;
        }
        if ((paramInt2 != EmojiStickerManager.e) || (localSticker.e != 0)) {
          if (paramInt2 == EmojiStickerManager.d)
          {
            if (localSticker.jdField_a_of_type_Int + this.bubbleLeft + localSticker.c / 2 < getMeasuredWidth() / 2) {
              localSticker.e -= paramInt1;
            } else {
              localSticker.e += paramInt1;
            }
            localSticker.f -= Math.abs(paramInt1 / 2);
            localSticker.f = Math.min(255, Math.max(0, localSticker.f));
          }
          else if (paramInt2 == EmojiStickerManager.e)
          {
            if (localSticker.jdField_a_of_type_Int + this.bubbleLeft + localSticker.c / 2 < getMeasuredWidth() / 2)
            {
              localSticker.e += paramInt1;
              if (localSticker.e > 0)
              {
                localSticker.e = 0;
                localSticker.f = 255;
              }
            }
            else
            {
              localSticker.e -= paramInt1;
              if (localSticker.e < 0)
              {
                localSticker.e = 0;
                localSticker.f = 255;
              }
            }
            localSticker.f += Math.abs(paramInt1 / 2);
            localSticker.f = Math.min(255, Math.max(0, localSticker.f));
          }
        }
        if (localSticker.e < -400)
        {
          localSticker.e = -400;
          localSticker.f = 0;
        }
        if (localSticker.e > 400)
        {
          localSticker.e = 400;
          localSticker.f = 0;
        }
      }
      if (i != 0)
      {
        localObject = this.message;
        if (localObject != null) {
          ((MessageRecord)localObject).stickerHidden = false;
        }
      }
      invalidate();
    }
  }
  
  public int getStickerCount()
  {
    ArrayList localArrayList = this.stickers;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public boolean haveStickers()
  {
    ArrayList localArrayList = this.stickers;
    return (localArrayList != null) && (localArrayList.size() > 0);
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
    Object localObject = this.stickers;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      this.autoDismiss = false;
      paramInt2 = getMeasuredHeight();
      paramInt1 = 0;
      int j = 0;
      while (paramInt1 < this.stickers.size())
      {
        localObject = (EmojiStickerManager.Sticker)this.stickers.get(paramInt1);
        ((EmojiStickerManager.Sticker)localObject).f = 255;
        ((EmojiStickerManager.Sticker)localObject).e = 0;
        int i = paramInt2;
        if (((EmojiStickerManager.Sticker)localObject).b + ((EmojiStickerManager.Sticker)localObject).d > paramInt2)
        {
          i = ((EmojiStickerManager.Sticker)localObject).b + ((EmojiStickerManager.Sticker)localObject).d;
          j = 1;
        }
        paramInt1 += 1;
        paramInt2 = i;
      }
      if (j != 0)
      {
        setMeasuredDimension(getMeasuredWidth(), paramInt2);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onMeasure bubbleBottm = ");
          ((StringBuilder)localObject).append(paramInt2);
          QLog.d("StickerGrayTipLayout", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (isTouchedOnStickers(paramMotionEvent.getX(), paramMotionEvent.getY()))
    {
      if (paramMotionEvent.getAction() == 0)
      {
        MotionEvent localMotionEvent = this.lastUpEvent;
        if ((localMotionEvent != null) && (isConsideredDoubleTap(localMotionEvent, paramMotionEvent)))
        {
          this.doubleClicked = true;
          paramMotionEvent = this.stickerDoubleClickListener;
          if (paramMotionEvent != null)
          {
            paramMotionEvent.a(this);
            return true;
          }
        }
      }
      else if (paramMotionEvent.getAction() == 1)
      {
        this.lastUpEvent = MotionEvent.obtain(paramMotionEvent);
        if (this.doubleClicked)
        {
          this.doubleClicked = false;
          this.lastUpEvent = null;
        }
      }
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void removeAllStickers()
  {
    ArrayList localArrayList = this.stickers;
    if (localArrayList != null)
    {
      this.autoDismiss = false;
      localArrayList.clear();
    }
  }
  
  public void startAutoDismiss()
  {
    this.autoDismiss = true;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.StickerGrayTipLayout
 * JD-Core Version:    0.7.0.1
 */