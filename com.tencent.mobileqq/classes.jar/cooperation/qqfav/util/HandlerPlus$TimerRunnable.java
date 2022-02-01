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
    if (localRunnable != null)
    {
      int i = this.jdField_a_of_type_Int;
      if (i > 0)
      {
        this.jdField_a_of_type_Int = (i - 1);
        localRunnable.run();
        i = this.jdField_a_of_type_Int;
        if (i > 0) {
          this.this$0.a(localRunnable, i, this.jdField_a_of_type_Long, 0L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     cooperation.qqfav.util.HandlerPlus.TimerRunnable
 * JD-Core Version:    0.7.0.1
 */