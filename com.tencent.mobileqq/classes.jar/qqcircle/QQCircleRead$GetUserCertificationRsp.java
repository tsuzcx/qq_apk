package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleRead$GetUserCertificationRsp
  extends MessageMicro<GetUserCertificationRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "certList" }, new Object[] { null, null }, GetUserCertificationRsp.class);
  public final PBRepeatMessageField<QQCircleRead.CertificationDetail> certList = PBField.initRepeatMessage(QQCircleRead.CertificationDetail.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleRead.GetUserCertificationRsp
 * JD-Core Version:    0.7.0.1
 */