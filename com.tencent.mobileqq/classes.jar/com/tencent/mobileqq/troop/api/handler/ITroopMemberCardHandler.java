package com.tencent.mobileqq.troop.api.handler;

import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import java.util.ArrayList;

public abstract interface ITroopMemberCardHandler
{
  public abstract void a(long paramLong1, long paramLong2);
  
  public abstract void a(long paramLong1, long paramLong2, boolean paramBoolean);
  
  public abstract void a(String paramString1, String paramString2, ArrayList<String> paramArrayList);
  
  public abstract void a(String paramString, ArrayList<TroopMemberCardInfo> paramArrayList, ArrayList<Integer> paramArrayList1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.handler.ITroopMemberCardHandler
 * JD-Core Version:    0.7.0.1
 */