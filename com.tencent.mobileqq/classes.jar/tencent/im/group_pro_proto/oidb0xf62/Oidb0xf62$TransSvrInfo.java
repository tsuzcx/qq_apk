package tencent.im.group_pro_proto.oidb0xf62;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb0xf62$TransSvrInfo
  extends MessageMicro<TransSvrInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field ret_code = PBField.initInt32(0);
  public final PBUInt32Field sub_type = PBField.initUInt32(0);
  public final PBBytesField trans_info = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "sub_type", "ret_code", "err_msg", "trans_info" }, new Object[] { localInteger, localInteger, localByteStringMicro1, localByteStringMicro2 }, TransSvrInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.oidb0xf62.Oidb0xf62.TransSvrInfo
 * JD-Core Version:    0.7.0.1
 */