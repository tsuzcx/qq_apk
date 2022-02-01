package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StUser;

public final class QQCircleRead$GetCircleMemberRsp
  extends MessageMicro<GetCircleMemberRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "extInfo", "attachInfo", "hasNext", "total", "userList" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0), null }, GetCircleMemberRsp.class);
  public final PBStringField attachInfo = PBField.initString("");
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBUInt32Field hasNext = PBField.initUInt32(0);
  public final PBUInt32Field total = PBField.initUInt32(0);
  public final PBRepeatMessageField<FeedCloudMeta.StUser> userList = PBField.initRepeatMessage(FeedCloudMeta.StUser.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleRead.GetCircleMemberRsp
 * JD-Core Version:    0.7.0.1
 */