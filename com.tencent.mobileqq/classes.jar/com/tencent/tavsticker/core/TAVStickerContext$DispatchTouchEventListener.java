package com.tencent.tavsticker.core;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.utils.TAVStickerUtil;

public class TAVStickerContext$DispatchTouchEventListener
  implements TAVStickerContentView.DispatchTouchEventListener
{
  boolean a = false;
  int b = -1;
  TAVStickerContext.InterceptTouchDelegate c;
  
  public TAVStickerContext$DispatchTouchEventListener(TAVStickerContext paramTAVStickerContext) {}
  
  public void a()
  {
    this.b = 1;
  }
  
  public void a(TAVStickerContext.InterceptTouchDelegate paramInterceptTouchDelegate)
  {
    this.c = paramInterceptTouchDelegate;
  }
  
  public boolean onDispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = TAVStickerContext.access$000(this.d);
    boolean bool2 = false;
    if ((bool1) && (!this.a))
    {
      if (paramMotionEvent != null)
      {
        int i = paramMotionEvent.getAction();
        Object localObject2 = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
        Object localObject1 = TAVStickerContext.access$100(this.d, (PointF)localObject2);
        if ((1 == i) && (TAVStickerContext.access$200(this.d, paramMotionEvent)))
        {
          if (localObject1 != null)
          {
            if (localObject1 != TAVStickerContext.access$300(this.d))
            {
              localObject2 = TAVStickerContext.access$400();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("onTouch -> 当前选中贴纸, ");
              localStringBuilder.append(localObject1);
              TLog.d((String)localObject2, localStringBuilder.toString());
              this.d.activeSticker((TAVSticker)localObject1);
              localObject2 = this.d.getCurrentStickerEditView();
              if (localObject2 != null) {
                ((TAVStickerEditView)localObject2).stickerEventListener.onStickerClick((TAVSticker)localObject1, paramMotionEvent);
              }
              this.b = 1;
              return false;
            }
            localObject1 = this.d.getCurrentStickerEditView();
            if (localObject1 != null)
            {
              ((TAVStickerEditView)localObject1).handleTouchEvent((View)localObject1, paramMotionEvent);
              return false;
            }
          }
          else
          {
            if (TAVStickerContext.access$500(this.d) != null)
            {
              TLog.d(TAVStickerContext.access$400(), "onTouch -> onTouchStickerOutside, touchable : false");
              TAVStickerContext.access$500(this.d).onTouchStickerOutside(paramMotionEvent);
              this.b = -1;
            }
            paramMotionEvent = this.c;
            if (paramMotionEvent != null)
            {
              if ((paramMotionEvent.shouldInterceptTouch()) && (this.c.checkInterceptArea((PointF)localObject2)))
              {
                this.b = 2;
                this.a = true;
                this.c.touchInterceptArea((PointF)localObject2);
              }
              return false;
            }
          }
        }
        else
        {
          localObject2 = this.d.getCurrentStickerEditView();
          if (localObject2 != null) {
            bool1 = ((TAVStickerEditView)localObject2).handleTouchEvent((View)localObject2, paramMotionEvent);
          } else {
            bool1 = false;
          }
          if (i == 0)
          {
            if (this.b == 1) {
              return true;
            }
            bool1 = bool2;
            if (localObject1 != null) {
              bool1 = true;
            }
            return bool1;
          }
          return bool1;
        }
      }
    }
    else if (TAVStickerContext.access$500(this.d) != null)
    {
      TLog.d(TAVStickerContext.access$400(), "onTouch -> onTouchStickerOutside, touchable : false");
      TAVStickerContext.access$500(this.d).onTouchStickerOutside(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onHackedTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = TAVStickerContext.access$000(this.d);
    boolean bool1 = false;
    if (bool2)
    {
      if ((paramMotionEvent != null) && (paramMotionEvent.getAction() == 0))
      {
        float f2 = paramMotionEvent.getX();
        float f3 = paramMotionEvent.getY();
        float f1 = f2;
        if (TAVStickerContext.access$600(this.d) != this.d.renderSize.width) {
          f1 = TAVStickerUtil.covertCoordinate(f2, TAVStickerContext.access$600(this.d), (int)this.d.renderSize.width);
        }
        f2 = f3;
        if (TAVStickerContext.access$700(this.d) != this.d.renderSize.height) {
          f2 = TAVStickerUtil.covertCoordinate(f3, TAVStickerContext.access$700(this.d), (int)this.d.renderSize.height);
        }
        localObject1 = this.d.getTouchedSticker(f1, f2);
        if ((localObject1 != null) && (localObject1 != TAVStickerContext.access$300(this.d)))
        {
          Object localObject2 = TAVStickerContext.access$400();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onTouch -> 当前选中贴纸, ");
          localStringBuilder.append(localObject1);
          TLog.d((String)localObject2, localStringBuilder.toString());
          this.d.activeSticker((TAVSticker)localObject1);
          localObject2 = this.d.getCurrentStickerEditView();
          if (localObject2 != null) {
            ((TAVStickerEditView)localObject2).stickerEventListener.onStickerClick((TAVSticker)localObject1, paramMotionEvent);
          }
          this.b = 1;
        }
      }
      Object localObject1 = this.d.getCurrentStickerEditView();
      if (localObject1 != null) {
        bool1 = ((TAVStickerEditView)localObject1).handleTouchEvent((View)localObject1, paramMotionEvent);
      }
      if (!bool1)
      {
        TLog.d(TAVStickerContext.access$400(), "onTouch -> onTouchStickerOutside, touchable : false");
        if (TAVStickerContext.access$500(this.d) != null) {
          TAVStickerContext.access$500(this.d).onTouchStickerOutside(paramMotionEvent);
        }
      }
      return bool1;
    }
    if (TAVStickerContext.access$500(this.d) != null)
    {
      TLog.d(TAVStickerContext.access$400(), "onTouch -> onTouchStickerOutside, touchable : false");
      TAVStickerContext.access$500(this.d).onTouchStickerOutside(paramMotionEvent);
    }
    return false;
  }
  
  public void setInterceptEvent(Boolean paramBoolean)
  {
    this.a = paramBoolean.booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerContext.DispatchTouchEventListener
 * JD-Core Version:    0.7.0.1
 */