package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hummer_commelem$MsgElemInfo_servtype37
  extends MessageMicro<MsgElemInfo_servtype37>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_packid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_resultid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_stickerid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_surpriseid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_qsid = PBField.initUInt32(0);
  public final PBEnumField uint32_randomtype = PBField.initEnum(1);
  public final PBEnumField uint32_sourcetype = PBField.initEnum(1);
  public final PBEnumField uint32_stickertype = PBField.initEnum(1);
  
  static
  {
    Integer localInteger = Integer.valueOf(1);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 58, 66, 72 }, new String[] { "bytes_packid", "bytes_stickerid", "uint32_qsid", "uint32_sourcetype", "uint32_stickertype", "bytes_resultid", "bytes_text", "bytes_surpriseid", "uint32_randomtype" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localInteger, localInteger, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localInteger }, MsgElemInfo_servtype37.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype37
 * JD-Core Version:    0.7.0.1
 */