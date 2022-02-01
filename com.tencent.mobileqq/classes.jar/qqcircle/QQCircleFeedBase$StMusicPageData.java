package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeedMusic;

public final class QQCircleFeedBase$StMusicPageData
  extends MessageMicro<StMusicPageData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "music", "desc", "publishSchema" }, new Object[] { null, "", "" }, StMusicPageData.class);
  public final PBStringField desc = PBField.initString("");
  public FeedCloudMeta.StFeedMusic music = new FeedCloudMeta.StFeedMusic();
  public final PBStringField publishSchema = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StMusicPageData
 * JD-Core Version:    0.7.0.1
 */