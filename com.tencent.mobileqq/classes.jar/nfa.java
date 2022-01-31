import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;

public class nfa
{
  private static nfa a;
  
  private nfa()
  {
    a = this;
  }
  
  public static nfa a()
  {
    if (a == null) {
      a = new nfa();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nfa
 * JD-Core Version:    0.7.0.1
 */