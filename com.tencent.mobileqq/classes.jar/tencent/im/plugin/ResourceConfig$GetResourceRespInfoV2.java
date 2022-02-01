package tencent.im.plugin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ResourceConfig$GetResourceRespInfoV2
  extends MessageMicro<GetResourceRespInfoV2>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 58, 66, 74, 82, 88, 96, 104, 112, 120, 128, 138, 146 }, new String[] { "pkgName", "newVer", "resSubType", "lanType", "priority", "resName", "resDesc", "resURLBig", "resURLSmall", "resConf", "defaultState", "canChangeState", "resId", "status", "push", "pluginType", "newPluginDesc", "newPluginURL" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "" }, GetResourceRespInfoV2.class);
  public final PBUInt32Field canChangeState = PBField.initUInt32(0);
  public final PBUInt32Field defaultState = PBField.initUInt32(0);
  public final PBUInt32Field lanType = PBField.initUInt32(0);
  public final PBStringField newPluginDesc = PBField.initString("");
  public final PBStringField newPluginURL = PBField.initString("");
  public final PBUInt32Field newVer = PBField.initUInt32(0);
  public final PBStringField pkgName = PBField.initString("");
  public final PBUInt32Field pluginType = PBField.initUInt32(0);
  public final PBUInt32Field priority = PBField.initUInt32(0);
  public final PBUInt32Field push = PBField.initUInt32(0);
  public final PBStringField resConf = PBField.initString("");
  public final PBStringField resDesc = PBField.initString("");
  public final PBUInt32Field resId = PBField.initUInt32(0);
  public final PBStringField resName = PBField.initString("");
  public final PBUInt32Field resSubType = PBField.initUInt32(0);
  public final PBStringField resURLBig = PBField.initString("");
  public final PBStringField resURLSmall = PBField.initString("");
  public final PBUInt32Field status = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.plugin.ResourceConfig.GetResourceRespInfoV2
 * JD-Core Version:    0.7.0.1
 */