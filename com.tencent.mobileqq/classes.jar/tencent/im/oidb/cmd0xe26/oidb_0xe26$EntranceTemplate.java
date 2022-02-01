package tencent.im.oidb.cmd0xe26;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xe26$EntranceTemplate
  extends MessageMicro<EntranceTemplate>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_icon_custom_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field end_time = PBField.initUInt32(0);
  public final PBUInt32Field id = PBField.initUInt32(0);
  public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field start_time = PBField.initUInt32(0);
  public final PBUInt32Field state = PBField.initUInt32(0);
  public final PBBytesField template_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField trace_info = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48, 56, 66, 74, 82, 90 }, new String[] { "id", "name", "state", "template_text", "start_time", "end_time", "type", "bytes_url", "bytes_icon_url", "bytes_icon_custom_url", "trace_info" }, new Object[] { localInteger, localByteStringMicro1, localInteger, localByteStringMicro2, localInteger, localInteger, localInteger, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, "" }, EntranceTemplate.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe26.oidb_0xe26.EntranceTemplate
 * JD-Core Version:    0.7.0.1
 */