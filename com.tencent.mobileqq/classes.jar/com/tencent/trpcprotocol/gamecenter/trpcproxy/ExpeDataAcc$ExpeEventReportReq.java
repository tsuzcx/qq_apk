package com.tencent.trpcprotocol.gamecenter.trpcproxy;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class ExpeDataAcc$ExpeEventReportReq
  extends MessageMicro<ExpeEventReportReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "action_infos", "noNeedRsp" }, new Object[] { null, Integer.valueOf(0) }, ExpeEventReportReq.class);
  public final PBRepeatMessageField<ExpeDataAcc.UserActionInfo> action_infos = PBField.initRepeatMessage(ExpeDataAcc.UserActionInfo.class);
  public final PBInt32Field noNeedRsp = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.trpcprotocol.gamecenter.trpcproxy.ExpeDataAcc.ExpeEventReportReq
 * JD-Core Version:    0.7.0.1
 */