package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudToastshowsvr$StShowControl
  extends MessageMicro<StShowControl>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "showPageType", "showTime" }, new Object[] { Integer.valueOf(0), null }, StShowControl.class);
  public final PBUInt32Field showPageType = PBField.initUInt32(0);
  public FeedCloudToastshowsvr.StShowTime showTime = new FeedCloudToastshowsvr.StShowTime();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudToastshowsvr.StShowControl
 * JD-Core Version:    0.7.0.1
 */