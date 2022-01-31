package tencent.im.oidb.cmd0x75e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x75e$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90 }, new String[] { "uint64_uin", "uint32_network_type", "msg_req_para" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null }, ReqBody.class);
  public oidb_cmd0x75e.ReqPara msg_req_para = new oidb_cmd0x75e.ReqPara();
  public final PBUInt32Field uint32_network_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x75e.oidb_cmd0x75e.ReqBody
 * JD-Core Version:    0.7.0.1
 */