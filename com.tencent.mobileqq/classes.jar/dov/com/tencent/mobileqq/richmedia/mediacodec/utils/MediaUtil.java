package dov.com.tencent.mobileqq.richmedia.mediacodec.utils;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import aowj;
import aowk;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.tencent.biz.qqstory.takevideo.localmedia.demos.MediaCodecThumbnailGenerator;

public class MediaUtil
{
  private static String a = "MediaUtil";
  
  @TargetApi(10)
  public static long a(String paramString)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    localMediaMetadataRetriever.setDataSource(paramString);
    paramString = localMediaMetadataRetriever.extractMetadata(9);
    localMediaMetadataRetriever.release();
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  @TargetApi(10)
  public static Bitmap a(String paramString, int paramInt)
  {
    if (!FileUtils.e(paramString))
    {
      SLog.e(a, "File note exist when getFrameAtTime(). videoPath = " + paramString + " millisecond = " + paramInt);
      return null;
    }
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    localMediaMetadataRetriever.setDataSource(paramString);
    paramString = localMediaMetadataRetriever.getFrameAtTime(paramInt * 1000, 0);
    localMediaMetadataRetriever.release();
    return paramString;
  }
  
  public static MediaUtil.FrameWithoutBlackResult a(String paramString, int paramInt)
  {
    Object localObject = new Object();
    MediaUtil.FrameWithoutBlackResult localFrameWithoutBlackResult = new MediaUtil.FrameWithoutBlackResult();
    MediaCodecThumbnailGenerator localMediaCodecThumbnailGenerator = new MediaCodecThumbnailGenerator();
    localMediaCodecThumbnailGenerator.a(ThreadManager.getSubThreadLooper());
    localMediaCodecThumbnailGenerator.a(paramString, null, false, 480, paramInt, 10000, 1, true, new aowj(localObject), new aowk(localFrameWithoutBlackResult));
    try
    {
      localObject.wait(5000L);
      return localFrameWithoutBlackResult;
    }
    catch (InterruptedException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil
 * JD-Core Version:    0.7.0.1
 */