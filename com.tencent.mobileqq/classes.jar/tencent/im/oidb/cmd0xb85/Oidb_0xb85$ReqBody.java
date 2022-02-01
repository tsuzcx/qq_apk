package tencent.im.oidb.cmd0xb85;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class Oidb_0xb85$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field appid = PBField.initInt32(0);
  public Oidb_0xb85.GetRankListReqBody get_ranklist_req = new Oidb_0xb85.GetRankListReqBody();
  public final PBStringField openid = PBField.initString("");
  public final PBStringField openkey = PBField.initString("");
  public Oidb_0xb85.ReportScoreReqBody report_score_req = new Oidb_0xb85.ReportScoreReqBody();
  public final PBInt32Field service_id = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 90, 98 }, new String[] { "openid", "openkey", "appid", "service_id", "report_score_req", "get_ranklist_req" }, new Object[] { "", "", localInteger, localInteger, null, null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb85.Oidb_0xb85.ReqBody
 * JD-Core Version:    0.7.0.1
 */