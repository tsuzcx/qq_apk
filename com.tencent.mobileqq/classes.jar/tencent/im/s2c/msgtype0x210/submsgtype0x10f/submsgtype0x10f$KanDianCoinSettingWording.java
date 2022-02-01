package tencent.im.s2c.msgtype0x210.submsgtype0x10f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class submsgtype0x10f$KanDianCoinSettingWording
  extends MessageMicro<KanDianCoinSettingWording>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_picture_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_wording", "bytes_picture_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, KanDianCoinSettingWording.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x10f.submsgtype0x10f.KanDianCoinSettingWording
 * JD-Core Version:    0.7.0.1
 */