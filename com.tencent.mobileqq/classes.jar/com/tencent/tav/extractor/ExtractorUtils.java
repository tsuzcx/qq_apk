package com.tencent.tav.extractor;

import android.graphics.Matrix;
import android.media.MediaFormat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.DecoderAssetTrack;
import java.util.ArrayList;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ExtractorUtils
{
  public static final String MIME_AUDIO = "audio/";
  public static final String MIME_VIDEO = "video/";
  
  public static void applyMirror(Matrix paramMatrix, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramMatrix == null) {
      return;
    }
    Matrix localMatrix = new Matrix();
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 == 3)
        {
          localMatrix.postScale(-1.0F, -1.0F);
          localMatrix.postTranslate(paramInt2, paramInt3);
        }
      }
      else
      {
        localMatrix.postScale(1.0F, -1.0F);
        localMatrix.postTranslate(0.0F, paramInt3);
      }
    }
    else
    {
      localMatrix.postScale(-1.0F, 1.0F);
      localMatrix.postTranslate(paramInt2, 0.0F);
    }
    paramMatrix.postConcat(localMatrix);
  }
  
  public static long getAudioDuration(AssetExtractor paramAssetExtractor)
  {
    return getAudioDuration(getMediaFormats(paramAssetExtractor));
  }
  
  public static long getAudioDuration(ArrayList<MediaFormat> paramArrayList)
  {
    try
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        MediaFormat localMediaFormat = (MediaFormat)paramArrayList.next();
        if ((localMediaFormat.getString("mime").startsWith("audio/")) && (localMediaFormat.containsKey("durationUs")))
        {
          long l = localMediaFormat.getLong("durationUs");
          return l;
        }
      }
    }
    catch (Exception|Error paramArrayList)
    {
      label56:
      break label56;
    }
    return 0L;
  }
  
  public static long getDuration(AssetExtractor paramAssetExtractor)
  {
    return getDuration(getMediaFormats(paramAssetExtractor));
  }
  
  public static long getDuration(String paramString)
  {
    try
    {
      AssetExtractor localAssetExtractor = new AssetExtractor();
      localAssetExtractor.setDataSource(paramString);
      long l = getDuration(localAssetExtractor);
      try
      {
        localAssetExtractor.release();
        return l;
      }
      catch (Error paramString)
      {
        paramString.printStackTrace();
        return l;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return l;
      }
    }
    catch (Exception|Error paramString)
    {
      label38:
      break label38;
    }
    return 0L;
  }
  
  public static long getDuration(ArrayList<MediaFormat> paramArrayList)
  {
    try
    {
      paramArrayList = paramArrayList.iterator();
      long l2 = 0L;
      long l1 = l2;
      while (paramArrayList.hasNext())
      {
        MediaFormat localMediaFormat = (MediaFormat)paramArrayList.next();
        String str = localMediaFormat.getString("mime");
        boolean bool = str.startsWith("video/");
        if (bool)
        {
          if (localMediaFormat.containsKey("durationUs")) {
            l2 = localMediaFormat.getLong("durationUs");
          }
        }
        else if ((str.startsWith("audio/")) && (localMediaFormat.containsKey("durationUs"))) {
          l1 = localMediaFormat.getLong("durationUs");
        }
      }
      if (l2 > 0L) {
        return l2;
      }
      return l1;
    }
    catch (Exception|Error paramArrayList) {}
    return 0L;
  }
  
  public static MediaFormat getFirstFormat(AssetExtractor paramAssetExtractor, String paramString)
  {
    return getFirstFormat(getMediaFormats(paramAssetExtractor), paramString);
  }
  
  @Nullable
  public static MediaFormat getFirstFormat(ArrayList<MediaFormat> paramArrayList, String paramString)
  {
    try
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        MediaFormat localMediaFormat = (MediaFormat)paramArrayList.next();
        boolean bool = localMediaFormat.getString("mime").startsWith(paramString);
        if (bool) {
          return localMediaFormat;
        }
      }
    }
    catch (Exception|Error paramArrayList)
    {
      label41:
      break label41;
    }
    return null;
  }
  
  public static int getFirstTrackIndex(AssetExtractor paramAssetExtractor, String paramString)
  {
    return getFirstTrackIndex(getMediaFormats(paramAssetExtractor), paramString);
  }
  
  public static int getFirstTrackIndex(ArrayList<MediaFormat> paramArrayList, String paramString)
  {
    int i = 0;
    try
    {
      while (i < paramArrayList.size())
      {
        boolean bool = ((MediaFormat)paramArrayList.get(i)).getString("mime").startsWith(paramString);
        if (bool) {
          return i;
        }
        i += 1;
      }
    }
    catch (Exception|Error paramArrayList)
    {
      label41:
      break label41;
    }
    return -1;
  }
  
  public static int getFrameRate(MediaFormat paramMediaFormat)
  {
    if (paramMediaFormat != null) {}
    try
    {
      if (paramMediaFormat.containsKey("frame-rate"))
      {
        int i = paramMediaFormat.getInteger("frame-rate");
        return i;
      }
    }
    catch (Exception|Error paramMediaFormat)
    {
      label22:
      break label22;
    }
    return 0;
  }
  
  @NotNull
  public static ArrayList<MediaFormat> getMediaFormats(AssetExtractor paramAssetExtractor)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      int j = paramAssetExtractor.getTrackCount();
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramAssetExtractor.getTrackFormat(i));
        i += 1;
      }
      return localArrayList;
    }
    catch (Throwable paramAssetExtractor) {}
    return localArrayList;
  }
  
  public static int getPreferRotation(AssetExtractor paramAssetExtractor)
  {
    return getPreferRotation(getMediaFormats(paramAssetExtractor));
  }
  
  public static int getPreferRotation(ArrayList<MediaFormat> paramArrayList)
  {
    try
    {
      paramArrayList = getFirstFormat(paramArrayList, "video/");
      if ((paramArrayList != null) && (paramArrayList.containsKey("rotation-degrees")))
      {
        int i = paramArrayList.getInteger("rotation-degrees") / 90;
        return i;
      }
    }
    catch (Exception|Error paramArrayList)
    {
      label32:
      break label32;
    }
    return 0;
  }
  
  public static CGSize getVideoSize(AssetExtractor paramAssetExtractor)
  {
    return getVideoSize(getMediaFormats(paramAssetExtractor));
  }
  
  @NotNull
  public static CGSize getVideoSize(ArrayList<MediaFormat> paramArrayList)
  {
    try
    {
      paramArrayList = getFirstFormat(paramArrayList, "video/");
      CGSize localCGSize = new CGSize();
      if (paramArrayList != null)
      {
        if (paramArrayList.containsKey("display-width")) {
          localCGSize.width = paramArrayList.getInteger("display-width");
        } else {
          localCGSize.width = paramArrayList.getInteger("width");
        }
        if (paramArrayList.containsKey("display-height"))
        {
          localCGSize.height = paramArrayList.getInteger("display-height");
          return localCGSize;
        }
        localCGSize.height = paramArrayList.getInteger("height");
      }
      return localCGSize;
    }
    catch (Exception|Error paramArrayList)
    {
      label88:
      break label88;
    }
    return new CGSize();
  }
  
  public static boolean isSameExtractor(DecoderAssetTrack paramDecoderAssetTrack1, DecoderAssetTrack paramDecoderAssetTrack2)
  {
    int i;
    if ((paramDecoderAssetTrack1 != null) && (paramDecoderAssetTrack2 != null)) {
      i = 1;
    } else {
      i = 0;
    }
    return (i != 0) && (paramDecoderAssetTrack1.assetPath != null) && (paramDecoderAssetTrack1.assetPath.equals(paramDecoderAssetTrack2.assetPath));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.extractor.ExtractorUtils
 * JD-Core Version:    0.7.0.1
 */