package cooperation.weiyun.channel.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class WeiyunPB$ShareFileItem
  extends MessageMicro<ShareFileItem>
{
  public static final int FILE_ID_FIELD_NUMBER = 2;
  public static final int PDIR_KEY_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField file_id = PBField.initString("");
  public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "pdir_key", "file_id" }, new Object[] { localByteStringMicro, "" }, ShareFileItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB.ShareFileItem
 * JD-Core Version:    0.7.0.1
 */