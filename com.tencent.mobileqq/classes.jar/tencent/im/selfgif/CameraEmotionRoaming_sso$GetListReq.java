package tencent.im.selfgif;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class CameraEmotionRoaming_sso$GetListReq
  extends MessageMicro<GetListReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField client_timestamp_version = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "client_timestamp_version" }, new Object[] { localByteStringMicro }, GetListReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.selfgif.CameraEmotionRoaming_sso.GetListReq
 * JD-Core Version:    0.7.0.1
 */