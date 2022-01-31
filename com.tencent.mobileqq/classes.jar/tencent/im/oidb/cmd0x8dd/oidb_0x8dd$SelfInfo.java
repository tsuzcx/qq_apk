package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8dd$SelfInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_birthday = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x8dd.LoginScore msg_cur_login_score = new oidb_0x8dd.LoginScore();
  public final PBStringField str_third_line_icon = PBField.initString("");
  public final PBStringField str_third_line_info = PBField.initString("");
  public final PBUInt32Field uint32_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_all_task_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_charm = PBField.initUInt32(0);
  public final PBUInt32Field uint32_charm_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_finish_task_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_god_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_heart_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_real_video_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vote_increment = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vote_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 56, 64, 72, 80, 90, 98, 104, 112, 122, 128, 136 }, new String[] { "uint64_tinyid", "uint32_gender", "uint32_age", "bytes_birthday", "bytes_nick", "uint32_vote_num", "uint32_vote_increment", "uint32_charm", "uint32_charm_level", "uint32_god_flag", "str_third_line_info", "str_third_line_icon", "uint32_heart_num", "uint32_real_video_flag", "msg_cur_login_score", "uint32_finish_task_num", "uint32_all_task_num" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, SelfInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo
 * JD-Core Version:    0.7.0.1
 */