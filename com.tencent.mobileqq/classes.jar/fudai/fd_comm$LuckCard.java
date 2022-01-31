package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class fd_comm$LuckCard
  extends MessageMicro<LuckCard>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "luck_card_type", "show_icon_tab", "icon_url", "des_type", "des" }, new Object[] { Integer.valueOf(1), Boolean.valueOf(false), "", Integer.valueOf(1), "" }, LuckCard.class);
  public final PBStringField des = PBField.initString("");
  public final PBEnumField des_type = PBField.initEnum(1);
  public final PBStringField icon_url = PBField.initString("");
  public final PBEnumField luck_card_type = PBField.initEnum(1);
  public final PBBoolField show_icon_tab = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     fudai.fd_comm.LuckCard
 * JD-Core Version:    0.7.0.1
 */