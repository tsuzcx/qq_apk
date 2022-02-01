package tencent.im.oidb.cmd0xfa4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xfa4$MsgBoardTypeInfo
  extends MessageMicro<MsgBoardTypeInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<oidb_cmd0xfa4.MsgBoardInfo> rpt_msg = PBField.initRepeatMessage(oidb_cmd0xfa4.MsgBoardInfo.class);
  public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField type = PBField.initEnum(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "type", "title", "rpt_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null }, MsgBoardTypeInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xfa4.oidb_cmd0xfa4.MsgBoardTypeInfo
 * JD-Core Version:    0.7.0.1
 */