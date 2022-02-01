package com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class MobileConfRsp
  extends MessageMicro<MobileConfRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField conf = PBField.initString("");
  public final PBInt32Field configType = PBField.initInt32(0);
  public final PBInt32Field ret = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "configType", "conf", "ret" }, new Object[] { localInteger, "", localInteger }, MobileConfRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.MobileConfRsp
 * JD-Core Version:    0.7.0.1
 */