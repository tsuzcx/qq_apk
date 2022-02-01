package tencent.im.oidb.cmd0xef1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xef1$QueryGroupLuckyWordStatusRequest
  extends MessageMicro<QueryGroupLuckyWordStatusRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "group_code" }, new Object[] { Long.valueOf(0L) }, QueryGroupLuckyWordStatusRequest.class);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xef1.oidb_0xef1.QueryGroupLuckyWordStatusRequest
 * JD-Core Version:    0.7.0.1
 */