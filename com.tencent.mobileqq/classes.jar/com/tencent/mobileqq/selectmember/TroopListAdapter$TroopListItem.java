package com.tencent.mobileqq.selectmember;

import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;

public class TroopListAdapter$TroopListItem
{
  public int a;
  public DiscussionInfo a;
  public TroopInfo a;
  public int b;
  
  public TroopListAdapter$TroopListItem(TroopListAdapter paramTroopListAdapter, int paramInt, DiscussionInfo paramDiscussionInfo)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = paramDiscussionInfo;
  }
  
  public TroopListAdapter$TroopListItem(TroopListAdapter paramTroopListAdapter, int paramInt1, DiscussionInfo paramDiscussionInfo, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = paramDiscussionInfo;
    this.b = paramInt2;
  }
  
  public TroopListAdapter$TroopListItem(TroopListAdapter paramTroopListAdapter, int paramInt, Entity paramEntity)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopInfo)paramEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopListAdapter.TroopListItem
 * JD-Core Version:    0.7.0.1
 */