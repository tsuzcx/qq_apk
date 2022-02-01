import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x977.oidb_cmd0x977.FollowStatusInfo;
import tencent.im.oidb.cmd0x977.oidb_cmd0x977.KdUserInfo;

class qfr
  implements rsx<oidb_cmd0x977.FollowStatusInfo, rpf>
{
  qfr(qfq paramqfq) {}
  
  public rpf a(oidb_cmd0x977.FollowStatusInfo paramFollowStatusInfo)
  {
    long l = paramFollowStatusInfo.uint64_uin.get();
    rpf localrpf = new rpf();
    localrpf.a(Long.valueOf(l));
    localrpf.a(Integer.valueOf(paramFollowStatusInfo.enum_account_type.get()));
    localrpf.a(paramFollowStatusInfo.user_info.bytes_nick.get().toStringUtf8());
    localrpf.b(paramFollowStatusInfo.user_info.bytes_qq_head_url.get().toStringUtf8());
    localrpf.a(qfq.a(this.a, paramFollowStatusInfo.enum_status.get()));
    return localrpf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qfr
 * JD-Core Version:    0.7.0.1
 */