package me.ele.uetool.view;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import java.util.Iterator;
import java.util.List;
import me.ele.uetool.base.Element;
import me.ele.uetool.dialog.MultipleAttrsDialog;

class EditAttrLayout$MultipleChosenMode
  implements EditAttrLayout.IMode
{
  EditAttrLayout$MultipleChosenMode(EditAttrLayout paramEditAttrLayout) {}
  
  public void onDraw(Canvas paramCanvas)
  {
    Rect localRect = EditAttrLayout.access$300(this.this$0).getRect();
    if (EditAttrLayout.access$700(this.this$0) != null)
    {
      localObject = EditAttrLayout.access$700(this.this$0).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Element localElement = (Element)((Iterator)localObject).next();
        paramCanvas.drawRect(localElement.getRect(), this.this$0.dashLinePaint);
        paramCanvas.drawRect(localElement.getRect(), EditAttrLayout.access$1000(this.this$0));
      }
    }
    this.this$0.drawLineWithText(paramCanvas, localRect.left, localRect.top - EditAttrLayout.access$900(this.this$0), localRect.right, localRect.top - EditAttrLayout.access$900(this.this$0));
    Object localObject = this.this$0;
    int i = localRect.right;
    int j = EditAttrLayout.access$900(this.this$0);
    int k = localRect.top;
    int m = localRect.right;
    ((EditAttrLayout)localObject).drawLineWithText(paramCanvas, j + i, k, EditAttrLayout.access$900(this.this$0) + m, localRect.bottom);
  }
  
  public void triggerActionLong(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = this.this$0.getTargetSimilarElement(EditAttrLayout.access$300(this.this$0), paramMotionEvent.getX(), paramMotionEvent.getY());
    MultipleAttrsDialog localMultipleAttrsDialog = new MultipleAttrsDialog(this.this$0.getContext());
    MultipleAttrsDialog.setRefresh(new EditAttrLayout.MultipleChosenMode.1(this));
    localMultipleAttrsDialog.setCallBack(new EditAttrLayout.MultipleChosenMode.2(this, localMultipleAttrsDialog));
    localMultipleAttrsDialog.show(paramMotionEvent, EditAttrLayout.access$700(this.this$0));
  }
  
  public void triggerActionMove(MotionEvent paramMotionEvent) {}
  
  public void triggerActionUp(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = this.this$0.getTargetSimilarElement(EditAttrLayout.access$300(this.this$0), paramMotionEvent.getX(), paramMotionEvent.getY());
    if (paramMotionEvent != null)
    {
      if (!EditAttrLayout.access$700(this.this$0).contains(paramMotionEvent)) {
        break label65;
      }
      EditAttrLayout.access$700(this.this$0).remove(paramMotionEvent);
    }
    for (;;)
    {
      this.this$0.invalidate();
      return;
      label65:
      EditAttrLayout.access$700(this.this$0).add(paramMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.view.EditAttrLayout.MultipleChosenMode
 * JD-Core Version:    0.7.0.1
 */