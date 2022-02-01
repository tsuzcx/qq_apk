package com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class CommonMobileConfQueryReq
  extends MessageMicro<CommonMobileConfQueryReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "commonReq", "reqConfList" }, new Object[] { null, null }, CommonMobileConfQueryReq.class);
  public CommonReq commonReq = new CommonReq();
  public final PBRepeatMessageField<MobileConfReq> reqConfList = PBField.initRepeatMessage(MobileConfReq.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.CommonMobileConfQueryReq
 * JD-Core Version:    0.7.0.1
 */