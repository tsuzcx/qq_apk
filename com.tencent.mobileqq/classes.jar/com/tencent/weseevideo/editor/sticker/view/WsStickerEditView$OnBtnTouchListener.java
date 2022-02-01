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
    if (this.this$0.getSticker().isEditable())
    {
      if (!this.this$0.isStickerSelected) {
        return false;
      }
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if (TAVStickerMode.ACTIVE == this.this$0.getMode())
      {
        int k = paramMotionEvent.getAction();
        if (k != 0)
        {
          if (k != 1)
          {
            if (k != 2) {
              return false;
            }
            if ((Math.abs(i - this.downPoint.x) <= this.this$0.TOUCH_SLOP) && (Math.abs(j - this.downPoint.y) <= this.this$0.TOUCH_SLOP)) {
              return true;
            }
            this.isClickAdjustTime = false;
            this.isClickDelete = false;
            this.isClickEdit = false;
            return false;
          }
          if (Math.abs(paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime()) < this.this$0.CLICK_DURATION)
          {
            if (this.isClickAdjustTime)
            {
              if (this.this$0.stickerEditButtonClickListener != null) {
                this.this$0.stickerEditButtonClickListener.onAdjustTimeClick(this.this$0.getSticker());
              }
              return true;
            }
            if (this.isClickDelete)
            {
              if (this.this$0.stickerEditButtonClickListener != null) {
                this.this$0.stickerEditButtonClickListener.onDeleteClick(this.this$0.getSticker());
              }
              return true;
            }
            if (this.isClickEdit)
            {
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
              if (this.this$0.stickerEditButtonClickListener != null) {
                this.this$0.stickerEditButtonClickListener.onEditClick(this.this$0.getSticker(), paramView);
              }
              return true;
            }
          }
        }
        else
        {
          this.isClickAdjustTime = false;
          this.isClickDelete = false;
          this.downPoint.set(i, j);
          if ((WsStickerEditView.access$300(this.this$0, i, j)) && (StickerDrawingOperationMask.isDrawLeftBottom(this.this$0.drawMask)))
          {
            this.isClickAdjustTime = true;
            return true;
          }
          if ((this.this$0.isTouchDeleteBtn(i, j)) && (StickerDrawingOperationMask.isDrawLeftTop(this.this$0.drawMask)))
          {
            this.isClickDelete = true;
            return true;
          }
          if ((WsStickerEditView.access$400(this.this$0, paramMotionEvent.getX(), paramMotionEvent.getY())) && (StickerDrawingOperationMask.isDrawRightTop(this.this$0.drawMask)))
          {
            this.isClickEdit = true;
            return true;
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.view.WsStickerEditView.OnBtnTouchListener
 * JD-Core Version:    0.7.0.1
 */