package tencent.im.oidb.cmd0x8f9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8f9$GetAsyncMsgFeedsReq
  extends MessageMicro<GetAsyncMsgFeedsReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int32_req_start", "uint32_req_num" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GetAsyncMsgFeedsReq.class);
  public final PBInt32Field int32_req_start = PBField.initInt32(0);
  public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f9.oidb_0x8f9.GetAsyncMsgFeedsReq
 * JD-Core Version:    0.7.0.1
 */