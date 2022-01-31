package cooperation.qqfav.util;

import java.lang.ref.WeakReference;

class HandlerPlus$TimerRunnable
  implements Runnable
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  private WeakReference<Runnable> jdField_a_of_type_JavaLangRefWeakReference;
  
  private HandlerPlus$TimerRunnable(HandlerPlus paramHandlerPlus, Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramRunnable);
  }
  
  public void run()
  {
    Runnable localRunnable = (Runnable)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localRunnable != null) && (this.jdField_a_of_type_Int > 0))
    {
      this.jdField_a_of_type_Int -= 1;
      localRunnable.run();
      if (this.jdField_a_of_type_Int > 0) {
        this.this$0.a(localRunnable, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, 0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqfav.util.HandlerPlus.TimerRunnable
 * JD-Core Version:    0.7.0.1
 */