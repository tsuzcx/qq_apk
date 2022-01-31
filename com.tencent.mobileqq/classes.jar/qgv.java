import android.support.v4.util.Pools.SynchronizedPool;

public class qgv
  extends qgt<qgz, qgy, qgx>
{
  private static final Pools.SynchronizedPool<qgx> jdField_a_of_type_AndroidSupportV4UtilPools$SynchronizedPool = new Pools.SynchronizedPool(10);
  private static final qgu<qgz, qgy, qgx> jdField_a_of_type_Qgu = new qgw();
  
  public qgv()
  {
    super(jdField_a_of_type_Qgu);
  }
  
  private static qgx a(int paramInt1, int paramInt2, int paramInt3)
  {
    qgx localqgx2 = (qgx)jdField_a_of_type_AndroidSupportV4UtilPools$SynchronizedPool.acquire();
    qgx localqgx1 = localqgx2;
    if (localqgx2 == null) {
      localqgx1 = new qgx();
    }
    localqgx1.a = paramInt1;
    localqgx1.c = paramInt2;
    localqgx1.b = paramInt3;
    return localqgx1;
  }
  
  public void a(qgy paramqgy, int paramInt1, int paramInt2)
  {
    a(paramqgy, 1, a(paramInt1, 0, paramInt2));
  }
  
  public void a(qgy paramqgy, int paramInt, qgx paramqgx)
  {
    try
    {
      super.a(paramqgy, paramInt, paramqgx);
      if (paramqgx != null) {
        jdField_a_of_type_AndroidSupportV4UtilPools$SynchronizedPool.release(paramqgx);
      }
      return;
    }
    finally {}
  }
  
  public void b(qgy paramqgy, int paramInt1, int paramInt2)
  {
    a(paramqgy, 2, a(paramInt1, 0, paramInt2));
  }
  
  public void c(qgy paramqgy, int paramInt1, int paramInt2)
  {
    a(paramqgy, 4, a(paramInt1, 0, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qgv
 * JD-Core Version:    0.7.0.1
 */