package tencent.im.oidb.cmd0xb54;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class oidb_cmd0xb54$CoinInfo
  extends MessageMicro<CoinInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 32, 40 }, new String[] { "content_has_coin", "content_coin_num" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0) }, CoinInfo.class);
  public final PBInt32Field content_coin_num = PBField.initInt32(0);
  public final PBBoolField content_has_coin = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.CoinInfo
 * JD-Core Version:    0.7.0.1
 */