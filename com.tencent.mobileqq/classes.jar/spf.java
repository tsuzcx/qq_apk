import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class spf<DATA>
{
  public static final String a;
  protected DATA a;
  protected List<spg<DATA>> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = spf.class.getName();
  }
  
  public spf()
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
  
  public void a(@NonNull spg<DATA> paramspg)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramspg)) {
      this.jdField_a_of_type_JavaUtilList.add(paramspg);
    }
  }
  
  protected abstract void a(sry paramsry);
  
  protected void a(boolean paramBoolean, DATA paramDATA)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((spg)localIterator.next()).a(paramBoolean, paramDATA);
    }
  }
  
  public void b()
  {
    urk.b(jdField_a_of_type_JavaLangString, "onInit");
  }
  
  public void b(@NonNull spg<DATA> paramspg)
  {
    if (this.jdField_a_of_type_JavaUtilList.contains(paramspg)) {
      this.jdField_a_of_type_JavaUtilList.remove(paramspg);
    }
  }
  
  public void b(sry paramsry)
  {
    a(paramsry);
  }
  
  public void c()
  {
    urk.b(jdField_a_of_type_JavaLangString, "onDestroy");
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     spf
 * JD-Core Version:    0.7.0.1
 */