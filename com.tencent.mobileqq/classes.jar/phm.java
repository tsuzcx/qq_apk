import android.graphics.Bitmap;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.ReuseBitmapPool;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.component.media.utils.LruCache;
import java.util.LinkedList;
import java.util.TreeMap;

public class phm
  extends LruCache
{
  public phm(ReuseBitmapPool paramReuseBitmapPool, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(Integer paramInteger, Bitmap paramBitmap)
  {
    return BitmapUtils.getBitmapAllocSize(paramBitmap);
  }
  
  protected void a(boolean paramBoolean, Integer paramInteger, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    try
    {
      super.entryRemoved(paramBoolean, paramInteger, paramBitmap1, paramBitmap2);
      if (paramBoolean)
      {
        int i = BitmapUtils.getBitmapAllocSize(paramBitmap1);
        paramBitmap1 = (LinkedList)ReuseBitmapPool.a(this.a).get(Integer.valueOf(i));
        paramBitmap1.remove(paramInteger);
        if (paramBitmap1.isEmpty()) {
          ReuseBitmapPool.a(this.a).remove(Integer.valueOf(i));
        }
        ImageManagerEnv.getLogger();
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     phm
 * JD-Core Version:    0.7.0.1
 */