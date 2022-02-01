package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleRead$GetCircleEmailSuffixRsp
  extends MessageMicro<GetCircleEmailSuffixRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "emailSuffix" }, new Object[] { null, "" }, GetCircleEmailSuffixRsp.class);
  public final PBStringField emailSuffix = PBField.initString("");
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleRead.GetCircleEmailSuffixRsp
 * JD-Core Version:    0.7.0.1
 */