package tencent.im.oidb;

import appoint.define.appoint_define.AppointID;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x7cf$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<appoint_define.AppointID> rpt_msg_appoint_ids = PBField.initRepeatMessage(appoint_define.AppointID.class);
  public final PBUInt32Field uint32_appoint_operation = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_valid_only = PBField.initUInt32(0);
  public final PBUInt32Field uint32_stamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_start = PBField.initUInt32(0);
  public final PBUInt32Field uint32_want = PBField.initUInt32(0);
  public final PBUInt64Field uint64_request_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 800 }, new String[] { "uint32_stamp", "uint32_start", "uint32_want", "uint32_req_valid_only", "rpt_msg_appoint_ids", "uint32_appoint_operation", "uint64_request_uin" }, new Object[] { localInteger, localInteger, localInteger, localInteger, null, localInteger, Long.valueOf(0L) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7cf.ReqBody
 * JD-Core Version:    0.7.0.1
 */