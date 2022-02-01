package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleRight$SetCircleUnCareReq
  extends MessageMicro<SetCircleUnCareReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40 }, new String[] { "extInfo", "uin", "operType", "strUid", "rightType" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(0) }, SetCircleUnCareReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBEnumField operType = PBField.initEnum(1);
  public final PBEnumField rightType = PBField.initEnum(0);
  public final PBStringField strUid = PBField.initString("");
  public final PBUInt32Field uin = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleRight.SetCircleUnCareReq
 * JD-Core Version:    0.7.0.1
 */