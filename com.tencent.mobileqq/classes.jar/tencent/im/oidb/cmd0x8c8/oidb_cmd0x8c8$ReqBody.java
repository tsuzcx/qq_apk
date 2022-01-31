package tencent.im.oidb.cmd0x8c8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x8c8$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_cmd0x8c8.ControlParam control_req_param = new oidb_cmd0x8c8.ControlParam();
  public final PBRepeatField<ByteStringMicro> rpt_bytes_rowkey = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatMessageField<oidb_cmd0x8c8.ReqMsgInfo> rpt_msg_info_list = PBField.initRepeatMessage(oidb_cmd0x8c8.ReqMsgInfo.class);
  public final PBUInt32Field uint32_need_account_info = PBField.initUInt32(0);
  public final PBUInt32Field uint32_version = PBField.initUInt32(0);
  public final PBUInt64Field uint64_client_switch = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 74, 82 }, new String[] { "uint64_uin", "rpt_msg_info_list", "uint32_version", "uint64_client_switch", "uint32_need_account_info", "control_req_param", "rpt_bytes_rowkey" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null, localByteStringMicro }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.ReqBody
 * JD-Core Version:    0.7.0.1
 */