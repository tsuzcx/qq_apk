import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class sly<T>
{
  private T jdField_a_of_type_JavaLangObject;
  private List<slz<T>> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public sly(T paramT)
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
        ((slz)localIterator.next()).a(this);
      }
    }
    finally {}
  }
  
  public void a(T paramT)
  {
    this.jdField_a_of_type_JavaLangObject = paramT;
    a();
  }
  
  public void a(slz<T> paramslz)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramslz)) {
        this.jdField_a_of_type_JavaUtilList.add(paramslz);
      }
      return;
    }
    finally
    {
      paramslz = finally;
      throw paramslz;
    }
  }
  
  public void b(slz<T> paramslz)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramslz);
      return;
    }
    finally
    {
      paramslz = finally;
      throw paramslz;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sly
 * JD-Core Version:    0.7.0.1
 */