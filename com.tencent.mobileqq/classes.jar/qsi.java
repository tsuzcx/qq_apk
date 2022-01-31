import android.support.v4.util.Pools.SynchronizedPool;

public class qsi
  extends qsg<qsm, qsl, qsk>
{
  private static final Pools.SynchronizedPool<qsk> jdField_a_of_type_AndroidSupportV4UtilPools$SynchronizedPool = new Pools.SynchronizedPool(10);
  private static final qsh<qsm, qsl, qsk> jdField_a_of_type_Qsh = new qsj();
  
  public qsi()
  {
    super(jdField_a_of_type_Qsh);
  }
  
  private static qsk a(int paramInt1, int paramInt2, int paramInt3)
  {
    qsk localqsk2 = (qsk)jdField_a_of_type_AndroidSupportV4UtilPools$SynchronizedPool.acquire();
    qsk localqsk1 = localqsk2;
    if (localqsk2 == null) {
      localqsk1 = new qsk();
    }
    localqsk1.a = paramInt1;
    localqsk1.c = paramInt2;
    localqsk1.b = paramInt3;
    return localqsk1;
  }
  
  public void a(qsl paramqsl, int paramInt1, int paramInt2)
  {
    a(paramqsl, 1, a(paramInt1, 0, paramInt2));
  }
  
  public void a(qsl paramqsl, int paramInt, qsk paramqsk)
  {
    try
    {
      super.a(paramqsl, paramInt, paramqsk);
      if (paramqsk != null) {
        jdField_a_of_type_AndroidSupportV4UtilPools$SynchronizedPool.release(paramqsk);
      }
      return;
    }
    finally {}
  }
  
  public void b(qsl paramqsl, int paramInt1, int paramInt2)
  {
    a(paramqsl, 2, a(paramInt1, 0, paramInt2));
  }
  
  public void c(qsl paramqsl, int paramInt1, int paramInt2)
  {
    a(paramqsl, 4, a(paramInt1, 0, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qsi
 * JD-Core Version:    0.7.0.1
 */