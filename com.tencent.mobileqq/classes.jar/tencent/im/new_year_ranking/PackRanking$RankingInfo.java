package tencent.im.new_year_ranking;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PackRanking$RankingInfo
  extends MessageMicro<RankingInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uin", "ranking", "count", "elems" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null }, RankingInfo.class);
  public final PBUInt32Field count = PBField.initUInt32(0);
  public final PBRepeatMessageField<PackRanking.RankingElem> elems = PBField.initRepeatMessage(PackRanking.RankingElem.class);
  public final PBUInt32Field ranking = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.new_year_ranking.PackRanking.RankingInfo
 * JD-Core Version:    0.7.0.1
 */