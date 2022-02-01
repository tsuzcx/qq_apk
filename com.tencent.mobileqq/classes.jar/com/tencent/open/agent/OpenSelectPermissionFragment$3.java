package com.tencent.open.agent;

import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.virtual.OpenSdkVirtualManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class OpenSelectPermissionFragment$3
  implements Runnable
{
  OpenSelectPermissionFragment$3(OpenSelectPermissionFragment paramOpenSelectPermissionFragment) {}
  
  public void run()
  {
    if (OpenSelectPermissionFragment.a(this.this$0) == null)
    {
      QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "doAuth null == mOpenVirtualMgr");
      return;
    }
    Object localObject1 = OpenSelectPermissionFragment.a(this.this$0).a(OpenSelectPermissionFragment.a(this.this$0));
    if (localObject1 == null)
    {
      QLog.d("SDK_LOGIN.OpenSelectPermissionFragment", 1, "getAuthApiListResponse == null");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    CardContainer.Permission localPermission1;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localPermission1 = (CardContainer.Permission)((Iterator)localObject1).next();
      localObject2 = new CardContainer.Permission();
      ((CardContainer.Permission)localObject2).jdField_a_of_type_Int = localPermission1.jdField_a_of_type_Int;
      ((CardContainer.Permission)localObject2).jdField_b_of_type_JavaLangString = localPermission1.jdField_b_of_type_JavaLangString;
      ((CardContainer.Permission)localObject2).jdField_b_of_type_Int = localPermission1.jdField_b_of_type_Int;
      ((CardContainer.Permission)localObject2).jdField_a_of_type_Boolean = localPermission1.jdField_a_of_type_Boolean;
      ((CardContainer.Permission)localObject2).jdField_a_of_type_JavaLangString = localPermission1.jdField_a_of_type_JavaLangString;
      ((CardContainer.Permission)localObject2).jdField_b_of_type_Boolean = true;
      localArrayList.add(localObject2);
    }
    localObject1 = OpenSelectPermissionFragment.a(this.this$0).a();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localPermission1 = (CardContainer.Permission)((Iterator)localObject1).next();
        localObject2 = localArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          CardContainer.Permission localPermission2 = (CardContainer.Permission)((Iterator)localObject2).next();
          if (localPermission1.jdField_b_of_type_Int == localPermission2.jdField_b_of_type_Int) {
            localPermission2.jdField_b_of_type_Boolean = localPermission1.jdField_b_of_type_Boolean;
          }
        }
      }
    }
    int i;
    if (OpenSelectPermissionFragment.a(this.this$0))
    {
      i = 2;
      ForwardStatisticsReporter.a("KEY_AUTHORIZE_REQUEST");
      if (0L != OpenSelectPermissionFragment.a(this.this$0)) {
        break label392;
      }
      localObject1 = "";
      label301:
      OpenSelectPermissionFragment.a(this.this$0).a(false, OpenSelectPermissionFragment.b(this.this$0), (String)localObject1, localArrayList, OpenSelectPermissionFragment.b(this.this$0), OpenSelectPermissionFragment.a(this.this$0), OpenSelectPermissionFragment.c(this.this$0), this.this$0.getActivity());
      if (OpenSelectPermissionFragment.b(this.this$0) != 0L) {
        break label406;
      }
    }
    label392:
    label406:
    for (localObject1 = "0X800A117";; localObject1 = "0X800A116")
    {
      ReportController.b(null, "dc00898", "", "", (String)localObject1, (String)localObject1, i, 0, "", "", "", "");
      return;
      i = 1;
      break;
      localObject1 = String.valueOf(OpenSelectPermissionFragment.a(this.this$0));
      break label301;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenSelectPermissionFragment.3
 * JD-Core Version:    0.7.0.1
 */