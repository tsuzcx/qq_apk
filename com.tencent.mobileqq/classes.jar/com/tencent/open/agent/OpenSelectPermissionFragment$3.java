package com.tencent.open.agent;

import aqgj;
import axqy;
import bdah;
import bdde;
import bdod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class OpenSelectPermissionFragment$3
  implements Runnable
{
  OpenSelectPermissionFragment$3(OpenSelectPermissionFragment paramOpenSelectPermissionFragment) {}
  
  public void run()
  {
    Object localObject1 = OpenSelectPermissionFragment.a(this.this$0).a(String.valueOf(OpenSelectPermissionFragment.a(this.this$0)));
    if (localObject1 == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    bdah localbdah1;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localbdah1 = (bdah)((Iterator)localObject1).next();
      localObject2 = new bdah();
      ((bdah)localObject2).jdField_a_of_type_Int = localbdah1.jdField_a_of_type_Int;
      ((bdah)localObject2).jdField_b_of_type_JavaLangString = localbdah1.jdField_b_of_type_JavaLangString;
      ((bdah)localObject2).jdField_b_of_type_Int = localbdah1.jdField_b_of_type_Int;
      ((bdah)localObject2).jdField_a_of_type_Boolean = localbdah1.jdField_a_of_type_Boolean;
      ((bdah)localObject2).jdField_a_of_type_JavaLangString = localbdah1.jdField_a_of_type_JavaLangString;
      ((bdah)localObject2).jdField_b_of_type_Boolean = true;
      localArrayList.add(localObject2);
    }
    localObject1 = OpenSelectPermissionFragment.a(this.this$0).a();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localbdah1 = (bdah)((Iterator)localObject1).next();
        localObject2 = localArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          bdah localbdah2 = (bdah)((Iterator)localObject2).next();
          if (localbdah1.jdField_b_of_type_Int == localbdah2.jdField_b_of_type_Int) {
            localbdah2.jdField_b_of_type_Boolean = localbdah1.jdField_b_of_type_Boolean;
          }
        }
      }
    }
    if (OpenSelectPermissionFragment.a(this.this$0)) {}
    for (int i = 2;; i = 1)
    {
      aqgj.a("KEY_AUTHORIZE_REQUEST");
      OpenSelectPermissionFragment.a(this.this$0).a(false, String.valueOf(OpenSelectPermissionFragment.a(this.this$0)), localArrayList, OpenSelectPermissionFragment.b(this.this$0), OpenSelectPermissionFragment.a(this.this$0), OpenSelectPermissionFragment.a(this.this$0), this.this$0.getActivity());
      if (OpenSelectPermissionFragment.b(this.this$0) != 0L) {
        break;
      }
      axqy.b(null, "dc00898", "", "", "0X800A117", "0X800A117", i, 0, "", "", "", "");
      return;
    }
    axqy.b(null, "dc00898", "", "", "0X800A116", "0X800A116", i, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenSelectPermissionFragment.3
 * JD-Core Version:    0.7.0.1
 */