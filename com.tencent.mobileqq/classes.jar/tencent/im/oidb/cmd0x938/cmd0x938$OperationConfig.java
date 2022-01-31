package tencent.im.oidb.cmd0x938;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class cmd0x938$OperationConfig
  extends MessageMicro<OperationConfig>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_button_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_button_wording" }, new Object[] { localByteStringMicro }, OperationConfig.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x938.cmd0x938.OperationConfig
 * JD-Core Version:    0.7.0.1
 */