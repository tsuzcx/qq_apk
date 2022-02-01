package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleTagsvr$GetFeedsKeysRsp
  extends MessageMicro<GetFeedsKeysRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field FeedTotal = PBField.initInt64(0L);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBRepeatField<String> feedsKeyList = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBInt32Field hasMore = PBField.initInt32(0);
  public QQCircleTagsvr.TagInfo tag = new QQCircleTagsvr.TagInfo();
  public final PBInt64Field uinTotal = PBField.initInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50 }, new String[] { "extInfo", "hasMore", "FeedTotal", "uinTotal", "feedsKeyList", "tag" }, new Object[] { null, Integer.valueOf(0), localLong, localLong, "", null }, GetFeedsKeysRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleTagsvr.GetFeedsKeysRsp
 * JD-Core Version:    0.7.0.1
 */