import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.AppInfo;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class rbk
  implements Runnable
{
  public rbk(DoraemonAPIManager paramDoraemonAPIManager, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    Object[] arrayOfObject;
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a().b == 1)
      {
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          arrayOfObject = (Object[])localIterator.next();
          this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a((String)arrayOfObject[0], (APIParam)arrayOfObject[1], (APICallback)arrayOfObject[2]);
        }
      }
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        arrayOfObject = (Object[])localIterator.next();
        QLog.i("DoraemonOpenAPI.apiMgr", 1, "app not online, api=" + arrayOfObject[0]);
        DoraemonUtil.a((APICallback)arrayOfObject[2], 9);
      }
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      arrayOfObject = (Object[])localIterator.next();
      QLog.i("DoraemonOpenAPI.apiMgr", 1, "network error, api=" + arrayOfObject[0]);
      DoraemonUtil.a((APICallback)arrayOfObject[2], 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     rbk
 * JD-Core Version:    0.7.0.1
 */