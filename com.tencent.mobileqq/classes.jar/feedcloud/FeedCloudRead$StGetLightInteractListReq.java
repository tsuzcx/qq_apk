package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudRead$StGetLightInteractListReq
  extends MessageMicro<StGetLightInteractListReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField attachInfo = PBField.initString("");
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBStringField feedID = PBField.initString("");
  public final PBStringField hostID = PBField.initString("");
  public final PBStringField id = PBField.initString("");
  public final PBInt32Field source = PBField.initInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 56 }, new String[] { "extInfo", "type", "attachInfo", "id", "hostID", "feedID", "source" }, new Object[] { null, localInteger, "", "", "", "", localInteger }, StGetLightInteractListReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StGetLightInteractListReq
 * JD-Core Version:    0.7.0.1
 */