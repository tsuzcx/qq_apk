import com.tencent.component.media.image.ImageDefaultConfig;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.PoolParams;
import com.tencent.component.media.image.PoolParams.BucketParams;

public class pls
  implements PoolParams
{
  public pls(ImageManager paramImageManager) {}
  
  public PoolParams.BucketParams getBucketParams(int paramInt)
  {
    return ImageDefaultConfig.getArtBitmapBucketParams(ImageManager.a(this.a), paramInt);
  }
  
  public int getBucketPoolSize()
  {
    return ImageDefaultConfig.getArtBitmapPoolSize(ImageManager.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pls
 * JD-Core Version:    0.7.0.1
 */