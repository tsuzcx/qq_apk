package tencent.im.oidb.qfind;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QFind$HistoryData
  extends MessageMicro<HistoryData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "details", "tag" }, new Object[] { null, Integer.valueOf(0) }, HistoryData.class);
  public final PBRepeatMessageField<QFind.HistoryDetail> details = PBField.initRepeatMessage(QFind.HistoryDetail.class);
  public final PBUInt32Field tag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.qfind.QFind.HistoryData
 * JD-Core Version:    0.7.0.1
 */