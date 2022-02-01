package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQCircleRankingstore$DovInfoStores
  extends MessageMicro<DovInfoStores>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "dovs" }, new Object[] { null }, DovInfoStores.class);
  public final PBRepeatMessageField<QQCircleRankingstore.DovInfoStore> dovs = PBField.initRepeatMessage(QQCircleRankingstore.DovInfoStore.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleRankingstore.DovInfoStores
 * JD-Core Version:    0.7.0.1
 */