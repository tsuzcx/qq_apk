package com.tencent.mobileqq.troop.api.handler;

import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

public abstract interface ITroopInfoHandler
{
  public abstract void a(long paramLong, String paramString);
  
  public abstract void a(Long paramLong, oidb_0x88d.GroupInfo paramGroupInfo, String paramString);
  
  public abstract void a(Long paramLong, oidb_0x88d.GroupInfo paramGroupInfo, String paramString, int paramInt1, long paramLong1, int paramInt2);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString1, long paramLong, String paramString2);
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(String paramString, boolean paramBoolean);
  
  public abstract void a(String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5);
  
  public abstract byte[] a(long paramLong);
  
  public abstract void b();
  
  public abstract void b(String paramString);
  
  public abstract void c(String paramString);
  
  public abstract void d(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler
 * JD-Core Version:    0.7.0.1
 */