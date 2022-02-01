package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleRead$GetCircleTagInfoReq
  extends MessageMicro<GetCircleTagInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt32Field needFollowStatus = PBField.initInt32(0);
  public final PBInt32Field needJoinNum = PBField.initInt32(0);
  public final PBRepeatField<String> tagNameList = PBField.initRepeat(PBStringField.__repeatHelper__);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "tagNameList", "needJoinNum", "needFollowStatus" }, new Object[] { null, "", localInteger, localInteger }, GetCircleTagInfoReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleRead.GetCircleTagInfoReq
 * JD-Core Version:    0.7.0.1
 */