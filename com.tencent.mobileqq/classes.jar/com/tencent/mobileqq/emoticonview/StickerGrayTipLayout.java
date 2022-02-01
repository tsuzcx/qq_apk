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
          if (localSticker.b + this.bubbleLeft + localSticker.d / 2 < getMeasuredWidth() / 2)
          {
            if (Math.abs(localSticker.g) > 200)
            {
              localSticker.g -= EmojiStickerManager.r;
              localSticker.h -= Math.abs(EmojiStickerManager.r / 2);
              localSticker.h = Math.min(255, Math.max(0, localSticker.h));
            }
            else
            {
              localSticker.h += Math.abs(EmojiStickerManager.r / 2);
              localSticker.h = Math.min(255, Math.max(0, localSticker.h));
              localSticker.g += EmojiStickerManager.r;
            }
            if (localSticker.g <= 0) {
              break label350;
            }
            localSticker.g = 0;
            localSticker.h = 255;
            this.autoDismiss = false;
          }
          else
          {
            if (Math.abs(localSticker.g) < 200)
            {
              localSticker.h += Math.abs(EmojiStickerManager.r / 2);
              localSticker.h = Math.min(255, Math.max(0, localSticker.h));
              localSticker.g -= EmojiStickerManager.r;
            }
            else
            {
              localSticker.h -= Math.abs(EmojiStickerManager.r / 2);
              localSticker.h = Math.min(255, Math.max(0, localSticker.h));
              localSticker.g += EmojiStickerManager.r;
            }
            if (localSticker.g >= 0) {
              break label350;
            }
            localSticker.g = 0;
            localSticker.h = 255;
            this.autoDismiss = false;
          }
          bool = false;
          label350:
          if (localSticker.g < -400)
          {
            localSticker.g = -400;
            localSticker.h = 0;
            this.autoDismiss = false;
            bool = true;
          }
          if (localSticker.g > 400)
          {
            localSticker.g = 400;
            localSticker.h = 0;
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
        int i = localSticker.b;
        int j = this.bubbleLeft;
        int n = (int)((localSticker.n - 1.0F) * localSticker.d);
        int m = (int)((localSticker.n - 1.0F) * localSticker.e);
        int k = localSticker.g;
        n /= 2;
        int i1 = localSticker.c;
        m /= 2;
        float f = i + j + k - n;
        if ((paramFloat1 > f) && (paramFloat1 < f + localSticker.n * localSticker.d))
        {
          f = i1 - m;
          if ((paramFloat2 > f) && (paramFloat2 < f + localSticker.n * localSticker.e)) {
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
        localSticker.a = paramDrawable.mutate();
        paramDrawable.setCallback(this);
      }
      localSticker.b = paramInt1;
      localSticker.c = paramInt2;
      localSticker.d = paramInt3;
      localSticker.e = paramInt4;
      localSticker.f = paramDouble;
      localSticker.i = paramString;
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
        localSticker.c += paramInt;
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
        this.message = ((ChatItemBuilder.BaseHolder)((ViewGroup)localObject).getTag()).q;
      }
    }
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      localObject = getChildAt(i);
      if (((View)localObject).getId() == 2131434371) {
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
          if (((EmojiStickerManager.Sticker)localObject).b + this.bubbleLeft + ((EmojiStickerManager.Sticker)localObject).d / 2 < getMeasuredWidth() / 2) {
            j = -400;
          } else {
            j = 400;
          }
          ((EmojiStickerManager.Sticker)localObject).g = j;
          ((EmojiStickerManager.Sticker)localObject).h = 0;
        }
        int j = paramCanvas.getSaveCount();
        paramCanvas.save();
        paramCanvas.translate(((EmojiStickerManager.Sticker)localObject).b + this.bubbleLeft + ((EmojiStickerManager.Sticker)localObject).g, ((EmojiStickerManager.Sticker)localObject).c);
        paramCanvas.rotate((float)((EmojiStickerManager.Sticker)localObject).f, ((EmojiStickerManager.Sticker)localObject).d / 2, ((EmojiStickerManager.Sticker)localObject).e / 2);
        ((EmojiStickerManager.Sticker)localObject).a.setAlpha(((EmojiStickerManager.Sticker)localObject).h);
        ((EmojiStickerManager.Sticker)localObject).a.setBounds(0, 0, ((EmojiStickerManager.Sticker)localObject).d, ((EmojiStickerManager.Sticker)localObject).e);
        ((EmojiStickerManager.Sticker)localObject).a.draw(paramCanvas);
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
          if (localSticker.b + this.bubbleLeft + localSticker.d / 2 < getMeasuredWidth() / 2) {
            j = -400;
          } else {
            j = 400;
          }
          localSticker.g = j;
          localSticker.h = 0;
        }
        if ((paramInt2 != EmojiStickerManager.q) || (localSticker.g != 0)) {
          if (paramInt2 == EmojiStickerManager.p)
          {
            if (localSticker.b + this.bubbleLeft + localSticker.d / 2 < getMeasuredWidth() / 2) {
              localSticker.g -= paramInt1;
            } else {
              localSticker.g += paramInt1;
            }
            localSticker.h -= Math.abs(paramInt1 / 2);
            localSticker.h = Math.min(255, Math.max(0, localSticker.h));
          }
          else if (paramInt2 == EmojiStickerManager.q)
          {
            if (localSticker.b + this.bubbleLeft + localSticker.d / 2 < getMeasuredWidth() / 2)
            {
              localSticker.g += paramInt1;
              if (localSticker.g > 0)
              {
                localSticker.g = 0;
                localSticker.h = 255;
              }
            }
            else
            {
              localSticker.g -= paramInt1;
              if (localSticker.g < 0)
              {
                localSticker.g = 0;
                localSticker.h = 255;
              }
            }
            localSticker.h += Math.abs(paramInt1 / 2);
            localSticker.h = Math.min(255, Math.max(0, localSticker.h));
          }
        }
        if (localSticker.g < -400)
        {
          localSticker.g = -400;
          localSticker.h = 0;
        }
        if (localSticker.g > 400)
        {
          localSticker.g = 400;
          localSticker.h = 0;
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
        ((EmojiStickerManager.Sticker)localObject).h = 255;
        ((EmojiStickerManager.Sticker)localObject).g = 0;
        int i = paramInt2;
        if (((EmojiStickerManager.Sticker)localObject).c + ((EmojiStickerManager.Sticker)localObject).e > paramInt2)
        {
          i = ((EmojiStickerManager.Sticker)localObject).c + ((EmojiStickerManager.Sticker)localObject).e;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.StickerGrayTipLayout
 * JD-Core Version:    0.7.0.1
 */