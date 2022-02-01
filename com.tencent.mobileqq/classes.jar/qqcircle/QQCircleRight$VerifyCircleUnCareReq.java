package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleRight$VerifyCircleUnCareReq
  extends MessageMicro<VerifyCircleUnCareReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "extInfo", "uin", "rightType", "verifyType" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, VerifyCircleUnCareReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBEnumField rightType = PBField.initEnum(0);
  public final PBUInt32Field uin = PBField.initUInt32(0);
  public final PBEnumField verifyType = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleRight.VerifyCircleUnCareReq
 * JD-Core Version:    0.7.0.1
 */