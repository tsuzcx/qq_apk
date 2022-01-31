import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.PoolParams;
import com.tencent.component.media.image.PoolParams.BucketParams;

public class pgz
  implements PoolParams
{
  public pgz(ImageManager paramImageManager) {}
  
  public PoolParams.BucketParams getBucketParams(int paramInt)
  {
    return new PoolParams.BucketParams(16384, ImageManagerEnv.g().getDecodeThreadNum(ImageManager.a()) + 2);
  }
  
  public int getBucketPoolSize()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pgz
 * JD-Core Version:    0.7.0.1
 */