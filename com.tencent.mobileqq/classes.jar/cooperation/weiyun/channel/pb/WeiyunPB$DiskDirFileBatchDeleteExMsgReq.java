package cooperation.weiyun.channel.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class WeiyunPB$DiskDirFileBatchDeleteExMsgReq
  extends MessageMicro<DiskDirFileBatchDeleteExMsgReq>
{
  public static final int DELETE_COMPLETELY_FIELD_NUMBER = 3;
  public static final int DIR_LIST_FIELD_NUMBER = 1;
  public static final int FILE_LIST_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "dir_list", "file_list", "delete_completely" }, new Object[] { null, null, Boolean.valueOf(false) }, DiskDirFileBatchDeleteExMsgReq.class);
  public final PBBoolField delete_completely = PBField.initBool(false);
  public final PBRepeatMessageField<WeiyunPB.DiskSimpleDirItem> dir_list = PBField.initRepeatMessage(WeiyunPB.DiskSimpleDirItem.class);
  public final PBRepeatMessageField<WeiyunPB.DiskSimpleFileItem> file_list = PBField.initRepeatMessage(WeiyunPB.DiskSimpleFileItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB.DiskDirFileBatchDeleteExMsgReq
 * JD-Core Version:    0.7.0.1
 */