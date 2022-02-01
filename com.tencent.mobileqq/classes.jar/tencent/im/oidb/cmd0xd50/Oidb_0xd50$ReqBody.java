package tencent.im.oidb.cmd0xd50;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0xd50$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 88016, 168016, 248016, 328008, 408008, 488008, 568008, 648008, 728008, 808008, 888008, 968008, 1048008, 1128008, 1208008, 1448008, 1688008, 1768008, 1768016, 1848008, 1848016, 1848024, 1928008, 2008008 }, new String[] { "appid", "max_pkg_size", "start_time", "start_index", "req_num", "rpt_uin_list", "req_lovers", "req_confidante", "req_buddy", "req_frd_tree", "req_chat", "req_praise", "req_qzone_love", "req_qzone_house", "req_music_switch", "req_mutualmark_alienation", "req_unread_message", "req_boat", "req_close_frd", "req_mutualmark_score", "req_ksing_switch", "req_mutualmark_lbsshare", "req_dont_forget_me", "req_my_online_status_visible_to_frd", "req_frd_online_status_visible_to_me", "req_visitor_record", "req_frd_steal_record", "req_my_steal_record", "req_avgame", "req_aio_quick_app" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public final PBUInt64Field appid = PBField.initUInt64(0L);
  public final PBUInt32Field max_pkg_size = PBField.initUInt32(0);
  public final PBUInt32Field req_aio_quick_app = PBField.initUInt32(0);
  public final PBUInt32Field req_avgame = PBField.initUInt32(0);
  public final PBUInt32Field req_boat = PBField.initUInt32(0);
  public final PBUInt32Field req_buddy = PBField.initUInt32(0);
  public final PBUInt32Field req_chat = PBField.initUInt32(0);
  public final PBUInt32Field req_close_frd = PBField.initUInt32(0);
  public final PBUInt32Field req_confidante = PBField.initUInt32(0);
  public final PBUInt32Field req_dont_forget_me = PBField.initUInt32(0);
  public final PBUInt32Field req_frd_online_status_visible_to_me = PBField.initUInt32(0);
  public final PBUInt32Field req_frd_steal_record = PBField.initUInt32(0);
  public final PBUInt32Field req_frd_tree = PBField.initUInt32(0);
  public final PBUInt32Field req_ksing_switch = PBField.initUInt32(0);
  public final PBUInt32Field req_lovers = PBField.initUInt32(0);
  public final PBUInt32Field req_music_switch = PBField.initUInt32(0);
  public final PBUInt32Field req_mutualmark_alienation = PBField.initUInt32(0);
  public final PBUInt32Field req_mutualmark_lbsshare = PBField.initUInt32(0);
  public final PBUInt32Field req_mutualmark_score = PBField.initUInt32(0);
  public final PBUInt32Field req_my_online_status_visible_to_frd = PBField.initUInt32(0);
  public final PBUInt32Field req_my_steal_record = PBField.initUInt32(0);
  public final PBUInt32Field req_num = PBField.initUInt32(0);
  public final PBUInt32Field req_praise = PBField.initUInt32(0);
  public final PBUInt32Field req_qzone_house = PBField.initUInt32(0);
  public final PBUInt32Field req_qzone_love = PBField.initUInt32(0);
  public final PBUInt32Field req_unread_message = PBField.initUInt32(0);
  public final PBUInt32Field req_visitor_record = PBField.initUInt32(0);
  public final PBRepeatField<Long> rpt_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field start_index = PBField.initUInt32(0);
  public final PBUInt32Field start_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd50.Oidb_0xd50.ReqBody
 * JD-Core Version:    0.7.0.1
 */