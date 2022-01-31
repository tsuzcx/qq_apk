import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qic
  implements awuu<awoi>, awuv<awoi>
{
  private awuv<awoi> jdField_a_of_type_Awuv;
  private List<awuu> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<awoi> b = new ArrayList();
  
  public qic(List<awuu> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public List<awoi> a(awvi paramawvi)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((awuu)localIterator.next()).a(paramawvi));
    }
    return localArrayList;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((awuu)localIterator.next()).a();
    }
  }
  
  public void a(awvi paramawvi, awuv<awoi> paramawuv)
  {
    this.b.clear();
    this.jdField_a_of_type_Awuv = paramawuv;
    paramawuv = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramawuv.hasNext()) {
      ((awuu)paramawuv.next()).a(paramawvi, this);
    }
  }
  
  public void a(List<awoi> paramList)
  {
    if (this.jdField_a_of_type_Awuv != null) {
      this.jdField_a_of_type_Awuv.a(paramList);
    }
  }
  
  public void a(List<awoi> paramList, int paramInt)
  {
    this.b.addAll(paramList);
    if (this.jdField_a_of_type_Awuv != null) {
      this.jdField_a_of_type_Awuv.a(this.b, paramInt);
    }
  }
  
  public void a(List<awoi> paramList, awvj paramawvj)
  {
    a(paramList, paramawvj.a);
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((awuu)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((awuu)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((awuu)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((awuu)localIterator.next()).e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qic
 * JD-Core Version:    0.7.0.1
 */