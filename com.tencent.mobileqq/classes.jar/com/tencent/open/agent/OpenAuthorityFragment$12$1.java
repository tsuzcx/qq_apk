package com.tencent.open.agent;

import anni;
import bimh;
import bine;
import binh;
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
  public OpenAuthorityFragment$12$1(bimh parambimh, boolean paramBoolean, GetVirtualListResult paramGetVirtualListResult) {}
  
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
          localObject = new binh(((VirtualInfo)localObject).jdField_a_of_type_Long, ((VirtualInfo)localObject).jdField_a_of_type_JavaLangString, ((VirtualInfo)localObject).b);
          if ((((binh)localObject).jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentOpenModelGetVirtualListResult.jdField_a_of_type_Long) && (OpenAuthorityFragment.a(this.jdField_a_of_type_Bimh.a).a() == 0L)) {
            ((binh)localObject).jdField_a_of_type_Boolean = true;
          }
          localArrayList.add(localObject);
          continue;
          QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->onGetVirtualList result == null || result.list == null && result.list.size() <= 0");
        }
      }
      if ((OpenAuthorityFragment.a(this.jdField_a_of_type_Bimh.a) != null) && (OpenAuthorityFragment.a(this.jdField_a_of_type_Bimh.a).a != null))
      {
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "-->onGetVirtualList setData accountInfoList.size=", Integer.valueOf(localArrayList.size()) });
        OpenAuthorityFragment.a(this.jdField_a_of_type_Bimh.a).a.a(localArrayList, OpenAuthorityFragment.a(this.jdField_a_of_type_Bimh.a).getAccount());
        if (OpenAuthorityFragment.j(this.jdField_a_of_type_Bimh.a) != 0L) {
          OpenAuthorityFragment.a(this.jdField_a_of_type_Bimh.a).a.a(OpenAuthorityFragment.j(this.jdField_a_of_type_Bimh.a));
        }
        OpenAuthorityFragment.d(this.jdField_a_of_type_Bimh.a, 0L);
      }
    }
    do
    {
      return;
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "-->onGetVirtualList mCardContainer == null || mCardContainer.mVirtualAccountAdapter == null");
      break;
      if (this.jdField_a_of_type_ComTencentOpenModelGetVirtualListResult != null)
      {
        OpenAuthorityFragment.a(this.jdField_a_of_type_Bimh.a, anni.a(2131706620) + this.jdField_a_of_type_ComTencentOpenModelGetVirtualListResult.jdField_a_of_type_Int, false);
        QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "getVirtualList error errorcode ===", Integer.valueOf(this.jdField_a_of_type_ComTencentOpenModelGetVirtualListResult.jdField_a_of_type_Int) });
      }
    } while ((OpenAuthorityFragment.a(this.jdField_a_of_type_Bimh.a) == null) || (OpenAuthorityFragment.a(this.jdField_a_of_type_Bimh.a).a == null) || ((OpenAuthorityFragment.a(this.jdField_a_of_type_Bimh.a).getAccount() != null) && (OpenAuthorityFragment.a(this.jdField_a_of_type_Bimh.a).getAccount().equals(OpenAuthorityFragment.a(this.jdField_a_of_type_Bimh.a).a.jdField_a_of_type_JavaLangString))));
    OpenAuthorityFragment.a(this.jdField_a_of_type_Bimh.a).a.a(localArrayList, OpenAuthorityFragment.a(this.jdField_a_of_type_Bimh.a).getAccount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment.12.1
 * JD-Core Version:    0.7.0.1
 */