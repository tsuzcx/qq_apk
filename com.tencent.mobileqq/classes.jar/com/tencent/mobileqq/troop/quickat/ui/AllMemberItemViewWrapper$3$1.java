package com.tencent.mobileqq.troop.quickat.ui;

import baei;
import bael;
import bafa;
import java.util.List;

public class AllMemberItemViewWrapper$3$1
  implements Runnable
{
  public AllMemberItemViewWrapper$3$1(bael parambael, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, boolean paramBoolean3) {}
  
  public void run()
  {
    this.jdField_a_of_type_Bael.a.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Boolean, 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_Boolean);
    if ((!this.jdField_c_of_type_Boolean) && (baei.a(this.jdField_a_of_type_Bael.a).a()))
    {
      List localList = baei.a(this.jdField_a_of_type_Bael.a).a();
      if (localList.size() >= 1) {
        localList.remove(0);
      }
      baei.a(this.jdField_a_of_type_Bael.a).a(localList);
      return;
    }
    baei.a(this.jdField_a_of_type_Bael.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AllMemberItemViewWrapper.3.1
 * JD-Core Version:    0.7.0.1
 */