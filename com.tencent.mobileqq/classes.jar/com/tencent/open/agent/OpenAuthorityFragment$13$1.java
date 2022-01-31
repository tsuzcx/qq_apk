package com.tencent.open.agent;

import alpo;
import bfau;
import bfbr;
import bfbu;
import com.tencent.open.model.GetVirtualListResult;
import com.tencent.open.model.VirtualInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OpenAuthorityFragment$13$1
  implements Runnable
{
  public OpenAuthorityFragment$13$1(bfau parambfau, boolean paramBoolean, GetVirtualListResult paramGetVirtualListResult) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentOpenModelGetVirtualListResult != null) && (this.jdField_a_of_type_ComTencentOpenModelGetVirtualListResult.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_ComTencentOpenModelGetVirtualListResult.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentOpenModelGetVirtualListResult.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (VirtualInfo)localIterator.next();
          if ((((VirtualInfo)localObject).b != null) && (((VirtualInfo)localObject).jdField_a_of_type_JavaLangString != null))
          {
            localObject = new bfbu(((VirtualInfo)localObject).jdField_a_of_type_Long, ((VirtualInfo)localObject).jdField_a_of_type_JavaLangString, ((VirtualInfo)localObject).b);
            if ((((bfbu)localObject).jdField_a_of_type_Long == this.jdField_a_of_type_ComTencentOpenModelGetVirtualListResult.jdField_a_of_type_Long) && (this.jdField_a_of_type_Bfau.a.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a() == 0L)) {
              ((bfbu)localObject).jdField_a_of_type_Boolean = true;
            }
            localArrayList.add(localObject);
          }
        }
      }
      if ((this.jdField_a_of_type_Bfau.a.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer != null) && (this.jdField_a_of_type_Bfau.a.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a != null))
      {
        this.jdField_a_of_type_Bfau.a.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a.a(localArrayList, this.jdField_a_of_type_Bfau.a.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount());
        if (this.jdField_a_of_type_Bfau.a.j != 0L) {
          this.jdField_a_of_type_Bfau.a.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a.a(this.jdField_a_of_type_Bfau.a.j);
        }
      }
      this.jdField_a_of_type_Bfau.a.j = 0L;
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentOpenModelGetVirtualListResult != null)
      {
        OpenAuthorityFragment.a(this.jdField_a_of_type_Bfau.a, alpo.a(2131708231) + this.jdField_a_of_type_ComTencentOpenModelGetVirtualListResult.jdField_a_of_type_Int, false);
        QLog.d("OpenAuthorityFragment", 1, new Object[] { "getVirtualList error errorcode ===", Integer.valueOf(this.jdField_a_of_type_ComTencentOpenModelGetVirtualListResult.jdField_a_of_type_Int) });
      }
    } while ((this.jdField_a_of_type_Bfau.a.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer == null) || (this.jdField_a_of_type_Bfau.a.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a == null) || ((this.jdField_a_of_type_Bfau.a.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount() != null) && (this.jdField_a_of_type_Bfau.a.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount().equals(this.jdField_a_of_type_Bfau.a.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a.jdField_a_of_type_JavaLangString))));
    this.jdField_a_of_type_Bfau.a.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer.a.a(localArrayList, this.jdField_a_of_type_Bfau.a.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.getAccount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment.13.1
 * JD-Core Version:    0.7.0.1
 */