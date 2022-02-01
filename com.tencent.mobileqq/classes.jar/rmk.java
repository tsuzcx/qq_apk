import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class rmk
  implements URLDrawable.URLDrawableListener
{
  rmk(rmj paramrmj) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if ((rmj.a(this.a) != null) && (rmj.a(this.a).getStatus() == 1) && ((rmj.a(this.a).getCurrDrawable() instanceof RegionDrawable)))
    {
      paramURLDrawable = (RegionDrawable)rmj.a(this.a).getCurrDrawable();
      rmj.a(this.a, paramURLDrawable.getBitmap());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rmk
 * JD-Core Version:    0.7.0.1
 */