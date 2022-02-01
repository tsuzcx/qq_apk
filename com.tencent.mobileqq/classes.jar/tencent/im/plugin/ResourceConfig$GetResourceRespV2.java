package tencent.im.plugin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ResourceConfig$GetResourceRespV2
  extends MessageMicro<GetResourceRespV2>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "uin", "result", "addedResInfo", "deletedResInfo", "updatedResInfo" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null }, GetResourceRespV2.class);
  public final PBRepeatMessageField<ResourceConfig.GetResourceRespInfoV2> addedResInfo = PBField.initRepeatMessage(ResourceConfig.GetResourceRespInfoV2.class);
  public final PBRepeatMessageField<ResourceConfig.GetResourceRespInfoV2> deletedResInfo = PBField.initRepeatMessage(ResourceConfig.GetResourceRespInfoV2.class);
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBUInt32Field uin = PBField.initUInt32(0);
  public final PBRepeatMessageField<ResourceConfig.GetResourceRespInfoV2> updatedResInfo = PBField.initRepeatMessage(ResourceConfig.GetResourceRespInfoV2.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.plugin.ResourceConfig.GetResourceRespV2
 * JD-Core Version:    0.7.0.1
 */