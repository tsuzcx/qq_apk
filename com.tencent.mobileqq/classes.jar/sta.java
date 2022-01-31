import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import java.util.concurrent.atomic.AtomicInteger;

class sta
  implements ThreadExcutor.IThreadListener
{
  sta(ssz paramssz, Runnable paramRunnable) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    ssz.a(this.jdField_a_of_type_Ssz).decrementAndGet();
    ved.b(ssz.a(this.jdField_a_of_type_Ssz), "threshold after running current task is " + ssz.a(this.jdField_a_of_type_Ssz).get());
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ved.b(ssz.a(this.jdField_a_of_type_Ssz), "threshold after running current task is:" + this.jdField_a_of_type_JavaLangRunnable.hashCode());
    }
  }
  
  public void onPreRun()
  {
    ssz.a(this.jdField_a_of_type_Ssz).incrementAndGet();
    ved.a(ssz.a(this.jdField_a_of_type_Ssz), "execute %s", this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ved.b(ssz.a(this.jdField_a_of_type_Ssz), "execute hashcode:" + this.jdField_a_of_type_JavaLangRunnable.hashCode());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sta
 * JD-Core Version:    0.7.0.1
 */