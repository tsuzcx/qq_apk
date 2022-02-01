package tencent.im.qapp.qvideoproj.qvideo_recom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qvideo_recom$QueryRecomQunVideoReq
  extends MessageMicro<QueryRecomQunVideoReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field end_index = PBField.initUInt32(0);
  public final PBUInt32Field start_index = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "start_index", "end_index" }, new Object[] { localInteger, localInteger }, QueryRecomQunVideoReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.qapp.qvideoproj.qvideo_recom.qvideo_recom.QueryRecomQunVideoReq
 * JD-Core Version:    0.7.0.1
 */