package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleSmartMatchMusic$SongInfo
  extends MessageMicro<SongInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field Copyright = PBField.initInt32(0);
  public final PBStringField H5Url = PBField.initString("");
  public final PBInt64Field ID = PBField.initInt64(0L);
  public final PBInt32Field IPlayTime = PBField.initInt32(0);
  public final PBInt32Field ISize = PBField.initInt32(0);
  public final PBInt32Field ISizeStandard = PBField.initInt32(0);
  public final PBInt32Field ITryBegin = PBField.initInt32(0);
  public final PBInt32Field ITryEnd = PBField.initInt32(0);
  public final PBInt32Field IsOnly = PBField.initInt32(0);
  public final PBStringField Language = PBField.initString("");
  public final PBStringField MID = PBField.initString("");
  public final PBStringField PlayUrl = PBField.initString("");
  public final PBStringField PlayUrlStandard = PBField.initString("");
  public final PBInt32Field TrySize = PBField.initInt32(0);
  public final PBStringField genre = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 58, 66, 74, 80, 88, 96, 104, 112, 120, 128 }, new String[] { "ID", "MID", "name", "genre", "IsOnly", "Language", "H5Url", "PlayUrl", "PlayUrlStandard", "ISize", "ISizeStandard", "IPlayTime", "Copyright", "TrySize", "ITryBegin", "ITryEnd" }, new Object[] { Long.valueOf(0L), "", "", "", localInteger, "", "", "", "", localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger }, SongInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleSmartMatchMusic.SongInfo
 * JD-Core Version:    0.7.0.1
 */