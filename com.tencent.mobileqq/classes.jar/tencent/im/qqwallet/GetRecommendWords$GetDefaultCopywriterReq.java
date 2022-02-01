package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class GetRecommendWords$GetDefaultCopywriterReq
  extends MessageMicro<GetDefaultCopywriterReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field fromtype = PBField.initInt32(0);
  public final PBEnumField subchannel = PBField.initEnum(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "subchannel", "fromtype" }, new Object[] { localInteger, localInteger }, GetDefaultCopywriterReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.qqwallet.GetRecommendWords.GetDefaultCopywriterReq
 * JD-Core Version:    0.7.0.1
 */