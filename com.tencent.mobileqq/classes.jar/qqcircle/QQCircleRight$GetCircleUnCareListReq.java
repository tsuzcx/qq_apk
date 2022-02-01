package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleRight$GetCircleUnCareListReq
  extends MessageMicro<GetCircleUnCareListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "extInfo", "rightType", "type" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0) }, GetCircleUnCareListReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBEnumField rightType = PBField.initEnum(0);
  public final PBInt32Field type = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleRight.GetCircleUnCareListReq
 * JD-Core Version:    0.7.0.1
 */