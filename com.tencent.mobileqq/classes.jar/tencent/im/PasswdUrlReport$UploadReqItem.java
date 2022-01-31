package tencent.im;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class PasswdUrlReport$UploadReqItem
  extends MessageMicro<UploadReqItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<String> js_func_features = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField origin_url = PBField.initString("");
  public final PBInt32Field passwd_input = PBField.initInt32(0);
  public final PBInt32Field passwd_show = PBField.initInt32(0);
  public final PBStringField screenshot = PBField.initString("");
  public final PBRepeatField<String> text_features = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField title = PBField.initString("");
  public final PBBytesField uin = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField url = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 72 }, new String[] { "url", "origin_url", "text_features", "js_func_features", "screenshot", "title", "uin", "passwd_show", "passwd_input" }, new Object[] { "", "", "", "", "", "", localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, UploadReqItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.PasswdUrlReport.UploadReqItem
 * JD-Core Version:    0.7.0.1
 */