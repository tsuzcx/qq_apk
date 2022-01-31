package dov.com.tencent.biz.qqstory.takevideo.localmedia.baoutils.media;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Log;

public class VideoUtils
{
  @TargetApi(16)
  public static int a(MediaExtractor paramMediaExtractor)
  {
    int j = paramMediaExtractor.getTrackCount();
    int i = 0;
    while (i < j)
    {
      MediaFormat localMediaFormat = paramMediaExtractor.getTrackFormat(i);
      String str = localMediaFormat.getString("mime");
      if (str.startsWith("video/"))
      {
        Log.d("VideoUtils", "Extractor selected track " + i + " (" + str + "): " + localMediaFormat);
        return i;
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.localmedia.baoutils.media.VideoUtils
 * JD-Core Version:    0.7.0.1
 */