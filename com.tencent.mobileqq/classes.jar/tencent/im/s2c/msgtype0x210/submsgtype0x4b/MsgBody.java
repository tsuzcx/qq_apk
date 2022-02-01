package tencent.im.s2c.msgtype0x210.submsgtype0x4b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<Long> rpt_uint64_user = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBStringField string_albumName = PBField.initString("");
  public final PBStringField string_albumid = PBField.initString("");
  public final PBStringField string_coverUrl = PBField.initString("");
  public final PBStringField string_push_msg_album = PBField.initString("");
  public final PBStringField string_push_msg_helper = PBField.initString("");
  public final PBUInt32Field uint32_pic_cnt = PBField.initUInt32(0);
  public final PBFixed32Field uint32_time = PBField.initFixed32(0);
  public final PBUInt32Field uint32_usr_total = PBField.initUInt32(0);
  public final PBUInt64Field uint64_opuin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 45, 48, 58, 66, 72, 80 }, new String[] { "string_albumid", "string_coverUrl", "string_albumName", "uint64_opuin", "uint32_time", "uint32_pic_cnt", "string_push_msg_helper", "string_push_msg_album", "uint32_usr_total", "rpt_uint64_user" }, new Object[] { "", "", "", localLong, localInteger, localInteger, "", "", localInteger, localLong }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x4b.MsgBody
 * JD-Core Version:    0.7.0.1
 */