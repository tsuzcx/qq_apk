package tencent.im.oidb.cmd0x921;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x921$GetAtAllRemainRsp
  extends MessageMicro<GetAtAllRemainRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_uin", "uint32_uin_remain", "uint64_discuss_uin", "uint32_discuss_uin_remain", "bool_priviledge" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Boolean.valueOf(false) }, GetAtAllRemainRsp.class);
  public final PBBoolField bool_priviledge = PBField.initBool(false);
  public final PBUInt32Field uint32_discuss_uin_remain = PBField.initUInt32(0);
  public final PBUInt32Field uint32_uin_remain = PBField.initUInt32(0);
  public final PBUInt64Field uint64_discuss_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x921.cmd0x921.GetAtAllRemainRsp
 * JD-Core Version:    0.7.0.1
 */