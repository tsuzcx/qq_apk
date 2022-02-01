package cooperation.qzone.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public class TriangleView
  extends View
{
  private int direction;
  private int drawColor;
  
  public TriangleView(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    BaseApplicationImpl.getApplication();
    this.drawColor = BaseApplicationImpl.getContext().getResources().getColor(2131165552);
    this.direction = paramInt1;
    this.drawColor = paramInt2;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(0);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setColor(this.drawColor);
    localPaint.setStyle(Paint.Style.FILL);
    Path localPath = new Path();
    int i = getMeasuredWidth();
    int j = getMeasuredHeight();
    if (this.direction == 1)
    {
      localPath.moveTo(i / 2, 0.0F);
      localPath.lineTo(i, j);
      localPath.lineTo(0.0F, j);
    }
    for (;;)
    {
      localPath.close();
      paramCanvas.drawPath(localPath, localPaint);
      return;
      localPath.moveTo(i / 2, j);
      localPath.lineTo(i, 0.0F);
      localPath.lineTo(0.0F, 0.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.widget.TriangleView
 * JD-Core Version:    0.7.0.1
 */