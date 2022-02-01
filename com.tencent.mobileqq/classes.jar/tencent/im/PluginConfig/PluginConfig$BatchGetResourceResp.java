package tencent.im.PluginConfig;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PluginConfig$BatchGetResourceResp
  extends MessageMicro<BatchGetResourceResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uin", "errcode", "errmsg", "resp_list" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", null }, BatchGetResourceResp.class);
  public final PBUInt32Field errcode = PBField.initUInt32(0);
  public final PBStringField errmsg = PBField.initString("");
  public final PBRepeatMessageField<PluginConfig.GetResourceResp> resp_list = PBField.initRepeatMessage(PluginConfig.GetResourceResp.class);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.PluginConfig.PluginConfig.BatchGetResourceResp
 * JD-Core Version:    0.7.0.1
 */