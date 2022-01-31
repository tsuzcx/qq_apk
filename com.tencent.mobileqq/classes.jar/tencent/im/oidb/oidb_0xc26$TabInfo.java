package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xc26$TabInfo
  extends MessageMicro<TabInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_0xc26.Color background_color_select = new oidb_0xc26.Color();
  public oidb_0xc26.Color background_color_unselect = new oidb_0xc26.Color();
  public final PBBytesField bytes_icon_url_select = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_icon_url_unselect = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_table_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_recommend_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tab_id = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58 }, new String[] { "uint32_tab_id", "uint32_recommend_count", "bytes_table_name", "bytes_icon_url_select", "bytes_icon_url_unselect", "background_color_select", "background_color_unselect" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, null, null }, TabInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xc26.TabInfo
 * JD-Core Version:    0.7.0.1
 */