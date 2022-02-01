package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class fd_comm$GrabPack
  extends MessageMicro<GrabPack>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "pack_type", "none_pack_desc", "monay_pack_info", "card_pack_info", "bless_pack_info" }, new Object[] { Integer.valueOf(0), "", null, null, null }, GrabPack.class);
  public fd_comm.BlessPackInfo bless_pack_info = new fd_comm.BlessPackInfo();
  public fd_comm.CardPackInfo card_pack_info = new fd_comm.CardPackInfo();
  public fd_comm.MoneyPackInfo monay_pack_info = new fd_comm.MoneyPackInfo();
  public final PBStringField none_pack_desc = PBField.initString("");
  public final PBEnumField pack_type = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     fudai.fd_comm.GrabPack
 * JD-Core Version:    0.7.0.1
 */