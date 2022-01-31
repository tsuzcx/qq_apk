import com.tencent.mobileqq.app.BaseActivity;
import java.util.LinkedList;

public class rmi
{
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private LinkedList<rmk> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  public rmi(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilLinkedList.size();
  }
  
  public rmk a()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
      return null;
    }
    return (rmk)this.jdField_a_of_type_JavaUtilLinkedList.pop();
  }
  
  public void a(rmj paramrmj)
  {
    if (paramrmj == null) {}
    for (;;)
    {
      return;
      while (!a())
      {
        rmk localrmk = a();
        if (localrmk != null) {
          paramrmj.a(localrmk);
        }
      }
    }
  }
  
  public void a(rmk paramrmk)
  {
    this.jdField_a_of_type_JavaUtilLinkedList.push(paramrmk);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedList.isEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rmi
 * JD-Core Version:    0.7.0.1
 */