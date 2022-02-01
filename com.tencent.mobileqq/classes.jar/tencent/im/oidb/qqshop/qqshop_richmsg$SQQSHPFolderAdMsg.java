package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqshop_richmsg$SQQSHPFolderAdMsg
  extends MessageMicro<SQQSHPFolderAdMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 66, 72, 82 }, new String[] { "ad_id", "begin_time", "end_time", "puin", "ad_url", "title", "pic_url", "name", "verify_flag", "ad_content_url" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", "", "", "", Integer.valueOf(0), "" }, SQQSHPFolderAdMsg.class);
  public final PBStringField ad_content_url = PBField.initString("");
  public final PBUInt64Field ad_id = PBField.initUInt64(0L);
  public final PBStringField ad_url = PBField.initString("");
  public final PBUInt32Field begin_time = PBField.initUInt32(0);
  public final PBUInt32Field end_time = PBField.initUInt32(0);
  public final PBStringField name = PBField.initString("");
  public final PBRepeatField<String> pic_url = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt64Field puin = PBField.initUInt64(0L);
  public final PBStringField title = PBField.initString("");
  public final PBUInt32Field verify_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qqshop_richmsg.SQQSHPFolderAdMsg
 * JD-Core Version:    0.7.0.1
 */