package tencent.im.troop_search_userinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class userinfo$Cell
  extends MessageMicro<Cell>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_rssi = PBField.initInt32(0);
  public final PBUInt32Field uint32_cellid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_lac = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mcc = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mnc = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint32_mcc", "uint32_mnc", "uint32_lac", "uint32_cellid", "int32_rssi" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger }, Cell.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.troop_search_userinfo.userinfo.Cell
 * JD-Core Version:    0.7.0.1
 */