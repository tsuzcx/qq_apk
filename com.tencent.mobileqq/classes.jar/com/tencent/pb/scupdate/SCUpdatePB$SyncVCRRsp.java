package com.tencent.pb.scupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SCUpdatePB$SyncVCRRsp
  extends MessageMicro<SyncVCRRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field continue_flag = PBField.initInt32(0);
  public final PBUInt32Field environment = PBField.initUInt32(0);
  public SCUpdatePB.SCPreload preload = new SCUpdatePB.SCPreload();
  public SCUpdatePB.SCReport report = new SCUpdatePB.SCReport();
  public final PBInt64Field seq = PBField.initInt64(0L);
  public final PBUInt32Field sync_switch = PBField.initUInt32(0);
  public final PBRepeatMessageField<SCUpdatePB.VCR> vcr_list = PBField.initRepeatMessage(SCUpdatePB.VCR.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 48, 56 }, new String[] { "seq", "vcr_list", "continue_flag", "preload", "report", "sync_switch", "environment" }, new Object[] { Long.valueOf(0L), null, localInteger, null, null, localInteger, localInteger }, SyncVCRRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.scupdate.SCUpdatePB.SyncVCRRsp
 * JD-Core Version:    0.7.0.1
 */