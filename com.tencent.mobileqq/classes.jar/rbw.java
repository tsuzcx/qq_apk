import android.content.BroadcastReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class rbw
{
  private static int jdField_a_of_type_Int = 5;
  private static BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new rbx();
  private static final String jdField_a_of_type_JavaLangString = rbw.class.getSimpleName();
  private static Thread jdField_a_of_type_JavaLangThread;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private static AtomicInteger b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    b = new AtomicInteger(0);
  }
  
  private static long b()
  {
    for (long l = 0L; jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 1; l += 1L) {}
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rbw
 * JD-Core Version:    0.7.0.1
 */