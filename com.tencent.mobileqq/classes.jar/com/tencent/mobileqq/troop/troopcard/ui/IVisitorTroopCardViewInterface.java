package com.tencent.mobileqq.troop.troopcard.ui;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.avatar.AvatarInfo;
import java.util.List;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import trpc.mizarproto.passthrough.FunctionLockMsg.FunctionLockBeatRsp;

public abstract interface IVisitorTroopCardViewInterface
{
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt1, int paramInt2, String paramString);
  
  public abstract void a(long paramLong, List<oidb_0x899.memberlist> paramList);
  
  public abstract void a(String paramString);
  
  public abstract void a(oidb_0x88d.GroupInfo paramGroupInfo);
  
  public abstract void a(boolean paramBoolean, long paramLong, TroopInfo paramTroopInfo);
  
  public abstract void a(boolean paramBoolean, String paramString, int paramInt, long paramLong);
  
  public abstract void a(boolean paramBoolean, String paramString1, String paramString2);
  
  public abstract void a(boolean paramBoolean, String paramString, FunctionLockMsg.FunctionLockBeatRsp paramFunctionLockBeatRsp);
  
  public abstract void a(boolean paramBoolean, List<AvatarInfo> paramList);
  
  public abstract void b();
  
  public abstract void b(String paramString);
  
  public abstract void c();
  
  public abstract void c(String paramString);
  
  public abstract void d();
  
  public abstract void d(String paramString);
  
  public abstract void e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.IVisitorTroopCardViewInterface
 * JD-Core Version:    0.7.0.1
 */