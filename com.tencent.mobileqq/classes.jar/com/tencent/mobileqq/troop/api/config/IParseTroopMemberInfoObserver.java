package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import friendlist.stTroopMemberInfo;
import tencent.im.group.group_member_info.MemberInfo;

public abstract interface IParseTroopMemberInfoObserver
{
  public abstract void a(@NonNull TroopInfo paramTroopInfo, stTroopMemberInfo paramstTroopMemberInfo);
  
  public abstract void a(@NonNull TroopMemberCard paramTroopMemberCard, group_member_info.MemberInfo paramMemberInfo);
  
  public abstract void a(@NonNull TroopMemberInfo paramTroopMemberInfo, stTroopMemberInfo paramstTroopMemberInfo);
  
  public abstract void b(@NonNull TroopMemberInfo paramTroopMemberInfo, stTroopMemberInfo paramstTroopMemberInfo);
  
  public abstract void c(@NonNull TroopMemberInfo paramTroopMemberInfo, stTroopMemberInfo paramstTroopMemberInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.IParseTroopMemberInfoObserver
 * JD-Core Version:    0.7.0.1
 */