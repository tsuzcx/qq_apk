package tencent.im.oidb.cmd0x791;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_0x791$DTNearbyEntranceWordCornerRedDot
  extends MessageMicro<DTNearbyEntranceWordCornerRedDot>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_enable = PBField.initBool(false);
  public final PBBoolField bool_switch_to_word_corner = PBField.initBool(false);
  public final PBBytesField str_hintText = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "bool_enable", "bool_switch_to_word_corner", "str_hintText" }, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false), localByteStringMicro }, DTNearbyEntranceWordCornerRedDot.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x791.oidb_0x791.DTNearbyEntranceWordCornerRedDot
 * JD-Core Version:    0.7.0.1
 */