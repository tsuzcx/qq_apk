package tencent.im.new_year_ranking;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PackRanking$QueryRankingReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "flag", "num" }, new Object[] { Integer.valueOf(3), Integer.valueOf(100) }, QueryRankingReq.class);
  public final PBEnumField flag = PBField.initEnum(3);
  public final PBUInt32Field num = PBField.initUInt32(100);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.new_year_ranking.PackRanking.QueryRankingReq
 * JD-Core Version:    0.7.0.1
 */