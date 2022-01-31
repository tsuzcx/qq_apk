package tencent.im.c2s.imax;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class IMaxService$IgnoreADMsg
  extends MessageMicro<IgnoreADMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "str_ad_id" }, new Object[] { Long.valueOf(0L), "" }, IgnoreADMsg.class);
  public final PBStringField str_ad_id = PBField.initString("");
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.c2s.imax.IMaxService.IgnoreADMsg
 * JD-Core Version:    0.7.0.1
 */