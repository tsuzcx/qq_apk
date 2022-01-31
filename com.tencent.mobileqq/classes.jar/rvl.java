import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rvl<T>
{
  private T jdField_a_of_type_JavaLangObject;
  private List<rvm<T>> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public rvl(T paramT)
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
        ((rvm)localIterator.next()).a(this);
      }
    }
    finally {}
  }
  
  public void a(T paramT)
  {
    this.jdField_a_of_type_JavaLangObject = paramT;
    a();
  }
  
  public void a(rvm<T> paramrvm)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramrvm)) {
        this.jdField_a_of_type_JavaUtilList.add(paramrvm);
      }
      return;
    }
    finally
    {
      paramrvm = finally;
      throw paramrvm;
    }
  }
  
  public void b(rvm<T> paramrvm)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramrvm);
      return;
    }
    finally
    {
      paramrvm = finally;
      throw paramrvm;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rvl
 * JD-Core Version:    0.7.0.1
 */