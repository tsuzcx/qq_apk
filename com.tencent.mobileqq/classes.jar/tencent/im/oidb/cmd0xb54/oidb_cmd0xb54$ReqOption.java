package tencent.im.oidb.cmd0xb54;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb54$ReqOption
  extends MessageMicro<ReqOption>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72 }, new String[] { "uint32_biu_count", "uint32_like_count", "uint32_is_like", "uint32_style_card", "uint32_related_search_size", "uint32_article_business", "uint32_related_search", "uint32_need_fusion_biu_info", "uint32_need_proteus_json_data" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqOption.class);
  public final PBUInt32Field uint32_article_business = PBField.initUInt32(0);
  public final PBUInt32Field uint32_biu_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_like = PBField.initUInt32(0);
  public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_fusion_biu_info = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_proteus_json_data = PBField.initUInt32(0);
  public final PBUInt32Field uint32_related_search = PBField.initUInt32(0);
  public final PBUInt32Field uint32_related_search_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_style_card = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.ReqOption
 * JD-Core Version:    0.7.0.1
 */