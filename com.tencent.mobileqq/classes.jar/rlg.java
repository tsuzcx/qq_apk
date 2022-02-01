import android.support.v4.util.Pools.SynchronizedPool;

public class rlg
  extends rle<rlk, rlj, rli>
{
  private static final Pools.SynchronizedPool<rli> jdField_a_of_type_AndroidSupportV4UtilPools$SynchronizedPool = new Pools.SynchronizedPool(10);
  private static final rlf<rlk, rlj, rli> jdField_a_of_type_Rlf = new rlh();
  
  public rlg()
  {
    super(jdField_a_of_type_Rlf);
  }
  
  private static rli a(int paramInt1, int paramInt2, int paramInt3)
  {
    rli localrli2 = (rli)jdField_a_of_type_AndroidSupportV4UtilPools$SynchronizedPool.acquire();
    rli localrli1 = localrli2;
    if (localrli2 == null) {
      localrli1 = new rli();
    }
    localrli1.a = paramInt1;
    localrli1.c = paramInt2;
    localrli1.b = paramInt3;
    return localrli1;
  }
  
  public void a(rlj paramrlj, int paramInt1, int paramInt2)
  {
    a(paramrlj, 1, a(paramInt1, 0, paramInt2));
  }
  
  public void a(rlj paramrlj, int paramInt, rli paramrli)
  {
    try
    {
      super.a(paramrlj, paramInt, paramrli);
      if (paramrli != null) {
        jdField_a_of_type_AndroidSupportV4UtilPools$SynchronizedPool.release(paramrli);
      }
      return;
    }
    finally {}
  }
  
  public void b(rlj paramrlj, int paramInt1, int paramInt2)
  {
    a(paramrlj, 2, a(paramInt1, 0, paramInt2));
  }
  
  public void c(rlj paramrlj, int paramInt1, int paramInt2)
  {
    a(paramrlj, 4, a(paramInt1, 0, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rlg
 * JD-Core Version:    0.7.0.1
 */