package com.tencent.pb.scupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class SCUpdatePB$SyncVCRReq
  extends MessageMicro<SyncVCRReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<SCUpdatePB.ItemVersion> item_list = PBField.initRepeatMessage(SCUpdatePB.ItemVersion.class);
  public final PBInt64Field plver = PBField.initInt64(0L);
  public final PBInt64Field rpver = PBField.initInt64(0L);
  public final PBInt64Field seq = PBField.initInt64(0L);
  public final PBInt32Field sync_mode = PBField.initInt32(0);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "seq", "sync_mode", "item_list", "plver", "rpver" }, new Object[] { localLong, Integer.valueOf(0), null, localLong, localLong }, SyncVCRReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.scupdate.SCUpdatePB.SyncVCRReq
 * JD-Core Version:    0.7.0.1
 */