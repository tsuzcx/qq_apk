package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class vac_adv_get$DropList
  extends MessageMicro<DropList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "iconurl", "optext", "jumpurl", "action_type" }, new Object[] { "", "", "", Integer.valueOf(1) }, DropList.class);
  public final PBEnumField action_type = PBField.initEnum(1);
  public final PBStringField iconurl = PBField.initString("");
  public final PBStringField jumpurl = PBField.initString("");
  public final PBStringField optext = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.pb.vac_adv_get.DropList
 * JD-Core Version:    0.7.0.1
 */