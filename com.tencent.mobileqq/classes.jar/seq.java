import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import mqq.util.WeakReference;

class seq
{
  private static Map<AbstractGifImage, List<WeakReference<ses>>> a = new WeakHashMap();
  private static Map<AbstractGifImage, ser> b = new WeakHashMap();
  
  public void a()
  {
    a.clear();
    b.clear();
  }
  
  void a(ses paramses, URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable.getCurrDrawable() instanceof GifDrawable))
    {
      AbstractGifImage localAbstractGifImage = ((GifDrawable)paramURLDrawable.getCurrDrawable()).getImage();
      paramURLDrawable = new ser(localAbstractGifImage);
      localAbstractGifImage.setGIFPlayOnceListener(paramURLDrawable);
      b.put(localAbstractGifImage, paramURLDrawable);
      List localList = (List)a.get(localAbstractGifImage);
      paramURLDrawable = localList;
      if (localList == null) {
        paramURLDrawable = new ArrayList();
      }
      paramURLDrawable.add(new WeakReference(paramses));
      a.put(localAbstractGifImage, paramURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     seq
 * JD-Core Version:    0.7.0.1
 */