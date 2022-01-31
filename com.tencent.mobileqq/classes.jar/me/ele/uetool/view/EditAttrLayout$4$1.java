package me.ele.uetool.view;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import com.app.hubert.guide.listener.OnHighlightDrewListener;

class EditAttrLayout$4$1
  implements OnHighlightDrewListener
{
  EditAttrLayout$4$1(EditAttrLayout.4 param4) {}
  
  public void onHighlightDrew(Canvas paramCanvas, RectF paramRectF)
  {
    paramCanvas = new Paint();
    paramCanvas.setColor(-1);
    paramCanvas.setStyle(Paint.Style.STROKE);
    paramCanvas.setStrokeWidth(10.0F);
    paramCanvas.setPathEffect(new DashPathEffect(new float[] { 20.0F, 20.0F }, 0.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.view.EditAttrLayout.4.1
 * JD-Core Version:    0.7.0.1
 */