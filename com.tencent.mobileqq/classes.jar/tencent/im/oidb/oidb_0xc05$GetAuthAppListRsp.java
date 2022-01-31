package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xc05$GetAuthAppListRsp
  extends MessageMicro<GetAuthAppListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "total_count", "appinfos", "cur_index" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0) }, GetAuthAppListRsp.class);
  public final PBRepeatMessageField<qqconnect.Appinfo> appinfos = PBField.initRepeatMessage(qqconnect.Appinfo.class);
  public final PBUInt32Field cur_index = PBField.initUInt32(0);
  public final PBUInt32Field total_count = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xc05.GetAuthAppListRsp
 * JD-Core Version:    0.7.0.1
 */