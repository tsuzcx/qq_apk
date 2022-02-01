package tencent.im.oidb.cmd0x89a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x89a$GroupSchoolInfo
  extends MessageMicro<GroupSchoolInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_location = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_school = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_grade = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "bytes_location", "uint32_grade", "bytes_school" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, GroupSchoolInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x89a.oidb_0x89a.GroupSchoolInfo
 * JD-Core Version:    0.7.0.1
 */