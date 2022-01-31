package tencent.im.oidb.cmd0x93b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x93b$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 88, 96, 104, 112 }, new String[] { "uint64_uin", "uint32_req_flag", "uint32_req_skey", "uint32_req_name", "uint32_req_school_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public final PBUInt32Field uint32_req_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_name = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_school_info = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_skey = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x93b.oidb_0x93b.ReqBody
 * JD-Core Version:    0.7.0.1
 */