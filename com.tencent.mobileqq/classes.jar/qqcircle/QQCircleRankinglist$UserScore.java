package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleRankinglist$UserScore
  extends MessageMicro<UserScore>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field deltaScore = PBField.initInt64(0L);
  public final PBInt64Field score = PBField.initInt64(0L);
  public final PBStringField uid = PBField.initString("");
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "uid", "score", "deltaScore" }, new Object[] { "", localLong, localLong }, UserScore.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleRankinglist.UserScore
 * JD-Core Version:    0.7.0.1
 */