package com.tencent.open.agent;

import anzj;
import bjng;
import bjod;
import bjog;
import com.tencent.open.model.GetVirtualListResult;
import com.tencent.open.model.VirtualInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OpenAuthorityFragment$12$1
  implements Runnable
{
  public OpenAuthorityFragment$12$1(bjng parambjng, boolean paramBoolean, GetVirtualListResult paramGetVirtualListResult) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_Boolean)
    {
      Iterator localIterator;
      if ((this.jdField_a_of_type_ComTencentOpenModelGetVirtualListResult != null) && (this.jdField_a_of_type_ComTencentOpenModelGetVirtualListResult.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentOpenModelGetVirtualListResult.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        localIterator = this.jdField_a_of_type_ComTencentOpenModelGetVirtualListResult.jdField_a_of_type_JavaUtilArrayList.iterator();
      }
      while (localIterator.hasNext())
      {
        Object localObject = (VirtualInfo)localIterator.next();
        if ((((VirtualInfo)localObject).b != null) && (((VirtualInfo)localObject).jdField_a_of_type_JavaLangString != null))
        {
          localObject = new bjog(((VirtualInfo)localObject).jdField_a_of_type_Long, ((VirtualInfo)localObject).jdField_a_of_type_JavaLangString, ((VirtualInfo)localObject).b);
          if ((((bjog)localObject).jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentOpenModelGetVirtualListResult.jdField_a_of_type_Long) && (OpenAuthorityFragment.a(this.jdField_a_of_type_Bjng.a).a() == 0L)) {
            ((bjog)localObject).jdField_a_of_type_Boolean = true;
          }
          localArrayList.add(localObject);
          continue;
          QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->onGetVirtualList result == null || result.list == null && result.list.size() <= 0");
        }
      }
      if ((OpenAuthorityFragment.a(this.jdField_a_of_type_Bjng.a) != null) && (OpenAuthorityFragment.a(this.jdField_a_of_type_Bjng.a).a != null))
      {
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->onGetVirtualList setData accountInfoList.size=", Integer.valueOf(localArrayList.size()) });
        OpenAuthorityFragment.a(this.jdField_a_of_type_Bjng.a).a.a(localArrayList, OpenAuthorityFragment.a(this.jdField_a_of_type_Bjng.a).getAccount());
        if (OpenAuthorityFragment.j(this.jdField_a_of_type_Bjng.a) != 0L) {
          OpenAuthorityFragment.a(this.jdField_a_of_type_Bjng.a).a.a(OpenAuthorityFragment.j(this.jdField_a_of_type_Bjng.a));
        }
        OpenAuthorityFragment.d(this.jdField_a_of_type_Bjng.a, 0L);
      }
    }
    do
    {
      return;
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->onGetVirtualList mCardContainer == null || mCardContainer.mVirtualAccountAdapter == null");
      break;
      if (this.jdField_a_of_type_ComTencentOpenModelGetVirtualListResult != null)
      {
        OpenAuthorityFragment.a(this.jdField_a_of_type_Bjng.a, anzj.a(2131706727) + this.jdField_a_of_type_ComTencentOpenModelGetVirtualListResult.jdField_a_of_type_Int, false);
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "getVirtualList error errorcode ===", Integer.valueOf(this.jdField_a_of_type_ComTencentOpenModelGetVirtualListResult.jdField_a_of_type_Int) });
      }
    } while ((OpenAuthorityFragment.a(this.jdField_a_of_type_Bjng.a) == null) || (OpenAuthorityFragment.a(this.jdField_a_of_type_Bjng.a).a == null) || ((OpenAuthorityFragment.a(this.jdField_a_of_type_Bjng.a).getAccount() != null) && (OpenAuthorityFragment.a(this.jdField_a_of_type_Bjng.a).getAccount().equals(OpenAuthorityFragment.a(this.jdField_a_of_type_Bjng.a).a.jdField_a_of_type_JavaLangString))));
    OpenAuthorityFragment.a(this.jdField_a_of_type_Bjng.a).a.a(localArrayList, OpenAuthorityFragment.a(this.jdField_a_of_type_Bjng.a).getAccount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment.12.1
 * JD-Core Version:    0.7.0.1
 */