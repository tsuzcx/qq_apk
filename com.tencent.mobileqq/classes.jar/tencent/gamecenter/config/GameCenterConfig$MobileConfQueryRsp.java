package tencent.gamecenter.config;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class GameCenterConfig$MobileConfQueryRsp
  extends MessageMicro<MobileConfQueryRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField isLoadHippyInToolProcess = PBField.initBool(false);
  public final PBBoolField isPredrawHippy = PBField.initBool(false);
  public final PBBoolField isPreloadHippy = PBField.initBool(false);
  public final PBInt64Field loadCache = PBField.initInt64(0L);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "isPredrawHippy", "isPreloadHippy", "isLoadHippyInToolProcess", "loadCache" }, new Object[] { localBoolean, localBoolean, localBoolean, Long.valueOf(0L) }, MobileConfQueryRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gamecenter.config.GameCenterConfig.MobileConfQueryRsp
 * JD-Core Version:    0.7.0.1
 */