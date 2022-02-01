package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class FeedCloudEeveePushmsg$StEeveePushSendRsp
  extends MessageMicro<StEeveePushSendRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "code" }, new Object[] { Integer.valueOf(0) }, StEeveePushSendRsp.class);
  public final PBInt32Field code = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudEeveePushmsg.StEeveePushSendRsp
 * JD-Core Version:    0.7.0.1
 */