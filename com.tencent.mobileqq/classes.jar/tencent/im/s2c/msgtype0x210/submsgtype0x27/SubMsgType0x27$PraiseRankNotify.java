package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x27$PraiseRankNotify
  extends MessageMicro<PraiseRankNotify>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 88, 96, 106 }, new String[] { "uint32_is_champion", "uint32_rank_num", "str_msg" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "" }, PraiseRankNotify.class);
  public final PBStringField str_msg = PBField.initString("");
  public final PBUInt32Field uint32_is_champion = PBField.initUInt32(0);
  public final PBUInt32Field uint32_rank_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.PraiseRankNotify
 * JD-Core Version:    0.7.0.1
 */