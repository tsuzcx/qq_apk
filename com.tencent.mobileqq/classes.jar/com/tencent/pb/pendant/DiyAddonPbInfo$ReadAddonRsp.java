package com.tencent.pb.pendant;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DiyAddonPbInfo$ReadAddonRsp
  extends MessageMicro<ReadAddonRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50 }, new String[] { "ret", "errmsg", "cmd", "packetseq", "comm", "rspcmd0x01" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L), null, null }, ReadAddonRsp.class);
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public DiyAddonPbInfo.AddonRspComm comm = new DiyAddonPbInfo.AddonRspComm();
  public final PBStringField errmsg = PBField.initString("");
  public final PBUInt64Field packetseq = PBField.initUInt64(0L);
  public final PBInt64Field ret = PBField.initInt64(0L);
  public DiyAddonPbInfo.AddonGetDiyInfoRsp rspcmd0x01 = new DiyAddonPbInfo.AddonGetDiyInfoRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.pendant.DiyAddonPbInfo.ReadAddonRsp
 * JD-Core Version:    0.7.0.1
 */