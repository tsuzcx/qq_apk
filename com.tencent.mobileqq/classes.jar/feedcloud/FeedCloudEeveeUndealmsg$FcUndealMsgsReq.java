package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudEeveeUndealmsg$FcUndealMsgsReq
  extends MessageMicro<FcUndealMsgsReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField appid = PBField.initEnum(0);
  public final PBRepeatMessageField<FeedCloudEeveeBase.StEeveeAttachInfo> attachInfo = PBField.initRepeatMessage(FeedCloudEeveeBase.StEeveeAttachInfo.class);
  public FeedCloudEeveeBase.ClientInfo clientInfo = new FeedCloudEeveeBase.ClientInfo();
  public FeedCloudEeveeUndealmsg.SignalMsg signalMsg = new FeedCloudEeveeUndealmsg.SignalMsg();
  public final PBStringField uid = PBField.initString("");
  public final PBEnumField visitPage = PBField.initEnum(0);
  public final PBEnumField visitScene = PBField.initEnum(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 58 }, new String[] { "appid", "uid", "clientInfo", "visitScene", "visitPage", "signalMsg", "attachInfo" }, new Object[] { localInteger, "", null, localInteger, localInteger, null, null }, FcUndealMsgsReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudEeveeUndealmsg.FcUndealMsgsReq
 * JD-Core Version:    0.7.0.1
 */