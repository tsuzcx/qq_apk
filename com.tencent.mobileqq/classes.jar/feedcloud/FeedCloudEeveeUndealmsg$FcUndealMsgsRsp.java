package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudEeveeUndealmsg$FcUndealMsgsRsp
  extends MessageMicro<FcUndealMsgsRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "result", "intervalCtl", "msgs", "attachInfo" }, new Object[] { null, null, null, null }, FcUndealMsgsRsp.class);
  public final PBRepeatMessageField<FeedCloudEeveeBase.StEeveeAttachInfo> attachInfo = PBField.initRepeatMessage(FeedCloudEeveeBase.StEeveeAttachInfo.class);
  public FeedCloudEeveeUndealmsg.IntervalControl intervalCtl = new FeedCloudEeveeUndealmsg.IntervalControl();
  public final PBRepeatMessageField<FeedCloudEeveeUndealmsg.BizUndealMsg> msgs = PBField.initRepeatMessage(FeedCloudEeveeUndealmsg.BizUndealMsg.class);
  public FeedCloudCommon.Result result = new FeedCloudCommon.Result();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudEeveeUndealmsg.FcUndealMsgsRsp
 * JD-Core Version:    0.7.0.1
 */