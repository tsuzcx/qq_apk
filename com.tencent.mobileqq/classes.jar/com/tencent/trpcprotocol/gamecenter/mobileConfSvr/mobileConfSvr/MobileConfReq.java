package com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class MobileConfReq
  extends MessageMicro<MobileConfReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "configType", "busiReq" }, new Object[] { Integer.valueOf(0), "" }, MobileConfReq.class);
  public final PBStringField busiReq = PBField.initString("");
  public final PBInt32Field configType = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.MobileConfReq
 * JD-Core Version:    0.7.0.1
 */