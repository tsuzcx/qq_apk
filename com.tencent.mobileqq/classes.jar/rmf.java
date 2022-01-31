import com.tencent.mobileqq.app.BaseActivity;
import java.util.LinkedList;

public class rmf
{
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private LinkedList<rmh> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  public rmf(BaseActivity paramBaseActivity)
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
  
  public rmh a()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
      return null;
    }
    return (rmh)this.jdField_a_of_type_JavaUtilLinkedList.pop();
  }
  
  public void a(rmg paramrmg)
  {
    if (paramrmg == null) {}
    for (;;)
    {
      return;
      while (!a())
      {
        rmh localrmh = a();
        if (localrmh != null) {
          paramrmg.a(localrmh);
        }
      }
    }
  }
  
  public void a(rmh paramrmh)
  {
    this.jdField_a_of_type_JavaUtilLinkedList.push(paramrmh);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedList.isEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rmf
 * JD-Core Version:    0.7.0.1
 */