import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x977.oidb_cmd0x977.FollowStatusInfo;
import tencent.im.oidb.cmd0x977.oidb_cmd0x977.KdUserInfo;

class pux
  implements rgq<oidb_cmd0x977.FollowStatusInfo, rcz>
{
  pux(puw parampuw) {}
  
  public rcz a(oidb_cmd0x977.FollowStatusInfo paramFollowStatusInfo)
  {
    long l = paramFollowStatusInfo.uint64_uin.get();
    rcz localrcz = new rcz();
    localrcz.a(Long.valueOf(l));
    localrcz.a(Integer.valueOf(paramFollowStatusInfo.enum_account_type.get()));
    localrcz.a(paramFollowStatusInfo.user_info.bytes_nick.get().toStringUtf8());
    localrcz.b(paramFollowStatusInfo.user_info.bytes_qq_head_url.get().toStringUtf8());
    localrcz.a(puw.a(this.a, paramFollowStatusInfo.enum_status.get()));
    return localrcz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pux
 * JD-Core Version:    0.7.0.1
 */