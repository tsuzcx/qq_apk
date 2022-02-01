package com.tencent.mobileqq.troop.util;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class TroopMemberUtil
{
  public static String a(AppRuntime paramAppRuntime, TroopInfo paramTroopInfo, List<oidb_0x899.memberlist> paramList, boolean paramBoolean)
  {
    if (paramList == null) {
      return null;
    }
    int j = paramList.size();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < j)
    {
      Object localObject = (oidb_0x899.memberlist)paramList.get(i);
      if ((localObject != null) && (((oidb_0x899.memberlist)localObject).uint64_member_uin.has()))
      {
        long l = ((oidb_0x899.memberlist)localObject).uint64_member_uin.get();
        if (l != 0L)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(String.valueOf(l));
          ((StringBuilder)localObject).append("|");
          localStringBuilder.append(((StringBuilder)localObject).toString());
        }
      }
      i += 1;
    }
    paramTroopInfo.Administrator = localStringBuilder.toString();
    if (paramBoolean) {
      ((ITroopInfoService)paramAppRuntime.getRuntimeService(ITroopInfoService.class, "")).saveTroopInfo(paramTroopInfo);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.util.TroopMemberUtil
 * JD-Core Version:    0.7.0.1
 */