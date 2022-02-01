package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class GetRecommendWords$GetClassifyReq
  extends MessageMicro<GetClassifyReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field subchannel = PBField.initInt32(0);
  public final PBInt32Field ver = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "subchannel", "ver" }, new Object[] { localInteger, localInteger }, GetClassifyReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.qqwallet.GetRecommendWords.GetClassifyReq
 * JD-Core Version:    0.7.0.1
 */