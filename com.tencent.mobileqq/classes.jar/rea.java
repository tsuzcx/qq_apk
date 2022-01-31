import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import java.util.Iterator;
import java.util.List;

public class rea
  implements Runnable
{
  public rea(DoraemonAPIManager paramDoraemonAPIManager, List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Object[] arrayOfObject = (Object[])localIterator.next();
      DoraemonAPIManager.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager, (String)arrayOfObject[0], (APIParam)arrayOfObject[1], (APICallback)arrayOfObject[2]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rea
 * JD-Core Version:    0.7.0.1
 */