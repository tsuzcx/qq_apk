package tencent.im.oidb.cmd0xbe4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xbe4$MsgGetReq
  extends MessageMicro<MsgGetReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_msgid = PBField.initString("");
  public final PBUInt32Field uint32_last_msg = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_content = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_last_msg", "uint32_msg_content", "str_msgid" }, new Object[] { localInteger, localInteger, "" }, MsgGetReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.MsgGetReq
 * JD-Core Version:    0.7.0.1
 */