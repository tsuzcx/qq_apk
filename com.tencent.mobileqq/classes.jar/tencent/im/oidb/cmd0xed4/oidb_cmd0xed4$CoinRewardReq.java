package tencent.im.oidb.cmd0xed4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xed4$CoinRewardReq
  extends MessageMicro<CoinRewardReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field coin_cnt = PBField.initUInt32(0);
  public final PBUInt64Field from_uin = PBField.initUInt64(0L);
  public final PBStringField rowkey = PBField.initString("");
  public final PBUInt64Field to_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "from_uin", "to_uin", "coin_cnt", "rowkey" }, new Object[] { localLong, localLong, Integer.valueOf(0), "" }, CoinRewardReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xed4.oidb_cmd0xed4.CoinRewardReq
 * JD-Core Version:    0.7.0.1
 */