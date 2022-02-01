package tencent.im.plugin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ResourceConfig$GetResourceReqInfoV2
  extends MessageMicro<GetResourceReqInfoV2>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field curVer = PBField.initInt64(0L);
  public final PBUInt32Field delFlag = PBField.initUInt32(0);
  public final PBUInt32Field lanType = PBField.initUInt32(0);
  public final PBStringField pkgName = PBField.initString("");
  public final PBUInt32Field pluginType = PBField.initUInt32(0);
  public final PBUInt32Field push = PBField.initUInt32(0);
  public final PBUInt32Field resId = PBField.initUInt32(0);
  public final PBUInt32Field resSubType = PBField.initUInt32(0);
  public final PBUInt32Field state = PBField.initUInt32(0);
  public final PBUInt32Field status = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56, 64, 72, 80 }, new String[] { "pkgName", "curVer", "resSubType", "lanType", "state", "resId", "status", "push", "pluginType", "delFlag" }, new Object[] { "", Long.valueOf(0L), localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger }, GetResourceReqInfoV2.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.plugin.ResourceConfig.GetResourceReqInfoV2
 * JD-Core Version:    0.7.0.1
 */