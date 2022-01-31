package tencent.im.msg.resv21;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hummer_resv_21$FileImgInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_file_width", "uint32_file_height" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, FileImgInfo.class);
  public final PBUInt32Field uint32_file_height = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_width = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.resv21.hummer_resv_21.FileImgInfo
 * JD-Core Version:    0.7.0.1
 */