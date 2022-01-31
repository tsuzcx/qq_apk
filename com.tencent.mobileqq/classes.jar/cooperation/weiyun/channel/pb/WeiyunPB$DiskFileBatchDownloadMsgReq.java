package cooperation.weiyun.channel.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WeiyunPB$DiskFileBatchDownloadMsgReq
  extends MessageMicro
{
  public static final int DOWNLOAD_TYPE_FIELD_NUMBER = 4;
  public static final int FILE_LIST_FIELD_NUMBER = 1;
  public static final int FILE_OWNER_FIELD_NUMBER = 2;
  public static final int NEED_THUMB_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "file_list", "file_owner", "need_thumb", "download_type" }, new Object[] { null, Long.valueOf(0L), Boolean.valueOf(false), Integer.valueOf(0) }, DiskFileBatchDownloadMsgReq.class);
  public final PBUInt32Field download_type = PBField.initUInt32(0);
  public final PBRepeatMessageField file_list = PBField.initRepeatMessage(WeiyunPB.DiskSimpleFileItem.class);
  public final PBUInt64Field file_owner = PBField.initUInt64(0L);
  public final PBBoolField need_thumb = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB.DiskFileBatchDownloadMsgReq
 * JD-Core Version:    0.7.0.1
 */