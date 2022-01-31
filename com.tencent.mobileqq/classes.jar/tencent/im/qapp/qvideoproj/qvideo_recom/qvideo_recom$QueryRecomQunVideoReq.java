package tencent.im.qapp.qvideoproj.qvideo_recom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qvideo_recom$QueryRecomQunVideoReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "start_index", "end_index" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, QueryRecomQunVideoReq.class);
  public final PBUInt32Field end_index = PBField.initUInt32(0);
  public final PBUInt32Field start_index = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.qapp.qvideoproj.qvideo_recom.qvideo_recom.QueryRecomQunVideoReq
 * JD-Core Version:    0.7.0.1
 */