package com.tencent.pb.scupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SCUpdatePB$SyncVCRRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 48 }, new String[] { "seq", "vcr_list", "continue_flag", "preload", "report", "sync_switch" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0), null, null, Integer.valueOf(0) }, SyncVCRRsp.class);
  public final PBInt32Field continue_flag = PBField.initInt32(0);
  public SCUpdatePB.SCPreload preload = new SCUpdatePB.SCPreload();
  public SCUpdatePB.SCReport report = new SCUpdatePB.SCReport();
  public final PBInt64Field seq = PBField.initInt64(0L);
  public final PBUInt32Field sync_switch = PBField.initUInt32(0);
  public final PBRepeatMessageField vcr_list = PBField.initRepeatMessage(SCUpdatePB.VCR.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.scupdate.SCUpdatePB.SyncVCRRsp
 * JD-Core Version:    0.7.0.1
 */