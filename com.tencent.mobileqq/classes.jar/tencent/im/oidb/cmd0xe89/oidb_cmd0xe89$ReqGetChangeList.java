package tencent.im.oidb.cmd0xe89;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_cmd0xe89$ReqGetChangeList
  extends MessageMicro<ReqGetChangeList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_req_json_buf = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_req_json_buf" }, new Object[] { localByteStringMicro }, ReqGetChangeList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe89.oidb_cmd0xe89.ReqGetChangeList
 * JD-Core Version:    0.7.0.1
 */