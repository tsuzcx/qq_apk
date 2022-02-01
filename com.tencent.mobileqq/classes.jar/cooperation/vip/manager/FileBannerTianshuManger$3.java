package cooperation.vip.manager;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import cooperation.qzone.util.QZLog;

class FileBannerTianshuManger$3
  implements URLDrawable.URLDrawableListener
{
  FileBannerTianshuManger$3(FileBannerTianshuManger paramFileBannerTianshuManger) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QZLog.i("FileBannerTianshuManger", "onLoadSuccessed picUrlDrawable ");
    FileBannerTianshuManger localFileBannerTianshuManger = this.a;
    localFileBannerTianshuManger.a(localFileBannerTianshuManger.b, paramURLDrawable);
    paramURLDrawable = this.a;
    paramURLDrawable.a(paramURLDrawable.d, 101);
    if (this.a.j == 1)
    {
      paramURLDrawable = this.a;
      paramURLDrawable.a(paramURLDrawable.d, 137);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.manager.FileBannerTianshuManger.3
 * JD-Core Version:    0.7.0.1
 */