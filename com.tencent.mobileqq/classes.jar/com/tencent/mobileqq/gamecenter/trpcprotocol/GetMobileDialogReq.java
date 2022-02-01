package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class GetMobileDialogReq
  extends MessageMicro<GetMobileDialogReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field offset = PBField.initInt32(0);
  public final PBInt32Field pageSize = PBField.initInt32(0);
  public final PBInt64Field uin = PBField.initInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "offset", "pageSize", "uin" }, new Object[] { localInteger, localInteger, Long.valueOf(0L) }, GetMobileDialogReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.trpcprotocol.GetMobileDialogReq
 * JD-Core Version:    0.7.0.1
 */