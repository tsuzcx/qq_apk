package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudToastpushsvr$StToastSendReq
  extends MessageMicro<StToastSendReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "toastShowWayType", "toastInfo", "userId", "sceneId", "extStr" }, new Object[] { Integer.valueOf(0), null, "", "", "" }, StToastSendReq.class);
  public final PBStringField extStr = PBField.initString("");
  public final PBStringField sceneId = PBField.initString("");
  public FeedCloudToastshowsvr.StToast toastInfo = new FeedCloudToastshowsvr.StToast();
  public final PBEnumField toastShowWayType = PBField.initEnum(0);
  public final PBStringField userId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudToastpushsvr.StToastSendReq
 * JD-Core Version:    0.7.0.1
 */