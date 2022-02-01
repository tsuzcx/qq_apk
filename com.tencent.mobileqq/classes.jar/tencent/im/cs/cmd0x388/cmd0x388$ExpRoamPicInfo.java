package tencent.im.cs.cmd0x388;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x388$ExpRoamPicInfo
  extends MessageMicro<ExpRoamPicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_pic_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_pkg_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_shop_flag = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_shop_flag", "uint32_pkg_id", "bytes_pic_id" }, new Object[] { localInteger, localInteger, localByteStringMicro }, ExpRoamPicInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.cmd0x388.cmd0x388.ExpRoamPicInfo
 * JD-Core Version:    0.7.0.1
 */