package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.group.group_label.GroupLabel.Label;

public final class cmd0x8b4$GroupInfo
  extends MessageMicro<GroupInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_rich_intro = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_text_intro = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<GroupLabel.Label> rpt_group_label = PBField.initRepeatMessage(GroupLabel.Label.class);
  public final PBStringField str_face_url = PBField.initString("");
  public final PBStringField str_group_name = PBField.initString("");
  public final PBUInt32Field uint32_set_display_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_gc = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58 }, new String[] { "uint64_gc", "str_group_name", "str_face_url", "uint32_set_display_time", "rpt_group_label", "bytes_text_intro", "bytes_rich_intro" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0), null, localByteStringMicro1, localByteStringMicro2 }, GroupInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8b4.GroupInfo
 * JD-Core Version:    0.7.0.1
 */