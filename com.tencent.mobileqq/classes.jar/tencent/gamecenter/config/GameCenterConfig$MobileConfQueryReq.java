package tencent.gamecenter.config;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class GameCenterConfig$MobileConfQueryReq
  extends MessageMicro<MobileConfQueryReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48 }, new String[] { "qqVersion", "manufacturer", "model", "osVersionCode", "totalMemory", "cpuCoreCount" }, new Object[] { "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, MobileConfQueryReq.class);
  public final PBInt32Field cpuCoreCount = PBField.initInt32(0);
  public final PBStringField manufacturer = PBField.initString("");
  public final PBStringField model = PBField.initString("");
  public final PBInt32Field osVersionCode = PBField.initInt32(0);
  public final PBStringField qqVersion = PBField.initString("");
  public final PBInt32Field totalMemory = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.gamecenter.config.GameCenterConfig.MobileConfQueryReq
 * JD-Core Version:    0.7.0.1
 */