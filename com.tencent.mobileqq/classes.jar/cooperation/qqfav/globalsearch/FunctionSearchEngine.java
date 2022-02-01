package cooperation.qqfav.globalsearch;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.FunctionModuleConfigManager;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FunctionSearchEngine
  implements ISearchEngine<GroupBaseNetSearchModelItem>
{
  public static final String a = "FunctionSearchEngine";
  private int a;
  protected QQAppInterface a;
  protected FunctionSearchEngine.SearchRunnable a;
  
  public FunctionSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable = new FunctionSearchEngine.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public List<GroupBaseNetSearchModelItem> a(SearchRequest paramSearchRequest)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramSearchRequest != null)
    {
      localObject1 = localObject2;
      if (paramSearchRequest.jdField_a_of_type_JavaLangString != null)
      {
        if (paramSearchRequest.jdField_a_of_type_JavaLangString.trim().length() == 0) {
          return null;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (localObject1 == null)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "search, app is null.");
          return null;
        }
        localObject1 = (FunctionModuleConfigManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.FUNCTION_MODULE_MANAGER);
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(paramSearchRequest.jdField_a_of_type_JavaLangString);
        localObject3 = ((FunctionModuleConfigManager)localObject1).a(((StringBuilder)localObject3).toString(), this.jdField_a_of_type_Int);
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          if (((List)localObject3).size() == 0) {
            return null;
          }
          paramSearchRequest = new ArrayList(((List)localObject3).size());
          int i = 0;
          for (;;)
          {
            localObject1 = paramSearchRequest;
            if (i >= ((List)localObject3).size()) {
              break;
            }
            paramSearchRequest.add((GroupBaseNetSearchModelItem)((List)localObject3).get(i));
            i += 1;
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null) {
      FunctionModuleConfigManager.a(localQQAppInterface);
    }
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener<GroupBaseNetSearchModelItem> paramISearchListener)
  {
    if ((paramSearchRequest != null) && (paramSearchRequest.jdField_a_of_type_JavaLangString != null))
    {
      if (paramSearchRequest.jdField_a_of_type_JavaLangString.trim().length() == 0) {
        return;
      }
      synchronized (this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable)
      {
        this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest = paramSearchRequest;
        this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener = paramISearchListener;
        ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable, 32);
        ThreadManager.excute(this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable, 32, null, false);
        return;
      }
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest = null;
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener = null;
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable, 32);
      return;
    }
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FunctionSearchEngine
 * JD-Core Version:    0.7.0.1
 */