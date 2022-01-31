package tencent.im.oidb.oidb_0x8e6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8e6$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x8e6.LoginSig msg_login_sig = new oidb_0x8e6.LoginSig();
  public final PBRepeatMessageField<oidb_0x8e6.VoteInfo> rpt_vote_info = PBField.initRepeatMessage(oidb_0x8e6.VoteInfo.class);
  public final PBUInt32Field uint32_client = PBField.initUInt32(0);
  public final PBUInt32Field uint32_portal = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42 }, new String[] { "rpt_vote_info", "uint32_portal", "uint32_client", "bytes_version", "msg_login_sig" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x8e6.oidb_0x8e6.ReqBody
 * JD-Core Version:    0.7.0.1
 */