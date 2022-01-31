package com.tencent.ttpic.util;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

public class VideoStorageProxy
{
  private static final String COLON = ":";
  private static final String DEV_MOUNT = "dev_mount";
  private static final String READ_COMMAND = "cat /etc/vold.fstab";
  private static final String TAG = VideoStorageProxy.class.getSimpleName();
  private static final String VOLD_FSTAB_FILE = "/etc/vold.fstab";
  
  public static ArrayList<String> getAvailableStorage(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    Object localObject;
    for (paramContext = getExternalStoragePathEx(paramContext); (paramContext == null) || (paramContext.size() == 0); paramContext = readEtcFstabFile())
    {
      localObject = null;
      return localObject;
    }
    Iterator localIterator = paramContext.iterator();
    for (;;)
    {
      localObject = paramContext;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = new File((String)localIterator.next());
      if ((localObject == null) || (!((File)localObject).exists())) {
        localIterator.remove();
      }
    }
  }
  
  private static ArrayList<String> getExternalStoragePathEx(Context paramContext)
  {
    paramContext = (StorageManager)paramContext.getSystemService("storage");
    Object localObject = paramContext.getClass();
    ArrayList localArrayList = new ArrayList(5);
    try
    {
      localObject = (String[])((Class)localObject).getMethod("getVolumePaths", (Class[])null).invoke(paramContext, (Object[])null);
      Log.d(TAG, "paths.size = " + localObject.length);
      int j = localObject.length;
      int i = 0;
      for (;;)
      {
        paramContext = localArrayList;
        if (i >= j) {
          break;
        }
        paramContext = localObject[i];
        Log.d(TAG, "path = " + paramContext);
        localArrayList.add(removePathColon(paramContext));
        i += 1;
      }
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e(TAG, "error, ", paramContext);
      paramContext = null;
    }
  }
  
  /* Error */
  private static ArrayList<String> readEtcFstabFile()
  {
    // Byte code:
    //   0: new 160	java/io/BufferedReader
    //   3: dup
    //   4: new 162	java/io/InputStreamReader
    //   7: dup
    //   8: invokestatic 168	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   11: ldc 14
    //   13: invokevirtual 172	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   16: invokevirtual 178	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   19: invokespecial 181	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   22: invokespecial 184	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   25: astore_2
    //   26: new 45	java/util/ArrayList
    //   29: dup
    //   30: iconst_5
    //   31: invokespecial 101	java/util/ArrayList:<init>	(I)V
    //   34: astore_1
    //   35: aload_2
    //   36: invokevirtual 187	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   39: astore_3
    //   40: aload_1
    //   41: astore_0
    //   42: aload_3
    //   43: ifnull +65 -> 108
    //   46: aload_3
    //   47: ldc 189
    //   49: invokevirtual 193	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   52: ifne -17 -> 35
    //   55: aload_3
    //   56: ldc 11
    //   58: invokevirtual 197	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   61: ifeq -26 -> 35
    //   64: aload_3
    //   65: ldc 199
    //   67: invokevirtual 203	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   70: astore_0
    //   71: aload_0
    //   72: ifnull -37 -> 35
    //   75: aload_0
    //   76: arraylength
    //   77: iconst_3
    //   78: if_icmplt -43 -> 35
    //   81: aload_1
    //   82: aload_0
    //   83: iconst_2
    //   84: aaload
    //   85: invokestatic 146	com/tencent/ttpic/util/VideoStorageProxy:removePathColon	(Ljava/lang/String;)Ljava/lang/String;
    //   88: invokevirtual 150	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   91: pop
    //   92: goto -57 -> 35
    //   95: astore_0
    //   96: getstatic 28	com/tencent/ttpic/util/VideoStorageProxy:TAG	Ljava/lang/String;
    //   99: ldc 205
    //   101: aload_0
    //   102: invokestatic 156	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   105: pop
    //   106: aconst_null
    //   107: astore_0
    //   108: aload_0
    //   109: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   41	42	0	localObject	Object
    //   95	7	0	localIOException	java.io.IOException
    //   107	2	0	localArrayList	ArrayList<String>
    //   34	48	1	localArrayList1	ArrayList
    //   25	11	2	localBufferedReader	java.io.BufferedReader
    //   39	26	3	str	String
    // Exception table:
    //   from	to	target	type
    //   0	35	95	java/io/IOException
    //   35	40	95	java/io/IOException
    //   46	71	95	java/io/IOException
    //   75	92	95	java/io/IOException
  }
  
  private static String removePathColon(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return paramString;
      i = paramString.indexOf(":");
    } while (i == -1);
    return paramString.substring(0, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoStorageProxy
 * JD-Core Version:    0.7.0.1
 */