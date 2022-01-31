import com.tencent.biz.pubaccount.readinjoy.magic.utils.Debouncer;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class lru
  implements Runnable
{
  private long jdField_a_of_type_Long;
  private final Object jdField_a_of_type_JavaLangObject;
  private final Object b = new Object();
  
  public lru(Debouncer paramDebouncer, Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    a();
  }
  
  public boolean a()
  {
    synchronized (this.b)
    {
      if (this.jdField_a_of_type_Long < 0L) {
        return false;
      }
      this.jdField_a_of_type_Long = (System.currentTimeMillis() + Debouncer.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicUtilsDebouncer));
      return true;
    }
  }
  
  public void run()
  {
    synchronized (this.b)
    {
      long l = this.jdField_a_of_type_Long - System.currentTimeMillis();
      if (l > 0L)
      {
        Debouncer.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyMagicUtilsDebouncer).schedule(this, l, TimeUnit.MILLISECONDS);
        return;
      }
      this.jdField_a_of_type_Long = -1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lru
 * JD-Core Version:    0.7.0.1
 */