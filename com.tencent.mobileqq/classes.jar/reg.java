import android.support.v4.util.Pools.SynchronizedPool;

public class reg
  extends ree<rek, rej, rei>
{
  private static final Pools.SynchronizedPool<rei> jdField_a_of_type_AndroidSupportV4UtilPools$SynchronizedPool = new Pools.SynchronizedPool(10);
  private static final ref<rek, rej, rei> jdField_a_of_type_Ref = new reh();
  
  public reg()
  {
    super(jdField_a_of_type_Ref);
  }
  
  private static rei a(int paramInt1, int paramInt2, int paramInt3)
  {
    rei localrei2 = (rei)jdField_a_of_type_AndroidSupportV4UtilPools$SynchronizedPool.acquire();
    rei localrei1 = localrei2;
    if (localrei2 == null) {
      localrei1 = new rei();
    }
    localrei1.a = paramInt1;
    localrei1.c = paramInt2;
    localrei1.b = paramInt3;
    return localrei1;
  }
  
  public void a(rej paramrej, int paramInt1, int paramInt2)
  {
    a(paramrej, 1, a(paramInt1, 0, paramInt2));
  }
  
  public void a(rej paramrej, int paramInt, rei paramrei)
  {
    try
    {
      super.a(paramrej, paramInt, paramrei);
      if (paramrei != null) {
        jdField_a_of_type_AndroidSupportV4UtilPools$SynchronizedPool.release(paramrei);
      }
      return;
    }
    finally {}
  }
  
  public void b(rej paramrej, int paramInt1, int paramInt2)
  {
    a(paramrej, 2, a(paramInt1, 0, paramInt2));
  }
  
  public void c(rej paramrej, int paramInt1, int paramInt2)
  {
    a(paramrej, 4, a(paramInt1, 0, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     reg
 * JD-Core Version:    0.7.0.1
 */