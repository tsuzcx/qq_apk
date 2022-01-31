import android.util.LruCache;
import com.tencent.av.ui.funchat.record.PCMLoader;

public class kdd
  extends LruCache
{
  public kdd(PCMLoader paramPCMLoader, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString, kde paramkde)
  {
    if (paramkde == null) {
      return 0;
    }
    return paramkde.a.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kdd
 * JD-Core Version:    0.7.0.1
 */