package com.tencent.qqavopensdk.IntrenalLogic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqavopensdkSsoTunnel$UniSsoServerRspComm
  extends MessageMicro<UniSsoServerRspComm>
{
  public static final int DELAYMS_FIELD_NUMBER = 1;
  public static final int PACKAGESIZE_FIELD_NUMBER = 2;
  public static final int PROCTIME_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field delayms = PBField.initUInt32(0);
  public final PBUInt32Field packagesize = PBField.initUInt32(0);
  public final PBInt32Field proctime = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "delayms", "packagesize", "proctime" }, new Object[] { localInteger, localInteger, localInteger }, UniSsoServerRspComm.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.UniSsoServerRspComm
 * JD-Core Version:    0.7.0.1
 */