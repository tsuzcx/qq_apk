package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x68b$AdInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_apurl = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_button_txt = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_button_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_cl = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_corporate_image_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_corporate_logo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_corporation_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_customized_invoke_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_ext = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField bytes_image_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBBytesField bytes_img = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_img_s = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_landing_page = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_price = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_product_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_rl = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField bytes_title_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBBytesField bytes_trace_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_txt = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField bytes_url_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBBytesField bytes_via = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_view_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_ad_jump_mode = PBField.initEnum(1);
  public final PBEnumField enum_ad_layout = PBField.initEnum(0);
  public final PBInt32Field int32_kd_pos = PBField.initInt32(0);
  public final PBInt32Field int32_product_type = PBField.initInt32(0);
  public final PBRepeatMessageField rpt_msg_inner_ad_info = PBField.initRepeatMessage(AdInfo.class);
  public final PBUInt32Field uint32_ad_material_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ad_material_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ad_material_width = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ad_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cost_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_dis_channel = PBField.initUInt32(0);
  public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
  public final PBUInt64Field uint64_ad_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_aid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro12 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro13 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro14 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro15 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro16 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro17 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro18 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro19 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro20 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro21 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro22 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro23 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro24 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 96, 104, 114, 122, 130, 138, 146, 154, 162, 170, 178, 184, 194, 202, 208, 218, 226, 234, 240, 248, 256, 264, 272, 282, 288, 298, 304, 312 }, new String[] { "uint64_channel_id", "int32_kd_pos", "bytes_cl", "bytes_img", "bytes_img_s", "bytes_txt", "bytes_desc", "bytes_rl", "bytes_apurl", "bytes_trace_id", "bytes_product_id", "int32_product_type", "uint32_ad_type", "rpt_msg_inner_ad_info", "bytes_landing_page", "bytes_price", "bytes_button_txt", "bytes_view_id", "bytes_customized_invoke_url", "bytes_corporation_name", "bytes_corporate_image_name", "bytes_corporate_logo", "uint64_ad_uin", "bytes_ext", "bytes_video_url", "uint32_cost_type", "bytes_title_list", "bytes_image_list", "bytes_url_list", "uint64_aid", "enum_ad_layout", "uint32_ad_material_id", "uint32_ad_material_width", "uint32_ad_material_height", "bytes_via", "uint32_dis_channel", "bytes_button_url", "uint32_duration", "enum_ad_jump_mode" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro10, localByteStringMicro11, localByteStringMicro12, localByteStringMicro13, localByteStringMicro14, localByteStringMicro15, localByteStringMicro16, localByteStringMicro17, Long.valueOf(0L), localByteStringMicro18, localByteStringMicro19, Integer.valueOf(0), localByteStringMicro20, localByteStringMicro21, localByteStringMicro22, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro23, Integer.valueOf(0), localByteStringMicro24, Integer.valueOf(0), Integer.valueOf(1) }, AdInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.AdInfo
 * JD-Core Version:    0.7.0.1
 */