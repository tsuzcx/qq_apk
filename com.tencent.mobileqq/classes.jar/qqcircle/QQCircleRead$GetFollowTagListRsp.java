package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleRead$GetFollowTagListRsp
  extends MessageMicro<GetFollowTagListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "extInfo", "tagList", "attachInfo", "hasNext" }, new Object[] { null, null, "", Integer.valueOf(0) }, GetFollowTagListRsp.class);
  public final PBStringField attachInfo = PBField.initString("");
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBUInt32Field hasNext = PBField.initUInt32(0);
  public final PBRepeatMessageField<QQCircleRead.TagItem> tagList = PBField.initRepeatMessage(QQCircleRead.TagItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleRead.GetFollowTagListRsp
 * JD-Core Version:    0.7.0.1
 */