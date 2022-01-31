import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class tby<DATA>
{
  public static final String a;
  protected DATA a;
  protected List<tbz<DATA>> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = tby.class.getName();
  }
  
  public tby()
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
  
  public void a(@NonNull tbz<DATA> paramtbz)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramtbz)) {
      this.jdField_a_of_type_JavaUtilList.add(paramtbz);
    }
  }
  
  protected abstract void a(ter paramter);
  
  protected void a(boolean paramBoolean, DATA paramDATA)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((tbz)localIterator.next()).a(paramBoolean, paramDATA);
    }
  }
  
  public void b()
  {
    ved.b(jdField_a_of_type_JavaLangString, "onInit");
  }
  
  public void b(@NonNull tbz<DATA> paramtbz)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramtbz)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramtbz);
    }
  }
  
  public void b(ter paramter)
  {
    a(paramter);
  }
  
  public void c()
  {
    ved.b(jdField_a_of_type_JavaLangString, "onDestroy");
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tby
 * JD-Core Version:    0.7.0.1
 */