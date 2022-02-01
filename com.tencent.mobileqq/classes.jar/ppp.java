import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x977.oidb_cmd0x977.FollowStatusInfo;
import tencent.im.oidb.cmd0x977.oidb_cmd0x977.KdUserInfo;

class ppp
  implements qzr<oidb_cmd0x977.FollowStatusInfo, qwb>
{
  ppp(ppo paramppo) {}
  
  public qwb a(oidb_cmd0x977.FollowStatusInfo paramFollowStatusInfo)
  {
    long l = paramFollowStatusInfo.uint64_uin.get();
    qwb localqwb = new qwb();
    localqwb.a(Long.valueOf(l));
    localqwb.a(Integer.valueOf(paramFollowStatusInfo.enum_account_type.get()));
    localqwb.a(paramFollowStatusInfo.user_info.bytes_nick.get().toStringUtf8());
    localqwb.b(paramFollowStatusInfo.user_info.bytes_qq_head_url.get().toStringUtf8());
    localqwb.a(ppo.a(this.a, paramFollowStatusInfo.enum_status.get()));
    return localqwb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ppp
 * JD-Core Version:    0.7.0.1
 */