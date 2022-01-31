package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudTagStorage$HotTagRecord
  extends MessageMicro<HotTagRecord>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "tagName", "totalCnt", "createTime" }, new Object[] { "", Long.valueOf(0L), Long.valueOf(0L) }, HotTagRecord.class);
  public final PBInt64Field createTime = PBField.initInt64(0L);
  public final PBStringField tagName = PBField.initString("");
  public final PBInt64Field totalCnt = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     feedcloud.FeedCloudTagStorage.HotTagRecord
 * JD-Core Version:    0.7.0.1
 */