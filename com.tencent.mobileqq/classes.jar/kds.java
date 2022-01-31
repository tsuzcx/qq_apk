import android.util.LruCache;
import com.tencent.av.ui.funchat.record.PCMLoader;

public class kds
  extends LruCache
{
  public kds(PCMLoader paramPCMLoader, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString, kdt paramkdt)
  {
    if (paramkdt == null) {
      return 0;
    }
    return paramkdt.a.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kds
 * JD-Core Version:    0.7.0.1
 */