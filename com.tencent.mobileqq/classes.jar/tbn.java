import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tbn<T>
{
  private T jdField_a_of_type_JavaLangObject;
  private List<tbo<T>> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public tbn(T paramT)
  {
    this.jdField_a_of_type_JavaLangObject = paramT;
  }
  
  public T a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void a()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((tbo)localIterator.next()).a(this);
      }
    }
    finally {}
  }
  
  public void a(T paramT)
  {
    this.jdField_a_of_type_JavaLangObject = paramT;
    a();
  }
  
  public void a(tbo<T> paramtbo)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramtbo)) {
        this.jdField_a_of_type_JavaUtilList.add(paramtbo);
      }
      return;
    }
    finally
    {
      paramtbo = finally;
      throw paramtbo;
    }
  }
  
  public void b(tbo<T> paramtbo)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramtbo);
      return;
    }
    finally
    {
      paramtbo = finally;
      throw paramtbo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tbn
 * JD-Core Version:    0.7.0.1
 */