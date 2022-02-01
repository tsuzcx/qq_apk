package tencent.im.s2c.msgtype0x210.submsgtype0x6f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x6f$QimRecomendInfo
  extends MessageMicro<QimRecomendInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_alghbuff = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_longnick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_source_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public SubMsgType0x6f.AddFriendSource msg_android_source = new SubMsgType0x6f.AddFriendSource();
  public SubMsgType0x6f.AddFriendSource msg_ios_source = new SubMsgType0x6f.AddFriendSource();
  public final PBUInt32Field uint32_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_source = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 56, 64, 74, 82, 90 }, new String[] { "uint64_uin", "bytes_name", "bytes_reason", "uint32_gender", "bytes_longnick", "bytes_alghbuff", "uint32_age", "uint32_source", "bytes_source_reason", "msg_ios_source", "msg_android_source" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localInteger, localByteStringMicro3, localByteStringMicro4, localInteger, localInteger, localByteStringMicro5, null, null }, QimRecomendInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.QimRecomendInfo
 * JD-Core Version:    0.7.0.1
 */