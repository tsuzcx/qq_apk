package tencent.im.oidb.cmd0xb57;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb57$GetNumApproveListReqBody
  extends MessageMicro<GetNumApproveListReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_start", "uint32_need_num" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GetNumApproveListReqBody.class);
  public final PBUInt32Field uint32_need_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_start = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb57.oidb_cmd0xb57.GetNumApproveListReqBody
 * JD-Core Version:    0.7.0.1
 */