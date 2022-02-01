package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudToastshowsvr$StJumpInfo
  extends MessageMicro<StJumpInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "jumpType", "jumpLink" }, new Object[] { Integer.valueOf(0), "" }, StJumpInfo.class);
  public final PBStringField jumpLink = PBField.initString("");
  public final PBEnumField jumpType = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudToastshowsvr.StJumpInfo
 * JD-Core Version:    0.7.0.1
 */