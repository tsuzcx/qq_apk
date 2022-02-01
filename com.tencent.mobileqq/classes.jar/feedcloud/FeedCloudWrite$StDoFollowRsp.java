package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class FeedCloudWrite$StDoFollowRsp
  extends MessageMicro<StDoFollowRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "extInfo", "isDoubly", "result" }, new Object[] { null, Boolean.valueOf(false), Integer.valueOf(1) }, StDoFollowRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBBoolField isDoubly = PBField.initBool(false);
  public final PBEnumField result = PBField.initEnum(1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudWrite.StDoFollowRsp
 * JD-Core Version:    0.7.0.1
 */