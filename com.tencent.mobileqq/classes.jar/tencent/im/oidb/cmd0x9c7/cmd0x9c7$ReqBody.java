package tencent.im.oidb.cmd0x9c7;

import appoint.define.appoint_define.InterestTag;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x9c7$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int RPT_MSG_TAGS_FIELD_NUMBER = 3;
  public static final int UINT32_SET_MODE_FIELD_NUMBER = 1;
  public static final int UINT32_TEST_MODE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_set_mode", "uint32_test_mode", "rpt_msg_tags" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, ReqBody.class);
  public final PBRepeatMessageField<appoint_define.InterestTag> rpt_msg_tags = PBField.initRepeatMessage(appoint_define.InterestTag.class);
  public final PBUInt32Field uint32_set_mode = PBField.initUInt32(0);
  public final PBUInt32Field uint32_test_mode = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9c7.cmd0x9c7.ReqBody
 * JD-Core Version:    0.7.0.1
 */