package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudEeveeBusiInterface$StBusiCommInterfaceRsp
  extends MessageMicro<StBusiCommInterfaceRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "bizAnswers" }, new Object[] { null, null }, StBusiCommInterfaceRsp.class);
  public final PBRepeatMessageField<FeedCloudEeveeBusiInterface.SingleBizMsgAnswer> bizAnswers = PBField.initRepeatMessage(FeedCloudEeveeBusiInterface.SingleBizMsgAnswer.class);
  public FeedCloudCommon.Result result = new FeedCloudCommon.Result();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudEeveeBusiInterface.StBusiCommInterfaceRsp
 * JD-Core Version:    0.7.0.1
 */