import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pwh
  implements avuz<avon>, avva<avon>
{
  private avva<avon> jdField_a_of_type_Avva;
  private List<avuz> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<avon> b = new ArrayList();
  
  public pwh(List<avuz> paramList)
  {
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public List<avon> a(avvn paramavvn)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((avuz)localIterator.next()).a(paramavvn));
    }
    return localArrayList;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((avuz)localIterator.next()).a();
    }
  }
  
  public void a(avvn paramavvn, avva<avon> paramavva)
  {
    this.b.clear();
    this.jdField_a_of_type_Avva = paramavva;
    paramavva = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramavva.hasNext()) {
      ((avuz)paramavva.next()).a(paramavvn, this);
    }
  }
  
  public void a(List<avon> paramList)
  {
    if (this.jdField_a_of_type_Avva != null) {
      this.jdField_a_of_type_Avva.a(paramList);
    }
  }
  
  public void a(List<avon> paramList, int paramInt)
  {
    this.b.addAll(paramList);
    if (this.jdField_a_of_type_Avva != null) {
      this.jdField_a_of_type_Avva.a(this.b, paramInt);
    }
  }
  
  public void a(List<avon> paramList, avvo paramavvo)
  {
    a(paramList, paramavvo.a);
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((avuz)localIterator.next()).b();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((avuz)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((avuz)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((avuz)localIterator.next()).e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pwh
 * JD-Core Version:    0.7.0.1
 */