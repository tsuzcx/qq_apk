package com.tencent.mobileqq.troop.api;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITroopHandlerService
  extends IRuntimeService
{
  public abstract void activeExtTroop(String paramString);
  
  public abstract Bitmap getGroupFaceIcon(String paramString, boolean paramBoolean);
  
  public abstract void handleMemberExit(String paramString1, String paramString2);
  
  public abstract void notifyUI_genNewTroopName(boolean paramBoolean, Object paramObject);
  
  public abstract void send_oidb_0x899_0(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void send_oidb_0xb36_1(String paramString, int paramInt);
  
  public abstract void updateGroupIcon(String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.ITroopHandlerService
 * JD-Core Version:    0.7.0.1
 */