import com.tencent.mobileqq.app.BaseActivity;
import java.util.LinkedList;

public class qzq
{
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private LinkedList<qzs> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  public qzq(BaseActivity paramBaseActivity)
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
  
  public qzs a()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
      return null;
    }
    return (qzs)this.jdField_a_of_type_JavaUtilLinkedList.pop();
  }
  
  public void a(qzr paramqzr)
  {
    if (paramqzr == null) {}
    for (;;)
    {
      return;
      while (!a())
      {
        qzs localqzs = a();
        if (localqzs != null) {
          paramqzr.a(localqzs);
        }
      }
    }
  }
  
  public void a(qzs paramqzs)
  {
    this.jdField_a_of_type_JavaUtilLinkedList.push(paramqzs);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilLinkedList.isEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qzq
 * JD-Core Version:    0.7.0.1
 */