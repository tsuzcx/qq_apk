import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

class nqm
  implements URLDrawable.URLDrawableListener
{
  nqm(nqi paramnqi) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.e("KandianAdPandent", 2, "urlDrawable is onLoadCanceled ");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("KandianAdPandent", 2, "urlDrawable is fialed ");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    QLog.e("KandianAdPandent", 2, "urlDrawable is onLoadProgressed ");
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable.setBounds(0, 0, paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight());
    if ((nqi.a(this.a).getCurrDrawable() instanceof ApngDrawable)) {
      ((ApngDrawable)nqi.a(this.a).getCurrDrawable()).setOnPlayRepeatListener(nqi.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nqm
 * JD-Core Version:    0.7.0.1
 */