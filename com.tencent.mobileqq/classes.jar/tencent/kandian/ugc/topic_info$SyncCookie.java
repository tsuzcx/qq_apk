package tencent.kandian.ugc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class topic_info$SyncCookie
  extends MessageMicro<SyncCookie>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48 }, new String[] { "start", "is_end", "module_id", "type", "end_rowkey", "end_rowkey_score" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L) }, SyncCookie.class);
  public final PBStringField end_rowkey = PBField.initString("");
  public final PBUInt64Field end_rowkey_score = PBField.initUInt64(0L);
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public final PBUInt32Field module_id = PBField.initUInt32(0);
  public final PBUInt64Field start = PBField.initUInt64(0L);
  public final PBUInt32Field type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.kandian.ugc.topic_info.SyncCookie
 * JD-Core Version:    0.7.0.1
 */