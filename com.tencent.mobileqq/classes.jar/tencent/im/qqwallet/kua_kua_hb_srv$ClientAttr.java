package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class kua_kua_hb_srv$ClientAttr
  extends MessageMicro<ClientAttr>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "osType", "qqVer", "skeyType", "skey" }, new Object[] { Long.valueOf(0L), "", Long.valueOf(0L), "" }, ClientAttr.class);
  public final PBInt64Field osType = PBField.initInt64(0L);
  public final PBStringField qqVer = PBField.initString("");
  public final PBStringField skey = PBField.initString("");
  public final PBInt64Field skeyType = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.qqwallet.kua_kua_hb_srv.ClientAttr
 * JD-Core Version:    0.7.0.1
 */