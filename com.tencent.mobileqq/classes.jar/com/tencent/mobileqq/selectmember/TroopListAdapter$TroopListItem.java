package com.tencent.mobileqq.selectmember;

import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;

public class TroopListAdapter$TroopListItem
{
  public int a;
  public TroopInfo b;
  public DiscussionInfo c;
  public int d;
  
  public TroopListAdapter$TroopListItem(TroopListAdapter paramTroopListAdapter, int paramInt, DiscussionInfo paramDiscussionInfo)
  {
    this.a = paramInt;
    this.c = paramDiscussionInfo;
  }
  
  public TroopListAdapter$TroopListItem(TroopListAdapter paramTroopListAdapter, int paramInt1, DiscussionInfo paramDiscussionInfo, int paramInt2)
  {
    this.a = paramInt1;
    this.c = paramDiscussionInfo;
    this.d = paramInt2;
  }
  
  public TroopListAdapter$TroopListItem(TroopListAdapter paramTroopListAdapter, int paramInt, Entity paramEntity)
  {
    this.a = paramInt;
    this.b = ((TroopInfo)paramEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopListAdapter.TroopListItem
 * JD-Core Version:    0.7.0.1
 */