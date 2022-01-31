package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class articlesummary$SRTUniversalID
  extends MessageMicro<SRTUniversalID>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_kb_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_ks_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_ws_id = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "bytes_kb_id", "bytes_ks_id", "bytes_ws_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, SRTUniversalID.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.SRTUniversalID
 * JD-Core Version:    0.7.0.1
 */