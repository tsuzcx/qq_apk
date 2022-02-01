package com.tencent.timi.game.utils;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class SoundPoolUtils
{
  private static String a = "SoundPoolUtils";
  private static HashMap<String, SoundPoolUtils.SoundCache> b = new HashMap();
  private static HashMap<String, SoundPoolUtils.SoundCache> c = new HashMap();
  private static HashMap<String, SoundPoolUtils.SoundCache> d = new HashMap();
  private static HashMap<Integer, String> e = new HashMap();
  private static HashMap<Integer, String> f = new HashMap();
  private static SoundPool.OnLoadCompleteListener g;
  private static SoundPool.OnLoadCompleteListener h;
  private static SoundPool.OnLoadCompleteListener i;
  private static SoundPool j;
  private static SoundPool k;
  private static SoundPool l;
  private static boolean m = true;
  private static boolean n = true;
  private static ArrayList<SoundPoolUtils.SoundPlayTask> o = new ArrayList();
  private static boolean p = false;
  private static boolean q = false;
  private static int r;
  private static int s;
  private static int t;
  private static Runnable u = new SoundPoolUtils.4();
  
  private static int a(SoundPool paramSoundPool, Context paramContext, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    if (paramString.startsWith("local:"))
    {
      paramContext = paramString.substring(6);
      if (FileUtils.fileExists(paramContext)) {
        return paramSoundPool.load(paramContext, paramInt);
      }
      return -1;
    }
    if (paramString.startsWith("res:"))
    {
      paramString = paramString.substring(4);
      try
      {
        paramString = Integer.valueOf(Integer.parseInt(paramString));
        if (paramString.intValue() > 0)
        {
          paramInt = paramSoundPool.load(paramContext, paramString.intValue(), paramInt);
          return paramInt;
        }
      }
      catch (Exception paramSoundPool)
      {
        paramSoundPool.printStackTrace();
      }
    }
    return -1;
  }
  
  /* Error */
  public static long a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: aload_1
    //   8: invokestatic 136	com/tencent/timi/game/utils/SoundPoolUtils:b	(Landroid/content/Context;Ljava/lang/String;)Landroid/media/MediaPlayer;
    //   11: astore_0
    //   12: aload_0
    //   13: ifnull +27 -> 40
    //   16: aload_0
    //   17: astore 6
    //   19: aload_0
    //   20: astore 5
    //   22: aload_0
    //   23: invokevirtual 141	android/media/MediaPlayer:getDuration	()I
    //   26: istore_2
    //   27: iload_2
    //   28: i2l
    //   29: lstore_3
    //   30: aload_0
    //   31: ifnull +7 -> 38
    //   34: aload_0
    //   35: invokevirtual 144	android/media/MediaPlayer:release	()V
    //   38: lload_3
    //   39: lreturn
    //   40: aload_0
    //   41: astore 6
    //   43: aload_0
    //   44: astore 5
    //   46: getstatic 146	com/tencent/timi/game/utils/SoundPoolUtils:a	Ljava/lang/String;
    //   49: astore 7
    //   51: aload_0
    //   52: astore 6
    //   54: aload_0
    //   55: astore 5
    //   57: new 148	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   64: astore 8
    //   66: aload_0
    //   67: astore 6
    //   69: aload_0
    //   70: astore 5
    //   72: aload 8
    //   74: ldc 151
    //   76: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_0
    //   81: astore 6
    //   83: aload_0
    //   84: astore 5
    //   86: aload 8
    //   88: aload_1
    //   89: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_0
    //   94: astore 6
    //   96: aload_0
    //   97: astore 5
    //   99: aload 7
    //   101: aload 8
    //   103: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 164	com/tencent/timi/game/utils/Logger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload_0
    //   110: ifnull +38 -> 148
    //   113: goto +31 -> 144
    //   116: astore_0
    //   117: goto +33 -> 150
    //   120: astore_0
    //   121: aload 5
    //   123: astore 6
    //   125: getstatic 146	com/tencent/timi/game/utils/SoundPoolUtils:a	Ljava/lang/String;
    //   128: aload_0
    //   129: invokevirtual 165	java/lang/Exception:toString	()Ljava/lang/String;
    //   132: aload_0
    //   133: invokestatic 168	com/tencent/timi/game/utils/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   136: aload 5
    //   138: ifnull +10 -> 148
    //   141: aload 5
    //   143: astore_0
    //   144: aload_0
    //   145: invokevirtual 144	android/media/MediaPlayer:release	()V
    //   148: lconst_0
    //   149: lreturn
    //   150: aload 6
    //   152: ifnull +8 -> 160
    //   155: aload 6
    //   157: invokevirtual 144	android/media/MediaPlayer:release	()V
    //   160: aload_0
    //   161: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramContext	Context
    //   0	162	1	paramString	String
    //   26	2	2	i1	int
    //   29	10	3	l1	long
    //   1	141	5	localContext1	Context
    //   4	152	6	localContext2	Context
    //   49	51	7	str	String
    //   64	38	8	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	12	116	finally
    //   22	27	116	finally
    //   46	51	116	finally
    //   57	66	116	finally
    //   72	80	116	finally
    //   86	93	116	finally
    //   99	109	116	finally
    //   125	136	116	finally
    //   6	12	120	java/lang/Exception
    //   22	27	120	java/lang/Exception
    //   46	51	120	java/lang/Exception
    //   57	66	120	java/lang/Exception
    //   72	80	120	java/lang/Exception
    //   86	93	120	java/lang/Exception
    //   99	109	120	java/lang/Exception
  }
  
  public static MediaPlayer b(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (paramString.startsWith("local:"))
    {
      paramString = paramString.substring(6);
      try
      {
        if (FileUtils.fileExists(paramString))
        {
          paramContext = MediaPlayer.create(paramContext, Uri.fromFile(new File(paramString)));
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      return null;
    }
    if (paramString.startsWith("res:"))
    {
      paramString = paramString.substring(4);
      try
      {
        paramString = Integer.valueOf(Integer.parseInt(paramString));
        if (paramString.intValue() > 0)
        {
          paramContext = MediaPlayer.create(paramContext, paramString.intValue());
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  private static SoundPoolUtils.SoundCache b(HashMap<String, SoundPoolUtils.SoundCache> paramHashMap, String paramString)
  {
    if (!paramHashMap.containsKey(paramString))
    {
      SoundPoolUtils.SoundCache localSoundCache = new SoundPoolUtils.SoundCache(null);
      paramHashMap.put(paramString, localSoundCache);
      return localSoundCache;
    }
    return (SoundPoolUtils.SoundCache)paramHashMap.get(paramString);
  }
  
  private static void b(Context paramContext)
  {
    if ((!p) && (!q))
    {
      if (o.size() == 0) {
        return;
      }
      p = true;
      if ((b.containsKey(((SoundPoolUtils.SoundPlayTask)o.get(0)).a)) && (g != null))
      {
        paramContext = (SoundPoolUtils.SoundCache)b.get(((SoundPoolUtils.SoundPlayTask)o.get(0)).a);
        g.onLoadComplete(l, paramContext.a, 0);
        return;
      }
      a(l, paramContext, ((SoundPoolUtils.SoundPlayTask)o.get(0)).a, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.SoundPoolUtils
 * JD-Core Version:    0.7.0.1
 */