package com.tencent.mobileqq.troop.quickat.ui;

import java.util.List;

class AllMemberItemViewWrapper$3$1
  implements Runnable
{
  AllMemberItemViewWrapper$3$1(AllMemberItemViewWrapper.3 param3, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, boolean paramBoolean3) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAllMemberItemViewWrapper$3.a.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Boolean, 0, 0, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_c_of_type_Boolean);
    if ((!this.jdField_c_of_type_Boolean) && (AllMemberItemViewWrapper.a(this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAllMemberItemViewWrapper$3.a).a()))
    {
      List localList = AllMemberItemViewWrapper.a(this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAllMemberItemViewWrapper$3.a).a();
      if (localList.size() >= 1) {
        localList.remove(0);
      }
      AllMemberItemViewWrapper.a(this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAllMemberItemViewWrapper$3.a).a(localList);
      return;
    }
    AllMemberItemViewWrapper.a(this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAllMemberItemViewWrapper$3.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.AllMemberItemViewWrapper.3.1
 * JD-Core Version:    0.7.0.1
 */