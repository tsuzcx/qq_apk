package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x68b$RefreshHistory
  extends MessageMicro<RefreshHistory>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_session_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<Integer> rpt_refresh_history = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_session_id", "rpt_refresh_history" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, RefreshHistory.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RefreshHistory
 * JD-Core Version:    0.7.0.1
 */