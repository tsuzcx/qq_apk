package tencent.im.oidb.device;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MiniFileProto$MiniFile
  extends MessageMicro<MiniFile>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field length = PBField.initUInt64(0L);
  public final PBBytesField md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField name = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "md5", "name", "length" }, new Object[] { localByteStringMicro, "", Long.valueOf(0L) }, MiniFile.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.device.MiniFileProto.MiniFile
 * JD-Core Version:    0.7.0.1
 */