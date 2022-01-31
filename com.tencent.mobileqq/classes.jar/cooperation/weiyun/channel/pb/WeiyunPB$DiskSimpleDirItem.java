package cooperation.weiyun.channel.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class WeiyunPB$DiskSimpleDirItem
  extends MessageMicro
{
  public static final int DIR_KEY_FIELD_NUMBER = 1;
  public static final int DIR_NAME_FIELD_NUMBER = 2;
  public static final int PDIR_KEY_FIELD_NUMBER = 5;
  public static final int PPDIR_KEY_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField dir_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField dir_name = PBField.initString("");
  public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 34, 42 }, new String[] { "dir_key", "dir_name", "ppdir_key", "pdir_key" }, new Object[] { localByteStringMicro1, "", localByteStringMicro2, localByteStringMicro3 }, DiskSimpleDirItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB.DiskSimpleDirItem
 * JD-Core Version:    0.7.0.1
 */