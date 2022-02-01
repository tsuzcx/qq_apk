package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import friendlist.stTroopRemarkInfo;
import java.util.ArrayList;
import tencent.im.group.group_member_info.MemberInfo;

public class AbsTroopMemberCardHandlerProcessor
{
  public void a(@NonNull TroopMemberCard paramTroopMemberCard, long paramLong, group_member_info.MemberInfo paramMemberInfo) {}
  
  public void a(@NonNull TroopMemberInfo paramTroopMemberInfo, TroopMemberCard paramTroopMemberCard) {}
  
  public Object[] a(@NonNull AppInterface paramAppInterface, String paramString, ArrayList<stTroopRemarkInfo> paramArrayList)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.AbsTroopMemberCardHandlerProcessor
 * JD-Core Version:    0.7.0.1
 */