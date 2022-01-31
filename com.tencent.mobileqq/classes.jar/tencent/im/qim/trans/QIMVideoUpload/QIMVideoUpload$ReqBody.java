package tencent.im.qim.trans.QIMVideoUpload;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QIMVideoUpload$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_video_uuid = PBField.initString("");
  public final PBUInt64Field uint64_data_type = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_not_notify_story_flag = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_pic_type = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_service_type = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 800, 810 }, new String[] { "uint64_uin", "uint64_service_type", "uint64_data_type", "bytes_md5", "uint64_not_notify_story_flag", "uint64_pic_type", "str_video_uuid" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L), "" }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.qim.trans.QIMVideoUpload.QIMVideoUpload.ReqBody
 * JD-Core Version:    0.7.0.1
 */