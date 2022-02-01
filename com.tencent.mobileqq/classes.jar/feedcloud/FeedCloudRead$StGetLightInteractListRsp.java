package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudRead$StGetLightInteractListRsp
  extends MessageMicro<StGetLightInteractListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField attachInfo = PBField.initString("");
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBUInt32Field isFinish = PBField.initUInt32(0);
  public final PBRepeatMessageField<FeedCloudMeta.StLightInteractInfo> listInfo = PBField.initRepeatMessage(FeedCloudMeta.StLightInteractInfo.class);
  public final PBUInt32Field totalCount = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "extInfo", "attachInfo", "listInfo", "isFinish", "totalCount" }, new Object[] { null, "", null, localInteger, localInteger }, StGetLightInteractListRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StGetLightInteractListRsp
 * JD-Core Version:    0.7.0.1
 */