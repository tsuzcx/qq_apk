package tencent.im.oidb.cmd0xa70;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_cmd0xa70$VideoReqInfo
  extends MessageMicro<VideoReqInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_wangzhe_share_url = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_wangzhe_share_url" }, new Object[] { localByteStringMicro }, VideoReqInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa70.oidb_cmd0xa70.VideoReqInfo
 * JD-Core Version:    0.7.0.1
 */