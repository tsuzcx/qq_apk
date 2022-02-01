package tencent.im.msg.hummer.resv1;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class TextMsgExtPb$ResvAttr
  extends MessageMicro<ResvAttr>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field at_member_tinyid = PBField.initUInt64(0L);
  public final PBUInt64Field at_member_uin = PBField.initUInt64(0L);
  public final PBUInt32Field at_type = PBField.initUInt32(0);
  public final PBUInt32Field text_analysis_result = PBField.initUInt32(0);
  public final PBBytesField wording = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "wording", "text_analysis_result", "at_type", "at_member_uin", "at_member_tinyid" }, new Object[] { localByteStringMicro, localInteger, localInteger, localLong, localLong }, ResvAttr.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.hummer.resv1.TextMsgExtPb.ResvAttr
 * JD-Core Version:    0.7.0.1
 */