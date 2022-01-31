package tencent.im.oidb.cmd0x9c5;

import appoint.define.appoint_define.InterestTag;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0x9c5$RspBody
  extends MessageMicro<RspBody>
{
  public static final int MSG_INTEREST_TAGS_FIELD_NUMBER = 1;
  public static final int STR_ERROR_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_interest_tags", "str_error" }, new Object[] { null, "" }, RspBody.class);
  public final PBRepeatMessageField<appoint_define.InterestTag> msg_interest_tags = PBField.initRepeatMessage(appoint_define.InterestTag.class);
  public final PBStringField str_error = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9c5.cmd0x9c5.RspBody
 * JD-Core Version:    0.7.0.1
 */