package com.tencent.mobileqq.troop.troopcard;

import java.util.ArrayList;

class TroopMoreDetailView$ShowTagTask$1
  implements Runnable
{
  TroopMoreDetailView$ShowTagTask$1(TroopMoreDetailView.ShowTagTask paramShowTagTask, TroopMoreDetailView paramTroopMoreDetailView, ArrayList paramArrayList) {}
  
  public void run()
  {
    TroopMoreDetailView localTroopMoreDetailView = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView;
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView$ShowTagTask.this$0.a) {
      i = 3;
    } else {
      i = 2;
    }
    localTroopMoreDetailView.a(0, localArrayList, true, i, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopMoreDetailView.ShowTagTask.1
 * JD-Core Version:    0.7.0.1
 */