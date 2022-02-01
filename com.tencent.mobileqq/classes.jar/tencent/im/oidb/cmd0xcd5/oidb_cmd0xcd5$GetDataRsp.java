package tencent.im.oidb.cmd0xcd5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xcd5$GetDataRsp
  extends MessageMicro<GetDataRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field flag = PBField.initUInt32(0);
  public final PBBytesField pb_data = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "flag", "pb_data" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, GetDataRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5.GetDataRsp
 * JD-Core Version:    0.7.0.1
 */