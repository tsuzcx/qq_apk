package tencent.im.oidb.cmd0xc32;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xc32$GetVisibleListReqBody
  extends MessageMicro<GetVisibleListReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_start_ix = PBField.initUInt32(0);
  public final PBUInt32Field uint32_want_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_feeds_id", "uint32_start_ix", "uint32_want_num" }, new Object[] { Long.valueOf(0L), localInteger, localInteger }, GetVisibleListReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc32.oidb_cmd0xc32.GetVisibleListReqBody
 * JD-Core Version:    0.7.0.1
 */