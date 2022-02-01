package tencent.im.oidb.cmd0xd46;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xd46$KsClearUnreadReq
  extends MessageMicro<KsClearUnreadReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_uint32_ks_topic_id_list" }, new Object[] { Integer.valueOf(0) }, KsClearUnreadReq.class);
  public final PBRepeatField<Integer> rpt_uint32_ks_topic_id_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd46.oidb_cmd0xd46.KsClearUnreadReq
 * JD-Core Version:    0.7.0.1
 */