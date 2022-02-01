package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleRead$GetUserCertificationReqV2
  extends MessageMicro<GetUserCertificationReqV2>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field certFlag = PBField.initInt32(0);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBStringField hostUin = PBField.initString("");
  public final PBInt32Field needDetail = PBField.initInt32(0);
  public final PBInt32Field statusFlag = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40 }, new String[] { "extInfo", "certFlag", "hostUin", "statusFlag", "needDetail" }, new Object[] { null, localInteger, "", localInteger, localInteger }, GetUserCertificationReqV2.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleRead.GetUserCertificationReqV2
 * JD-Core Version:    0.7.0.1
 */