package tencent.im.oidb.inner.cmdGroupAdGetAdInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GetTroopAioTopAD$ExtAdInfo
  extends MessageMicro<ExtAdInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_word", "str_ui_url", "str_jmp_url" }, new Object[] { "", "", "" }, ExtAdInfo.class);
  public final PBStringField str_jmp_url = PBField.initString("");
  public final PBStringField str_ui_url = PBField.initString("");
  public final PBStringField str_word = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.inner.cmdGroupAdGetAdInfo.GetTroopAioTopAD.ExtAdInfo
 * JD-Core Version:    0.7.0.1
 */