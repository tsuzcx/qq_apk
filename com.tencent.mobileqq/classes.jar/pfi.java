import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.ImageTaskTracer;
import com.tencent.component.media.utils.LruCache;

public class pfi
  extends LruCache
{
  public pfi(ImageManager paramImageManager, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(Integer paramInteger, Drawable paramDrawable)
  {
    return ImageManager.a(paramDrawable);
  }
  
  protected void a(boolean paramBoolean, Integer paramInteger, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (paramInteger != null) {
      ImageTaskTracer.addImageLruCacheEvictedRecord(paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pfi
 * JD-Core Version:    0.7.0.1
 */