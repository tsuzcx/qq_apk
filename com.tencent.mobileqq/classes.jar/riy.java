import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class riy<T>
{
  private T jdField_a_of_type_JavaLangObject;
  private List<riz<T>> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public riy(T paramT)
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
        ((riz)localIterator.next()).a(this);
      }
    }
    finally {}
  }
  
  public void a(T paramT)
  {
    this.jdField_a_of_type_JavaLangObject = paramT;
    a();
  }
  
  public void a(riz<T> paramriz)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramriz)) {
        this.jdField_a_of_type_JavaUtilList.add(paramriz);
      }
      return;
    }
    finally
    {
      paramriz = finally;
      throw paramriz;
    }
  }
  
  public void b(riz<T> paramriz)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramriz);
      return;
    }
    finally
    {
      paramriz = finally;
      throw paramriz;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     riy
 * JD-Core Version:    0.7.0.1
 */