package com.tencent.mobileqq.troop.api.handler;

import com.tencent.mobileqq.troop.data.InviteToGroupInfo;
import com.tencent.mobileqq.troop.data.JoinGroupInfo;
import com.tencent.mobileqq.troop.data.TroopCreateInfo.InviteMemberInfo;
import java.util.ArrayList;
import java.util.List;

public abstract interface ITroopMngHandler
{
  public abstract void a(int paramInt, boolean paramBoolean, Object paramObject);
  
  public abstract void a(long paramLong);
  
  public abstract void a(long paramLong, int paramInt);
  
  public abstract void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, long paramLong3, long paramLong4, int paramInt5, String paramString3, byte[] paramArrayOfByte);
  
  public abstract void a(long paramLong1, long paramLong2);
  
  public abstract void a(long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void a(long paramLong1, long paramLong2, String paramString);
  
  public abstract void a(InviteToGroupInfo paramInviteToGroupInfo);
  
  public abstract void a(JoinGroupInfo paramJoinGroupInfo);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, byte[] paramArrayOfByte, String paramString5);
  
  public abstract void a(String paramString1, String paramString2, long paramLong);
  
  public abstract void a(String paramString1, ArrayList<String> paramArrayList, String paramString2);
  
  public abstract void a(String paramString1, List<TroopCreateInfo.InviteMemberInfo> paramList, String paramString2);
  
  public abstract void b(String paramString);
  
  public abstract void c(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.handler.ITroopMngHandler
 * JD-Core Version:    0.7.0.1
 */