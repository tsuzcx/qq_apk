import com.tencent.component.network.utils.http.pool.AbstractConnPool;
import com.tencent.component.network.utils.http.pool.FutureCallback;
import com.tencent.component.network.utils.http.pool.PoolEntry;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class pjn
  extends pjo
{
  public pjn(AbstractConnPool paramAbstractConnPool, Lock paramLock, FutureCallback paramFutureCallback, Object paramObject1, Object paramObject2)
  {
    super(paramLock, paramFutureCallback);
  }
  
  public PoolEntry a(long paramLong, TimeUnit paramTimeUnit)
  {
    return AbstractConnPool.a(this.jdField_a_of_type_ComTencentComponentNetworkUtilsHttpPoolAbstractConnPool, this.jdField_a_of_type_JavaLangObject, this.b, paramLong, paramTimeUnit, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pjn
 * JD-Core Version:    0.7.0.1
 */