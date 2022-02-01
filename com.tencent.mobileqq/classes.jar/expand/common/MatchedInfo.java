package expand.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MatchedInfo
  extends MessageMicro<MatchedInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 32, 42 }, new String[] { "MatchedUin", "Timestamp", "MatchSrcId", "MatchSrcDes" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "" }, MatchedInfo.class);
  public final PBStringField MatchSrcDes = PBField.initString("");
  public final PBUInt32Field MatchSrcId = PBField.initUInt32(0);
  public final PBUInt64Field MatchedUin = PBField.initUInt64(0L);
  public final PBUInt64Field Timestamp = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     expand.common.MatchedInfo
 * JD-Core Version:    0.7.0.1
 */