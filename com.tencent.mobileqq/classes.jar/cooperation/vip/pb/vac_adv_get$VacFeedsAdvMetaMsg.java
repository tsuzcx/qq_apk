package cooperation.vip.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class vac_adv_get$VacFeedsAdvMetaMsg
  extends MessageMicro<VacFeedsAdvMetaMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field insert_pos = PBField.initInt32(0);
  public final PBBytesField rsp_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rsp_buffer", "insert_pos" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, VacFeedsAdvMetaMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.pb.vac_adv_get.VacFeedsAdvMetaMsg
 * JD-Core Version:    0.7.0.1
 */