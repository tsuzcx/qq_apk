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
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 728008, 808008, 1128008, 1208008, 1448008 }, new String[] { "appid", "max_pkg_size", "start_time", "start_index", "req_num", "rpt_uin_list", "req_music_switch", "req_mutualmark_alienation", "req_mutualmark_score", "req_ksing_switch", "req_mutualmark_lbsshare" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public final PBUInt64Field appid = PBField.initUInt64(0L);
  public final PBUInt32Field max_pkg_size = PBField.initUInt32(0);
  public final PBUInt32Field req_ksing_switch = PBField.initUInt32(0);
  public final PBUInt32Field req_music_switch = PBField.initUInt32(0);
  public final PBUInt32Field req_mutualmark_alienation = PBField.initUInt32(0);
  public final PBUInt32Field req_mutualmark_lbsshare = PBField.initUInt32(0);
  public final PBUInt32Field req_mutualmark_score = PBField.initUInt32(0);
  public final PBUInt32Field req_num = PBField.initUInt32(0);
  public final PBRepeatField<Long> rpt_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field start_index = PBField.initUInt32(0);
  public final PBUInt32Field start_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd50.Oidb_0xd50.ReqBody
 * JD-Core Version:    0.7.0.1
 */