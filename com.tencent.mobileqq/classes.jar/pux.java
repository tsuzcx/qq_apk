import android.support.v4.util.Pools.SynchronizedPool;

public class pux
  extends puv<pvb, pva, puz>
{
  private static final Pools.SynchronizedPool<puz> jdField_a_of_type_AndroidSupportV4UtilPools$SynchronizedPool = new Pools.SynchronizedPool(10);
  private static final puw<pvb, pva, puz> jdField_a_of_type_Puw = new puy();
  
  public pux()
  {
    super(jdField_a_of_type_Puw);
  }
  
  private static puz a(int paramInt1, int paramInt2, int paramInt3)
  {
    puz localpuz2 = (puz)jdField_a_of_type_AndroidSupportV4UtilPools$SynchronizedPool.acquire();
    puz localpuz1 = localpuz2;
    if (localpuz2 == null) {
      localpuz1 = new puz();
    }
    localpuz1.a = paramInt1;
    localpuz1.c = paramInt2;
    localpuz1.b = paramInt3;
    return localpuz1;
  }
  
  public void a(pva parampva, int paramInt1, int paramInt2)
  {
    a(parampva, 1, a(paramInt1, 0, paramInt2));
  }
  
  public void a(pva parampva, int paramInt, puz parampuz)
  {
    try
    {
      super.a(parampva, paramInt, parampuz);
      if (parampuz != null) {
        jdField_a_of_type_AndroidSupportV4UtilPools$SynchronizedPool.release(parampuz);
      }
      return;
    }
    finally {}
  }
  
  public void b(pva parampva, int paramInt1, int paramInt2)
  {
    a(parampva, 2, a(paramInt1, 0, paramInt2));
  }
  
  public void c(pva parampva, int paramInt1, int paramInt2)
  {
    a(parampva, 4, a(paramInt1, 0, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pux
 * JD-Core Version:    0.7.0.1
 */