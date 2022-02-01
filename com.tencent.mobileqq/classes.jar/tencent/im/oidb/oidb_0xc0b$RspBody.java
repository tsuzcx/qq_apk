package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xc0b$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_coin_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0xc0b.KanDianCoinRemind msg_kandian_coin_remind = new oidb_0xc0b.KanDianCoinRemind();
  public oidb_0xc0b.KanDianTaskRemind msg_kandian_task_remind = new oidb_0xc0b.KanDianTaskRemind();
  public final PBRepeatMessageField<oidb_0xc0b.KanDianCMSActivityInfo> rpt_cms_wording = PBField.initRepeatMessage(oidb_0xc0b.KanDianCMSActivityInfo.class);
  public final PBUInt32Field uint32_can_get_coin_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_open_coin_entry = PBField.initUInt32(0);
  public final PBUInt64Field uint64_last_cms_activity_stamp = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_last_completed_task_stamp = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 40, 50, 56, 66, 74 }, new String[] { "uint32_is_open_coin_entry", "uint32_can_get_coin_count", "bytes_coin_icon_url", "uint64_last_completed_task_stamp", "rpt_cms_wording", "uint64_last_cms_activity_stamp", "msg_kandian_coin_remind", "msg_kandian_task_remind" }, new Object[] { localInteger, localInteger, localByteStringMicro, localLong, null, localLong, null, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xc0b.RspBody
 * JD-Core Version:    0.7.0.1
 */