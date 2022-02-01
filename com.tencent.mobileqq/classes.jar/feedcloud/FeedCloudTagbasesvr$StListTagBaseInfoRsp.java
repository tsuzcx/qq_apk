package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudTagbasesvr$StListTagBaseInfoRsp
  extends MessageMicro<StListTagBaseInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "infos", "pageSize", "pageCurrent", "pageTotal" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, StListTagBaseInfoRsp.class);
  public final PBRepeatMessageField<FeedCloudTagbasesvr.StTagBaseInfo> infos = PBField.initRepeatMessage(FeedCloudTagbasesvr.StTagBaseInfo.class);
  public final PBInt32Field pageCurrent = PBField.initInt32(0);
  public final PBInt32Field pageSize = PBField.initInt32(0);
  public final PBInt32Field pageTotal = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudTagbasesvr.StListTagBaseInfoRsp
 * JD-Core Version:    0.7.0.1
 */