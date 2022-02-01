package com.tencent.mobileqq.troop.api.handler;

import java.util.List;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.groupinfo;

public abstract interface ITroopModifyHandler
{
  public abstract void a(int paramInt, boolean paramBoolean, Object paramObject);
  
  public abstract void a(long paramLong1, int paramInt1, String paramString1, long paramLong2, List<String> paramList, int paramInt2, long paramLong3, long paramLong4, long paramLong5, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, String paramString6);
  
  public abstract void a(long paramLong1, long paramLong2, long paramLong3, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2);
  
  public abstract void a(long paramLong, oidb_0x89a.groupinfo paramgroupinfo, String paramString);
  
  public abstract void a(long paramLong, oidb_0x89a.groupinfo paramgroupinfo, String paramString, int paramInt);
  
  public abstract void a(String paramString1, String paramString2, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.handler.ITroopModifyHandler
 * JD-Core Version:    0.7.0.1
 */