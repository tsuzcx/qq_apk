import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;

public class nth
{
  private static nth a;
  
  private nth()
  {
    a = this;
  }
  
  public static nth a()
  {
    if (a == null) {
      a = new nth();
    }
    return a;
  }
  
  public Drawable a(Resources paramResources, int paramInt)
  {
    Object localObject = BaseApplicationImpl.sImageCache.get(String.valueOf(paramInt));
    if ((localObject != null) && ((localObject instanceof Drawable))) {
      localObject = (Drawable)localObject;
    }
    for (;;)
    {
      return localObject;
      localObject = null;
      try
      {
        paramResources = paramResources.getDrawable(paramInt);
        localObject = paramResources;
        if (paramResources == null) {
          continue;
        }
        BaseApplicationImpl.sImageCache.put(String.valueOf(paramInt), paramResources);
        return paramResources;
      }
      catch (OutOfMemoryError paramResources)
      {
        for (;;)
        {
          paramResources = (Resources)localObject;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nth
 * JD-Core Version:    0.7.0.1
 */