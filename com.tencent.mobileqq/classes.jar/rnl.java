import android.support.v4.util.Pools.SynchronizedPool;

public class rnl
  extends rnj<rnp, rno, rnn>
{
  private static final Pools.SynchronizedPool<rnn> jdField_a_of_type_AndroidSupportV4UtilPools$SynchronizedPool = new Pools.SynchronizedPool(10);
  private static final rnk<rnp, rno, rnn> jdField_a_of_type_Rnk = new rnm();
  
  public rnl()
  {
    super(jdField_a_of_type_Rnk);
  }
  
  private static rnn a(int paramInt1, int paramInt2, int paramInt3)
  {
    rnn localrnn2 = (rnn)jdField_a_of_type_AndroidSupportV4UtilPools$SynchronizedPool.acquire();
    rnn localrnn1 = localrnn2;
    if (localrnn2 == null) {
      localrnn1 = new rnn();
    }
    localrnn1.a = paramInt1;
    localrnn1.c = paramInt2;
    localrnn1.b = paramInt3;
    return localrnn1;
  }
  
  public void a(rno paramrno, int paramInt1, int paramInt2)
  {
    a(paramrno, 1, a(paramInt1, 0, paramInt2));
  }
  
  public void a(rno paramrno, int paramInt, rnn paramrnn)
  {
    try
    {
      super.a(paramrno, paramInt, paramrnn);
      if (paramrnn != null) {
        jdField_a_of_type_AndroidSupportV4UtilPools$SynchronizedPool.release(paramrnn);
      }
      return;
    }
    finally {}
  }
  
  public void b(rno paramrno, int paramInt1, int paramInt2)
  {
    a(paramrno, 2, a(paramInt1, 0, paramInt2));
  }
  
  public void c(rno paramrno, int paramInt1, int paramInt2)
  {
    a(paramrno, 4, a(paramInt1, 0, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rnl
 * JD-Core Version:    0.7.0.1
 */