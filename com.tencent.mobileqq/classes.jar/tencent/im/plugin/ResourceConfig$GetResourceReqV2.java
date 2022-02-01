package tencent.im.plugin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ResourceConfig$GetResourceReqV2
  extends MessageMicro<GetResourceReqV2>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 50 }, new String[] { "resReqInfo", "pluginType", "model", "appid", "reqVer", "revision" }, new Object[] { null, Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "" }, GetResourceReqV2.class);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBStringField model = PBField.initString("");
  public final PBUInt32Field pluginType = PBField.initUInt32(0);
  public final PBUInt32Field reqVer = PBField.initUInt32(0);
  public final PBRepeatMessageField<ResourceConfig.GetResourceReqInfoV2> resReqInfo = PBField.initRepeatMessage(ResourceConfig.GetResourceReqInfoV2.class);
  public final PBStringField revision = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.plugin.ResourceConfig.GetResourceReqV2
 * JD-Core Version:    0.7.0.1
 */