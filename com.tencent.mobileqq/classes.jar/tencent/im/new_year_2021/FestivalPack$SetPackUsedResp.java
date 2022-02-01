package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FestivalPack$SetPackUsedResp
  extends MessageMicro<SetPackUsedResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "business" }, new Object[] { Integer.valueOf(0) }, SetPackUsedResp.class);
  public final PBUInt32Field business = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.new_year_2021.FestivalPack.SetPackUsedResp
 * JD-Core Version:    0.7.0.1
 */