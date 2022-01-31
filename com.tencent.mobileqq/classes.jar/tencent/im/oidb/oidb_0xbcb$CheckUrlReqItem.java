package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xbcb$CheckUrlReqItem
  extends MessageMicro<CheckUrlReqItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 56, 64, 72, 82 }, new String[] { "url", "refer", "plateform", "qq_pf_to", "msg_type", "msg_from", "msg_chatid", "service_type", "send_uin", "req_type" }, new Object[] { "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "" }, CheckUrlReqItem.class);
  public final PBUInt64Field msg_chatid = PBField.initUInt64(0L);
  public final PBUInt32Field msg_from = PBField.initUInt32(0);
  public final PBUInt32Field msg_type = PBField.initUInt32(0);
  public final PBStringField plateform = PBField.initString("");
  public final PBStringField qq_pf_to = PBField.initString("");
  public final PBStringField refer = PBField.initString("");
  public final PBStringField req_type = PBField.initString("");
  public final PBUInt64Field send_uin = PBField.initUInt64(0L);
  public final PBUInt64Field service_type = PBField.initUInt64(0L);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xbcb.CheckUrlReqItem
 * JD-Core Version:    0.7.0.1
 */