package com.tencent.pb.ppcloginauth;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class PPCLoginAuth$req
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "comm", "reqcmd_0x01", "reqcmd_0x02" }, new Object[] { null, null, null }, req.class);
  public PPCLoginAuth.plat_info comm = new PPCLoginAuth.plat_info();
  public PPCLoginAuth.comering_req reqcmd_0x01 = new PPCLoginAuth.comering_req();
  public PPCLoginAuth.backgound_req reqcmd_0x02 = new PPCLoginAuth.backgound_req();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.ppcloginauth.PPCLoginAuth.req
 * JD-Core Version:    0.7.0.1
 */