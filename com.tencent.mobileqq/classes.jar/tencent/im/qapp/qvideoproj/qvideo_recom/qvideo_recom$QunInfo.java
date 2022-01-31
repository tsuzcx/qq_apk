package tencent.im.qapp.qvideoproj.qvideo_recom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qvideo_recom$QunInfo
  extends MessageMicro<QunInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50 }, new String[] { "qun_index", "qun_code", "qun_name", "onlive_num", "qvideo_url", "logo_url" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(0), "", "" }, QunInfo.class);
  public final PBStringField logo_url = PBField.initString("");
  public final PBUInt32Field onlive_num = PBField.initUInt32(0);
  public final PBUInt64Field qun_code = PBField.initUInt64(0L);
  public final PBUInt32Field qun_index = PBField.initUInt32(0);
  public final PBStringField qun_name = PBField.initString("");
  public final PBStringField qvideo_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.qapp.qvideoproj.qvideo_recom.qvideo_recom.QunInfo
 * JD-Core Version:    0.7.0.1
 */