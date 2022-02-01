package com.tencent.tav.decoder;

import android.media.MediaCodec;
import android.util.Log;
import com.tencent.tav.decoder.logger.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public class MediaCodecManager
{
  public static final boolean PRINT_STACK = false;
  private static final String TAG = "MediaCodecManager";
  private static final HashMap<String, List<MediaCodec>> codecListMap = new HashMap();
  private static final HashMap<MediaCodec, String> stackMap = new HashMap();
  
  @NotNull
  public static MediaCodec createDecoderByType(String paramString)
  {
    MediaCodec localMediaCodec = MediaCodec.createDecoderByType(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("decode-");
    localStringBuilder.append(paramString);
    putInMap(localStringBuilder.toString(), localMediaCodec);
    logCodecMapInfo("createDecoderByType:", false);
    return localMediaCodec;
  }
  
  @NotNull
  public static MediaCodec createEncoderByType(String paramString)
  {
    MediaCodec localMediaCodec = MediaCodec.createEncoderByType(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("encode-");
    localStringBuilder.append(paramString);
    putInMap(localStringBuilder.toString(), localMediaCodec);
    logCodecMapInfo("createEncoderByType:", false);
    return localMediaCodec;
  }
  
  @NotNull
  private static List<MediaCodec> geMimeCodecs(String paramString)
  {
    List localList = (List)codecListMap.get(paramString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      codecListMap.put(paramString, localObject);
    }
    return localObject;
  }
  
  public static String getCodecCountInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = codecListMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      List localList = (List)codecListMap.get(str);
      if (localList != null)
      {
        localStringBuilder.append(str);
        localStringBuilder.append("-");
        localStringBuilder.append(localList.size());
        localStringBuilder.append(";");
      }
    }
    return localStringBuilder.toString();
  }
  
  private static void logCodecMapInfo(String paramString, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("logCodecMapInfo() called with: call from = [");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("]");
    Logger.i("MediaCodecManager", ((StringBuilder)localObject).toString());
    paramString = codecListMap.keySet().iterator();
    while (paramString.hasNext())
    {
      localObject = (String)paramString.next();
      List localList = (List)codecListMap.get(localObject);
      if (localList != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(":");
        localStringBuilder.append(localList.size());
        localStringBuilder.append(", values = ");
        localStringBuilder.append(localList);
        Logger.i("MediaCodecManager", localStringBuilder.toString());
        printStack(paramBoolean, localList);
      }
    }
  }
  
  public static void printStack()
  {
    Iterator localIterator = stackMap.values().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("logCodecMapInfo: stack = ");
      localStringBuilder.append(str);
      Logger.i("MediaCodecManager", localStringBuilder.toString());
    }
  }
  
  private static void printStack(boolean paramBoolean, List<MediaCodec> paramList)
  {
    if (!paramBoolean) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MediaCodec localMediaCodec = (MediaCodec)paramList.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stack = ");
      localStringBuilder.append((String)stackMap.get(localMediaCodec));
      Logger.i("MediaCodecManager", localStringBuilder.toString());
    }
  }
  
  private static void putInMap(String paramString, MediaCodec paramMediaCodec)
  {
    stackMap.put(paramMediaCodec, Log.getStackTraceString(new RuntimeException()));
    geMimeCodecs(paramString).add(paramMediaCodec);
  }
  
  public static void releaseCodec(MediaCodec paramMediaCodec)
  {
    if (paramMediaCodec == null) {
      return;
    }
    paramMediaCodec.release();
    Iterator localIterator = codecListMap.values().iterator();
    while (localIterator.hasNext()) {
      ((List)localIterator.next()).remove(paramMediaCodec);
    }
    stackMap.remove(paramMediaCodec);
    logCodecMapInfo("releaseCodec:", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.decoder.MediaCodecManager
 * JD-Core Version:    0.7.0.1
 */