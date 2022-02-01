package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class articlesummary$UGCVoiceInfo
  extends MessageMicro<UGCVoiceInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_voice_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_size = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_voice_url", "uint32_duration", "uint32_file_size" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, UGCVoiceInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.UGCVoiceInfo
 * JD-Core Version:    0.7.0.1
 */