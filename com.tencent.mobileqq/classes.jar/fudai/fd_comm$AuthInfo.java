package fudai;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class fd_comm$AuthInfo
  extends MessageMicro<AuthInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField a8 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBUInt32Field city_code = PBField.initUInt32(0);
  public final PBUInt32Field ctime = PBField.initUInt32(0);
  public final PBStringField imei = PBField.initString("");
  public final PBStringField latitude = PBField.initString("");
  public final PBStringField longitude = PBField.initString("");
  public final PBUInt32Field net_type = PBField.initUInt32(0);
  public final PBBytesField skey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 88, 98, 170, 178, 184 }, new String[] { "uin", "ctime", "skey", "a8", "appid", "net_type", "imei", "longitude", "latitude", "city_code" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(0) }, AuthInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     fudai.fd_comm.AuthInfo
 * JD-Core Version:    0.7.0.1
 */