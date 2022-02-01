package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class Unisso$UniSsoServerRsp
  extends MessageMicro<UniSsoServerRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public Unisso.UniSsoServerRspComm comm = new Unisso.UniSsoServerRspComm();
  public final PBStringField errmsg = PBField.initString("");
  public final PBInt64Field ret = PBField.initInt64(0L);
  public final PBBytesField rspdata = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "ret", "errmsg", "comm", "rspdata" }, new Object[] { Long.valueOf(0L), "", null, localByteStringMicro }, UniSsoServerRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.new_year_2021.Unisso.UniSsoServerRsp
 * JD-Core Version:    0.7.0.1
 */