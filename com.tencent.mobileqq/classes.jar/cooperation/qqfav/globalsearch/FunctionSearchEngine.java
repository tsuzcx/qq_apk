package cooperation.qqfav.globalsearch;

import bbyl;
import bceh;
import bclw;
import bclx;
import bcmk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FunctionSearchEngine
  implements bclw<bceh>
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
  
  public List<bceh> a(bcmk parambcmk)
  {
    if ((parambcmk == null) || (parambcmk.jdField_a_of_type_JavaLangString == null) || (parambcmk.jdField_a_of_type_JavaLangString.trim().length() == 0)) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "search, app is null.");
      return null;
    }
    parambcmk = ((bbyl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FUNCTION_MODULE_MANAGER)).a("" + parambcmk.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if ((parambcmk == null) || (parambcmk.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(parambcmk.size());
    int i = 0;
    while (i < parambcmk.size())
    {
      localArrayList.add((bceh)parambcmk.get(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public void a() {}
  
  public void a(bcmk parambcmk, bclx<bceh> parambclx)
  {
    if ((parambcmk == null) || (parambcmk.jdField_a_of_type_JavaLangString == null) || (parambcmk.jdField_a_of_type_JavaLangString.trim().length() == 0)) {
      return;
    }
    synchronized (this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable.jdField_a_of_type_Bcmk = parambcmk;
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable.jdField_a_of_type_Bclx = parambclx;
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable, 32);
      ThreadManager.excute(this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable, 32, null, false);
      return;
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable.jdField_a_of_type_Bcmk = null;
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable.jdField_a_of_type_Bclx = null;
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable, 32);
      return;
    }
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqfav.globalsearch.FunctionSearchEngine
 * JD-Core Version:    0.7.0.1
 */