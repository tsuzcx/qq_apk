package tencent.im.oidb.cmd0x972;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class oidb_0x972$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field boold_type = PBField.initInt32(0);
  public final PBInt32Field career_id = PBField.initInt32(0);
  public final PBBytesField check_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field city_id = PBField.initInt32(0);
  public final PBInt32Field constellation = PBField.initInt32(0);
  public final PBInt32Field country_id = PBField.initInt32(0);
  public final PBInt32Field end_age = PBField.initInt32(0);
  public oidb_0x972.ExtensionRequestInfo extension_request_info = new oidb_0x972.ExtensionRequestInfo();
  public final PBInt32Field gander = PBField.initInt32(0);
  public final PBInt32Field h_city_id = PBField.initInt32(0);
  public final PBInt32Field h_country_id = PBField.initInt32(0);
  public final PBInt32Field h_province_id = PBField.initInt32(0);
  public final PBBytesField key_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field online = PBField.initInt32(0);
  public final PBInt32Field province_id = PBField.initInt32(0);
  public oidb_0x972.RootSearcherRequest search_request = new oidb_0x972.RootSearcherRequest();
  public final PBInt32Field start_age = PBField.initInt32(0);
  public final PBBytesField version = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field video = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 80, 88, 96, 104, 112, 120, 128, 136, 144, 152, 160, 168, 176, 184, 802, 810 }, new String[] { "key_word", "version", "search_request", "gander", "start_age", "end_age", "constellation", "boold_type", "country_id", "province_id", "city_id", "h_country_id", "h_province_id", "h_city_id", "career_id", "online", "video", "extension_request_info", "check_nick" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, null, localByteStringMicro3 }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x972.oidb_0x972.ReqBody
 * JD-Core Version:    0.7.0.1
 */