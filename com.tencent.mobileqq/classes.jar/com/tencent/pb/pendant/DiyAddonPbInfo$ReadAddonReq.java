package com.tencent.pb.pendant;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DiyAddonPbInfo$ReadAddonReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "cmd", "packetseq", "comm", "reqcmd0x01" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null }, ReadAddonReq.class);
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public DiyAddonPbInfo.AddonReqComm comm = new DiyAddonPbInfo.AddonReqComm();
  public final PBUInt64Field packetseq = PBField.initUInt64(0L);
  public DiyAddonPbInfo.AddonGetDiyInfoReq reqcmd0x01 = new DiyAddonPbInfo.AddonGetDiyInfoReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.pendant.DiyAddonPbInfo.ReadAddonReq
 * JD-Core Version:    0.7.0.1
 */