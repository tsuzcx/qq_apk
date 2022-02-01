import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rpi
  implements bbfe<bayt>, bbff<bayt>
{
  private bbff<bayt> jdField_a_of_type_Bbff;
  private List<bbfe> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<bayt> b = new ArrayList();
  
  public rpi(List<bbfe> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public List<bayt> a(bbfs parambbfs)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((bbfe)localIterator.next()).a(parambbfs));
    }
    return localArrayList;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bbfe)localIterator.next()).a();
    }
  }
  
  public void a(bbfs parambbfs, bbff<bayt> parambbff)
  {
    this.b.clear();
    this.jdField_a_of_type_Bbff = parambbff;
    parambbff = this.jdField_a_of_type_JavaUtilList.iterator();
    while (parambbff.hasNext()) {
      ((bbfe)parambbff.next()).a(parambbfs, this);
    }
  }
  
  public void a(List<bayt> paramList)
  {
    if (this.jdField_a_of_type_Bbff != null) {
      this.jdField_a_of_type_Bbff.a(paramList);
    }
  }
  
  public void a(List<bayt> paramList, int paramInt)
  {
    this.b.addAll(paramList);
    if (this.jdField_a_of_type_Bbff != null) {
      this.jdField_a_of_type_Bbff.a(this.b, paramInt);
    }
  }
  
  public void a(List<bayt> paramList, bbft parambbft)
  {
    a(paramList, parambbft.a);
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bbfe)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bbfe)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bbfe)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bbfe)localIterator.next()).e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rpi
 * JD-Core Version:    0.7.0.1
 */