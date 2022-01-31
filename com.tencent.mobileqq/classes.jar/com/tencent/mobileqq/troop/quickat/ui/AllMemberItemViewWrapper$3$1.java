package com.tencent.mobileqq.troop.quickat.ui;

import azcz;
import azdc;
import azdr;
import java.util.List;

public class AllMemberItemViewWrapper$3$1
  implements Runnable
{
  public AllMemberItemViewWrapper$3$1(azdc paramazdc, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, boolean paramBoolean3) {}
  
  public void run()
  {
    this.jdField_a_of_type_Azdc.a.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Boolean, 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_Boolean);
    if ((!this.jdField_c_of_type_Boolean) && (azcz.a(this.jdField_a_of_type_Azdc.a).a()))
    {
      List localList = azcz.a(this.jdField_a_of_type_Azdc.a).a();
      if (localList.size() >= 1) {
        localList.remove(0);
      }
      azcz.a(this.jdField_a_of_type_Azdc.a).a(localList);
      return;
    }
    azcz.a(this.jdField_a_of_type_Azdc.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AllMemberItemViewWrapper.3.1
 * JD-Core Version:    0.7.0.1
 */