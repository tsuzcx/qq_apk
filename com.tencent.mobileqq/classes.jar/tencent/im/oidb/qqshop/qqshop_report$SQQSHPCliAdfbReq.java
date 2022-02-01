package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqshop_report$SQQSHPCliAdfbReq
  extends MessageMicro<SQQSHPCliAdfbReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField adid = PBField.initString("");
  public final PBInt32Field msg_type = PBField.initInt32(0);
  public final PBUInt64Field msgid = PBField.initUInt64(0L);
  public final PBUInt64Field puin = PBField.initUInt64(0L);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBStringField viewid = PBField.initString("");
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50 }, new String[] { "puin", "msgid", "uin", "msg_type", "adid", "viewid" }, new Object[] { localLong, localLong, localLong, Integer.valueOf(0), "", "" }, SQQSHPCliAdfbReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qqshop_report.SQQSHPCliAdfbReq
 * JD-Core Version:    0.7.0.1
 */