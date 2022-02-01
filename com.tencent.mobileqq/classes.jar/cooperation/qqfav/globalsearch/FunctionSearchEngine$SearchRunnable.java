package cooperation.qqfav.globalsearch;

import bbyb;
import bcep;
import bcmd;
import bcmq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FunctionSearchEngine$SearchRunnable
  implements Runnable
{
  public bcmd<bcep> a;
  public bcmq a;
  
  protected FunctionSearchEngine$SearchRunnable(FunctionSearchEngine paramFunctionSearchEngine) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Bcmq == null) || (this.jdField_a_of_type_Bcmd == null)) {
      if (QLog.isColorLevel()) {
        QLog.e(FunctionSearchEngine.jdField_a_of_type_JavaLangString, 2, "mSearchRunnable.run, innerSearchRequest == null or innerListener == null");
      }
    }
    ArrayList localArrayList;
    do
    {
      List localList;
      do
      {
        return;
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
        {
          QLog.e(FunctionSearchEngine.jdField_a_of_type_JavaLangString, 1, "mSearchRunnable.run, app is null.");
          this.jdField_a_of_type_Bcmd.a(null, 6);
          return;
        }
        localList = ((bbyb)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(222)).a("" + this.jdField_a_of_type_Bcmq.jdField_a_of_type_JavaLangString, FunctionSearchEngine.a(this.this$0));
        if ((localList != null) && (localList.size() != 0)) {
          break;
        }
      } while (this.jdField_a_of_type_Bcmd == null);
      this.jdField_a_of_type_Bcmd.a(null, 1);
      return;
      localArrayList = new ArrayList(localList.size());
      int i = 0;
      while (i < localList.size())
      {
        localArrayList.add((bcep)localList.get(i));
        i += 1;
      }
    } while (this.jdField_a_of_type_Bcmd == null);
    this.jdField_a_of_type_Bcmd.a(localArrayList, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FunctionSearchEngine.SearchRunnable
 * JD-Core Version:    0.7.0.1
 */