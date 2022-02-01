package com.tencent.mobileqq.troop.announcement.api;

import java.io.DataInputStream;

public abstract interface ITroopAnnouncementHandler
{
  public abstract ITroopAnnouncementHelperApi.FeedItem a(DataInputStream paramDataInputStream, boolean paramBoolean);
  
  public abstract void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt2, short paramShort, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(int paramInt, boolean paramBoolean, Object paramObject);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString1, String paramString2, short paramShort);
  
  public abstract void b(int paramInt1, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt2, short paramShort, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract boolean b(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHandler
 * JD-Core Version:    0.7.0.1
 */