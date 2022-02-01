package tencent.im.new_year_2014;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PackServer$PkgResp
  extends MessageMicro<PkgResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 160, 168, 176 }, new String[] { "cmdtype", "uin", "errcode", "errmsg", "resp_name", "get_new_pack", "query_pack_list", "set_pack_used", "give_pack", "query_pack", "query_user_history", "query_lucky_users", "query_promotion", "query_business", "query_remain_pack", "grab_interval", "report_active_interval", "report_normal_interval" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", "", null, null, null, null, null, null, null, null, null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, PkgResp.class);
  public final PBUInt32Field cmdtype = PBField.initUInt32(0);
  public final PBUInt32Field errcode = PBField.initUInt32(0);
  public final PBStringField errmsg = PBField.initString("");
  public PackServer.GetNewPackResp get_new_pack = new PackServer.GetNewPackResp();
  public PackServer.GivePackResp give_pack = new PackServer.GivePackResp();
  public final PBUInt32Field grab_interval = PBField.initUInt32(0);
  public PackServer.QueryBusinessResp query_business = new PackServer.QueryBusinessResp();
  public PackServer.QueryLuckyUsersResp query_lucky_users = new PackServer.QueryLuckyUsersResp();
  public PackServer.QueryPackResp query_pack = new PackServer.QueryPackResp();
  public PackServer.QueryPackListResp query_pack_list = new PackServer.QueryPackListResp();
  public PackServer.QueryPromotionResp query_promotion = new PackServer.QueryPromotionResp();
  public PackServer.QueryRemainPackResp query_remain_pack = new PackServer.QueryRemainPackResp();
  public PackServer.QueryUserHistoryResp query_user_history = new PackServer.QueryUserHistoryResp();
  public final PBUInt32Field report_active_interval = PBField.initUInt32(0);
  public final PBUInt32Field report_normal_interval = PBField.initUInt32(0);
  public final PBStringField resp_name = PBField.initString("");
  public PackServer.SetPackUsedResp set_pack_used = new PackServer.SetPackUsedResp();
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.new_year_2014.PackServer.PkgResp
 * JD-Core Version:    0.7.0.1
 */