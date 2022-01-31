package tencent.im.new_year_ranking;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class PackRanking$QueryRankingResp
  extends MessageMicro<QueryRankingResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rank_swipe", "rank_combo" }, new Object[] { null, null }, QueryRankingResp.class);
  public PackRanking.RankingInfo rank_combo = new PackRanking.RankingInfo();
  public PackRanking.RankingInfo rank_swipe = new PackRanking.RankingInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.new_year_ranking.PackRanking.QueryRankingResp
 * JD-Core Version:    0.7.0.1
 */