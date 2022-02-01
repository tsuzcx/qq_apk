package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleBitmap$GetMultiFlagReq
  extends MessageMicro<GetMultiFlagReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field endPos = PBField.initInt32(0);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt32Field startPos = PBField.initInt32(0);
  public final PBStringField uid = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "uid", "startPos", "endPos" }, new Object[] { null, "", localInteger, localInteger }, GetMultiFlagReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleBitmap.GetMultiFlagReq
 * JD-Core Version:    0.7.0.1
 */