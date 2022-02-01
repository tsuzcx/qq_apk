package tencent.im.cs.doutu;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class DoutuRecommend$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_get_imginfo_rsp" }, new Object[] { null }, RspBody.class);
  public DoutuRecommend.GetImgInfoRsp msg_get_imginfo_rsp = new DoutuRecommend.GetImgInfoRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.cs.doutu.DoutuRecommend.RspBody
 * JD-Core Version:    0.7.0.1
 */