import android.util.LruCache;
import com.tencent.av.ui.funchat.record.PCMLoader;

public class kfh
  extends LruCache
{
  public kfh(PCMLoader paramPCMLoader, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString, kfi paramkfi)
  {
    if (paramkfi == null) {
      return 0;
    }
    return paramkfi.a.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kfh
 * JD-Core Version:    0.7.0.1
 */