import com.tencent.component.media.image.ImageDefaultConfig;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.PoolParams;
import com.tencent.component.media.image.PoolParams.BucketParams;

public class plq
  implements PoolParams
{
  public plq(ImageManager paramImageManager, boolean paramBoolean) {}
  
  public PoolParams.BucketParams getBucketParams(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      return new PoolParams.BucketParams(ImageDefaultConfig.BYTE_ARRAY_LOCAL[paramInt][1], ImageDefaultConfig.BYTE_ARRAY_LOCAL[paramInt][0]);
    }
    return new PoolParams.BucketParams(ImageDefaultConfig.BYTE_ARRAY[paramInt][1], ImageDefaultConfig.BYTE_ARRAY[paramInt][0]);
  }
  
  public int getBucketPoolSize()
  {
    if (this.jdField_a_of_type_Boolean) {
      return ImageDefaultConfig.BYTE_ARRAY_LOCAL.length;
    }
    return ImageDefaultConfig.BYTE_ARRAY.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     plq
 * JD-Core Version:    0.7.0.1
 */