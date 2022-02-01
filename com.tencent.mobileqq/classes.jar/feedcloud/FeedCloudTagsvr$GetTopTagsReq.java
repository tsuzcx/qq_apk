package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class FeedCloudTagsvr$GetTopTagsReq
  extends MessageMicro<GetTopTagsReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt32Field minScore = PBField.initInt32(0);
  public final PBInt32Field num = PBField.initInt32(0);
  public final PBInt32Field sortType = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "extInfo", "sortType", "num", "minScore" }, new Object[] { null, localInteger, localInteger, localInteger }, GetTopTagsReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudTagsvr.GetTopTagsReq
 * JD-Core Version:    0.7.0.1
 */