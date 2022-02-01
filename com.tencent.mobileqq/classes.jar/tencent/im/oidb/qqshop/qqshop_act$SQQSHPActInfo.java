package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqshop_act$SQQSHPActInfo
  extends MessageMicro<SQQSHPActInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field act_id = PBField.initUInt32(0);
  public final PBUInt32Field beg_ts = PBField.initUInt32(0);
  public final PBUInt32Field end_ts = PBField.initUInt32(0);
  public final PBStringField fail_pic = PBField.initString("");
  public final PBUInt32Field status = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "act_id", "beg_ts", "end_ts", "status", "fail_pic" }, new Object[] { localInteger, localInteger, localInteger, localInteger, "" }, SQQSHPActInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qqshop_act.SQQSHPActInfo
 * JD-Core Version:    0.7.0.1
 */