package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class QQCircleRecomgateway$GetBusiRecomReq
  extends MessageMicro<GetBusiRecomReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField commReq = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField extendChangedReq = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField extendConstReq = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "commReq", "extendConstReq", "extendChangedReq" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, GetBusiRecomReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleRecomgateway.GetBusiRecomReq
 * JD-Core Version:    0.7.0.1
 */