package tencent.im.oidb.cmd0xcd5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xcd5$GetDataReq
  extends MessageMicro<GetDataReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "query_type", "target_uin" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, GetDataReq.class);
  public final PBUInt32Field query_type = PBField.initUInt32(0);
  public final PBUInt64Field target_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5.GetDataReq
 * JD-Core Version:    0.7.0.1
 */