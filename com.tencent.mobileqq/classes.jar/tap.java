import com.tencent.mobileqq.app.BaseActivity;
import java.util.LinkedList;

public class tap
{
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private LinkedList<tar> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  public tap(BaseActivity paramBaseActivity)
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
  
  public tar a()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
      return null;
    }
    return (tar)this.jdField_a_of_type_JavaUtilLinkedList.pop();
  }
  
  public void a(taq paramtaq)
  {
    if (paramtaq == null) {}
    for (;;)
    {
      return;
      while (!a())
      {
        tar localtar = a();
        if (localtar != null) {
          paramtaq.a(localtar);
        }
      }
    }
  }
  
  public void a(tar paramtar)
  {
    this.jdField_a_of_type_JavaUtilLinkedList.push(paramtar);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedList.isEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tap
 * JD-Core Version:    0.7.0.1
 */