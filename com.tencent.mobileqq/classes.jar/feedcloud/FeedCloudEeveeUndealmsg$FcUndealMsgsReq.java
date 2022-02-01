package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudEeveeUndealmsg$FcUndealMsgsReq
  extends MessageMicro<FcUndealMsgsReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50 }, new String[] { "appid", "uid", "clientInfo", "visitScene", "visitPage", "signalMsg" }, new Object[] { Integer.valueOf(0), "", null, Integer.valueOf(0), Integer.valueOf(0), null }, FcUndealMsgsReq.class);
  public final PBEnumField appid = PBField.initEnum(0);
  public FeedCloudEeveeBase.ClientInfo clientInfo = new FeedCloudEeveeBase.ClientInfo();
  public FeedCloudEeveeUndealmsg.SignalMsg signalMsg = new FeedCloudEeveeUndealmsg.SignalMsg();
  public final PBStringField uid = PBField.initString("");
  public final PBEnumField visitPage = PBField.initEnum(0);
  public final PBEnumField visitScene = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudEeveeUndealmsg.FcUndealMsgsReq
 * JD-Core Version:    0.7.0.1
 */