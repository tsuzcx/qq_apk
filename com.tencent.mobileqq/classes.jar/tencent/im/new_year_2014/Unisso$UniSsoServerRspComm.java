package tencent.im.new_year_2014;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Unisso$UniSsoServerRspComm
  extends MessageMicro<UniSsoServerRspComm>
{
  public static final int DELAYMS_FIELD_NUMBER = 1;
  public static final int PACKAGESIZE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field delayms = PBField.initUInt32(0);
  public final PBUInt32Field packagesize = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "delayms", "packagesize" }, new Object[] { localInteger, localInteger }, UniSsoServerRspComm.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.new_year_2014.Unisso.UniSsoServerRspComm
 * JD-Core Version:    0.7.0.1
 */