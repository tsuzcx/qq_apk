package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FrdSysMsg$TongXunLuNickInfo
  extends MessageMicro<TongXunLuNickInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_tongxunlu_nickname = PBField.initString("");
  public final PBUInt64Field uint64_fromuin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_touin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_fromuin", "uint64_touin", "str_tongxunlu_nickname" }, new Object[] { localLong, localLong, "" }, TongXunLuNickInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.frdsysmsg.FrdSysMsg.TongXunLuNickInfo
 * JD-Core Version:    0.7.0.1
 */