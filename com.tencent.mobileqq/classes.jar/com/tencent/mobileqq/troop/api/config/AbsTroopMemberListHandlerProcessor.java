package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import friendlist.stTroopMemberInfo;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x787.oidb_0x787.MemberLevelInfo;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class AbsTroopMemberListHandlerProcessor
{
  public void a(long paramLong, List<oidb_0x899.memberlist> paramList) {}
  
  public void a(@NonNull AppInterface paramAppInterface, TroopInfo paramTroopInfo, ArrayList<String> paramArrayList) {}
  
  public void a(@NonNull AppInterface paramAppInterface, String paramString, long paramLong) {}
  
  public void a(@NonNull AppInterface paramAppInterface, String paramString, ArrayList<stTroopMemberInfo> paramArrayList) {}
  
  public void a(@NonNull TroopMemberCard paramTroopMemberCard, oidb_0x787.MemberLevelInfo paramMemberLevelInfo) {}
  
  public void a(@NonNull TroopMemberCardInfo paramTroopMemberCardInfo, stTroopMemberInfo paramstTroopMemberInfo) {}
  
  public void a(@NonNull TroopMemberInfo paramTroopMemberInfo, stTroopMemberInfo paramstTroopMemberInfo) {}
  
  public void b(@NonNull TroopMemberInfo paramTroopMemberInfo, stTroopMemberInfo paramstTroopMemberInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.AbsTroopMemberListHandlerProcessor
 * JD-Core Version:    0.7.0.1
 */