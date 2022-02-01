package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleSmartMatchMusic$SmartMatchMusicReq
  extends MessageMicro<SmartMatchMusicReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field cameraType = PBField.initUInt32(0);
  public final PBUInt32Field dataType = PBField.initUInt32(0);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBDoubleField fLat = PBField.initDouble(0.0D);
  public final PBDoubleField fLon = PBField.initDouble(0.0D);
  public final PBRepeatField<ByteStringMicro> vecPicBuffer = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBBytesField videoBuffer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field videoDuration = PBField.initUInt32(0);
  public final PBDoubleField videoLat = PBField.initDouble(0.0D);
  public final PBDoubleField videoLon = PBField.initDouble(0.0D);
  public final PBUInt64Field videoTime = PBField.initUInt64(0L);
  public final PBUInt32Field videoType = PBField.initUInt32(0);
  public final PBStringField wording = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    Double localDouble = Double.valueOf(0.0D);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 49, 57, 64, 72, 81, 89, 96, 106 }, new String[] { "extInfo", "videoBuffer", "videoDuration", "dataType", "vecPicBuffer", "fLat", "fLon", "videoType", "cameraType", "videoLat", "videoLon", "videoTime", "wording" }, new Object[] { null, localByteStringMicro1, localInteger, localInteger, localByteStringMicro2, localDouble, localDouble, localInteger, localInteger, localDouble, localDouble, Long.valueOf(0L), "" }, SmartMatchMusicReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleSmartMatchMusic.SmartMatchMusicReq
 * JD-Core Version:    0.7.0.1
 */