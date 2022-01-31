package com.tencent.open.agent;

import aqgh;
import axqw;
import bczs;
import bdcp;
import bdno;
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
    bczs localbczs1;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localbczs1 = (bczs)((Iterator)localObject1).next();
      localObject2 = new bczs();
      ((bczs)localObject2).jdField_a_of_type_Int = localbczs1.jdField_a_of_type_Int;
      ((bczs)localObject2).jdField_b_of_type_JavaLangString = localbczs1.jdField_b_of_type_JavaLangString;
      ((bczs)localObject2).jdField_b_of_type_Int = localbczs1.jdField_b_of_type_Int;
      ((bczs)localObject2).jdField_a_of_type_Boolean = localbczs1.jdField_a_of_type_Boolean;
      ((bczs)localObject2).jdField_a_of_type_JavaLangString = localbczs1.jdField_a_of_type_JavaLangString;
      ((bczs)localObject2).jdField_b_of_type_Boolean = true;
      localArrayList.add(localObject2);
    }
    localObject1 = OpenSelectPermissionFragment.a(this.this$0).a();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localbczs1 = (bczs)((Iterator)localObject1).next();
        localObject2 = localArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          bczs localbczs2 = (bczs)((Iterator)localObject2).next();
          if (localbczs1.jdField_b_of_type_Int == localbczs2.jdField_b_of_type_Int) {
            localbczs2.jdField_b_of_type_Boolean = localbczs1.jdField_b_of_type_Boolean;
          }
        }
      }
    }
    if (OpenSelectPermissionFragment.a(this.this$0)) {}
    for (int i = 2;; i = 1)
    {
      aqgh.a("KEY_AUTHORIZE_REQUEST");
      OpenSelectPermissionFragment.a(this.this$0).a(false, String.valueOf(OpenSelectPermissionFragment.a(this.this$0)), localArrayList, OpenSelectPermissionFragment.b(this.this$0), OpenSelectPermissionFragment.a(this.this$0), OpenSelectPermissionFragment.a(this.this$0), this.this$0.getActivity());
      if (OpenSelectPermissionFragment.b(this.this$0) != 0L) {
        break;
      }
      axqw.b(null, "dc00898", "", "", "0X800A117", "0X800A117", i, 0, "", "", "", "");
      return;
    }
    axqw.b(null, "dc00898", "", "", "0X800A116", "0X800A116", i, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenSelectPermissionFragment.3
 * JD-Core Version:    0.7.0.1
 */