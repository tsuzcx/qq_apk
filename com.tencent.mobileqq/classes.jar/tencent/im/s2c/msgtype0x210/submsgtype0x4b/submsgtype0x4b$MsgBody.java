package tencent.im.s2c.msgtype0x210.submsgtype0x4b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0x4b$MsgBody
  extends MessageMicro
{
  public static final int RPT_UINT64_USER_FIELD_NUMBER = 10;
  public static final int STRING_ALBUMID_FIELD_NUMBER = 1;
  public static final int STRING_ALBUMNAME_FIELD_NUMBER = 3;
  public static final int STRING_COVERURL_FIELD_NUMBER = 2;
  public static final int STRING_PUSH_MSG_ALBUM_FIELD_NUMBER = 8;
  public static final int STRING_PUSH_MSG_HELPER_FIELD_NUMBER = 7;
  public static final int UINT32_PIC_CNT_FIELD_NUMBER = 6;
  public static final int UINT32_TIME_FIELD_NUMBER = 5;
  public static final int UINT32_USR_TOTAL_FIELD_NUMBER = 9;
  public static final int UINT64_OPUIN_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 45, 48, 58, 66, 72, 80 }, new String[] { "string_albumid", "string_coverUrl", "string_albumName", "uint64_opuin", "uint32_time", "uint32_pic_cnt", "string_push_msg_helper", "string_push_msg_album", "uint32_usr_total", "rpt_uint64_user" }, new Object[] { "", "", "", Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Long.valueOf(0L) }, MsgBody.class);
  public final PBRepeatField rpt_uint64_user = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBStringField string_albumName = PBField.initString("");
  public final PBStringField string_albumid = PBField.initString("");
  public final PBStringField string_coverUrl = PBField.initString("");
  public final PBStringField string_push_msg_album = PBField.initString("");
  public final PBStringField string_push_msg_helper = PBField.initString("");
  public final PBUInt32Field uint32_pic_cnt = PBField.initUInt32(0);
  public final PBFixed32Field uint32_time = PBField.initFixed32(0);
  public final PBUInt32Field uint32_usr_total = PBField.initUInt32(0);
  public final PBUInt64Field uint64_opuin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x4b.submsgtype0x4b.MsgBody
 * JD-Core Version:    0.7.0.1
 */