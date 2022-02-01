package com.tencent.tav.extractor;

import android.graphics.Matrix;
import android.media.MediaFormat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.DecoderAssetTrack;
import com.tencent.tav.decoder.DecoderUtils;

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
  
  public static int getPreferRotation(AssetExtractor paramAssetExtractor)
  {
    try
    {
      paramAssetExtractor = DecoderUtils.getFirstFormat(paramAssetExtractor, "video/");
      if ((paramAssetExtractor != null) && (paramAssetExtractor.containsKey("rotation-degrees")))
      {
        int i = paramAssetExtractor.getInteger("rotation-degrees") / 90;
        return i;
      }
    }
    catch (Exception|Error paramAssetExtractor)
    {
      label32:
      break label32;
    }
    return 0;
  }
  
  public static CGSize getVideoSize(AssetExtractor paramAssetExtractor)
  {
    try
    {
      paramAssetExtractor = DecoderUtils.getFirstFormat(paramAssetExtractor, "video/");
      CGSize localCGSize = new CGSize();
      if (paramAssetExtractor != null)
      {
        if (paramAssetExtractor.containsKey("display-width")) {
          localCGSize.width = paramAssetExtractor.getInteger("display-width");
        } else {
          localCGSize.width = paramAssetExtractor.getInteger("width");
        }
        if (paramAssetExtractor.containsKey("display-height"))
        {
          localCGSize.height = paramAssetExtractor.getInteger("display-height");
          return localCGSize;
        }
        localCGSize.height = paramAssetExtractor.getInteger("height");
      }
      return localCGSize;
    }
    catch (Exception|Error paramAssetExtractor)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.extractor.ExtractorUtils
 * JD-Core Version:    0.7.0.1
 */