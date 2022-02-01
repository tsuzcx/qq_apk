package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleInvite$CheckActInviteCircleCountRsp
  extends MessageMicro<CheckActInviteCircleCountRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt32Field isLimit = PBField.initInt32(0);
  public final PBInt32Field isVip = PBField.initInt32(0);
  public final PBStringField strErr = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "extInfo", "isLimit", "strErr", "isVip" }, new Object[] { null, localInteger, "", localInteger }, CheckActInviteCircleCountRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleInvite.CheckActInviteCircleCountRsp
 * JD-Core Version:    0.7.0.1
 */