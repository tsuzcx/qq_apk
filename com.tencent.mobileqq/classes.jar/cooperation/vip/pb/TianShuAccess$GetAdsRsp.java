package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class TianShuAccess$GetAdsRsp
  extends MessageMicro<GetAdsRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "code", "errmsg", "mapAds", "rspExtInfo" }, new Object[] { Integer.valueOf(0), "", null, "" }, GetAdsRsp.class);
  public final PBInt32Field code = PBField.initInt32(0);
  public final PBStringField errmsg = PBField.initString("");
  public final PBRepeatMessageField<TianShuAccess.RspEntry> mapAds = PBField.initRepeatMessage(TianShuAccess.RspEntry.class);
  public final PBStringField rspExtInfo = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.pb.TianShuAccess.GetAdsRsp
 * JD-Core Version:    0.7.0.1
 */