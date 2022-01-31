import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import java.util.concurrent.atomic.AtomicInteger;

class sgh
  implements ThreadExcutor.IThreadListener
{
  sgh(sgg paramsgg, Runnable paramRunnable) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    sgg.a(this.jdField_a_of_type_Sgg).decrementAndGet();
    urk.b(sgg.a(this.jdField_a_of_type_Sgg), "threshold after running current task is " + sgg.a(this.jdField_a_of_type_Sgg).get());
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      urk.b(sgg.a(this.jdField_a_of_type_Sgg), "threshold after running current task is:" + this.jdField_a_of_type_JavaLangRunnable.hashCode());
    }
  }
  
  public void onPreRun()
  {
    sgg.a(this.jdField_a_of_type_Sgg).incrementAndGet();
    urk.a(sgg.a(this.jdField_a_of_type_Sgg), "execute %s", this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      urk.b(sgg.a(this.jdField_a_of_type_Sgg), "execute hashcode:" + this.jdField_a_of_type_JavaLangRunnable.hashCode());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sgh
 * JD-Core Version:    0.7.0.1
 */