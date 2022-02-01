package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleRankingstore$RankUserInfoStore
  extends MessageMicro<RankUserInfoStore>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field grade = PBField.initInt32(0);
  public final PBInt32Field rank = PBField.initInt32(0);
  public final PBInt32Field score = PBField.initInt32(0);
  public final PBStringField uid = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "uid", "score", "grade", "rank" }, new Object[] { "", localInteger, localInteger, localInteger }, RankUserInfoStore.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleRankingstore.RankUserInfoStore
 * JD-Core Version:    0.7.0.1
 */