import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.etrump.mixlayout.AnimatedImageDrawable;

public class fn
  extends fk
{
  public fn(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramPaint = getDrawable();
    paramCharSequence = paramPaint;
    if ((paramPaint instanceof AnimatedImageDrawable)) {
      paramCharSequence = ((AnimatedImageDrawable)paramPaint).a();
    }
    if (paramCharSequence == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(paramFloat, paramInt5 - getDrawable().getBounds().height());
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public Drawable getDrawable()
  {
    return super.getDrawable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     fn
 * JD-Core Version:    0.7.0.1
 */