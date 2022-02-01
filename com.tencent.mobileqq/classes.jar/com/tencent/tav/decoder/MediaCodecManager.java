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
  private static HashMap<String, List<MediaCodec>> codecListMap = new HashMap();
  private static HashMap<MediaCodec, String> stackMap = new HashMap();
  
  @NotNull
  public static MediaCodec createDecoderByType(String paramString)
  {
    MediaCodec localMediaCodec = MediaCodec.createDecoderByType(paramString);
    putInMap("decode-" + paramString, localMediaCodec);
    logCodecMapInfo("createDecoderByType:", false);
    return localMediaCodec;
  }
  
  @NotNull
  public static MediaCodec createEncoderByType(String paramString)
  {
    MediaCodec localMediaCodec = MediaCodec.createEncoderByType(paramString);
    putInMap("encode-" + paramString, localMediaCodec);
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
  
  private static void logCodecMapInfo(String paramString, boolean paramBoolean)
  {
    Logger.i("MediaCodecManager", "logCodecMapInfo() called with: call from = [" + paramString + "]");
    paramString = codecListMap.keySet().iterator();
    while (paramString.hasNext())
    {
      String str = (String)paramString.next();
      List localList = (List)codecListMap.get(str);
      if (localList != null)
      {
        Logger.i("MediaCodecManager", str + ":" + localList.size() + ", values = " + localList);
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
      Logger.i("MediaCodecManager", "logCodecMapInfo: stack = " + str);
    }
  }
  
  private static void printStack(boolean paramBoolean, List<MediaCodec> paramList)
  {
    if (!paramBoolean) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MediaCodec localMediaCodec = (MediaCodec)paramList.next();
        Logger.i("MediaCodecManager", "stack = " + (String)stackMap.get(localMediaCodec));
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.decoder.MediaCodecManager
 * JD-Core Version:    0.7.0.1
 */