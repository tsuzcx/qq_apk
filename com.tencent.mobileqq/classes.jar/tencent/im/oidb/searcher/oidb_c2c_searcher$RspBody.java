package tencent.im.oidb.searcher;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_c2c_searcher$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField friends = PBField.initRepeatMessage(oidb_c2c_searcher.Iterator.class);
  public final PBRepeatField msgs = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBEnumField result = PBField.initEnum(0);
  public final PBRepeatField segs = PBField.initRepeat(PBBytesField.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "result", "friends", "msgs", "segs" }, new Object[] { Integer.valueOf(0), null, localByteStringMicro1, localByteStringMicro2 }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.searcher.oidb_c2c_searcher.RspBody
 * JD-Core Version:    0.7.0.1
 */