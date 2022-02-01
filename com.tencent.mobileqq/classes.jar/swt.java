import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

public class swt
  extends Drawable
{
  private Bitmap a;
  
  public swt(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
  }
  
  public Bitmap a()
  {
    return this.a;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((this.a != null) && (!this.a.isRecycled())) {
      paramCanvas.drawBitmap(this.a, 0.0F, 0.0F, null);
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.a.getHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.a.getWidth();
  }
  
  public int getMinimumHeight()
  {
    return this.a.getHeight();
  }
  
  public int getMinimumWidth()
  {
    return this.a.getWidth();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     swt
 * JD-Core Version:    0.7.0.1
 */