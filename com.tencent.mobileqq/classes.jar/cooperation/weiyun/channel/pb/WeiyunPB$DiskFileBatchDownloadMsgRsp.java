package cooperation.weiyun.channel.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class WeiyunPB$DiskFileBatchDownloadMsgRsp
  extends MessageMicro<DiskFileBatchDownloadMsgRsp>
{
  public static final int FILE_LIST_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "file_list" }, new Object[] { null }, DiskFileBatchDownloadMsgRsp.class);
  public final PBRepeatMessageField<WeiyunPB.DiskFileDownloadRspItem> file_list = PBField.initRepeatMessage(WeiyunPB.DiskFileDownloadRspItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB.DiskFileBatchDownloadMsgRsp
 * JD-Core Version:    0.7.0.1
 */