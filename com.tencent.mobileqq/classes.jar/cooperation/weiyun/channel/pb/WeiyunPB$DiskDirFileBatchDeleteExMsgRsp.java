package cooperation.weiyun.channel.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WeiyunPB$DiskDirFileBatchDeleteExMsgRsp
  extends MessageMicro
{
  public static final int DIR_LIST_FIELD_NUMBER = 3;
  public static final int FILE_LIST_FIELD_NUMBER = 4;
  public static final int FREED_INDEX_CNT_FIELD_NUMBER = 2;
  public static final int FREED_SPACE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "freed_space", "freed_index_cnt", "dir_list", "file_list" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, null }, DiskDirFileBatchDeleteExMsgRsp.class);
  public final PBRepeatMessageField dir_list = PBField.initRepeatMessage(WeiyunPB.DiskSimpleDirItemResult.class);
  public final PBRepeatMessageField file_list = PBField.initRepeatMessage(WeiyunPB.DiskSimpleFileItemResult.class);
  public final PBUInt32Field freed_index_cnt = PBField.initUInt32(0);
  public final PBInt64Field freed_space = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB.DiskDirFileBatchDeleteExMsgRsp
 * JD-Core Version:    0.7.0.1
 */