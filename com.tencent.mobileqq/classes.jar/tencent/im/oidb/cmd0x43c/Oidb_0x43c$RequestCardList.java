package tencent.im.oidb.cmd0x43c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x43c$RequestCardList
  extends MessageMicro<RequestCardList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field next_flag = PBField.initUInt32(0);
  public final PBUInt32Field req_num = PBField.initUInt32(10);
  public final PBUInt32Field seq = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "seq", "next_flag", "req_num" }, new Object[] { localInteger, localInteger, Integer.valueOf(10) }, RequestCardList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x43c.Oidb_0x43c.RequestCardList
 * JD-Core Version:    0.7.0.1
 */