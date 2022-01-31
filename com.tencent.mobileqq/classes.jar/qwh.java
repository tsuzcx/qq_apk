import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qwh
  implements ayug<aynu>, ayuh<aynu>
{
  private ayuh<aynu> jdField_a_of_type_Ayuh;
  private List<ayug> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<aynu> b = new ArrayList();
  
  public qwh(List<ayug> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public List<aynu> a(ayuu paramayuu)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((ayug)localIterator.next()).a(paramayuu));
    }
    return localArrayList;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ayug)localIterator.next()).a();
    }
  }
  
  public void a(ayuu paramayuu, ayuh<aynu> paramayuh)
  {
    this.b.clear();
    this.jdField_a_of_type_Ayuh = paramayuh;
    paramayuh = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramayuh.hasNext()) {
      ((ayug)paramayuh.next()).a(paramayuu, this);
    }
  }
  
  public void a(List<aynu> paramList)
  {
    if (this.jdField_a_of_type_Ayuh != null) {
      this.jdField_a_of_type_Ayuh.a(paramList);
    }
  }
  
  public void a(List<aynu> paramList, int paramInt)
  {
    this.b.addAll(paramList);
    if (this.jdField_a_of_type_Ayuh != null) {
      this.jdField_a_of_type_Ayuh.a(this.b, paramInt);
    }
  }
  
  public void a(List<aynu> paramList, ayuv paramayuv)
  {
    a(paramList, paramayuv.a);
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ayug)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ayug)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ayug)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ayug)localIterator.next()).e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qwh
 * JD-Core Version:    0.7.0.1
 */