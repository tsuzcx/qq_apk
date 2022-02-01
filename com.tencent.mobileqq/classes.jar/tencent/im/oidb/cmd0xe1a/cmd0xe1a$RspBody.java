package tencent.im.oidb.cmd0xe1a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0xe1a$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField have_red_packet = PBField.initBool(false);
  public final PBBoolField opened_red_packet = PBField.initBool(false);
  public final PBStringField wording = PBField.initString("");
  public final PBStringField wording2 = PBField.initString("");
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "have_red_packet", "opened_red_packet", "wording", "wording2" }, new Object[] { localBoolean, localBoolean, "", "" }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe1a.cmd0xe1a.RspBody
 * JD-Core Version:    0.7.0.1
 */