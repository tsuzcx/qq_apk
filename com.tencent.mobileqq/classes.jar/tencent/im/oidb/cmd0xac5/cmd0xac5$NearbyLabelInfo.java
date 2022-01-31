package tencent.im.oidb.cmd0xac5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xac5$NearbyLabelInfo
  extends MessageMicro<NearbyLabelInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field font_colour = PBField.initUInt32(0);
  public final PBUInt32Field label_colour = PBField.initUInt32(0);
  public final PBUInt32Field label_id = PBField.initUInt32(0);
  public final PBBytesField label_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField label_pic = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field show_day = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48 }, new String[] { "label_id", "label_pic", "label_name", "label_colour", "font_colour", "show_day" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, NearbyLabelInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xac5.cmd0xac5.NearbyLabelInfo
 * JD-Core Version:    0.7.0.1
 */