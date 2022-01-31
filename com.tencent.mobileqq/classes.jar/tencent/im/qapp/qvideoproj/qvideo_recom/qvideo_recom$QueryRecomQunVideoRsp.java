package tencent.im.qapp.qvideoproj.qvideo_recom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qvideo_recom$QueryRecomQunVideoRsp
  extends MessageMicro<QueryRecomQunVideoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "ret", "err", "total", "qun_infos" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), null }, QueryRecomQunVideoRsp.class);
  public final PBStringField err = PBField.initString("");
  public final PBRepeatMessageField<qvideo_recom.QunInfo> qun_infos = PBField.initRepeatMessage(qvideo_recom.QunInfo.class);
  public final PBInt32Field ret = PBField.initInt32(0);
  public final PBUInt32Field total = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.qapp.qvideoproj.qvideo_recom.qvideo_recom.QueryRecomQunVideoRsp
 * JD-Core Version:    0.7.0.1
 */