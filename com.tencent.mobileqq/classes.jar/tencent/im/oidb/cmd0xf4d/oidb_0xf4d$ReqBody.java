package tencent.im.oidb.cmd0xf4d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xf4d$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field begin_delta_time = PBField.initUInt32(0);
  public final PBUInt32Field end_delta_time = PBField.initUInt32(0);
  public final PBStringField rowkey = PBField.initString("");
  public final PBStringField uin = PBField.initString("");
  public final PBUInt32Field uin_source = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40 }, new String[] { "uin", "uin_source", "rowkey", "begin_delta_time", "end_delta_time" }, new Object[] { "", localInteger, "", localInteger, localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf4d.oidb_0xf4d.ReqBody
 * JD-Core Version:    0.7.0.1
 */