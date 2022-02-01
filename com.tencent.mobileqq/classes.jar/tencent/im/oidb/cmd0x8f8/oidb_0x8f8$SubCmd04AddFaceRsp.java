package tencent.im.oidb.cmd0x8f8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.trunk.feeds_inner_define.feeds_inner_define.FaceRecordSet;

public final class oidb_0x8f8$SubCmd04AddFaceRsp
  extends MessageMicro<SubCmd04AddFaceRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public feeds_inner_define.FaceRecordSet msg_face_set = new feeds_inner_define.FaceRecordSet();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_feeds_id", "msg_face_set" }, new Object[] { localByteStringMicro, null }, SubCmd04AddFaceRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f8.oidb_0x8f8.SubCmd04AddFaceRsp
 * JD-Core Version:    0.7.0.1
 */