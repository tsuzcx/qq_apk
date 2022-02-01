package tencent.im.oidb.cmd0xe9b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xe9b$BasicProfileData
  extends MessageMicro<BasicProfileData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_addfrd_src = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_place = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_comm_frd_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "uint32_age", "uint32_gender", "bytes_place", "bytes_addfrd_src", "uint32_comm_frd_num" }, new Object[] { localInteger, localInteger, localByteStringMicro1, localByteStringMicro2, localInteger }, BasicProfileData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe9b.oidb_0xe9b.BasicProfileData
 * JD-Core Version:    0.7.0.1
 */