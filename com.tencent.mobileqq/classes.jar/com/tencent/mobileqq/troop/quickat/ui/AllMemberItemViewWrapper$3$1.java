package com.tencent.mobileqq.troop.quickat.ui;

import besj;
import besm;
import betb;
import java.util.List;

public class AllMemberItemViewWrapper$3$1
  implements Runnable
{
  public AllMemberItemViewWrapper$3$1(besm parambesm, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, boolean paramBoolean3) {}
  
  public void run()
  {
    this.jdField_a_of_type_Besm.a.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Boolean, 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_Boolean);
    if ((!this.jdField_c_of_type_Boolean) && (besj.a(this.jdField_a_of_type_Besm.a).a()))
    {
      List localList = besj.a(this.jdField_a_of_type_Besm.a).a();
      if (localList.size() >= 1) {
        localList.remove(0);
      }
      besj.a(this.jdField_a_of_type_Besm.a).a(localList);
      return;
    }
    besj.a(this.jdField_a_of_type_Besm.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AllMemberItemViewWrapper.3.1
 * JD-Core Version:    0.7.0.1
 */