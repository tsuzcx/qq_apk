package com.tencent.pb.ppcloginauth;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class PPCLoginAuth$rsp
  extends MessageMicro<rsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "ret", "errmsg", "rspcmd_0x01", "rspcmd_0x02" }, new Object[] { Long.valueOf(0L), "", null, null }, rsp.class);
  public final PBStringField errmsg = PBField.initString("");
  public final PBInt64Field ret = PBField.initInt64(0L);
  public PPCLoginAuth.comering_rsp rspcmd_0x01 = new PPCLoginAuth.comering_rsp();
  public PPCLoginAuth.backgound_rsp rspcmd_0x02 = new PPCLoginAuth.backgound_rsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.ppcloginauth.PPCLoginAuth.rsp
 * JD-Core Version:    0.7.0.1
 */