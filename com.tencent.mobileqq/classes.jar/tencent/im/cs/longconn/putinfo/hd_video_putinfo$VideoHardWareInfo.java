package tencent.im.cs.longconn.putinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hd_video_putinfo$VideoHardWareInfo
  extends MessageMicro<VideoHardWareInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_mobile_max_encodeframe", "uint32_mobile_max_decodeframe", "uint32_mobile_width", "uint32_mobile_height" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, VideoHardWareInfo.class);
  public final PBUInt32Field uint32_mobile_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mobile_max_decodeframe = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mobile_max_encodeframe = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mobile_width = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.cs.longconn.putinfo.hd_video_putinfo.VideoHardWareInfo
 * JD-Core Version:    0.7.0.1
 */