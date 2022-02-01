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
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField MatchSrcDes = PBField.initString("");
  public final PBUInt32Field MatchSrcId = PBField.initUInt32(0);
  public final PBUInt64Field MatchedUin = PBField.initUInt64(0L);
  public final PBUInt64Field Timestamp = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 32, 42 }, new String[] { "MatchedUin", "Timestamp", "MatchSrcId", "MatchSrcDes" }, new Object[] { localLong, localLong, Integer.valueOf(0), "" }, MatchedInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     expand.common.MatchedInfo
 * JD-Core Version:    0.7.0.1
 */