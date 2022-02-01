package tencent.im.msgsync.cmd0x100;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class Submsgtype0x8a$WithDrawWordingInfo
  extends MessageMicro<WithDrawWordingInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "int32_item_id", "string_item_name" }, new Object[] { Integer.valueOf(0), "" }, WithDrawWordingInfo.class);
  public final PBInt32Field int32_item_id = PBField.initInt32(0);
  public final PBStringField string_item_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.msgsync.cmd0x100.Submsgtype0x8a.WithDrawWordingInfo
 * JD-Core Version:    0.7.0.1
 */