package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleBitmap$SetMultiFlagReq
  extends MessageMicro<SetMultiFlagReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "extInfo", "uid", "startPos", "endPos", "value" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SetMultiFlagReq.class);
  public final PBInt32Field endPos = PBField.initInt32(0);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt32Field startPos = PBField.initInt32(0);
  public final PBStringField uid = PBField.initString("");
  public final PBUInt32Field value = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleBitmap.SetMultiFlagReq
 * JD-Core Version:    0.7.0.1
 */