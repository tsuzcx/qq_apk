package cooperation.qqfav.globalsearch;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.search.FunctionModuleConfigManager;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FunctionSearchEngine$SearchRunnable
  implements Runnable
{
  public ISearchListener<GroupBaseNetSearchModelItem> a;
  public SearchRequest a;
  
  protected FunctionSearchEngine$SearchRunnable(FunctionSearchEngine paramFunctionSearchEngine) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest != null) && (this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener != null))
    {
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
      {
        QLog.e(FunctionSearchEngine.jdField_a_of_type_JavaLangString, 1, "mSearchRunnable.run, app is null.");
        this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener.a(null, 6);
        return;
      }
      Object localObject1 = (FunctionModuleConfigManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FUNCTION_MODULE_MANAGER);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest.jdField_a_of_type_JavaLangString);
      localObject2 = ((FunctionModuleConfigManager)localObject1).a(((StringBuilder)localObject2).toString(), FunctionSearchEngine.a(this.this$0));
      if ((localObject2 != null) && (((List)localObject2).size() != 0))
      {
        localObject1 = new ArrayList(((List)localObject2).size());
        int i = 0;
        while (i < ((List)localObject2).size())
        {
          ((List)localObject1).add((GroupBaseNetSearchModelItem)((List)localObject2).get(i));
          i += 1;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener;
        if (localObject2 != null) {
          ((ISearchListener)localObject2).a((List)localObject1, 1);
        }
      }
      else
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener;
        if (localObject1 != null) {
          ((ISearchListener)localObject1).a(null, 1);
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(FunctionSearchEngine.jdField_a_of_type_JavaLangString, 2, "mSearchRunnable.run, innerSearchRequest == null or innerListener == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FunctionSearchEngine.SearchRunnable
 * JD-Core Version:    0.7.0.1
 */