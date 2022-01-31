import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable.OnGIFPlayOnceListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;

class rcd
  implements GifDrawable.OnGIFPlayOnceListener
{
  AbstractGifImage a;
  
  rcd(AbstractGifImage paramAbstractGifImage)
  {
    this.a = paramAbstractGifImage;
  }
  
  public void onPlayOnce()
  {
    Object localObject = (List)rcc.a().get(this.a);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
        if (localWeakReference.get() != null) {
          ((rce)localWeakReference.get()).a();
        }
      }
    }
    this.a.setGIFPlayOnceListener(null);
    rcc.b().remove(this.a);
    rcc.a().remove(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rcd
 * JD-Core Version:    0.7.0.1
 */