package tencent.im.oidb.cmd0x69f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x69f$ChannelInfo
  extends MessageMicro<ChannelInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ark_config = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_channel_cover_picurl = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_channel_cover_spec = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_channel_cover_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_channel_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_channel_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_is_external_bg_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_channel_cover_style = PBField.initEnum(0);
  public final PBEnumField enum_column_type = PBField.initEnum(0);
  public oidb_cmd0x69f.RichTips msg_rich_tips = new oidb_cmd0x69f.RichTips();
  public final PBRepeatMessageField<oidb_cmd0x69f.ChildChannelInfo> rpt_child_channel_list = PBField.initRepeatMessage(oidb_cmd0x69f.ChildChannelInfo.class);
  public final PBUInt32Field uint32_bold_font = PBField.initUInt32(0);
  public final PBUInt32Field uint32_channel_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_fonts_color = PBField.initUInt32(0);
  public final PBUInt32Field uint32_frame_color = PBField.initUInt32(0);
  public final PBUInt32Field uint32_has_recommend = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_external_expose = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_first_req = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_followed = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_topic = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_icon = PBField.initUInt32(0);
  public final PBUInt64Field uint64_channel_cover_article_id = PBField.initUInt64(0L);
  
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
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48, 56, 66, 72, 80, 90, 96, 106, 114, 120, 130, 136, 144, 154, 162, 168, 176, 186, 192 }, new String[] { "uint32_channel_id", "bytes_channel_name", "uint32_channel_type", "uint32_is_first_req", "rpt_child_channel_list", "uint32_frame_color", "uint32_fonts_color", "bytes_channel_jump_url", "uint32_bold_font", "uint32_show_icon", "bytes_ark_config", "enum_channel_cover_style", "bytes_channel_cover_wording", "bytes_channel_cover_picurl", "uint64_channel_cover_article_id", "bytes_channel_cover_spec", "uint32_is_followed", "enum_column_type", "msg_rich_tips", "bytes_icon_url", "uint32_is_topic", "uint32_is_external_expose", "bytes_is_external_bg_url", "uint32_has_recommend" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L), localByteStringMicro6, Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro7, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro8, Integer.valueOf(0) }, ChannelInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.ChannelInfo
 * JD-Core Version:    0.7.0.1
 */