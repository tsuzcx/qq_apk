package cooperation.weiyun.channel.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WeiyunPB$DiskFileDocDownloadAbsMsgReq
  extends MessageMicro<DiskFileDocDownloadAbsMsgReq>
{
  public static final int FILE_ID_FIELD_NUMBER = 2;
  public static final int FILE_OWNER_FIELD_NUMBER = 3;
  public static final int PDIR_KEY_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField file_id = PBField.initString("");
  public final PBUInt64Field file_owner = PBField.initUInt64(0L);
  public final PBBytesField pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "pdir_key", "file_id", "file_owner" }, new Object[] { localByteStringMicro, "", Long.valueOf(0L) }, DiskFileDocDownloadAbsMsgReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB.DiskFileDocDownloadAbsMsgReq
 * JD-Core Version:    0.7.0.1
 */