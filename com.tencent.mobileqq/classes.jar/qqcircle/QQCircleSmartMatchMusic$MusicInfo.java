package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class QQCircleSmartMatchMusic$MusicInfo
  extends MessageMicro<MusicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "albumInfo", "singerInfo", "songInfo", "lyricInfo", "subtitleInfo", "foreignlyric", "confInfo" }, new Object[] { null, null, null, null, null, null, null }, MusicInfo.class);
  public QQCircleSmartMatchMusic.AlbumInfo albumInfo = new QQCircleSmartMatchMusic.AlbumInfo();
  public QQCircleSmartMatchMusic.ConfInfo confInfo = new QQCircleSmartMatchMusic.ConfInfo();
  public QQCircleSmartMatchMusic.LyricInfo foreignlyric = new QQCircleSmartMatchMusic.LyricInfo();
  public QQCircleSmartMatchMusic.LyricInfo lyricInfo = new QQCircleSmartMatchMusic.LyricInfo();
  public QQCircleSmartMatchMusic.SingerInfo singerInfo = new QQCircleSmartMatchMusic.SingerInfo();
  public QQCircleSmartMatchMusic.SongInfo songInfo = new QQCircleSmartMatchMusic.SongInfo();
  public QQCircleSmartMatchMusic.LyricInfo subtitleInfo = new QQCircleSmartMatchMusic.LyricInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleSmartMatchMusic.MusicInfo
 * JD-Core Version:    0.7.0.1
 */