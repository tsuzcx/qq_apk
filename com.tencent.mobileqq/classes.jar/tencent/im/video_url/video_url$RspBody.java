package tencent.im.video_url;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class video_url$RspBody
  extends MessageMicro<RspBody>
{
  public static final int BYTES_ERR_MSG_FIELD_NUMBER = 2;
  public static final int INT32_RESULT_FIELD_NUMBER = 1;
  public static final int RPT_BYTES_PLAY_URLS_FIELD_NUMBER = 3;
  public static final int UINT32_DEFN_FIELD_NUMBER = 5;
  public static final int UINT32_TOTAL_TIME_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_result = PBField.initInt32(0);
  public final PBRepeatField<ByteStringMicro> rpt_bytes_play_urls = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBUInt32Field uint32_defn = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_time = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "int32_result", "bytes_err_msg", "rpt_bytes_play_urls", "uint32_total_time", "uint32_defn" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.video_url.video_url.RspBody
 * JD-Core Version:    0.7.0.1
 */