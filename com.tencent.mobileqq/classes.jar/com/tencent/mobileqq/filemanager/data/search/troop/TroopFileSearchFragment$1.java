package com.tencent.mobileqq.filemanager.data.search.troop;

import com.tencent.mobileqq.app.BizTroopObserver;

class TroopFileSearchFragment$1
  extends BizTroopObserver
{
  TroopFileSearchFragment$1(TroopFileSearchFragment paramTroopFileSearchFragment) {}
  
  public void onTroopFileStatusUpdate(Object paramObject)
  {
    TroopFileSearchFragment.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchFragment.1
 * JD-Core Version:    0.7.0.1
 */