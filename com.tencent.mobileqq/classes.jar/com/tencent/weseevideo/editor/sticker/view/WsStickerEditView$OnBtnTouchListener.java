package com.tencent.weseevideo.editor.sticker.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.model.TAVStickerTextItem;
import com.tencent.weseevideo.editor.sticker.StickerDrawingOperationMask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class WsStickerEditView$OnBtnTouchListener
  implements View.OnTouchListener
{
  private Point downPoint = new Point();
  private boolean isClickAdjustTime = false;
  private boolean isClickDelete = false;
  private boolean isClickEdit = false;
  
  private WsStickerEditView$OnBtnTouchListener(WsStickerEditView paramWsStickerEditView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((!this.this$0.getSticker().isEditable()) || (!this.this$0.isStickerSelected)) {}
    do
    {
      do
      {
        int i;
        int j;
        do
        {
          do
          {
            return false;
            i = (int)paramMotionEvent.getX();
            j = (int)paramMotionEvent.getY();
          } while ((WsStickerEditView.access$400(this.this$0)) || (TAVStickerMode.ACTIVE != this.this$0.getMode()));
          switch (paramMotionEvent.getAction())
          {
          default: 
            return false;
          case 0: 
            this.isClickAdjustTime = false;
            this.isClickDelete = false;
            this.downPoint.set(i, j);
            if ((WsStickerEditView.access$500(this.this$0, i, j)) && (StickerDrawingOperationMask.isDrawLeftBottom(WsStickerEditView.access$600(this.this$0))))
            {
              this.isClickAdjustTime = true;
              return true;
            }
            if ((WsStickerEditView.access$700(this.this$0, i, j)) && (StickerDrawingOperationMask.isDrawLeftTop(WsStickerEditView.access$600(this.this$0))))
            {
              this.isClickDelete = true;
              return true;
            }
            break;
          }
        } while ((!WsStickerEditView.access$800(this.this$0, paramMotionEvent.getX(), paramMotionEvent.getY())) || (!StickerDrawingOperationMask.isDrawRightTop(WsStickerEditView.access$600(this.this$0))));
        this.isClickEdit = true;
        return true;
        if ((Math.abs(i - this.downPoint.x) > this.this$0.TOUCH_SLOP) || (Math.abs(j - this.downPoint.y) > this.this$0.TOUCH_SLOP))
        {
          this.isClickAdjustTime = false;
          this.isClickDelete = false;
          this.isClickEdit = false;
          return false;
        }
        return true;
      } while (Math.abs(paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime()) >= this.this$0.CLICK_DURATION);
      if (this.isClickAdjustTime)
      {
        if (WsStickerEditView.access$200(this.this$0) != null) {
          WsStickerEditView.access$200(this.this$0).onAdjustTimeClick(this.this$0.getSticker());
        }
        return true;
      }
      if (this.isClickDelete)
      {
        if (WsStickerEditView.access$200(this.this$0) != null) {
          WsStickerEditView.access$200(this.this$0).onDeleteClick(this.this$0.getSticker());
        }
        return true;
      }
    } while (!this.isClickEdit);
    paramView = new ArrayList();
    if (this.this$0.getSticker().getStickerTextItems() != null)
    {
      paramMotionEvent = this.this$0.getSticker().getStickerTextItems().iterator();
      while (paramMotionEvent.hasNext())
      {
        TAVStickerTextItem localTAVStickerTextItem = (TAVStickerTextItem)paramMotionEvent.next();
        if (localTAVStickerTextItem.getLayerType() == 3) {
          paramView.add(localTAVStickerTextItem);
        }
      }
    }
    if (WsStickerEditView.access$200(this.this$0) != null) {
      WsStickerEditView.access$200(this.this$0).onEditClick(this.this$0.getSticker(), paramView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.view.WsStickerEditView.OnBtnTouchListener
 * JD-Core Version:    0.7.0.1
 */