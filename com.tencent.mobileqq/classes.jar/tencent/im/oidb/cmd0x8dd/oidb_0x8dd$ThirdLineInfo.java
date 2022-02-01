package tencent.im.oidb.cmd0x8dd;

import appoint.define.appoint_define.CommonLabel;
import appoint.define.appoint_define.RptInterestTag;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8dd$ThirdLineInfo
  extends MessageMicro<ThirdLineInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_common_label = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_interest_tag = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_rich_state = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_rich_state2 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_third_line_icon = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_third_line_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public appoint_define.CommonLabel common_label = new appoint_define.CommonLabel();
  public final PBUInt32Field identity_type = PBField.initUInt32(0);
  public final PBBytesField identity_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public appoint_define.RptInterestTag interest_tag = new appoint_define.RptInterestTag();
  public final PBUInt32Field mark_type = PBField.initUInt32(0);
  public final PBBytesField mark_word = PBField.initBytes(ByteStringMicro.EMPTY);
  
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
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 72, 82, 88, 98 }, new String[] { "bytes_third_line_icon", "bytes_third_line_info", "bytes_common_label", "bytes_interest_tag", "bytes_rich_state", "common_label", "interest_tag", "bytes_rich_state2", "identity_type", "identity_word", "mark_type", "mark_word" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, null, null, localByteStringMicro6, Integer.valueOf(0), localByteStringMicro7, Integer.valueOf(0), localByteStringMicro8 }, ThirdLineInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8dd.oidb_0x8dd.ThirdLineInfo
 * JD-Core Version:    0.7.0.1
 */