package com.tencent.tavsticker.core;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.utils.TAVStickerUtil;

class TAVStickerContext$1
  implements TAVStickerContentView.DispatchTouchEventListener
{
  TAVStickerContext$1(TAVStickerContext paramTAVStickerContext) {}
  
  public boolean onDispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    Object localObject;
    if (TAVStickerContext.access$000(this.this$0))
    {
      bool2 = bool3;
      if (paramMotionEvent != null)
      {
        localObject = this.this$0.getCurrentStickerEditView();
        if (localObject != null)
        {
          bool2 = ((TAVStickerEditView)localObject).handleTouchEvent((View)localObject, paramMotionEvent);
          bool1 = bool2;
          if (bool2) {
            bool1 = true;
          }
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool2 = bool1;
          if (paramMotionEvent.getAction() == 0)
          {
            float f2 = paramMotionEvent.getX();
            float f3 = paramMotionEvent.getY();
            float f1 = f2;
            if (TAVStickerContext.access$100(this.this$0) != this.this$0.mRenderSize.width) {
              f1 = TAVStickerUtil.covertCoordinate(f2, TAVStickerContext.access$100(this.this$0), (int)this.this$0.mRenderSize.width);
            }
            f2 = f3;
            if (TAVStickerContext.access$200(this.this$0) != this.this$0.mRenderSize.height) {
              f2 = TAVStickerUtil.covertCoordinate(f3, TAVStickerContext.access$200(this.this$0), (int)this.this$0.mRenderSize.height);
            }
            localObject = this.this$0.getTouchedSticker(f1, f2);
            bool2 = bool1;
            if (localObject != null)
            {
              bool2 = bool1;
              if (localObject != TAVStickerContext.access$300(this.this$0))
              {
                TLog.d(TAVStickerContext.access$400(), "onTouch -> 当前选中贴纸, " + localObject);
                this.this$0.activeSticker((TAVSticker)localObject);
                bool2 = bool1;
              }
            }
          }
          localObject = this.this$0.getCurrentStickerEditView();
          if (localObject != null) {
            bool2 = ((TAVStickerEditView)localObject).handleTouchEvent((View)localObject, paramMotionEvent);
          }
          bool1 = bool2;
        } while (bool2);
        TLog.d(TAVStickerContext.access$400(), "onTouch -> onTouchStickerOutside, touchable : false");
        bool1 = bool2;
      } while (TAVStickerContext.access$500(this.this$0) == null);
      TAVStickerContext.access$500(this.this$0).onTouchStickerOutside(paramMotionEvent);
      return bool2;
      bool1 = bool2;
    } while (TAVStickerContext.access$500(this.this$0) == null);
    TLog.d(TAVStickerContext.access$400(), "onTouch -> onTouchStickerOutside, touchable : false");
    TAVStickerContext.access$500(this.this$0).onTouchStickerOutside(paramMotionEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerContext.1
 * JD-Core Version:    0.7.0.1
 */