import com.tencent.mobileqq.app.BaseActivity;
import java.util.LinkedList;

public class scb
{
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private LinkedList<scd> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  public scb(BaseActivity paramBaseActivity)
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
  
  public scd a()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
      return null;
    }
    return (scd)this.jdField_a_of_type_JavaUtilLinkedList.pop();
  }
  
  public void a(scc paramscc)
  {
    if (paramscc == null) {}
    for (;;)
    {
      return;
      while (!a())
      {
        scd localscd = a();
        if (localscd != null) {
          paramscc.a(localscd);
        }
      }
    }
  }
  
  public void a(scd paramscd)
  {
    this.jdField_a_of_type_JavaUtilLinkedList.push(paramscd);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedList.isEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     scb
 * JD-Core Version:    0.7.0.1
 */