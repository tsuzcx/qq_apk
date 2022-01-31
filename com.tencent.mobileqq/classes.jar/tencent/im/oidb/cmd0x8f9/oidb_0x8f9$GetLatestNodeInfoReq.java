package tencent.im.oidb.cmd0x8f9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8f9$GetLatestNodeInfoReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_node_type", "uint32_unread_count_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GetLatestNodeInfoReq.class);
  public final PBUInt32Field uint32_node_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_unread_count_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f9.oidb_0x8f9.GetLatestNodeInfoReq
 * JD-Core Version:    0.7.0.1
 */