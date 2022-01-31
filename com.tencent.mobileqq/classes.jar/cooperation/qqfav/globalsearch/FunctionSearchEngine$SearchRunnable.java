package cooperation.qqfav.globalsearch;

import aycr;
import ayij;
import aypy;
import ayql;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FunctionSearchEngine$SearchRunnable
  implements Runnable
{
  public aypy<ayij> a;
  public ayql a;
  
  protected FunctionSearchEngine$SearchRunnable(FunctionSearchEngine paramFunctionSearchEngine) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Ayql == null) || (this.jdField_a_of_type_Aypy == null)) {
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
          this.jdField_a_of_type_Aypy.a(null, 6);
          return;
        }
        localList = ((aycr)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(222)).a("" + this.jdField_a_of_type_Ayql.jdField_a_of_type_JavaLangString, FunctionSearchEngine.a(this.this$0));
        if ((localList != null) && (localList.size() != 0)) {
          break;
        }
      } while (this.jdField_a_of_type_Aypy == null);
      this.jdField_a_of_type_Aypy.a(null, 1);
      return;
      localArrayList = new ArrayList(localList.size());
      int i = 0;
      while (i < localList.size())
      {
        localArrayList.add((ayij)localList.get(i));
        i += 1;
      }
    } while (this.jdField_a_of_type_Aypy == null);
    this.jdField_a_of_type_Aypy.a(localArrayList, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FunctionSearchEngine.SearchRunnable
 * JD-Core Version:    0.7.0.1
 */