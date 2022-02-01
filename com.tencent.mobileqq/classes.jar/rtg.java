import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class rtg
  implements URLDrawable.URLDrawableListener
{
  rtg(rsx paramrsx) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if ((rsx.a(this.a) != null) && (rsx.a(this.a).getStatus() == 1) && ((rsx.a(this.a).getCurrDrawable() instanceof RegionDrawable)))
    {
      paramURLDrawable = (RegionDrawable)rsx.a(this.a).getCurrDrawable();
      rsx.a(this.a, paramURLDrawable.getBitmap());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rtg
 * JD-Core Version:    0.7.0.1
 */