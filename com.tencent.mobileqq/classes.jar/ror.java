import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import mqq.util.WeakReference;

class ror
{
  private static Map<AbstractGifImage, List<WeakReference<rot>>> a = new WeakHashMap();
  private static Map<AbstractGifImage, ros> b = new WeakHashMap();
  
  public void a()
  {
    a.clear();
    b.clear();
  }
  
  void a(rot paramrot, URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable.getCurrDrawable() instanceof GifDrawable))
    {
      AbstractGifImage localAbstractGifImage = ((GifDrawable)paramURLDrawable.getCurrDrawable()).getImage();
      paramURLDrawable = new ros(localAbstractGifImage);
      localAbstractGifImage.setGIFPlayOnceListener(paramURLDrawable);
      b.put(localAbstractGifImage, paramURLDrawable);
      List localList = (List)a.get(localAbstractGifImage);
      paramURLDrawable = localList;
      if (localList == null) {
        paramURLDrawable = new ArrayList();
      }
      paramURLDrawable.add(new WeakReference(paramrot));
      a.put(localAbstractGifImage, paramURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ror
 * JD-Core Version:    0.7.0.1
 */