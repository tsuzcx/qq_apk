package tencent.im.oidb.cmd0x7bb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x7bb$TaskInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField animation = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBBytesField banner = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field begtime = PBField.initUInt64(0L);
  public final PBBytesField config = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field cooldown = PBField.initUInt32(0);
  public final PBUInt64Field endtime = PBField.initUInt64(0L);
  public final PBRepeatMessageField extras = PBField.initRepeatMessage(oidb_0x7bb.ExtraInfo.class);
  public final PBBytesField icon = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field mtime = PBField.initUInt64(0L);
  public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField pic_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field priority = PBField.initUInt32(0);
  public final PBBytesField screen_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field set_id = PBField.initUInt32(0);
  public final PBUInt32Field status = PBField.initUInt32(0);
  public final PBUInt64Field task_id = PBField.initUInt64(0L);
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 50, 58, 64, 74, 104, 112, 120, 128, 138, 168, 178, 186, 194, 202 }, new String[] { "task_id", "set_id", "name", "type", "priority", "icon", "banner", "appid", "pic_id", "status", "begtime", "endtime", "mtime", "extras", "cooldown", "animation", "jump_url", "screen_info", "config" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, Integer.valueOf(0), localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, localByteStringMicro8 }, TaskInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7bb.oidb_0x7bb.TaskInfo
 * JD-Core Version:    0.7.0.1
 */