package tencent.im.oidb;

import appoint.define.appoint_define.AppointID;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x5fe$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int MSG_APPOINT_ID_FIELD_NUMBER = 1;
  public static final int STR_COMMENT_ID_FIELD_NUMBER = 2;
  public static final int UINT32_FETCH_NEW_COUNT_FIELD_NUMBER = 4;
  public static final int UINT32_FETCH_OLD_COUNT_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "msg_appoint_id", "str_comment_id", "uint32_fetch_old_count", "uint32_fetch_new_count" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public appoint_define.AppointID msg_appoint_id = new appoint_define.AppointID();
  public final PBStringField str_comment_id = PBField.initString("");
  public final PBUInt32Field uint32_fetch_new_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_fetch_old_count = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5fe.ReqBody
 * JD-Core Version:    0.7.0.1
 */