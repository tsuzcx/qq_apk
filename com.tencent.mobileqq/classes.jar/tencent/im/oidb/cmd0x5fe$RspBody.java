package tencent.im.oidb;

import appoint.define.appoint_define.DateComment;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x5fe$RspBody
  extends MessageMicro<RspBody>
{
  public static final int MSG_COMMENT_FIELD_NUMBER = 1;
  public static final int STR_ERROR_TIPS_FIELD_NUMBER = 2;
  public static final int UINT32_FETCH_NEW_OVER_FIELD_NUMBER = 4;
  public static final int UINT32_FETCH_OLD_OVER_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<appoint_define.DateComment> msg_comment = PBField.initRepeatMessage(appoint_define.DateComment.class);
  public final PBStringField str_error_tips = PBField.initString("");
  public final PBUInt32Field uint32_fetch_new_over = PBField.initUInt32(0);
  public final PBUInt32Field uint32_fetch_old_over = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "msg_comment", "str_error_tips", "uint32_fetch_old_over", "uint32_fetch_new_over" }, new Object[] { null, "", localInteger, localInteger }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5fe.RspBody
 * JD-Core Version:    0.7.0.1
 */