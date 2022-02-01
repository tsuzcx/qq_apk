package tencent.im.PluginConfig;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PluginConfig$GetResourceReqInfo
  extends MessageMicro<GetResourceReqInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "res_id", "res_seq" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GetResourceReqInfo.class);
  public final PBUInt32Field res_id = PBField.initUInt32(0);
  public final PBUInt32Field res_seq = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.PluginConfig.PluginConfig.GetResourceReqInfo
 * JD-Core Version:    0.7.0.1
 */