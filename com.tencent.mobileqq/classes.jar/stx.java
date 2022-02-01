import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import mqq.util.WeakReference;

class stx
{
  private static Map<AbstractGifImage, List<WeakReference<stz>>> a = new WeakHashMap();
  private static Map<AbstractGifImage, sty> b = new WeakHashMap();
  
  public void a()
  {
    a.clear();
    b.clear();
  }
  
  void a(stz paramstz, URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable.getCurrDrawable() instanceof GifDrawable))
    {
      AbstractGifImage localAbstractGifImage = ((GifDrawable)paramURLDrawable.getCurrDrawable()).getImage();
      paramURLDrawable = new sty(localAbstractGifImage);
      localAbstractGifImage.setGIFPlayOnceListener(paramURLDrawable);
      b.put(localAbstractGifImage, paramURLDrawable);
      List localList = (List)a.get(localAbstractGifImage);
      paramURLDrawable = localList;
      if (localList == null) {
        paramURLDrawable = new ArrayList();
      }
      paramURLDrawable.add(new WeakReference(paramstz));
      a.put(localAbstractGifImage, paramURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     stx
 * JD-Core Version:    0.7.0.1
 */