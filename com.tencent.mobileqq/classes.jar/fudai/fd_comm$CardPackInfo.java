package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class fd_comm$CardPackInfo
  extends MessageMicro<CardPackInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "card_id", "card_des", "jmp_url", "url_suffix" }, new Object[] { Integer.valueOf(0), "", "", "" }, CardPackInfo.class);
  public final PBStringField card_des = PBField.initString("");
  public final PBUInt32Field card_id = PBField.initUInt32(0);
  public final PBStringField jmp_url = PBField.initString("");
  public final PBStringField url_suffix = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     fudai.fd_comm.CardPackInfo
 * JD-Core Version:    0.7.0.1
 */