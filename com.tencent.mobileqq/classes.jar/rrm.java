import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rrm
  implements bbtj<bbmy>, bbtk<bbmy>
{
  private bbtk<bbmy> jdField_a_of_type_Bbtk;
  private List<bbtj> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<bbmy> b = new ArrayList();
  
  public rrm(List<bbtj> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public List<bbmy> a(bbtx parambbtx)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((bbtj)localIterator.next()).a(parambbtx));
    }
    return localArrayList;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bbtj)localIterator.next()).a();
    }
  }
  
  public void a(bbtx parambbtx, bbtk<bbmy> parambbtk)
  {
    this.b.clear();
    this.jdField_a_of_type_Bbtk = parambbtk;
    parambbtk = this.jdField_a_of_type_JavaUtilList.iterator();
    while (parambbtk.hasNext()) {
      ((bbtj)parambbtk.next()).a(parambbtx, this);
    }
  }
  
  public void a(List<bbmy> paramList)
  {
    if (this.jdField_a_of_type_Bbtk != null) {
      this.jdField_a_of_type_Bbtk.a(paramList);
    }
  }
  
  public void a(List<bbmy> paramList, int paramInt)
  {
    this.b.addAll(paramList);
    if (this.jdField_a_of_type_Bbtk != null) {
      this.jdField_a_of_type_Bbtk.a(this.b, paramInt);
    }
  }
  
  public void a(List<bbmy> paramList, bbty parambbty)
  {
    a(paramList, parambbty.a);
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bbtj)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bbtj)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bbtj)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bbtj)localIterator.next()).e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rrm
 * JD-Core Version:    0.7.0.1
 */