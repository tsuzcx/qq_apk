package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudEeveeBusiInterface$StBusiCommInterfaceReq
  extends MessageMicro<StBusiCommInterfaceReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField appid = PBField.initEnum(0);
  public final PBRepeatMessageField<FeedCloudEeveeBusiInterface.SingleBizMsgAsk> bizAsks = PBField.initRepeatMessage(FeedCloudEeveeBusiInterface.SingleBizMsgAsk.class);
  public FeedCloudEeveeBase.ClientInfo clientInfo = new FeedCloudEeveeBase.ClientInfo();
  public final PBStringField uid = PBField.initString("");
  public final PBEnumField visitPage = PBField.initEnum(0);
  public final PBEnumField visitScene = PBField.initEnum(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50 }, new String[] { "appid", "uid", "clientInfo", "visitScene", "visitPage", "bizAsks" }, new Object[] { localInteger, "", null, localInteger, localInteger, null }, StBusiCommInterfaceReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudEeveeBusiInterface.StBusiCommInterfaceReq
 * JD-Core Version:    0.7.0.1
 */