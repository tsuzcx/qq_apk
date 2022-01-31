import com.tencent.biz.qqstory.newshare.job.UrlDrawableDownloadJob;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

public class neu
  implements URLDrawable.URLDrawableListener
{
  public neu(UrlDrawableDownloadJob paramUrlDrawableDownloadJob) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    UrlDrawableDownloadJob.c(this.a, false);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    UrlDrawableDownloadJob.b(this.a, false);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.a.a("UrlDrawableDownloadJob_dra", paramURLDrawable.getCurrDrawable());
    UrlDrawableDownloadJob.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     neu
 * JD-Core Version:    0.7.0.1
 */