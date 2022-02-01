package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class QQCircleRankingstore$DovInfoStore
  extends MessageMicro<DovInfoStore>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "addtime", "score" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, DovInfoStore.class);
  public final PBInt64Field addtime = PBField.initInt64(0L);
  public final PBInt32Field score = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleRankingstore.DovInfoStore
 * JD-Core Version:    0.7.0.1
 */