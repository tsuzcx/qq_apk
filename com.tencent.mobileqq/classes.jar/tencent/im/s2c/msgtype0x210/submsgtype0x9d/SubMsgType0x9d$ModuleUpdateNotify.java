package tencent.im.s2c.msgtype0x210.submsgtype0x9d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x9d$ModuleUpdateNotify
  extends MessageMicro<ModuleUpdateNotify>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field module_id = PBField.initUInt32(0);
  public final PBUInt32Field module_state = PBField.initUInt32(0);
  public final PBUInt32Field module_version = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "module_id", "module_version", "module_state" }, new Object[] { localInteger, localInteger, localInteger }, ModuleUpdateNotify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x9d.SubMsgType0x9d.ModuleUpdateNotify
 * JD-Core Version:    0.7.0.1
 */