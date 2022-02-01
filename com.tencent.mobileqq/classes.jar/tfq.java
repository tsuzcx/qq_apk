import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tfq<T>
{
  private T jdField_a_of_type_JavaLangObject;
  private List<tfr<T>> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public tfq(T paramT)
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
        ((tfr)localIterator.next()).a(this);
      }
    }
    finally {}
  }
  
  public void a(T paramT)
  {
    this.jdField_a_of_type_JavaLangObject = paramT;
    a();
  }
  
  public void a(tfr<T> paramtfr)
  {
    try
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramtfr)) {
        this.jdField_a_of_type_JavaUtilList.add(paramtfr);
      }
      return;
    }
    finally
    {
      paramtfr = finally;
      throw paramtfr;
    }
  }
  
  public void b(tfr<T> paramtfr)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramtfr);
      return;
    }
    finally
    {
      paramtfr = finally;
      throw paramtfr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tfq
 * JD-Core Version:    0.7.0.1
 */