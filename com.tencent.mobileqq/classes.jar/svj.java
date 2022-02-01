import com.tencent.mobileqq.app.BaseActivity;
import java.util.LinkedList;

public class svj
{
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private LinkedList<svl> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  public svj(BaseActivity paramBaseActivity)
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
  
  public svl a()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
      return null;
    }
    return (svl)this.jdField_a_of_type_JavaUtilLinkedList.pop();
  }
  
  public void a(svk paramsvk)
  {
    if (paramsvk == null) {}
    for (;;)
    {
      return;
      while (!a())
      {
        svl localsvl = a();
        if (localsvl != null) {
          paramsvk.a(localsvl);
        }
      }
    }
  }
  
  public void a(svl paramsvl)
  {
    this.jdField_a_of_type_JavaUtilLinkedList.push(paramsvl);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedList.isEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     svj
 * JD-Core Version:    0.7.0.1
 */