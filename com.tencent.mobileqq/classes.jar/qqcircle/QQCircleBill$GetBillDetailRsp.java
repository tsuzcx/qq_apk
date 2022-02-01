package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleBill$GetBillDetailRsp
  extends MessageMicro<GetBillDetailRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "billDetail" }, new Object[] { null, null }, GetBillDetailRsp.class);
  public final PBRepeatMessageField<QQCircleBill.StBillDetail> billDetail = PBField.initRepeatMessage(QQCircleBill.StBillDetail.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleBill.GetBillDetailRsp
 * JD-Core Version:    0.7.0.1
 */