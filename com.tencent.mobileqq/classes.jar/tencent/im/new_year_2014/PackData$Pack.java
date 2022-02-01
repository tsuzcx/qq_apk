package tencent.im.new_year_2014;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PackData$Pack
  extends MessageMicro<Pack>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBUInt32Field business = PBField.initUInt32(0);
  public final PBUInt32Field ctime = PBField.initUInt32(0);
  public final PBBoolField empty = PBField.initBool(false);
  public final PBUInt32Field etime = PBField.initUInt32(0);
  public final PBBoolField expired = PBField.initBool(false);
  public final PBUInt32Field group_id = PBField.initUInt32(0);
  public final PBUInt32Field group_type = PBField.initUInt32(0);
  public final PBBoolField locked = PBField.initBool(false);
  public final PBUInt32Field money = PBField.initUInt32(0);
  public final PBUInt32Field mtime = PBField.initUInt32(0);
  public final PBStringField order = PBField.initString("");
  public final PBBytesField pack_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField peer_face = PBField.initString("");
  public final PBBytesField peer_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field peer_uin = PBField.initUInt64(0L);
  public final PBUInt32Field promotion_id = PBField.initUInt32(0);
  public final PBBoolField provider_dead = PBField.initBool(false);
  public final PBBytesField signature = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field state = PBField.initUInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBStringField url = PBField.initString("");
  public final PBUInt32Field user_apn = PBField.initUInt32(0);
  public final PBStringField user_ip = PBField.initString("");
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 58, 66, 72, 80, 90, 96, 104, 114, 122, 128, 136, 144, 152, 162, 168, 176, 184, 192, 200 }, new String[] { "pack_id", "state", "type", "ctime", "money", "business", "signature", "url", "peer_uin", "etime", "peer_nick", "expired", "locked", "order", "peer_face", "uin", "group_type", "group_id", "promotion_id", "user_ip", "user_apn", "empty", "appid", "provider_dead", "mtime" }, new Object[] { localByteStringMicro1, localInteger, localInteger, localInteger, localInteger, localInteger, localByteStringMicro2, "", Long.valueOf(0L), localInteger, localByteStringMicro3, localBoolean, localBoolean, "", "", Long.valueOf(0L), localInteger, localInteger, localInteger, "", localInteger, localBoolean, localInteger, localBoolean, localInteger }, Pack.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.new_year_2014.PackData.Pack
 * JD-Core Version:    0.7.0.1
 */