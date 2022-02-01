package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleFamous$SetCircleFamousDataReq
  extends MessageMicro<SetCircleFamousDataReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "extInfo", "totalFuel", "uin" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0) }, SetCircleFamousDataReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt32Field totalFuel = PBField.initInt32(0);
  public final PBUInt32Field uin = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleFamous.SetCircleFamousDataReq
 * JD-Core Version:    0.7.0.1
 */