import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.ImageTaskTracer;
import com.tencent.component.media.image.image.Image;
import com.tencent.component.media.utils.LruCache;

public class plv
  extends LruCache
{
  public plv(ImageManager paramImageManager, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(Integer paramInteger, Image paramImage)
  {
    return paramImage.size();
  }
  
  protected void a(boolean paramBoolean, Integer paramInteger, Image paramImage1, Image paramImage2)
  {
    if (paramInteger != null) {
      ImageTaskTracer.addImageLruCacheEvictedRecord(paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     plv
 * JD-Core Version:    0.7.0.1
 */