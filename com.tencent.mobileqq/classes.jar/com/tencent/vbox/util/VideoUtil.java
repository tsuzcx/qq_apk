package com.tencent.vbox.util;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class VideoUtil
{
  private static final String TAG = VideoUtil.class.getSimpleName();
  
  public static List<Long> getFramestamps(String paramString)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    MediaExtractor localMediaExtractor = new MediaExtractor();
    for (;;)
    {
      try
      {
        localMediaExtractor.setDataSource(paramString);
        if (i < localMediaExtractor.getTrackCount())
        {
          if (localMediaExtractor.getTrackFormat(i).getString("mime").startsWith("video/")) {
            localMediaExtractor.selectTrack(i);
          }
        }
        else
        {
          paramString = ByteBuffer.allocate(921600);
          if (localMediaExtractor.readSampleData(paramString, 0) < 0) {
            return localArrayList;
          }
          localArrayList.add(Long.valueOf(localMediaExtractor.getSampleTime() / 1000L));
          localMediaExtractor.advance();
          continue;
        }
        i += 1;
      }
      catch (Exception paramString)
      {
        Log.e(TAG, "get frame stamps exception");
        return null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.vbox.util.VideoUtil
 * JD-Core Version:    0.7.0.1
 */