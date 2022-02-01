package tencent.im.msg.hummer.resv3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CustomFaceExtPb$ResvAttr
  extends MessageMicro<ResvAttr>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_download_index = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_text_summary = PBField.initBytes(ByteStringMicro.EMPTY);
  public CustomFaceExtPb.AnimationImageShow msg_image_show = new CustomFaceExtPb.AnimationImageShow();
  public final PBStringField string_ad_emo_desc_str = PBField.initString("");
  public final PBStringField string_ad_emo_jump_url = PBField.initString("");
  public final PBStringField string_camera_capture_materialname = PBField.initString("");
  public final PBStringField string_camera_capture_templateinfo = PBField.initString("");
  public final PBStringField string_doutu_suppliers = PBField.initString("");
  public final PBStringField string_emoji_iconUrl = PBField.initString("");
  public final PBStringField string_emoji_marketFaceName = PBField.initString("");
  public final PBStringField string_emoji_source = PBField.initString("");
  public final PBStringField string_emoji_webUrl = PBField.initString("");
  public final PBStringField string_text = PBField.initString("");
  public final PBUInt32Field uint32_customface_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_emoji_from = PBField.initUInt32(0);
  public final PBUInt32Field uint32_emoji_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_emoji_packageid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_image_biz_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_source = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 74, 80, 90, 98, 106, 114, 120, 130, 138, 146, 154, 162 }, new String[] { "uint32_image_biz_type", "uint32_customface_type", "uint32_emoji_packageid", "uint32_emoji_id", "string_text", "string_doutu_suppliers", "msg_image_show", "bytes_text_summary", "uint32_emoji_from", "string_emoji_source", "string_emoji_webUrl", "string_emoji_iconUrl", "string_emoji_marketFaceName", "uint32_source", "string_camera_capture_templateinfo", "string_camera_capture_materialname", "string_ad_emo_jump_url", "string_ad_emo_desc_str", "bytes_download_index" }, new Object[] { localInteger, localInteger, localInteger, localInteger, "", "", null, localByteStringMicro1, localInteger, "", "", "", "", localInteger, "", "", "", "", localByteStringMicro2 }, ResvAttr.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.hummer.resv3.CustomFaceExtPb.ResvAttr
 * JD-Core Version:    0.7.0.1
 */