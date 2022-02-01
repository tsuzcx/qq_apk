package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class FeedCloudTagbasesvr$StListTagBaseInfoReq
  extends MessageMicro<StListTagBaseInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "filter", "sort", "pageSize", "pageCurrent", "sortType" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, StListTagBaseInfoReq.class);
  public FeedCloudTagbasesvr.StListFilter filter = new FeedCloudTagbasesvr.StListFilter();
  public final PBInt32Field pageCurrent = PBField.initInt32(0);
  public final PBInt32Field pageSize = PBField.initInt32(0);
  public final PBEnumField sort = PBField.initEnum(0);
  public final PBEnumField sortType = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudTagbasesvr.StListTagBaseInfoReq
 * JD-Core Version:    0.7.0.1
 */