package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class fd_interactive_pack$GrabeRedEnvelopeRsp
  extends MessageMicro<GrabeRedEnvelopeRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 48, 58 }, new String[] { "host_prof", "grab_state", "pack_info", "top_des", "busi_elem", "switch_jmp_main_page", "luck_card_info" }, new Object[] { null, Integer.valueOf(1), null, "", null, Integer.valueOf(0), null }, GrabeRedEnvelopeRsp.class);
  public fd_comm.BusiElement busi_elem = new fd_comm.BusiElement();
  public final PBEnumField grab_state = PBField.initEnum(1);
  public fd_comm.UinProf host_prof = new fd_comm.UinProf();
  public fd_comm.LuckCard luck_card_info = new fd_comm.LuckCard();
  public fd_comm.GrabPack pack_info = new fd_comm.GrabPack();
  public final PBUInt32Field switch_jmp_main_page = PBField.initUInt32(0);
  public final PBStringField top_des = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     fudai.fd_interactive_pack.GrabeRedEnvelopeRsp
 * JD-Core Version:    0.7.0.1
 */