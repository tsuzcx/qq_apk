import com.tencent.gdtad.net.GdtHttp.Listener;
import java.lang.ref.WeakReference;

class qps
  implements Runnable
{
  qps(qpr paramqpr) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.a.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      ((GdtHttp.Listener)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.a.jdField_a_of_type_ComTencentGdtadNetGdtHttp$Params);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qps
 * JD-Core Version:    0.7.0.1
 */