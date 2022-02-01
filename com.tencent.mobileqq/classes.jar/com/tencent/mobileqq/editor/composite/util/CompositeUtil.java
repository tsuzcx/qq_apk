package com.tencent.mobileqq.editor.composite.util;

import android.graphics.PointF;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.richmedia.capture.data.DynamicStickerData;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.VideoConverterLog;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.VideoConverter;
import com.tencent.video.decode.ShortVideoSoLoad;
import java.util.ArrayList;
import java.util.Arrays;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class CompositeUtil
{
  public static int a(int paramInt)
  {
    int j = paramInt % 16;
    int i = paramInt;
    if (j != 0)
    {
      if (j < 8) {
        return paramInt - j;
      }
      i = paramInt + (16 - j);
    }
    return i;
  }
  
  public static int a(String paramString1, String paramString2, PublishVideoEntry paramPublishVideoEntry)
  {
    if ((paramPublishVideoEntry != null) && (paramPublishVideoEntry.videoMaxrate > 0))
    {
      double d = paramPublishVideoEntry.recordTime / 1000.0D;
      int i = paramPublishVideoEntry.videoMaxrate;
      try
      {
        paramPublishVideoEntry = ShortVideoSoLoad.getShortVideoSoPath(MobileQQ.getContext());
        String str = VideoEnvironment.getShortVideoSoLibName();
        VideoConverter localVideoConverter = new VideoConverter(new VideoConverterLog());
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramPublishVideoEntry);
        ((StringBuilder)localObject).append("QQVideoTrimProcess");
        localObject = ((StringBuilder)localObject).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramPublishVideoEntry);
        localStringBuilder.append(str);
        localVideoConverter.setFFmpegBinAndSoPath((String)localObject, localStringBuilder.toString());
        i = new VideoConverter().executeFFmpegCmd(Arrays.asList(new String[] { "-threads", "1", "-ss", "0.0", "-accurate_seek", "-i", paramString1, "-t", String.valueOf(d), "-vf", "null", "-metadata:s", "rotate=0", "-acodec", "aac", "-vcodec", "libx264", "-movflags", "faststart", "-preset", "veryfast", "-tune", "psnr", "-profile:v", "high", "-level", "3.0", "-b:v", String.valueOf(i), "-y", paramString2 }));
        return i;
      }
      catch (Error paramString1)
      {
        if (QLog.isColorLevel())
        {
          QLog.i("CompositeUtil", 2, "TrimNative.trim: error", paramString1);
          return 0;
        }
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("CompositeUtil", 2, "TrimNative.trim: ", paramString1);
        }
      }
      return 0;
    }
    return -1;
  }
  
  public static long a(String paramString)
  {
    if (!FileUtils.fileExists(paramString)) {
      return 0L;
    }
    if (Build.VERSION.SDK_INT >= 10) {}
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = localMediaMetadataRetriever.extractMetadata(9);
      localMediaMetadataRetriever.release();
      long l = Long.valueOf(paramString).longValue();
      return l;
    }
    catch (Exception paramString) {}
    return 0L;
    return 0L;
  }
  
  public static ArrayList<DynamicStickerData> b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          localObject = new ArrayList();
          paramString = new JSONObject(paramString).optJSONArray("list");
          if (paramString != null)
          {
            i = 0;
            if (i < paramString.length())
            {
              JSONObject localJSONObject = paramString.getJSONObject(i);
              if (localJSONObject == null) {
                break label338;
              }
              DynamicStickerData localDynamicStickerData = new DynamicStickerData();
              localDynamicStickerData.centerP = new PointF((float)localJSONObject.optDouble("centerP_x"), (float)localJSONObject.optDouble("centerP_y"));
              localDynamicStickerData.scale = ((float)localJSONObject.optDouble("scale"));
              localDynamicStickerData.rotate = ((float)localJSONObject.optDouble("rotate"));
              localDynamicStickerData.translateX = ((float)localJSONObject.optDouble("translateX"));
              localDynamicStickerData.translateY = ((float)localJSONObject.optDouble("translateY"));
              localDynamicStickerData.width = ((float)localJSONObject.optDouble("width"));
              localDynamicStickerData.height = ((float)localJSONObject.optDouble("height"));
              localDynamicStickerData.layerWidth = localJSONObject.optInt("layerWidth");
              localDynamicStickerData.layerHeight = localJSONObject.optInt("layerHeight");
              localDynamicStickerData.path = localJSONObject.optString("path");
              localDynamicStickerData.type = localJSONObject.optInt("type", 0);
              localDynamicStickerData.data = localJSONObject.optString("data", "");
              localDynamicStickerData.mGifDecoder = InjectGifDecoder.a(localDynamicStickerData);
              ((ArrayList)localObject).add(localDynamicStickerData);
              break label338;
            }
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder();
              paramString.append("getDynamicStickersFromJson= ");
              paramString.append(localObject);
              QLog.d("CompositeUtil", 2, paramString.toString());
            }
            return localObject;
          }
        }
      }
      catch (Exception paramString)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("e= ");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("CompositeUtil", 2, ((StringBuilder)localObject).toString());
        }
      }
      return null;
      label338:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.util.CompositeUtil
 * JD-Core Version:    0.7.0.1
 */