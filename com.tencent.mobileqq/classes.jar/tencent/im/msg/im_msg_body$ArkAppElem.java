package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class im_msg_body$ArkAppElem
  extends MessageMicro<ArkAppElem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField app_name = PBField.initString("");
  public final PBBytesField bytes_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField min_version = PBField.initString("");
  public final PBStringField xml_template = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "app_name", "min_version", "xml_template", "bytes_data" }, new Object[] { "", "", "", localByteStringMicro }, ArkAppElem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.ArkAppElem
 * JD-Core Version:    0.7.0.1
 */