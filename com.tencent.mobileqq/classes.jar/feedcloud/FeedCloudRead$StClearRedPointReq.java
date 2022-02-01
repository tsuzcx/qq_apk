package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudRead$StClearRedPointReq
  extends MessageMicro<StClearRedPointReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42 }, new String[] { "extInfo", "pageType", "userID", "groupID", "toUID" }, new Object[] { null, Integer.valueOf(0), "", "", "" }, StClearRedPointReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBStringField groupID = PBField.initString("");
  public final PBInt32Field pageType = PBField.initInt32(0);
  public final PBStringField toUID = PBField.initString("");
  public final PBStringField userID = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StClearRedPointReq
 * JD-Core Version:    0.7.0.1
 */