package tencent.im.PluginConfig;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class PluginConfig$BatchGetResourceReq
  extends MessageMicro<BatchGetResourceReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "req_list" }, new Object[] { null }, BatchGetResourceReq.class);
  public final PBRepeatMessageField<PluginConfig.GetResourceReq> req_list = PBField.initRepeatMessage(PluginConfig.GetResourceReq.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.PluginConfig.PluginConfig.BatchGetResourceReq
 * JD-Core Version:    0.7.0.1
 */