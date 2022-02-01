package tencent.im.oidb.cmd0xfa4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xfa4$MsgBoardInfo
  extends MessageMicro<MsgBoardInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField icon = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0xfa4.SourceInfo id = new oidb_cmd0xfa4.SourceInfo();
  public final PBBoolField is_red = PBField.initBool(false);
  public final PBUInt64Field time_stamp = PBField.initUInt64(0L);
  public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48 }, new String[] { "id", "title", "icon", "url", "time_stamp", "is_red" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), Boolean.valueOf(false) }, MsgBoardInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xfa4.oidb_cmd0xfa4.MsgBoardInfo
 * JD-Core Version:    0.7.0.1
 */