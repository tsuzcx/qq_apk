package tencent.im.oidb.cmd0xe7e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xe7e$ModuleInfo
  extends MessageMicro<ModuleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_json = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field bytes_type = PBField.initUInt32(0);
  public final PBFloatField bytes_weight = PBField.initFloat(0.0F);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 21, 26 }, new String[] { "bytes_type", "bytes_weight", "bytes_json" }, new Object[] { Integer.valueOf(0), Float.valueOf(0.0F), localByteStringMicro }, ModuleInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe7e.oidb_cmd0xe7e.ModuleInfo
 * JD-Core Version:    0.7.0.1
 */