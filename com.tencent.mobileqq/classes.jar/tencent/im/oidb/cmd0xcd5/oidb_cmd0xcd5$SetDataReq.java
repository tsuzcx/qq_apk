package tencent.im.oidb.cmd0xcd5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_cmd0xcd5$SetDataReq
  extends MessageMicro<SetDataReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField pb_data = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "pb_data" }, new Object[] { localByteStringMicro }, SetDataReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5.SetDataReq
 * JD-Core Version:    0.7.0.1
 */