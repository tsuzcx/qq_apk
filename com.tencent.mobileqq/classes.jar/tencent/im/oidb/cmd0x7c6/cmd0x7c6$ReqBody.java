package tencent.im.oidb.cmd0x7c6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x7c6$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int UINT32_NOT_SEE_QZONE_FIELD_NUMBER = 2;
  public static final int UINT32_PREVENT_DYNAMIC_FIELD_NUMBER = 3;
  public static final int UINT32_RECV_MSG_BOX_FIELD_NUMBER = 4;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_not_see_qzone = PBField.initUInt32(0);
  public final PBUInt32Field uint32_prevent_dynamic = PBField.initUInt32(0);
  public final PBUInt32Field uint32_recv_msg_box = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_uin", "uint32_not_see_qzone", "uint32_prevent_dynamic", "uint32_recv_msg_box" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7c6.cmd0x7c6.ReqBody
 * JD-Core Version:    0.7.0.1
 */