package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x27$GroupSort
  extends MessageMicro<GroupSort>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_groupid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sortid = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_groupid", "uint32_sortid" }, new Object[] { localInteger, localInteger }, GroupSort.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.GroupSort
 * JD-Core Version:    0.7.0.1
 */