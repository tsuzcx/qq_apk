package cooperation.qqfav.globalsearch;

import bbyb;
import bcep;
import bcmc;
import bcmd;
import bcmq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class FunctionSearchEngine
  implements bcmc<bcep>
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
  
  public List<bcep> a(bcmq parambcmq)
  {
    if ((parambcmq == null) || (parambcmq.jdField_a_of_type_JavaLangString == null) || (parambcmq.jdField_a_of_type_JavaLangString.trim().length() == 0)) {
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "search, app is null.");
      return null;
    }
    parambcmq = ((bbyb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(222)).a("" + parambcmq.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if ((parambcmq == null) || (parambcmq.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(parambcmq.size());
    int i = 0;
    while (i < parambcmq.size())
    {
      localArrayList.add((bcep)parambcmq.get(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public void a() {}
  
  public void a(bcmq parambcmq, bcmd<bcep> parambcmd)
  {
    if ((parambcmq == null) || (parambcmq.jdField_a_of_type_JavaLangString == null) || (parambcmq.jdField_a_of_type_JavaLangString.trim().length() == 0)) {
      return;
    }
    synchronized (this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable.jdField_a_of_type_Bcmq = parambcmq;
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable.jdField_a_of_type_Bcmd = parambcmd;
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable, 32);
      ThreadManager.excute(this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable, 32, null, false);
      return;
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable.jdField_a_of_type_Bcmq = null;
      this.jdField_a_of_type_CooperationQqfavGlobalsearchFunctionSearchEngine$SearchRunnable.jdField_a_of_type_Bcmd = null;
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