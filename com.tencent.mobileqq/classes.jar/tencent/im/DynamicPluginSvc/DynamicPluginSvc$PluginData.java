package tencent.im.DynamicPluginSvc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DynamicPluginSvc$PluginData
  extends MessageMicro<PluginData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field click_cnt = PBField.initUInt32(0);
  public final PBUInt32Field plugin_id = PBField.initUInt32(0);
  public final PBBytesField plugin_name = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "plugin_id", "plugin_name", "click_cnt" }, new Object[] { localInteger, localByteStringMicro, localInteger }, PluginData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.DynamicPluginSvc.DynamicPluginSvc.PluginData
 * JD-Core Version:    0.7.0.1
 */