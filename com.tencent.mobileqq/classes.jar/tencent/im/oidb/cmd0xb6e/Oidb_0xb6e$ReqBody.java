package tencent.im.oidb.cmd0xb6e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0xb6e$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBInt32Field filter_type = PBField.initInt32(0);
  public final PBInt32Field https_figure_adapter = PBField.initInt32(1);
  public final PBStringField openid = PBField.initString("");
  public final PBStringField openkey = PBField.initString("");
  public final PBStringField platform = PBField.initString("");
  public final PBInt32Field relation_flag = PBField.initInt32(0);
  public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 58, 66 }, new String[] { "openid", "openkey", "appid", "filter_type", "relation_flag", "https_figure_adapter", "sig", "platform" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), localByteStringMicro, "" }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb6e.Oidb_0xb6e.ReqBody
 * JD-Core Version:    0.7.0.1
 */