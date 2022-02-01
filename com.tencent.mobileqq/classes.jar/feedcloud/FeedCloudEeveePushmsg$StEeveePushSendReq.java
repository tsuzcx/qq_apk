package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudEeveePushmsg$StEeveePushSendReq
  extends MessageMicro<StEeveePushSendReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "sendMsg", "pushTime" }, new Object[] { null, Long.valueOf(0L) }, StEeveePushSendReq.class);
  public final PBInt64Field pushTime = PBField.initInt64(0L);
  public final PBRepeatMessageField<FeedCloudEeveePushmsg.StEeveePushSendMsg> sendMsg = PBField.initRepeatMessage(FeedCloudEeveePushmsg.StEeveePushSendMsg.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudEeveePushmsg.StEeveePushSendReq
 * JD-Core Version:    0.7.0.1
 */