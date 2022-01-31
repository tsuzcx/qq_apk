import android.support.v4.util.Pools.SynchronizedPool;

public class qgs
  extends qgq<qgw, qgv, qgu>
{
  private static final Pools.SynchronizedPool<qgu> jdField_a_of_type_AndroidSupportV4UtilPools$SynchronizedPool = new Pools.SynchronizedPool(10);
  private static final qgr<qgw, qgv, qgu> jdField_a_of_type_Qgr = new qgt();
  
  public qgs()
  {
    super(jdField_a_of_type_Qgr);
  }
  
  private static qgu a(int paramInt1, int paramInt2, int paramInt3)
  {
    qgu localqgu2 = (qgu)jdField_a_of_type_AndroidSupportV4UtilPools$SynchronizedPool.acquire();
    qgu localqgu1 = localqgu2;
    if (localqgu2 == null) {
      localqgu1 = new qgu();
    }
    localqgu1.a = paramInt1;
    localqgu1.c = paramInt2;
    localqgu1.b = paramInt3;
    return localqgu1;
  }
  
  public void a(qgv paramqgv, int paramInt1, int paramInt2)
  {
    a(paramqgv, 1, a(paramInt1, 0, paramInt2));
  }
  
  public void a(qgv paramqgv, int paramInt, qgu paramqgu)
  {
    try
    {
      super.a(paramqgv, paramInt, paramqgu);
      if (paramqgu != null) {
        jdField_a_of_type_AndroidSupportV4UtilPools$SynchronizedPool.release(paramqgu);
      }
      return;
    }
    finally {}
  }
  
  public void b(qgv paramqgv, int paramInt1, int paramInt2)
  {
    a(paramqgv, 2, a(paramInt1, 0, paramInt2));
  }
  
  public void c(qgv paramqgv, int paramInt1, int paramInt2)
  {
    a(paramqgv, 4, a(paramInt1, 0, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qgs
 * JD-Core Version:    0.7.0.1
 */