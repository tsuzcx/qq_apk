package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GetRecommendWords$GetDefaultCopywriterRsp
  extends MessageMicro<GetDefaultCopywriterRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "code", "message", "copywriter" }, new Object[] { Integer.valueOf(0), "", null }, GetDefaultCopywriterRsp.class);
  public final PBInt32Field code = PBField.initInt32(0);
  public final PBRepeatMessageField<GetRecommendWords.CopyWriter> copywriter = PBField.initRepeatMessage(GetRecommendWords.CopyWriter.class);
  public final PBStringField message = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.qqwallet.GetRecommendWords.GetDefaultCopywriterRsp
 * JD-Core Version:    0.7.0.1
 */