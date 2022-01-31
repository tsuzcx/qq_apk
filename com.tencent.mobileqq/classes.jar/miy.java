import com.tencent.biz.pubaccount.readinjoy.video.VideoShareHelper;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

public class miy
  implements URLDrawable.URLDrawableListener
{
  public miy(VideoShareHelper paramVideoShareHelper) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if ((VideoShareHelper.a(this.a) != null) && (VideoShareHelper.a(this.a).getStatus() == 1) && ((VideoShareHelper.a(this.a).getCurrDrawable() instanceof RegionDrawable)))
    {
      paramURLDrawable = (RegionDrawable)VideoShareHelper.a(this.a).getCurrDrawable();
      VideoShareHelper.a(this.a, paramURLDrawable.getBitmap());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     miy
 * JD-Core Version:    0.7.0.1
 */