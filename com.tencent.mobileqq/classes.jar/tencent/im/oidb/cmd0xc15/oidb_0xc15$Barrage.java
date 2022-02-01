package tencent.im.oidb.cmd0xc15;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xc15$Barrage
  extends MessageMicro<Barrage>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_barrage_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_comment = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_comment_corner_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0xc15.Sender rpt_sender = new oidb_0xc15.Sender();
  public final PBUInt32Field uint32_barrage_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "bytes_barrage_id", "rpt_sender", "bytes_comment", "bytes_comment_corner_url", "uint32_barrage_type" }, new Object[] { localByteStringMicro1, null, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0) }, Barrage.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc15.oidb_0xc15.Barrage
 * JD-Core Version:    0.7.0.1
 */