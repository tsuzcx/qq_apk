import android.support.annotation.NonNull;
import java.lang.ref.WeakReference;

class nwe
  implements nwd
{
  private final int jdField_a_of_type_Int;
  @NonNull
  private final WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public nwe(@NonNull nwd paramnwd)
  {
    this.jdField_a_of_type_Int = System.identityHashCode(paramnwd);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramnwd);
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_JavaLangRefWeakReference.get() != null;
  }
  
  public void a(@NonNull nwb paramnwb)
  {
    nwd localnwd = (nwd)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localnwd != null) {
      localnwd.a(paramnwb);
    }
  }
  
  public void b(@NonNull nwb paramnwb)
  {
    nwd localnwd = (nwd)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localnwd != null) {
      localnwd.b(paramnwb);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof nwe)) && (((nwe)paramObject).jdField_a_of_type_Int == this.jdField_a_of_type_Int);
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nwe
 * JD-Core Version:    0.7.0.1
 */