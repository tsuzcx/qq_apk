import android.support.v4.util.LruCache;
import com.rookery.translate.model.TransMemCache;

public class jep
  extends LruCache
{
  public jep(TransMemCache paramTransMemCache, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString1, String paramString2)
  {
    return paramString2.length() + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     jep
 * JD-Core Version:    0.7.0.1
 */