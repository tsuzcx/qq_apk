import com.tencent.mobileqq.app.BaseActivity;
import java.util.LinkedList;

public class srl
{
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private LinkedList<srn> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  public srl(BaseActivity paramBaseActivity)
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
  
  public srn a()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
      return null;
    }
    return (srn)this.jdField_a_of_type_JavaUtilLinkedList.pop();
  }
  
  public void a(srm paramsrm)
  {
    if (paramsrm == null) {}
    for (;;)
    {
      return;
      while (!a())
      {
        srn localsrn = a();
        if (localsrn != null) {
          paramsrm.a(localsrn);
        }
      }
    }
  }
  
  public void a(srn paramsrn)
  {
    this.jdField_a_of_type_JavaUtilLinkedList.push(paramsrn);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedList.isEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     srl
 * JD-Core Version:    0.7.0.1
 */