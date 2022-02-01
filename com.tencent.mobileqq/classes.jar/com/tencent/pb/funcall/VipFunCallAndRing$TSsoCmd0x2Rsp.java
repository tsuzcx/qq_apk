package com.tencent.pb.funcall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class VipFunCallAndRing$TSsoCmd0x2Rsp
  extends MessageMicro<TSsoCmd0x2Rsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "i32_funcall_id", "i32_ring_id", "st_src_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, TSsoCmd0x2Rsp.class);
  public final PBInt32Field i32_funcall_id = PBField.initInt32(0);
  public final PBInt32Field i32_ring_id = PBField.initInt32(0);
  public VipFunCallAndRing.TSourceInfo st_src_info = new VipFunCallAndRing.TSourceInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.funcall.VipFunCallAndRing.TSsoCmd0x2Rsp
 * JD-Core Version:    0.7.0.1
 */