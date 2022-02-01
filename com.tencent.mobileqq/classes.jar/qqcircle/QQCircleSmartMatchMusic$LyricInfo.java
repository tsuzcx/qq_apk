package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleSmartMatchMusic$LyricInfo
  extends MessageMicro<LyricInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "uiSongId", "strSongMid", "strFormat", "strLyric", "strMatchLyric" }, new Object[] { Long.valueOf(0L), "", "", "", "" }, LyricInfo.class);
  public final PBStringField strFormat = PBField.initString("");
  public final PBStringField strLyric = PBField.initString("");
  public final PBStringField strMatchLyric = PBField.initString("");
  public final PBStringField strSongMid = PBField.initString("");
  public final PBInt64Field uiSongId = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleSmartMatchMusic.LyricInfo
 * JD-Core Version:    0.7.0.1
 */