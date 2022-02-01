package common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class QqAdGetProtos$QQAdGetRsp$AdInfo$QQAppInfo
  extends MessageMicro<QQAppInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField app_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField app_path = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField app_schema = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "app_id", "app_path", "app_schema" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, QQAppInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     common.QqAdGetProtos.QQAdGetRsp.AdInfo.QQAppInfo
 * JD-Core Version:    0.7.0.1
 */