package cooperation.weiyun.channel.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class WeiyunPB$DiskSimpleFileItem
  extends MessageMicro<DiskSimpleFileItem>
{
  public static final int FILENAME_FIELD_NUMBER = 2;
  public static final int FILE_ID_FIELD_NUMBER = 1;
  public static final int PDIR_KEY_FIELD_NUMBER = 3;
  public static final int PPDIR_KEY_FIELD_NUMBER = 7;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField file_id = PBField.initString("");
  public final PBStringField filename = PBField.initString("");
  public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 58 }, new String[] { "file_id", "filename", "pdir_key", "ppdir_key" }, new Object[] { "", "", localByteStringMicro1, localByteStringMicro2 }, DiskSimpleFileItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB.DiskSimpleFileItem
 * JD-Core Version:    0.7.0.1
 */