package tencent.im.s2c.msgtype0x210.submsgtype0x135;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class ModulePushPb$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_notify_id = PBField.initInt32(0);
  public final PBInt32Field int32_push_id = PBField.initInt32(0);
  public final PBInt32Field int32_recall_flag = PBField.initInt32(0);
  public final PBInt32Field int32_service_id = PBField.initInt32(0);
  public final PBInt32Field int32_sub_service_id = PBField.initInt32(0);
  public final PBInt32Field int32_type = PBField.initInt32(0);
  public ModulePushPb.Content msg_content = new ModulePushPb.Content();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58 }, new String[] { "int32_service_id", "int32_sub_service_id", "int32_notify_id", "int32_push_id", "int32_type", "int32_recall_flag", "msg_content" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, null }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x135.ModulePushPb.MsgBody
 * JD-Core Version:    0.7.0.1
 */