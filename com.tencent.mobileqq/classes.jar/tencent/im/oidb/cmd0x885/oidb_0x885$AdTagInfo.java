package tencent.im.oidb.cmd0x885;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0x885$AdTagInfo
  extends MessageMicro<AdTagInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_display_ad_flag = PBField.initInt32(0);
  public final PBInt32Field int32_pos = PBField.initInt32(0);
  public oidb_0x885.ClassInfo msg_class_info = new oidb_0x885.ClassInfo();
  public final PBRepeatMessageField<oidb_0x885.KdTagItem> rpt_kd_tag_list = PBField.initRepeatMessage(oidb_0x885.KdTagItem.class);
  public final PBStringField string_ad_feature_info = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50 }, new String[] { "bytes_rowkey", "rpt_kd_tag_list", "int32_display_ad_flag", "int32_pos", "msg_class_info", "string_ad_feature_info" }, new Object[] { localByteStringMicro, null, localInteger, localInteger, null, "" }, AdTagInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x885.oidb_0x885.AdTagInfo
 * JD-Core Version:    0.7.0.1
 */