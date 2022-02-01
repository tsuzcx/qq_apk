package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudMeta$StReportInfo
  extends MessageMicro<StReportInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiReport = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField id = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "id", "busiReport" }, new Object[] { "", localByteStringMicro }, StReportInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StReportInfo
 * JD-Core Version:    0.7.0.1
 */