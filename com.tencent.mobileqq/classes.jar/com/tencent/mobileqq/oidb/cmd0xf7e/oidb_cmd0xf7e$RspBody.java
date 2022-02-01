package com.tencent.mobileqq.oidb.cmd0xf7e;

import com.tencent.mobileqq.oidb.tofuCommon.TofuCommon.TofuCubeInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xf7e$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 8010 }, new String[] { "uint64_next_pull_time", "msg_tofu_cube_info" }, new Object[] { Long.valueOf(0L), null }, RspBody.class);
  public TofuCommon.TofuCubeInfo msg_tofu_cube_info = new TofuCommon.TofuCubeInfo();
  public final PBUInt64Field uint64_next_pull_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.oidb.cmd0xf7e.oidb_cmd0xf7e.RspBody
 * JD-Core Version:    0.7.0.1
 */