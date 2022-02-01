package com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class CommonMobileConfQueryRsp
  extends MessageMicro<CommonMobileConfQueryRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "confList", "updatePreDownloadGap" }, new Object[] { null, Long.valueOf(0L) }, CommonMobileConfQueryRsp.class);
  public final PBRepeatMessageField<MobileConfRsp> confList = PBField.initRepeatMessage(MobileConfRsp.class);
  public final PBInt64Field updatePreDownloadGap = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.CommonMobileConfQueryRsp
 * JD-Core Version:    0.7.0.1
 */