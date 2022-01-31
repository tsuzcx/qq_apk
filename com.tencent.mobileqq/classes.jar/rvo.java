import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rvo<T>
{
  private T jdField_a_of_type_JavaLangObject;
  private List<rvp<T>> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public rvo(T paramT)
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
        ((rvp)localIterator.next()).a(this);
      }
    }
    finally {}
  }
  
  public void a(T paramT)
  {
    this.jdField_a_of_type_JavaLangObject = paramT;
    a();
  }
  
  public void a(rvp<T> paramrvp)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramrvp)) {
        this.jdField_a_of_type_JavaUtilList.add(paramrvp);
      }
      return;
    }
    finally
    {
      paramrvp = finally;
      throw paramrvp;
    }
  }
  
  public void b(rvp<T> paramrvp)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramrvp);
      return;
    }
    finally
    {
      paramrvp = finally;
      throw paramrvp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rvo
 * JD-Core Version:    0.7.0.1
 */