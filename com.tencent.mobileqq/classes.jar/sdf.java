import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class sdf
  implements URLDrawable.URLDrawableListener
{
  sdf(scy paramscy) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    scy.b(this.a);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = bheg.b(paramURLDrawable.getCurrDrawable());
    scy.a(this.a, paramURLDrawable, scy.a(this.a).e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sdf
 * JD-Core Version:    0.7.0.1
 */