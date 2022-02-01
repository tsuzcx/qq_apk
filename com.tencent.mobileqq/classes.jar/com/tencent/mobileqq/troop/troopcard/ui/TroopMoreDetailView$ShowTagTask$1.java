package com.tencent.mobileqq.troop.troopcard.ui;

import java.util.ArrayList;

class TroopMoreDetailView$ShowTagTask$1
  implements Runnable
{
  TroopMoreDetailView$ShowTagTask$1(TroopMoreDetailView.ShowTagTask paramShowTagTask, TroopMoreDetailView paramTroopMoreDetailView, ArrayList paramArrayList) {}
  
  public void run()
  {
    TroopMoreDetailView localTroopMoreDetailView = this.a;
    ArrayList localArrayList = this.b;
    int i;
    if (this.c.this$0.d) {
      i = 3;
    } else {
      i = 2;
    }
    localTroopMoreDetailView.a(0, localArrayList, true, i, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopMoreDetailView.ShowTagTask.1
 * JD-Core Version:    0.7.0.1
 */