package tencent.im.oidb;

import appoint.define.appoint_define.AppointID;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0x5ff$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int MSG_APPOINT_ID_FIELD_NUMBER = 1;
  public static final int STR_COMMENT_ID_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_appoint_id", "str_comment_id" }, new Object[] { null, "" }, ReqBody.class);
  public appoint_define.AppointID msg_appoint_id = new appoint_define.AppointID();
  public final PBStringField str_comment_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5ff.ReqBody
 * JD-Core Version:    0.7.0.1
 */