package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class TroopTips0x857$QQVaLiveNotifyMsg
  extends MessageMicro<QQVaLiveNotifyMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ext1 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_ext2 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_ext3 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_uid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field notify_type = PBField.initInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42 }, new String[] { "bytes_uid", "notify_type", "bytes_ext1", "bytes_ext2", "bytes_ext3" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, QQVaLiveNotifyMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.QQVaLiveNotifyMsg
 * JD-Core Version:    0.7.0.1
 */