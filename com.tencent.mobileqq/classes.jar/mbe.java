import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

public class mbe
  implements URLDrawable.URLDrawableListener
{
  public mbe(VideoFeedsAdapter paramVideoFeedsAdapter) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if ((VideoFeedsAdapter.a(this.a) != null) && (VideoFeedsAdapter.a(this.a).getStatus() == 1) && ((VideoFeedsAdapter.a(this.a).getCurrDrawable() instanceof RegionDrawable)))
    {
      paramURLDrawable = (RegionDrawable)VideoFeedsAdapter.a(this.a).getCurrDrawable();
      VideoFeedsAdapter.a(this.a, paramURLDrawable.getBitmap());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mbe
 * JD-Core Version:    0.7.0.1
 */