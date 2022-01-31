package cooperation.qqfav.globalsearch;

import awhn;
import awng;
import awuu;
import awuv;
import awvi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FunctionSearchEngine
  implements awuu<awng>
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
    this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable = new FunctionSearchEngine.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public List<awng> a(awvi paramawvi)
  {
    if ((paramawvi == null) || (paramawvi.jdField_a_of_type_JavaLangString == null) || (paramawvi.jdField_a_of_type_JavaLangString.trim().length() == 0)) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "search, app is null.");
      return null;
    }
    paramawvi = ((awhn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(222)).a("" + paramawvi.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if ((paramawvi == null) || (paramawvi.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramawvi.size());
    int i = 0;
    while (i < paramawvi.size())
    {
      localArrayList.add((awng)paramawvi.get(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public void a() {}
  
  public void a(awvi paramawvi, awuv<awng> paramawuv)
  {
    if ((paramawvi == null) || (paramawvi.jdField_a_of_type_JavaLangString == null) || (paramawvi.jdField_a_of_type_JavaLangString.trim().length() == 0)) {
      return;
    }
    synchronized (this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable.jdField_a_of_type_Awvi = paramawvi;
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable.jdField_a_of_type_Awuv = paramawuv;
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable, 32);
      ThreadManager.excute(this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable, 32, null, false);
      return;
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable.jdField_a_of_type_Awvi = null;
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable.jdField_a_of_type_Awuv = null;
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable, 32);
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