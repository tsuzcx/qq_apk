package tencent.im.oidb.cmd0x77f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x77f$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_listtype", "rpt_msg_visit_prof_rec", "uint32_list_ruleid" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0) }, ReqBody.class);
  public final PBRepeatMessageField<cmd0x77f.VisitProfRec> rpt_msg_visit_prof_rec = PBField.initRepeatMessage(cmd0x77f.VisitProfRec.class);
  public final PBUInt32Field uint32_list_ruleid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_listtype = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x77f.cmd0x77f.ReqBody
 * JD-Core Version:    0.7.0.1
 */