import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qif
  implements awus<awog>, awut<awog>
{
  private awut<awog> jdField_a_of_type_Awut;
  private List<awus> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<awog> b = new ArrayList();
  
  public qif(List<awus> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public List<awog> a(awvg paramawvg)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((awus)localIterator.next()).a(paramawvg));
    }
    return localArrayList;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((awus)localIterator.next()).a();
    }
  }
  
  public void a(awvg paramawvg, awut<awog> paramawut)
  {
    this.b.clear();
    this.jdField_a_of_type_Awut = paramawut;
    paramawut = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramawut.hasNext()) {
      ((awus)paramawut.next()).a(paramawvg, this);
    }
  }
  
  public void a(List<awog> paramList)
  {
    if (this.jdField_a_of_type_Awut != null) {
      this.jdField_a_of_type_Awut.a(paramList);
    }
  }
  
  public void a(List<awog> paramList, int paramInt)
  {
    this.b.addAll(paramList);
    if (this.jdField_a_of_type_Awut != null) {
      this.jdField_a_of_type_Awut.a(this.b, paramInt);
    }
  }
  
  public void a(List<awog> paramList, awvh paramawvh)
  {
    a(paramList, paramawvh.a);
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((awus)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((awus)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((awus)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((awus)localIterator.next()).e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qif
 * JD-Core Version:    0.7.0.1
 */