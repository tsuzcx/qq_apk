package com.tencent.mobileqq.kandian.repo.follow;

import com.tencent.mobileqq.kandian.base.utils.CollectionUtils.IAction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x977.oidb_cmd0x977.FollowStatusInfo;
import tencent.im.oidb.cmd0x977.oidb_cmd0x977.KdUserInfo;

class FollowListInfoModule$6
  implements CollectionUtils.IAction<oidb_cmd0x977.FollowStatusInfo, FollowingMember>
{
  FollowListInfoModule$6(FollowListInfoModule paramFollowListInfoModule) {}
  
  public FollowingMember a(oidb_cmd0x977.FollowStatusInfo paramFollowStatusInfo)
  {
    long l = paramFollowStatusInfo.uint64_uin.get();
    FollowingMember localFollowingMember = new FollowingMember();
    localFollowingMember.a(Long.valueOf(l));
    localFollowingMember.a(Integer.valueOf(paramFollowStatusInfo.enum_account_type.get()));
    localFollowingMember.a(paramFollowStatusInfo.user_info.bytes_nick.get().toStringUtf8());
    localFollowingMember.b(paramFollowStatusInfo.user_info.bytes_qq_head_url.get().toStringUtf8());
    localFollowingMember.a(FollowListInfoModule.a(this.a, paramFollowStatusInfo.enum_status.get()));
    return localFollowingMember;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.follow.FollowListInfoModule.6
 * JD-Core Version:    0.7.0.1
 */