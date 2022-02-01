package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class QQCircleFeedBase$StGetNoticeListRspData
  extends MessageMicro<StGetNoticeListRspData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rspTimestamp" }, new Object[] { Long.valueOf(0L) }, StGetNoticeListRspData.class);
  public final PBInt64Field rspTimestamp = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StGetNoticeListRspData
 * JD-Core Version:    0.7.0.1
 */