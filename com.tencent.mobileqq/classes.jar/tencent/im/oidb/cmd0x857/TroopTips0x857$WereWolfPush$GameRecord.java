package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TroopTips0x857$WereWolfPush$GameRecord
  extends MessageMicro<GameRecord>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_draw = PBField.initUInt32(0);
  public final PBUInt32Field uint32_lose = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total = PBField.initUInt32(0);
  public final PBUInt32Field uint32_win = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_total", "uint32_win", "uint32_lose", "uint32_draw" }, new Object[] { localInteger, localInteger, localInteger, localInteger }, GameRecord.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.WereWolfPush.GameRecord
 * JD-Core Version:    0.7.0.1
 */