package com.tencent.mobileqq.troop.troopcard.api.impl;

import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.troop.troopcard.api.IVisitorTroopCardApi;
import com.tencent.mobileqq.troop.troopcard.ui.VisitorTroopCardFragment;

public class VisitorTroopCardApiImpl
  implements IVisitorTroopCardApi
{
  public Class<? extends QPublicBaseFragment> getVisitorTroopCardFragmentClass()
  {
    return VisitorTroopCardFragment.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.api.impl.VisitorTroopCardApiImpl
 * JD-Core Version:    0.7.0.1
 */