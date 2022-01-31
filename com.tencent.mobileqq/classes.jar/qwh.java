import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qwh
  implements aypx<ayjl>, aypy<ayjl>
{
  private aypy<ayjl> jdField_a_of_type_Aypy;
  private List<aypx> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<ayjl> b = new ArrayList();
  
  public qwh(List<aypx> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public List<ayjl> a(ayql paramayql)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((aypx)localIterator.next()).a(paramayql));
    }
    return localArrayList;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((aypx)localIterator.next()).a();
    }
  }
  
  public void a(ayql paramayql, aypy<ayjl> paramaypy)
  {
    this.b.clear();
    this.jdField_a_of_type_Aypy = paramaypy;
    paramaypy = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramaypy.hasNext()) {
      ((aypx)paramaypy.next()).a(paramayql, this);
    }
  }
  
  public void a(List<ayjl> paramList)
  {
    if (this.jdField_a_of_type_Aypy != null) {
      this.jdField_a_of_type_Aypy.a(paramList);
    }
  }
  
  public void a(List<ayjl> paramList, int paramInt)
  {
    this.b.addAll(paramList);
    if (this.jdField_a_of_type_Aypy != null) {
      this.jdField_a_of_type_Aypy.a(this.b, paramInt);
    }
  }
  
  public void a(List<ayjl> paramList, ayqm paramayqm)
  {
    a(paramList, paramayqm.a);
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((aypx)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((aypx)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((aypx)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((aypx)localIterator.next()).e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qwh
 * JD-Core Version:    0.7.0.1
 */