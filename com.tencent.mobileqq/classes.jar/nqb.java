import android.support.annotation.NonNull;
import java.lang.ref.WeakReference;

class nqb
  implements nqa
{
  private final int jdField_a_of_type_Int;
  @NonNull
  private final WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public nqb(@NonNull nqa paramnqa)
  {
    this.jdField_a_of_type_Int = System.identityHashCode(paramnqa);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramnqa);
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_JavaLangRefWeakReference.get() != null;
  }
  
  public void a(@NonNull npy paramnpy)
  {
    nqa localnqa = (nqa)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localnqa != null) {
      localnqa.a(paramnpy);
    }
  }
  
  public void b(@NonNull npy paramnpy)
  {
    nqa localnqa = (nqa)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localnqa != null) {
      localnqa.b(paramnpy);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof nqb)) && (((nqb)paramObject).jdField_a_of_type_Int == this.jdField_a_of_type_Int);
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nqb
 * JD-Core Version:    0.7.0.1
 */