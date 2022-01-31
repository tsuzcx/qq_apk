package cooperation.qqfav.globalsearch;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.FunctionModuleConfigManager;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FunctionSearchEngine$SearchRunnable
  implements Runnable
{
  public ISearchListener a;
  public SearchRequest a;
  
  public FunctionSearchEngine$SearchRunnable(FunctionSearchEngine paramFunctionSearchEngine) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener == null)) {
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
        if (this.b.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
        {
          QLog.e(FunctionSearchEngine.jdField_a_of_type_JavaLangString, 1, "mSearchRunnable.run, app is null.");
          this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(null, 6);
          return;
        }
        localList = ((FunctionModuleConfigManager)this.b.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(221)).a("" + this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest.jdField_a_of_type_JavaLangString, FunctionSearchEngine.a(this.b));
        if ((localList != null) && (localList.size() != 0)) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener == null);
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(null, 1);
      return;
      localArrayList = new ArrayList(localList.size());
      int i = 0;
      while (i < localList.size())
      {
        localArrayList.add((GroupBaseNetSearchModelItem)localList.get(i));
        i += 1;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener == null);
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener.a(localArrayList, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FunctionSearchEngine.SearchRunnable
 * JD-Core Version:    0.7.0.1
 */