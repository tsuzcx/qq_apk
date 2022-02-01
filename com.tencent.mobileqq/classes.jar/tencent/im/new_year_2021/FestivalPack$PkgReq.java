package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FestivalPack$PkgReq
  extends MessageMicro<PkgReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field cmdtype = PBField.initUInt32(0);
  public final PBUInt32Field from_id = PBField.initUInt32(0);
  public FestivalPack.NewYearEvePackReq get_eve_pack = new FestivalPack.NewYearEvePackReq();
  public FestivalPack.QueryPackReq query_pack = new FestivalPack.QueryPackReq();
  public FestivalPack.QueryPackListReq query_pack_list = new FestivalPack.QueryPackListReq();
  public FestivalPack.QueryPackListH5Req query_pack_list_h5 = new FestivalPack.QueryPackListH5Req();
  public FestivalPack.QueryPromotionPackListReq query_promotion_pack_list = new FestivalPack.QueryPromotionPackListReq();
  public FestivalPack.SetBlockUserReq set_block_user = new FestivalPack.SetBlockUserReq();
  public FestivalPack.SetPackUsedReq set_pack_used = new FestivalPack.SetPackUsedReq();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 24, 50, 82, 90, 98, 114, 290, 298 }, new String[] { "cmdtype", "from_id", "get_eve_pack", "query_pack", "query_pack_list", "set_pack_used", "query_pack_list_h5", "query_promotion_pack_list", "set_block_user" }, new Object[] { localInteger, localInteger, null, null, null, null, null, null, null }, PkgReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.new_year_2021.FestivalPack.PkgReq
 * JD-Core Version:    0.7.0.1
 */