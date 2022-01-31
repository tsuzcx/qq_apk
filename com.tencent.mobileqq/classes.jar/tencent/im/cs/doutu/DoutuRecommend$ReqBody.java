package tencent.im.cs.doutu;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class DoutuRecommend$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_get_imginfo_req" }, new Object[] { null }, ReqBody.class);
  public DoutuRecommend.GetImgInfoReq msg_get_imginfo_req = new DoutuRecommend.GetImgInfoReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.doutu.DoutuRecommend.ReqBody
 * JD-Core Version:    0.7.0.1
 */