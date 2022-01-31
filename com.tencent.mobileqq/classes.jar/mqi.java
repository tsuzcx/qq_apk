import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyFeedsHeaderViewController.GifPlayOnceEventMultiCaster;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyFeedsHeaderViewController.GifPlayOnceEventMultiCaster.GifStateListener;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable.OnGIFPlayOnceListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;

public class mqi
  implements GifDrawable.OnGIFPlayOnceListener
{
  AbstractGifImage a;
  
  public mqi(AbstractGifImage paramAbstractGifImage)
  {
    this.a = paramAbstractGifImage;
  }
  
  public void onPlayOnce()
  {
    Object localObject = (List)ReadInJoyFeedsHeaderViewController.GifPlayOnceEventMultiCaster.a().get(this.a);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
        if (localWeakReference.get() != null) {
          ((ReadInJoyFeedsHeaderViewController.GifPlayOnceEventMultiCaster.GifStateListener)localWeakReference.get()).a();
        }
      }
    }
    this.a.setGIFPlayOnceListener(null);
    ReadInJoyFeedsHeaderViewController.GifPlayOnceEventMultiCaster.b().remove(this.a);
    ReadInJoyFeedsHeaderViewController.GifPlayOnceEventMultiCaster.a().remove(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mqi
 * JD-Core Version:    0.7.0.1
 */