import android.support.annotation.NonNull;
import java.lang.ref.WeakReference;

class nro
  implements nrn
{
  private final int jdField_a_of_type_Int;
  @NonNull
  private final WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public nro(@NonNull nrn paramnrn)
  {
    this.jdField_a_of_type_Int = System.identityHashCode(paramnrn);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramnrn);
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_JavaLangRefWeakReference.get() != null;
  }
  
  public void a(@NonNull nrl paramnrl)
  {
    nrn localnrn = (nrn)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localnrn != null) {
      localnrn.a(paramnrl);
    }
  }
  
  public void b(@NonNull nrl paramnrl)
  {
    nrn localnrn = (nrn)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localnrn != null) {
      localnrn.b(paramnrl);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof nro)) && (((nro)paramObject).jdField_a_of_type_Int == this.jdField_a_of_type_Int);
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nro
 * JD-Core Version:    0.7.0.1
 */