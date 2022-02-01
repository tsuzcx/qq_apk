package msf.msgsvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_svc$BusinessWPATmp
  extends MessageMicro<BusinessWPATmp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField sigt = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field to_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "to_uin", "sig", "sigt" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, BusinessWPATmp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     msf.msgsvc.msg_svc.BusinessWPATmp
 * JD-Core Version:    0.7.0.1
 */