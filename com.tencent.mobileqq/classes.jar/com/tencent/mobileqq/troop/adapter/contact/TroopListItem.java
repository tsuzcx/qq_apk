package com.tencent.mobileqq.troop.adapter.contact;

import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;

public class TroopListItem
{
  public int a;
  public TroopInfo b;
  public DiscussionInfo c;
  public int d;
  
  public TroopListItem(int paramInt, DiscussionInfo paramDiscussionInfo)
  {
    this.a = paramInt;
    this.c = paramDiscussionInfo;
  }
  
  public TroopListItem(int paramInt1, DiscussionInfo paramDiscussionInfo, int paramInt2)
  {
    this.a = paramInt1;
    this.c = paramDiscussionInfo;
    this.d = paramInt2;
  }
  
  public TroopListItem(int paramInt, Entity paramEntity)
  {
    this.a = paramInt;
    this.b = ((TroopInfo)paramEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.adapter.contact.TroopListItem
 * JD-Core Version:    0.7.0.1
 */