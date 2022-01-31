import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x977.oidb_cmd0x977.FollowStatusInfo;
import tencent.im.oidb.cmd0x977.oidb_cmd0x977.KdUserInfo;

class ops
  implements psh<oidb_cmd0x977.FollowStatusInfo, ppg>
{
  ops(opp paramopp) {}
  
  public ppg a(oidb_cmd0x977.FollowStatusInfo paramFollowStatusInfo)
  {
    return new ppg(Long.valueOf(paramFollowStatusInfo.uint64_uin.get()), Integer.valueOf(paramFollowStatusInfo.enum_account_type.get()), paramFollowStatusInfo.user_info.bytes_nick.get().toStringUtf8(), paramFollowStatusInfo.user_info.bytes_qq_head_url.get().toStringUtf8());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ops
 * JD-Core Version:    0.7.0.1
 */