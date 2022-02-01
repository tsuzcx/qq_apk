package com.tencent.tav.decoder;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.AudioCapabilities;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.util.Range;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CodecHelper
{
  public static final int MAX_BIT_RATE = 8000000;
  private static final String TAG = "CodecHelper";
  
  private static int ceilTo(float paramFloat1, float paramFloat2)
  {
    double d1 = Math.floor(paramFloat1 / paramFloat2);
    double d2 = paramFloat2;
    Double.isNaN(d2);
    return (int)(d1 * d2);
  }
  
  @RequiresApi(api=21)
  public static boolean checkAudioOutSupported(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Object localObject1 = encoderCodecInfo(paramString);
    if (((List)localObject1).size() > 0)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((MediaCodecInfo)((Iterator)localObject1).next()).getCapabilitiesForType(paramString).getAudioCapabilities();
        boolean bool = ((MediaCodecInfo.AudioCapabilities)localObject2).getBitrateRange().contains(Integer.valueOf(paramInt1));
        int i;
        if (((MediaCodecInfo.AudioCapabilities)localObject2).getMaxInputChannelCount() >= paramInt2) {
          i = 1;
        } else {
          i = 0;
        }
        localObject2 = ((MediaCodecInfo.AudioCapabilities)localObject2).getSupportedSampleRateRanges();
        int k = localObject2.length;
        int j = 0;
        while (j < k)
        {
          if (localObject2[j].contains(Integer.valueOf(paramInt3)))
          {
            j = 1;
            break label141;
          }
          j += 1;
        }
        j = 0;
        label141:
        if ((bool) && (i != 0) && (j != 0)) {
          return true;
        }
      }
    }
    return false;
  }
  
  @RequiresApi(api=21)
  public static boolean checkVideoOutSupported(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    Object localObject = encoderCodecInfo(paramString);
    if (((List)localObject).size() > 0)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MediaCodecInfo.VideoCapabilities localVideoCapabilities = ((MediaCodecInfo)((Iterator)localObject).next()).getCapabilitiesForType(paramString).getVideoCapabilities();
        boolean bool1 = localVideoCapabilities.getBitrateRange().contains(Integer.valueOf(paramInt4));
        boolean bool2 = localVideoCapabilities.getSupportedFrameRates().contains(Integer.valueOf(paramInt3));
        boolean bool3 = localVideoCapabilities.isSizeSupported(paramInt1, paramInt2);
        if ((bool1) && (bool2) && (bool3)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static int clampHeight(MediaCodecInfo paramMediaCodecInfo, String paramString, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramMediaCodecInfo == null) {
        return paramInt;
      }
      return ((Integer)paramMediaCodecInfo.getCapabilitiesForType(paramString).getVideoCapabilities().getSupportedHeights().clamp(Integer.valueOf(paramInt))).intValue();
    }
    return paramInt;
  }
  
  public static int clampWidth(MediaCodecInfo paramMediaCodecInfo, String paramString, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (paramMediaCodecInfo == null) {
        return paramInt;
      }
      return ((Integer)paramMediaCodecInfo.getCapabilitiesForType(paramString).getVideoCapabilities().getSupportedWidths().clamp(Integer.valueOf(paramInt))).intValue();
    }
    return paramInt;
  }
  
  public static CGSize correctSupportSize(CGSize paramCGSize, String paramString)
  {
    return correctSupportSize(paramCGSize, paramString, true);
  }
  
  public static CGSize correctSupportSize(CGSize paramCGSize, String paramString, boolean paramBoolean)
  {
    int n = (int)paramCGSize.width;
    int m = (int)paramCGSize.height;
    int i1 = MediaCodecList.getCodecCount();
    paramCGSize = null;
    int i = 0;
    while ((i < i1) && (paramCGSize == null))
    {
      localObject1 = MediaCodecList.getCodecInfoAt(i);
      if (((MediaCodecInfo)localObject1).isEncoder())
      {
        localObject2 = ((MediaCodecInfo)localObject1).getSupportedTypes();
        j = 0;
        k = 0;
        while ((j < localObject2.length) && (k == 0))
        {
          if (localObject2[j].equals(paramString)) {
            k = 1;
          }
          j += 1;
        }
        if (k != 0) {
          paramCGSize = (CGSize)localObject1;
        }
      }
      i += 1;
    }
    i = getWidthAlignment(paramCGSize, paramString);
    int j = getHeightAlignment(paramCGSize, paramString);
    float f1 = n;
    float f2 = i;
    i = ceilTo(f1 * 1.0F, f2);
    float f3 = m;
    float f4 = j;
    j = ceilTo(f3 * 1.0F, f4);
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("correctSupportSize 1: target = [");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append(j);
    ((StringBuilder)localObject2).append("]");
    Logger.d((String)localObject1, ((StringBuilder)localObject2).toString());
    int k = clampWidth(paramCGSize, paramString, n);
    float f5;
    if (i > k)
    {
      f5 = k * 1.0F / i;
      j = (int)(j * f5);
      i = k;
    }
    localObject1 = TAG;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("correctSupportSize 2: target = [");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append(j);
    ((StringBuilder)localObject2).append("]");
    Logger.d((String)localObject1, ((StringBuilder)localObject2).toString());
    k = clampHeight(paramCGSize, paramString, m);
    if (j > k)
    {
      f5 = k * 1.0F / j;
      i = (int)(i * f5);
      j = k;
    }
    k = ceilTo(i * 1.0F, f2);
    m = ceilTo(j * 1.0F, f4);
    localObject1 = TAG;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("correctSupportSize 3: target = [");
    ((StringBuilder)localObject2).append(k);
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append(m);
    ((StringBuilder)localObject2).append("]");
    Logger.d((String)localObject1, ((StringBuilder)localObject2).toString());
    j = k;
    i = m;
    if (!isSupported(paramCGSize, paramString, k, m))
    {
      j = k;
      i = m;
      if (paramBoolean)
      {
        j = ceilTo(f1, 16.0F);
        i = ceilTo(f3, 16.0F);
      }
    }
    paramCGSize = TAG;
    paramString = new StringBuilder();
    paramString.append("correctSupportSize return: target = [");
    paramString.append(j);
    paramString.append(", ");
    paramString.append(i);
    paramString.append("]");
    Logger.i(paramCGSize, paramString.toString());
    return new CGSize(j, i);
  }
  
  private static List<MediaCodecInfo> decoderCodecInfo(String paramString)
  {
    int k = MediaCodecList.getCodecCount();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (!localMediaCodecInfo.isEncoder())
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int m = arrayOfString.length;
        int j = 0;
        while (j < m)
        {
          if (arrayOfString[j].equals(paramString))
          {
            localArrayList.add(localMediaCodecInfo);
            break;
          }
          j += 1;
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private static List<MediaCodecInfo> encoderCodecInfo(String paramString)
  {
    int k = MediaCodecList.getCodecCount();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.isEncoder())
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int m = arrayOfString.length;
        int j = 0;
        while (j < m)
        {
          if (arrayOfString[j].equals(paramString))
          {
            localArrayList.add(localMediaCodecInfo);
            break;
          }
          j += 1;
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private static int getHeightAlignment(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    int k = Build.VERSION.SDK_INT;
    int j = 16;
    int i = j;
    if (k >= 21)
    {
      i = j;
      if (paramMediaCodecInfo != null) {
        i = paramMediaCodecInfo.getCapabilitiesForType(paramString).getVideoCapabilities().getHeightAlignment();
      }
    }
    return i;
  }
  
  private static int getWidthAlignment(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    int k = Build.VERSION.SDK_INT;
    int j = 16;
    int i = j;
    if (k >= 21)
    {
      i = j;
      if (paramMediaCodecInfo != null) {
        i = paramMediaCodecInfo.getCapabilitiesForType(paramString).getVideoCapabilities().getWidthAlignment();
      }
    }
    return i;
  }
  
  private static boolean isSupported(MediaCodecInfo paramMediaCodecInfo, String paramString, int paramInt1, int paramInt2)
  {
    return (Build.VERSION.SDK_INT >= 21) && (paramMediaCodecInfo != null) && (paramMediaCodecInfo.getCapabilitiesForType(paramString).getVideoCapabilities().isSizeSupported(paramInt1, paramInt2));
  }
  
  public static MediaCodecInfo selectCodec(String paramString)
  {
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.isEncoder())
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int j = 0;
        while (j < arrayOfString.length)
        {
          if (arrayOfString[j].equalsIgnoreCase(paramString)) {
            return localMediaCodecInfo;
          }
          j += 1;
        }
      }
      i += 1;
    }
    return null;
  }
  
  public static void selectProfileAndLevel(MediaFormat paramMediaFormat, String paramString)
  {
    Object localObject = selectCodec(paramString);
    if (localObject != null)
    {
      paramString = ((MediaCodecInfo)localObject).getCapabilitiesForType(paramString);
      localObject = paramString.profileLevels;
      int i = -1;
      if (localObject != null)
      {
        int m = 0;
        for (int j = -1;; j = k)
        {
          n = i;
          k = j;
          if (m >= paramString.profileLevels.length) {
            break;
          }
          n = i;
          k = j;
          if (paramString.profileLevels[m].profile <= 8) {
            if (paramString.profileLevels[m].profile > i)
            {
              n = paramString.profileLevels[m].profile;
              k = paramString.profileLevels[m].level;
            }
            else
            {
              n = i;
              k = j;
              if (paramString.profileLevels[m].profile == i)
              {
                n = i;
                k = j;
                if (paramString.profileLevels[m].level > j)
                {
                  k = paramString.profileLevels[m].level;
                  n = i;
                }
              }
            }
          }
          m += 1;
          i = n;
        }
      }
      int k = -1;
      int n = i;
      if (n == 8)
      {
        paramMediaFormat.setInteger("profile", n);
        paramMediaFormat.setInteger("level", k);
        Logger.i(TAG, String.format("selectProfileAndLevel: 0x%x, 0x%x", new Object[] { Integer.valueOf(n), Integer.valueOf(k) }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.CodecHelper
 * JD-Core Version:    0.7.0.1
 */