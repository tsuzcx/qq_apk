package tencent.im.new_year_2014;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PackServer$PkgReq
  extends MessageMicro<PkgReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField a8 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBUInt32Field cmdtype = PBField.initUInt32(0);
  public final PBUInt32Field ctime = PBField.initUInt32(0);
  public final PBUInt32Field from_id = PBField.initUInt32(0);
  public PackServer.GetNewPackReq get_new_pack = new PackServer.GetNewPackReq();
  public PackServer.GivePackReq give_pack = new PackServer.GivePackReq();
  public final PBUInt32Field net_type = PBField.initUInt32(0);
  public PackServer.QueryBusinessReq query_business = new PackServer.QueryBusinessReq();
  public PackServer.QueryLuckyUsersReq query_lucky_users = new PackServer.QueryLuckyUsersReq();
  public PackServer.QueryPackReq query_pack = new PackServer.QueryPackReq();
  public PackServer.QueryPackListReq query_pack_list = new PackServer.QueryPackListReq();
  public PackServer.QueryPromotionReq query_promotion = new PackServer.QueryPromotionReq();
  public PackServer.QueryReloadCounterReq query_reload_counter = new PackServer.QueryReloadCounterReq();
  public PackServer.QueryRemainPackReq query_remain_pack = new PackServer.QueryRemainPackReq();
  public PackServer.QueryUserHistoryReq query_user_history = new PackServer.QueryUserHistoryReq();
  public PackServer.SetPackUsedReq set_pack_used = new PackServer.SetPackUsedReq();
  public final PBBytesField skey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 162, 170, 176, 184, 192, 200 }, new String[] { "cmdtype", "uin", "get_new_pack", "query_pack_list", "set_pack_used", "give_pack", "query_pack", "query_user_history", "query_lucky_users", "query_promotion", "query_business", "query_remain_pack", "query_reload_counter", "skey", "a8", "appid", "from_id", "net_type", "ctime" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null, null, null, null, null, null, null, null, null, null, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, PkgReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.new_year_2014.PackServer.PkgReq
 * JD-Core Version:    0.7.0.1
 */