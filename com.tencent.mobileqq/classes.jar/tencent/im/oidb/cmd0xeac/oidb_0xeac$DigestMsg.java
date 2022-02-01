package tencent.im.oidb.cmd0xeac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xeac$DigestMsg
  extends MessageMicro<DigestMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112 }, new String[] { "group_code", "msg_seq", "msg_random", "msg_content", "text_size", "pic_size", "video_size", "sender_uin", "sender_time", "add_digest_uin", "add_digest_time", "start_time", "latest_msg_seq", "op_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, DigestMsg.class);
  public final PBUInt32Field add_digest_time = PBField.initUInt32(0);
  public final PBUInt64Field add_digest_uin = PBField.initUInt64(0L);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt32Field latest_msg_seq = PBField.initUInt32(0);
  public final PBRepeatMessageField<oidb_0xeac.MsgElem> msg_content = PBField.initRepeatMessage(oidb_0xeac.MsgElem.class);
  public final PBUInt32Field msg_random = PBField.initUInt32(0);
  public final PBUInt32Field msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field op_type = PBField.initUInt32(0);
  public final PBUInt64Field pic_size = PBField.initUInt64(0L);
  public final PBUInt32Field sender_time = PBField.initUInt32(0);
  public final PBUInt64Field sender_uin = PBField.initUInt64(0L);
  public final PBUInt32Field start_time = PBField.initUInt32(0);
  public final PBUInt64Field text_size = PBField.initUInt64(0L);
  public final PBUInt64Field video_size = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeac.oidb_0xeac.DigestMsg
 * JD-Core Version:    0.7.0.1
 */