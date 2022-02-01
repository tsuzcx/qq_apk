import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x977.oidb_cmd0x977.FollowStatusInfo;
import tencent.im.oidb.cmd0x977.oidb_cmd0x977.KdUserInfo;

class pxg
  implements riy<oidb_cmd0x977.FollowStatusInfo, rfi>
{
  pxg(pxd parampxd) {}
  
  public rfi a(oidb_cmd0x977.FollowStatusInfo paramFollowStatusInfo)
  {
    paramFollowStatusInfo = new rfi(Long.valueOf(paramFollowStatusInfo.uint64_uin.get()), Integer.valueOf(paramFollowStatusInfo.enum_account_type.get()), paramFollowStatusInfo.user_info.bytes_nick.get().toStringUtf8(), paramFollowStatusInfo.user_info.bytes_qq_head_url.get().toStringUtf8());
    QLog.i("FollowingInfoModule", 1, "[handleGetFollowMemberListFromServer], followingMember = " + paramFollowStatusInfo);
    return paramFollowStatusInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pxg
 * JD-Core Version:    0.7.0.1
 */