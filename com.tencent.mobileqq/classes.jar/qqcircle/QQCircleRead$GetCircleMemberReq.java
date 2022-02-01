package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleRead$GetCircleMemberReq
  extends MessageMicro<GetCircleMemberReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "extInfo", "id", "count", "attachInfo" }, new Object[] { null, "", Long.valueOf(0L), "" }, GetCircleMemberReq.class);
  public final PBStringField attachInfo = PBField.initString("");
  public final PBInt64Field count = PBField.initInt64(0L);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBStringField id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleRead.GetCircleMemberReq
 * JD-Core Version:    0.7.0.1
 */