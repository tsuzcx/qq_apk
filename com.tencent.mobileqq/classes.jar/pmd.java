import com.tencent.component.media.image.PoolParams;
import com.tencent.component.media.image.PoolParams.BucketParams;

public class pmd
  implements PoolParams
{
  public PoolParams.BucketParams getBucketParams(int paramInt)
  {
    return new PoolParams.BucketParams(1, 1);
  }
  
  public int getBucketPoolSize()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pmd
 * JD-Core Version:    0.7.0.1
 */