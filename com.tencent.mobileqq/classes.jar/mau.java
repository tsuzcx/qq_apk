import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

public final class mau
  implements URLDrawable.URLDrawableListener
{
  public mau(int paramInt) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    paramURLDrawable.getCurrDrawable().mutate().setAlpha(this.a);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramURLDrawable.getCurrDrawable().mutate().setAlpha(this.a);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    paramURLDrawable.getCurrDrawable().mutate().setAlpha(this.a);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable.getCurrDrawable().mutate().setAlpha(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mau
 * JD-Core Version:    0.7.0.1
 */