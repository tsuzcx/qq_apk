package com.tencent.open.agent;

import arzy;
import azmj;
import bezj;
import bfcc;
import bfna;
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
      QLog.d("OpenSelectPermissionFragment", 1, "doAuth null == mOpenVirtualMgr");
      return;
    }
    Object localObject1 = OpenSelectPermissionFragment.a(this.this$0).a(String.valueOf(OpenSelectPermissionFragment.a(this.this$0)));
    if (localObject1 == null)
    {
      QLog.d("OpenSelectPermissionFragment", 1, "getAuthApiListResponse == null");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    bezj localbezj1;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localbezj1 = (bezj)((Iterator)localObject1).next();
      localObject2 = new bezj();
      ((bezj)localObject2).jdField_a_of_type_Int = localbezj1.jdField_a_of_type_Int;
      ((bezj)localObject2).jdField_b_of_type_JavaLangString = localbezj1.jdField_b_of_type_JavaLangString;
      ((bezj)localObject2).jdField_b_of_type_Int = localbezj1.jdField_b_of_type_Int;
      ((bezj)localObject2).jdField_a_of_type_Boolean = localbezj1.jdField_a_of_type_Boolean;
      ((bezj)localObject2).jdField_a_of_type_JavaLangString = localbezj1.jdField_a_of_type_JavaLangString;
      ((bezj)localObject2).jdField_b_of_type_Boolean = true;
      localArrayList.add(localObject2);
    }
    localObject1 = OpenSelectPermissionFragment.a(this.this$0).a();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localbezj1 = (bezj)((Iterator)localObject1).next();
        localObject2 = localArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          bezj localbezj2 = (bezj)((Iterator)localObject2).next();
          if (localbezj1.jdField_b_of_type_Int == localbezj2.jdField_b_of_type_Int) {
            localbezj2.jdField_b_of_type_Boolean = localbezj1.jdField_b_of_type_Boolean;
          }
        }
      }
    }
    if (OpenSelectPermissionFragment.a(this.this$0)) {}
    for (int i = 2;; i = 1)
    {
      arzy.a("KEY_AUTHORIZE_REQUEST");
      OpenSelectPermissionFragment.a(this.this$0).a(false, String.valueOf(OpenSelectPermissionFragment.a(this.this$0)), localArrayList, OpenSelectPermissionFragment.b(this.this$0), OpenSelectPermissionFragment.a(this.this$0), OpenSelectPermissionFragment.a(this.this$0), this.this$0.getActivity());
      if (OpenSelectPermissionFragment.b(this.this$0) != 0L) {
        break;
      }
      azmj.b(null, "dc00898", "", "", "0X800A117", "0X800A117", i, 0, "", "", "", "");
      return;
    }
    azmj.b(null, "dc00898", "", "", "0X800A116", "0X800A116", i, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenSelectPermissionFragment.3
 * JD-Core Version:    0.7.0.1
 */