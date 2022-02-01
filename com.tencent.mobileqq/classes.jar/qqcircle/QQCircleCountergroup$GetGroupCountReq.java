package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleCountergroup$GetGroupCountReq
  extends MessageMicro<GetGroupCountReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "gid" }, new Object[] { null, Long.valueOf(0L) }, GetGroupCountReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt64Field gid = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleCountergroup.GetGroupCountReq
 * JD-Core Version:    0.7.0.1
 */