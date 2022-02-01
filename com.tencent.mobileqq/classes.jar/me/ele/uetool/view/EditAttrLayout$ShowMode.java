package me.ele.uetool.view;

import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.text.TextPaint;
import android.view.MotionEvent;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;
import me.ele.uetool.base.Element;

class EditAttrLayout$ShowMode
  implements EditAttrLayout.IMode
{
  EditAttrLayout$ShowMode(EditAttrLayout paramEditAttrLayout) {}
  
  public void onDraw(Canvas paramCanvas)
  {
    Rect localRect = EditAttrLayout.access$300(this.this$0).getRect();
    if ((EditAttrLayout.access$300(this.this$0).getView() instanceof TextView))
    {
      localObject = (TextView)EditAttrLayout.access$300(this.this$0).getView();
      if (((TextView)localObject).getLineCount() <= 1)
      {
        Paint.FontMetrics localFontMetrics = ((TextView)localObject).getPaint().getFontMetrics();
        float f3 = localRect.top + (((TextView)localObject).getHeight() - (localFontMetrics.bottom - localFontMetrics.top)) / 2.0F;
        float f4 = localRect.bottom - (((TextView)localObject).getHeight() - (localFontMetrics.bottom - localFontMetrics.top)) / 2.0F;
        float f1 = localRect.left + ((TextView)localObject).getTotalPaddingLeft();
        float f2 = localRect.right - ((TextView)localObject).getTotalPaddingRight();
        paramCanvas.drawLine(f1, f3, f2, f3, this.this$0.textPaint);
        paramCanvas.drawLine(f1, f4, f2, f4, this.this$0.textPaint);
        paramCanvas.drawLine(f1, f4, f1, f3, this.this$0.textPaint);
        paramCanvas.drawLine(f2, f4, f2, f3, this.this$0.textPaint);
        f3 = localRect.top;
        f3 = (((TextView)localObject).getHeight() - localFontMetrics.bottom - localFontMetrics.top) / 2.0F + f3;
        paramCanvas.drawLine(f1, f3, f2, f3, this.this$0.textPaint);
        f3 = localRect.top;
        f4 = (((TextView)localObject).getHeight() - localFontMetrics.bottom - localFontMetrics.top) / 2.0F;
        f3 = localFontMetrics.ascent * 3.0F / 4.0F + (f3 + f4);
        paramCanvas.drawLine(f1, f3, f2, f3, this.this$0.textPaint);
      }
    }
    if (EditAttrLayout.access$700(this.this$0) != null)
    {
      localObject = EditAttrLayout.access$700(this.this$0).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramCanvas.drawRect(((Element)((Iterator)localObject).next()).getRect(), this.this$0.dashLinePaint);
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
  
  public void triggerActionLong(MotionEvent paramMotionEvent) {}
  
  public void triggerActionMove(MotionEvent paramMotionEvent) {}
  
  public void triggerActionUp(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = this.this$0.getTargetElement(paramMotionEvent.getX(), paramMotionEvent.getY());
    this.this$0.clickAndShow(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.view.EditAttrLayout.ShowMode
 * JD-Core Version:    0.7.0.1
 */