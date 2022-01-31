import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import java.util.concurrent.atomic.AtomicInteger;

class std
  implements ThreadExcutor.IThreadListener
{
  std(stc paramstc, Runnable paramRunnable) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    stc.a(this.jdField_a_of_type_Stc).decrementAndGet();
    veg.b(stc.a(this.jdField_a_of_type_Stc), "threshold after running current task is " + stc.a(this.jdField_a_of_type_Stc).get());
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      veg.b(stc.a(this.jdField_a_of_type_Stc), "threshold after running current task is:" + this.jdField_a_of_type_JavaLangRunnable.hashCode());
    }
  }
  
  public void onPreRun()
  {
    stc.a(this.jdField_a_of_type_Stc).incrementAndGet();
    veg.a(stc.a(this.jdField_a_of_type_Stc), "execute %s", this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      veg.b(stc.a(this.jdField_a_of_type_Stc), "execute hashcode:" + this.jdField_a_of_type_JavaLangRunnable.hashCode());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     std
 * JD-Core Version:    0.7.0.1
 */