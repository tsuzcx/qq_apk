import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class rjq
  implements URLDrawable.URLDrawableListener
{
  rjq(rjj paramrjj) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    rjj.b(this.a);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = bhmq.b(paramURLDrawable.getCurrDrawable());
    rjj.a(this.a, paramURLDrawable, rjj.a(this.a).e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rjq
 * JD-Core Version:    0.7.0.1
 */