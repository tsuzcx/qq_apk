package cooperation.qqfav.globalsearch;

import ampk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.FunctionModuleConfigManager;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchListener;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FunctionSearchEngine
  implements ISearchEngine
{
  public static final String a;
  private int a;
  protected QQAppInterface a;
  protected FunctionSearchEngine.SearchRunnable a;
  
  static
  {
    jdField_a_of_type_JavaLangString = FunctionSearchEngine.class.getSimpleName();
  }
  
  public FunctionSearchEngine(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable = new ampk(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public List a(SearchRequest paramSearchRequest)
  {
    if ((paramSearchRequest == null) || (paramSearchRequest.jdField_a_of_type_JavaLangString == null) || (paramSearchRequest.jdField_a_of_type_JavaLangString.trim().length() == 0)) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "search, app is null.");
      return null;
    }
    paramSearchRequest = ((FunctionModuleConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(221)).a("" + paramSearchRequest.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if ((paramSearchRequest == null) || (paramSearchRequest.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramSearchRequest.size());
    int i = 0;
    while (i < paramSearchRequest.size())
    {
      localArrayList.add((GroupBaseNetSearchModelItem)paramSearchRequest.get(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public void a() {}
  
  public void a(SearchRequest paramSearchRequest, ISearchListener paramISearchListener)
  {
    if ((paramSearchRequest == null) || (paramSearchRequest.jdField_a_of_type_JavaLangString == null) || (paramSearchRequest.jdField_a_of_type_JavaLangString.trim().length() == 0)) {
      return;
    }
    synchronized (this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest = paramSearchRequest;
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener = paramISearchListener;
      ThreadManager.remove(this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable);
      ThreadManager.postImmediately(this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable, null, false);
      return;
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable.jdField_a_of_type_ComTencentMobileqqSearchSearchengineSearchRequest = null;
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchListener = null;
      ThreadManager.remove(this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable);
      return;
    }
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FunctionSearchEngine
 * JD-Core Version:    0.7.0.1
 */