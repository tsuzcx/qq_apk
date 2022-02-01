package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x27$PraiseRankNotify
  extends MessageMicro<PraiseRankNotify>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_msg = PBField.initString("");
  public final PBUInt32Field uint32_is_champion = PBField.initUInt32(0);
  public final PBUInt32Field uint32_rank_num = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 88, 96, 106 }, new String[] { "uint32_is_champion", "uint32_rank_num", "str_msg" }, new Object[] { localInteger, localInteger, "" }, PraiseRankNotify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.PraiseRankNotify
 * JD-Core Version:    0.7.0.1
 */