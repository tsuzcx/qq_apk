package tencent.im.oidb.cmd0xcd5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xcd5$GetDataReq
  extends MessageMicro<GetDataReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "query_type" }, new Object[] { Integer.valueOf(0) }, GetDataReq.class);
  public final PBUInt32Field query_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5.GetDataReq
 * JD-Core Version:    0.7.0.1
 */