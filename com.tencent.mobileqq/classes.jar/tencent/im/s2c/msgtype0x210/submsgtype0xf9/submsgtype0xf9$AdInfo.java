package tencent.im.s2c.msgtype0x210.submsgtype0xf9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xf9$AdInfo
  extends MessageMicro<AdInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 56, 64, 74, 82, 90, 96, 104, 112 }, new String[] { "uint64_from_uin", "str_nick", "str_head_url", "str_brief", "str_action", "uint32_flag", "uint32_serviceID", "uint32_templateID", "str_url", "msg_msgCommonData", "rpt_msg_video", "uint32_pushTime", "uint32_invalidTime", "uint32_maxExposureTime" }, new Object[] { Long.valueOf(0L), "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, AdInfo.class);
  public submsgtype0xf9.MsgCommonData msg_msgCommonData = new submsgtype0xf9.MsgCommonData();
  public final PBRepeatMessageField<submsgtype0xf9.Video> rpt_msg_video = PBField.initRepeatMessage(submsgtype0xf9.Video.class);
  public final PBStringField str_action = PBField.initString("");
  public final PBStringField str_brief = PBField.initString("");
  public final PBStringField str_head_url = PBField.initString("");
  public final PBStringField str_nick = PBField.initString("");
  public final PBStringField str_url = PBField.initString("");
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_invalidTime = PBField.initUInt32(0);
  public final PBUInt32Field uint32_maxExposureTime = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pushTime = PBField.initUInt32(0);
  public final PBUInt32Field uint32_serviceID = PBField.initUInt32(0);
  public final PBUInt32Field uint32_templateID = PBField.initUInt32(0);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xf9.submsgtype0xf9.AdInfo
 * JD-Core Version:    0.7.0.1
 */