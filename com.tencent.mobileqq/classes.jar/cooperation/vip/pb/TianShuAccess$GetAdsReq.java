package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class TianShuAccess$GetAdsReq
  extends MessageMicro<GetAdsReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "stComminfo", "lstPos" }, new Object[] { null, null }, GetAdsReq.class);
  public final PBRepeatMessageField<TianShuAccess.AdPosItem> lstPos = PBField.initRepeatMessage(TianShuAccess.AdPosItem.class);
  public TianShuAccess.CommInfo stComminfo = new TianShuAccess.CommInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.pb.TianShuAccess.GetAdsReq
 * JD-Core Version:    0.7.0.1
 */