package tencent.im.cs.doutu;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Doutu$GetImgInfoRsp
  extends MessageMicro<GetImgInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_fail_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_result = PBField.initInt32(0);
  public final PBRepeatMessageField<Doutu.ImgInfo> rpt_msg_img_info = PBField.initRepeatMessage(Doutu.ImgInfo.class);
  public final PBUInt32Field uint32_rsp_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "int32_result", "bytes_fail_msg", "rpt_msg_img_info", "uint32_rsp_type" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, Integer.valueOf(0) }, GetImgInfoRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.doutu.Doutu.GetImgInfoRsp
 * JD-Core Version:    0.7.0.1
 */