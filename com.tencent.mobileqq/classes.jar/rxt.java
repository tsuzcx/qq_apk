import android.support.v4.util.Pools.SynchronizedPool;

public class rxt
  extends rxr<rxx, rxw, rxv>
{
  private static final Pools.SynchronizedPool<rxv> jdField_a_of_type_AndroidSupportV4UtilPools$SynchronizedPool = new Pools.SynchronizedPool(10);
  private static final rxs<rxx, rxw, rxv> jdField_a_of_type_Rxs = new rxu();
  
  public rxt()
  {
    super(jdField_a_of_type_Rxs);
  }
  
  private static rxv a(int paramInt1, int paramInt2, int paramInt3)
  {
    rxv localrxv2 = (rxv)jdField_a_of_type_AndroidSupportV4UtilPools$SynchronizedPool.acquire();
    rxv localrxv1 = localrxv2;
    if (localrxv2 == null) {
      localrxv1 = new rxv();
    }
    localrxv1.a = paramInt1;
    localrxv1.c = paramInt2;
    localrxv1.b = paramInt3;
    return localrxv1;
  }
  
  public void a(rxw paramrxw, int paramInt1, int paramInt2)
  {
    a(paramrxw, 1, a(paramInt1, 0, paramInt2));
  }
  
  public void a(rxw paramrxw, int paramInt, rxv paramrxv)
  {
    try
    {
      super.a(paramrxw, paramInt, paramrxv);
      if (paramrxv != null) {
        jdField_a_of_type_AndroidSupportV4UtilPools$SynchronizedPool.release(paramrxv);
      }
      return;
    }
    finally {}
  }
  
  public void b(rxw paramrxw, int paramInt1, int paramInt2)
  {
    a(paramrxw, 2, a(paramInt1, 0, paramInt2));
  }
  
  public void c(rxw paramrxw, int paramInt1, int paramInt2)
  {
    a(paramrxw, 4, a(paramInt1, 0, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rxt
 * JD-Core Version:    0.7.0.1
 */