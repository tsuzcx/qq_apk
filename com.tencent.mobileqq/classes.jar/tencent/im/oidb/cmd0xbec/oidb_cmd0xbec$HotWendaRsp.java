package tencent.im.oidb.cmd0xbec;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xbec$HotWendaRsp
  extends MessageMicro<HotWendaRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_hot", "uint64_next_pull_time" }, new Object[] { null, Long.valueOf(0L) }, HotWendaRsp.class);
  public final PBRepeatMessageField<oidb_cmd0xbec.HotItem> rpt_hot = PBField.initRepeatMessage(oidb_cmd0xbec.HotItem.class);
  public final PBUInt64Field uint64_next_pull_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbec.oidb_cmd0xbec.HotWendaRsp
 * JD-Core Version:    0.7.0.1
 */