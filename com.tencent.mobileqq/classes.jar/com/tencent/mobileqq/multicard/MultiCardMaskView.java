package com.tencent.mobileqq.multicard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;

public class MultiCardMaskView
  extends View
{
  private Path a;
  private RectF b;
  private float c = ViewUtils.dpToPx(12.0F);
  private boolean d = true;
  
  public MultiCardMaskView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public MultiCardMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    b();
  }
  
  private boolean a()
  {
    return (Build.VERSION.SDK_INT == 24) && ("Xiaomi".equals(Build.MANUFACTURER)) && ("MIX".equals(Build.MODEL));
  }
  
  private void b()
  {
    setWillNotDraw(false);
    this.a = new Path();
    this.b = new RectF();
    if ((Build.VERSION.SDK_INT <= 18) || (a())) {
      setLayerType(1, null);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.d)
    {
      this.a.reset();
      this.b.set(0.0F, 0.0F, getWidth(), getHeight());
      Path localPath = this.a;
      RectF localRectF = this.b;
      float f = this.c;
      localPath.addRoundRect(localRectF, f, f, Path.Direction.CW);
      paramCanvas.clipPath(this.a);
    }
    super.draw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardMaskView
 * JD-Core Version:    0.7.0.1
 */