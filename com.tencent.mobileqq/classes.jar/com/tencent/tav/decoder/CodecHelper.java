package com.tencent.tav.decoder;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.AudioCapabilities;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCodecList;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.util.Range;
import com.tencent.tav.coremedia.CGSize;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CodecHelper
{
  public static final int MAX_BIT_RATE = 8000000;
  private static final String TAG = CodecHelper.class.getSimpleName();
  
  @RequiresApi(api=21)
  public static boolean checkAudioOutSupported(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    Object localObject1 = encoderCodecInfo(paramString);
    if (((List)localObject1).size() > 0) {
      localObject1 = ((List)localObject1).iterator();
    }
    label143:
    label154:
    label158:
    for (;;)
    {
      boolean bool;
      int i;
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((MediaCodecInfo)((Iterator)localObject1).next()).getCapabilitiesForType(paramString).getAudioCapabilities();
        bool = ((MediaCodecInfo.AudioCapabilities)localObject2).getBitrateRange().contains(Integer.valueOf(paramInt1));
        if (((MediaCodecInfo.AudioCapabilities)localObject2).getMaxInputChannelCount() >= paramInt2)
        {
          i = 1;
          localObject2 = ((MediaCodecInfo.AudioCapabilities)localObject2).getSupportedSampleRateRanges();
          int k = localObject2.length;
          j = 0;
          label95:
          if (j >= k) {
            break label154;
          }
          if (!localObject2[j].contains(Integer.valueOf(paramInt3))) {
            break label143;
          }
        }
      }
      for (int j = 1;; j = 0)
      {
        if ((!bool) || (i == 0) || (j == 0)) {
          break label158;
        }
        return true;
        i = 0;
        break;
        j += 1;
        break label95;
        return false;
      }
    }
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
  
  public static CGSize correctSupportSize(CGSize paramCGSize, String paramString)
  {
    int n = (int)paramCGSize.width;
    int m = (int)paramCGSize.height;
    int i1 = MediaCodecList.getCodecCount();
    int i = 0;
    paramCGSize = null;
    if ((i < i1) && (paramCGSize == null))
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (!localMediaCodecInfo.isEncoder()) {}
      for (;;)
      {
        i += 1;
        break;
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int k = 0;
        j = 0;
        while ((j < arrayOfString.length) && (k == 0))
        {
          if (arrayOfString[j].equals(paramString)) {
            k = 1;
          }
          j += 1;
        }
        if (k != 0) {
          paramCGSize = localMediaCodecInfo;
        }
      }
    }
    int j = getWidthAlignment(paramCGSize, paramString);
    i = getHeightAlignment(paramCGSize, paramString);
    j = (int)(Math.ceil(n * 1.0F / j) * j);
    i = (int)(Math.ceil(m * 1.0F / i) * i);
    if (!isSupported(paramCGSize, paramString, j, i))
    {
      j = (int)(Math.ceil(n / 16.0F) * 16.0D);
      i = (int)(Math.ceil(m / 16.0F) * 16.0D);
    }
    for (;;)
    {
      return new CGSize(j, i);
    }
  }
  
  private static List<MediaCodecInfo> decoderCodecInfo(String paramString)
  {
    int k = MediaCodecList.getCodecCount();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.isEncoder()) {}
      label90:
      for (;;)
      {
        i += 1;
        break;
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int m = arrayOfString.length;
        int j = 0;
        for (;;)
        {
          if (j >= m) {
            break label90;
          }
          if (arrayOfString[j].equals(paramString))
          {
            localArrayList.add(localMediaCodecInfo);
            break;
          }
          j += 1;
        }
      }
    }
    return localArrayList;
  }
  
  private static List<MediaCodecInfo> encoderCodecInfo(String paramString)
  {
    int k = MediaCodecList.getCodecCount();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (!localMediaCodecInfo.isEncoder()) {}
      label90:
      for (;;)
      {
        i += 1;
        break;
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int m = arrayOfString.length;
        int j = 0;
        for (;;)
        {
          if (j >= m) {
            break label90;
          }
          if (arrayOfString[j].equals(paramString))
          {
            localArrayList.add(localMediaCodecInfo);
            break;
          }
          j += 1;
        }
      }
    }
    return localArrayList;
  }
  
  private static int getHeightAlignment(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    int j = 16;
    int i = j;
    if (Build.VERSION.SDK_INT >= 21)
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
    int j = 16;
    int i = j;
    if (Build.VERSION.SDK_INT >= 21)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.decoder.CodecHelper
 * JD-Core Version:    0.7.0.1
 */