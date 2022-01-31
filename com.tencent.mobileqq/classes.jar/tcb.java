import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class tcb<DATA>
{
  public static final String a;
  protected DATA a;
  protected List<tcc<DATA>> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = tcb.class.getName();
  }
  
  public tcb()
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  }
  
  public DATA a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void a()
  {
    a(null);
  }
  
  public void a(@NonNull tcc<DATA> paramtcc)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramtcc)) {
      this.jdField_a_of_type_JavaUtilList.add(paramtcc);
    }
  }
  
  protected abstract void a(teu paramteu);
  
  protected void a(boolean paramBoolean, DATA paramDATA)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((tcc)localIterator.next()).a(paramBoolean, paramDATA);
    }
  }
  
  public void b()
  {
    veg.b(jdField_a_of_type_JavaLangString, "onInit");
  }
  
  public void b(@NonNull tcc<DATA> paramtcc)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramtcc)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramtcc);
    }
  }
  
  public void b(teu paramteu)
  {
    a(paramteu);
  }
  
  public void c()
  {
    veg.b(jdField_a_of_type_JavaLangString, "onDestroy");
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tcb
 * JD-Core Version:    0.7.0.1
 */