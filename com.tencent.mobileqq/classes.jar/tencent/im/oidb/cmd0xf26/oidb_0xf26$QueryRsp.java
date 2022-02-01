package tencent.im.oidb.cmd0xf26;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xf26$QueryRsp
  extends MessageMicro<QueryRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "auth_item" }, new Object[] { null }, QueryRsp.class);
  public final PBRepeatMessageField<oidb_0xf26.AuthItem> auth_item = PBField.initRepeatMessage(oidb_0xf26.AuthItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf26.oidb_0xf26.QueryRsp
 * JD-Core Version:    0.7.0.1
 */