package msf.msgcomm;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class msg_comm$C2CTmpMsgHead
  extends MessageMicro<C2CTmpMsgHead>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField business_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField business_sub_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field c2c_type = PBField.initUInt32(0);
  public final PBUInt32Field direction_flag = PBField.initUInt32(0);
  public final PBStringField from_phone = PBField.initString("");
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt64Field group_uin = PBField.initUInt64(0L);
  public final PBUInt32Field lock_display = PBField.initUInt32(0);
  public final PBBytesField reserved = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field service_type = PBField.initUInt32(0);
  public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field sig_type = PBField.initUInt32(0);
  public final PBStringField to_phone = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 58, 66, 72, 80, 90, 114, 122 }, new String[] { "c2c_type", "service_type", "group_uin", "group_code", "sig", "sig_type", "from_phone", "to_phone", "lock_display", "direction_flag", "reserved", "business_name", "business_sub_content" }, new Object[] { localInteger, localInteger, localLong, localLong, localByteStringMicro1, localInteger, "", "", localInteger, localInteger, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, C2CTmpMsgHead.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     msf.msgcomm.msg_comm.C2CTmpMsgHead
 * JD-Core Version:    0.7.0.1
 */