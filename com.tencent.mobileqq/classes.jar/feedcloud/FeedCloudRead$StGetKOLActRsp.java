package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudRead$StGetKOLActRsp
  extends MessageMicro<StGetKOLActRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "city", "cityRank" }, new Object[] { null, "", Integer.valueOf(0) }, StGetKOLActRsp.class);
  public final PBStringField city = PBField.initString("");
  public final PBUInt32Field cityRank = PBField.initUInt32(0);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StGetKOLActRsp
 * JD-Core Version:    0.7.0.1
 */