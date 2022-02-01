package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class GetMobileDialogRsp
  extends MessageMicro<GetMobileDialogRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "nextOffset", "dialogList" }, new Object[] { Integer.valueOf(0), null }, GetMobileDialogRsp.class);
  public final PBRepeatMessageField<MobileDialog> dialogList = PBField.initRepeatMessage(MobileDialog.class);
  public final PBInt32Field nextOffset = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.trpcprotocol.GetMobileDialogRsp
 * JD-Core Version:    0.7.0.1
 */