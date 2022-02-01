package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleInvite$CheckPavInviteCircleCountRsp
  extends MessageMicro<CheckPavInviteCircleCountRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "extInfo", "isLimit", "strErr" }, new Object[] { null, Integer.valueOf(0), "" }, CheckPavInviteCircleCountRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt32Field isLimit = PBField.initInt32(0);
  public final PBStringField strErr = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleInvite.CheckPavInviteCircleCountRsp
 * JD-Core Version:    0.7.0.1
 */