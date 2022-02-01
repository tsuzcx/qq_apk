package tencent.im.oidb.cmd0xeac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xeac$MsgInfo
  extends MessageMicro<MsgInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field msg_random = PBField.initUInt32(0);
  public final PBUInt32Field msg_seq = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "msg_seq", "msg_random" }, new Object[] { localInteger, localInteger }, MsgInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeac.oidb_0xeac.MsgInfo
 * JD-Core Version:    0.7.0.1
 */