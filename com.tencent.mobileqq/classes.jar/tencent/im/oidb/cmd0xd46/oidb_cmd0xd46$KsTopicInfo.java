package tencent.im.oidb.cmd0xd46;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xd46$KsTopicInfo
  extends MessageMicro<KsTopicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_web_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subscribe_ts = PBField.initUInt32(0);
  public final PBUInt32Field uint32_update_cnt = PBField.initUInt32(0);
  public final PBUInt32Field uint32_update_ts = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 88, 96, 104 }, new String[] { "uint32_id", "bytes_title", "bytes_icon_url", "bytes_web_url", "uint32_subscribe_ts", "uint32_update_ts", "uint32_update_cnt" }, new Object[] { localInteger, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localInteger, localInteger, localInteger }, KsTopicInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd46.oidb_cmd0xd46.KsTopicInfo
 * JD-Core Version:    0.7.0.1
 */