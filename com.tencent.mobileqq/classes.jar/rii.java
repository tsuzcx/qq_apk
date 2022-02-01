import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rii
  implements bcmc<bcfr>, bcmd<bcfr>
{
  private bcmd<bcfr> jdField_a_of_type_Bcmd;
  private List<bcmc> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<bcfr> b = new ArrayList();
  
  public rii(List<bcmc> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public List<bcfr> a(bcmq parambcmq)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((bcmc)localIterator.next()).a(parambcmq));
    }
    return localArrayList;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bcmc)localIterator.next()).a();
    }
  }
  
  public void a(bcmq parambcmq, bcmd<bcfr> parambcmd)
  {
    this.b.clear();
    this.jdField_a_of_type_Bcmd = parambcmd;
    parambcmd = this.jdField_a_of_type_JavaUtilList.iterator();
    while (parambcmd.hasNext()) {
      ((bcmc)parambcmd.next()).a(parambcmq, this);
    }
  }
  
  public void a(List<bcfr> paramList)
  {
    if (this.jdField_a_of_type_Bcmd != null) {
      this.jdField_a_of_type_Bcmd.a(paramList);
    }
  }
  
  public void a(List<bcfr> paramList, int paramInt)
  {
    this.b.addAll(paramList);
    if (this.jdField_a_of_type_Bcmd != null) {
      this.jdField_a_of_type_Bcmd.a(this.b, paramInt);
    }
  }
  
  public void a(List<bcfr> paramList, bcmr parambcmr)
  {
    a(paramList, parambcmr.a);
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bcmc)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bcmc)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bcmc)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bcmc)localIterator.next()).e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rii
 * JD-Core Version:    0.7.0.1
 */