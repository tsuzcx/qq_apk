package face;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FaceForeignIp$AvailableRequest
  extends MessageMicro<AvailableRequest>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field appID = PBField.initUInt32(0);
  public final PBRepeatField<Integer> dims = PBField.initRepeat(PBEnumField.__repeatHelper__);
  public final PBStringField from = PBField.initString("");
  public final PBBytesField ip = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField name = PBField.initString("");
  public final PBUInt32Field platform = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBBytesField version = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 80, 90, 96, 106 }, new String[] { "dims", "appID", "name", "from", "uin", "ip", "platform", "version" }, new Object[] { localInteger, localInteger, "", "", Long.valueOf(0L), localByteStringMicro1, localInteger, localByteStringMicro2 }, AvailableRequest.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     face.FaceForeignIp.AvailableRequest
 * JD-Core Version:    0.7.0.1
 */