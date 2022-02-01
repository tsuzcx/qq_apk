package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudMeta$StFeedMusic
  extends MessageMicro<StFeedMusic>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field ID = PBField.initInt64(0L);
  public final PBStringField MID = PBField.initString("");
  public FeedCloudMeta.StImage cover = new FeedCloudMeta.StImage();
  public final PBInt32Field endPos = PBField.initInt32(0);
  public final PBStringField musicName = PBField.initString("");
  public final PBStringField playUrl = PBField.initString("");
  public final PBUInt32Field scene = PBField.initUInt32(0);
  public final PBStringField singerName = PBField.initString("");
  public final PBInt32Field startPos = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 64, 72 }, new String[] { "ID", "MID", "musicName", "scene", "cover", "playUrl", "singerName", "startPos", "endPos" }, new Object[] { Long.valueOf(0L), "", "", localInteger, null, "", "", localInteger, localInteger }, StFeedMusic.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StFeedMusic
 * JD-Core Version:    0.7.0.1
 */