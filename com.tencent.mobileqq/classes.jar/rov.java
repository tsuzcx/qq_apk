import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable.OnGIFPlayOnceListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.util.WeakReference;

class rov
  implements GifDrawable.OnGIFPlayOnceListener
{
  AbstractGifImage a;
  
  rov(AbstractGifImage paramAbstractGifImage)
  {
    this.a = paramAbstractGifImage;
  }
  
  public void onPlayOnce()
  {
    Object localObject = (List)rou.a().get(this.a);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
        if (localWeakReference.get() != null) {
          ((row)localWeakReference.get()).a();
        }
      }
    }
    this.a.setGIFPlayOnceListener(null);
    rou.b().remove(this.a);
    rou.a().remove(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rov
 * JD-Core Version:    0.7.0.1
 */