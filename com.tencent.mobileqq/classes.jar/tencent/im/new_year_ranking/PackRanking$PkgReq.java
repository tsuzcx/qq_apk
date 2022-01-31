package tencent.im.new_year_ranking;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PackRanking$PkgReq
  extends MessageMicro<PkgReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 82 }, new String[] { "cmdtype", "uin", "query_ranking" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null }, PkgReq.class);
  public final PBUInt32Field cmdtype = PBField.initUInt32(0);
  public PackRanking.QueryRankingReq query_ranking = new PackRanking.QueryRankingReq();
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.new_year_ranking.PackRanking.PkgReq
 * JD-Core Version:    0.7.0.1
 */