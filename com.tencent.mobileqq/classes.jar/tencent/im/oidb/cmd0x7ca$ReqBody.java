package tencent.im.oidb;

import appoint.define.appoint_define.AppointID;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x7ca$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int MSG_APPOINT_ID_FIELD_NUMBER = 1;
  public static final int UINT32_OP_TYPE_FIELD_NUMBER = 3;
  public static final int UINT64_TINYID_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "msg_appoint_id", "uint64_tinyid", "uint32_op_type" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0) }, ReqBody.class);
  public appoint_define.AppointID msg_appoint_id = new appoint_define.AppointID();
  public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7ca.ReqBody
 * JD-Core Version:    0.7.0.1
 */