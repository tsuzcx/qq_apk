package com.tencent.mobileqq.troop.troopcreate.api.impl;

import com.tencent.mobileqq.troop.troopcreate.TroopCreateUtils;
import com.tencent.mobileqq.troop.troopcreate.ui.NewTroopSearchResultDialog;
import java.util.ArrayList;

class TroopCreateServiceImpl$1$1
  implements Runnable
{
  TroopCreateServiceImpl$1$1(TroopCreateServiceImpl.1 param1, ArrayList paramArrayList) {}
  
  public void run()
  {
    TroopCreateUtils.a();
    NewTroopSearchResultDialog localNewTroopSearchResultDialog = new NewTroopSearchResultDialog(this.b.b, this.b.c);
    localNewTroopSearchResultDialog.a(this.a);
    localNewTroopSearchResultDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.api.impl.TroopCreateServiceImpl.1.1
 * JD-Core Version:    0.7.0.1
 */