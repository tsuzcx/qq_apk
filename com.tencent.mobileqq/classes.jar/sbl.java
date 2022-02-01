import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class sbl
  implements URLDrawable.URLDrawableListener
{
  sbl(sbi paramsbi) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if ((sbi.a(this.a) != null) && (sbi.a(this.a).getStatus() == 1) && ((sbi.a(this.a).getCurrDrawable() instanceof RegionDrawable)))
    {
      paramURLDrawable = (RegionDrawable)sbi.a(this.a).getCurrDrawable();
      sbi.a(this.a, paramURLDrawable.getBitmap());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sbl
 * JD-Core Version:    0.7.0.1
 */