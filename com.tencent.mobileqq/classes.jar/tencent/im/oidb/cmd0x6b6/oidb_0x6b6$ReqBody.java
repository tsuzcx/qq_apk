package tencent.im.oidb.cmd0x6b6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6b6$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_user_ip = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x6b6.AnonymousGroupMsg msg_anony = new oidb_0x6b6.AnonymousGroupMsg();
  public oidb_0x6b6.ExtParam msg_ext_param = new oidb_0x6b6.ExtParam();
  public oidb_0x6b6.GPSInfo msg_gps_info = new oidb_0x6b6.GPSInfo();
  public oidb_0x6b6.SendFlowerReq msg_send_flower = new oidb_0x6b6.SendFlowerReq();
  public oidb_0x6b6.ThrowFlowerReq msg_throw_flower = new oidb_0x6b6.ThrowFlowerReq();
  public oidb_0x6b6.TmpMsgToken msg_tmp_msg_token = new oidb_0x6b6.TmpMsgToken();
  public final PBUInt32Field uint32_c2c_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_client = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_instance_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_portal = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 58, 66, 74, 82, 90, 98, 104, 112 }, new String[] { "uint64_group", "bytes_user_ip", "bytes_version", "uint32_portal", "uint32_client", "uint32_instance_id", "msg_ext_param", "msg_send_flower", "msg_throw_flower", "msg_tmp_msg_token", "msg_gps_info", "msg_anony", "uint32_c2c_type", "uint32_group_type" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localInteger, localInteger, localInteger, null, null, null, null, null, null, localInteger, localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6b6.oidb_0x6b6.ReqBody
 * JD-Core Version:    0.7.0.1
 */