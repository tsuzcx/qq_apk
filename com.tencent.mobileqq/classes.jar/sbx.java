import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class sbx
  implements bclw<bcfj>, bclx<bcfj>
{
  private bclx<bcfj> jdField_a_of_type_Bclx;
  private List<bclw> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<bcfj> b = new ArrayList();
  
  public sbx(List<bclw> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public List<bcfj> a(bcmk parambcmk)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((bclw)localIterator.next()).a(parambcmk));
    }
    return localArrayList;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bclw)localIterator.next()).a();
    }
  }
  
  public void a(bcmk parambcmk, bclx<bcfj> parambclx)
  {
    this.b.clear();
    this.jdField_a_of_type_Bclx = parambclx;
    parambclx = this.jdField_a_of_type_JavaUtilList.iterator();
    while (parambclx.hasNext()) {
      ((bclw)parambclx.next()).a(parambcmk, this);
    }
  }
  
  public void a(List<bcfj> paramList)
  {
    if (this.jdField_a_of_type_Bclx != null) {
      this.jdField_a_of_type_Bclx.a(paramList);
    }
  }
  
  public void a(List<bcfj> paramList, int paramInt)
  {
    this.b.addAll(paramList);
    if (this.jdField_a_of_type_Bclx != null) {
      this.jdField_a_of_type_Bclx.a(this.b, paramInt);
    }
  }
  
  public void a(List<bcfj> paramList, bcml parambcml)
  {
    a(paramList, parambcml.a);
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bclw)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bclw)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bclw)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bclw)localIterator.next()).e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sbx
 * JD-Core Version:    0.7.0.1
 */