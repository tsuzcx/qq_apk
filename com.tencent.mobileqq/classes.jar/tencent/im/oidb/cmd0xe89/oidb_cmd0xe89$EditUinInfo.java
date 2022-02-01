package tencent.im.oidb.cmd0xe89;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xe89$EditUinInfo
  extends MessageMicro<EditUinInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field last_edit_ts = PBField.initUInt32(0);
  public final PBBytesField nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint", "last_edit_ts", "nick_name" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, EditUinInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe89.oidb_cmd0xe89.EditUinInfo
 * JD-Core Version:    0.7.0.1
 */