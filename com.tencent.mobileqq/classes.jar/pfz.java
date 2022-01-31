import com.tencent.component.media.gif.NewGifDrawable;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class pfz
  implements Runnable
{
  long jdField_a_of_type_Long;
  
  public pfz(NewGifDrawable paramNewGifDrawable, long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void run()
  {
    long l = 0L;
    NewGifDrawable.a(this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable);
    NewGifDrawable localNewGifDrawable = this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable;
    ScheduledThreadPoolExecutor localScheduledThreadPoolExecutor = this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor;
    pgb localpgb = NewGifDrawable.a(this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable);
    if (this.jdField_a_of_type_Long > 0L) {
      l = this.jdField_a_of_type_Long;
    }
    localNewGifDrawable.jdField_a_of_type_JavaUtilConcurrentScheduledFuture = localScheduledThreadPoolExecutor.schedule(localpgb, l, TimeUnit.MILLISECONDS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pfz
 * JD-Core Version:    0.7.0.1
 */