package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class FestivalPack$PkgResp
  extends MessageMicro<PkgResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18, 42, 50, 58, 66, 98, 106 }, new String[] { "get_eve_pack", "query_pack", "query_pack_list", "set_pack_used", "query_pack_list_h5", "query_promotion_pack_list", "set_block_user" }, new Object[] { null, null, null, null, null, null, null }, PkgResp.class);
  public FestivalPack.NewYearEvePackResp get_eve_pack = new FestivalPack.NewYearEvePackResp();
  public FestivalPack.QueryPackResp query_pack = new FestivalPack.QueryPackResp();
  public FestivalPack.QueryPackListResp query_pack_list = new FestivalPack.QueryPackListResp();
  public FestivalPack.QueryPackListH5Resp query_pack_list_h5 = new FestivalPack.QueryPackListH5Resp();
  public FestivalPack.QueryPromotionPackListResp query_promotion_pack_list = new FestivalPack.QueryPromotionPackListResp();
  public FestivalPack.SetBlockUserResp set_block_user = new FestivalPack.SetBlockUserResp();
  public FestivalPack.SetPackUsedResp set_pack_used = new FestivalPack.SetPackUsedResp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.new_year_2021.FestivalPack.PkgResp
 * JD-Core Version:    0.7.0.1
 */