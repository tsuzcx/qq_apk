package com.tencent.xweb;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.xweb.util.h;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class XWebCoreContentProvider
  extends ContentProvider
{
  public static Uri a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    String str = paramString2;
    if (paramString2.isEmpty()) {
      str = " ";
    }
    if (paramInt1 != 2)
    {
      paramString2 = new StringBuilder();
      paramString2.append("content://");
      paramString2.append(paramString1);
      paramString2.append(".sdk.xweb.XWebCoreProvider");
      paramString2.append("/");
      paramString2.append(str);
      paramString2.append("/");
      paramString2.append(paramInt1);
      return Uri.parse(paramString2.toString());
    }
    paramString2 = new StringBuilder();
    paramString2.append("content://");
    paramString2.append(paramString1);
    paramString2.append(".sdk.xweb.XWebCoreProvider");
    paramString2.append("/");
    paramString2.append(str);
    paramString2.append("/");
    paramString2.append(paramInt1);
    paramString2.append("/");
    paramString2.append(paramInt2);
    paramString2.append("/");
    paramString2.append(paramString3);
    return Uri.parse(paramString2.toString());
  }
  
  private static XWebCoreContentProvider.d a(Uri paramUri)
  {
    XWebCoreContentProvider.d locald = new XWebCoreContentProvider.d();
    locald.a = -1;
    Object localObject = paramUri.toString();
    if (((String)localObject).length() > 1000)
    {
      Log.d("XWebCoreContentProvider", "parseUri exceed max length");
      return locald;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("parseUri ");
    localStringBuilder.append((String)localObject);
    Log.d("XWebCoreContentProvider", localStringBuilder.toString());
    localObject = paramUri.getPathSegments();
    if ((localObject != null) && (((List)localObject).size() >= 2))
    {
      paramUri = (String)((List)localObject).get(0);
      if ((paramUri != null) && (!paramUri.isEmpty())) {
        locald.b = paramUri;
      }
    }
    try
    {
      j = Integer.parseInt((String)((List)localObject).get(1));
      if (j != 1) {
        if (j != 2)
        {
          if (j != 3)
          {
            Log.d("XWebCoreContentProvider", "parseUri invalid opType");
            return locald;
          }
        }
        else if (((List)localObject).size() == 4) {
          paramUri = (String)((List)localObject).get(3);
        }
      }
    }
    catch (Exception paramUri)
    {
      int j;
      int i;
      label210:
      break label388;
    }
    try
    {
      i = Integer.parseInt((String)((List)localObject).get(2));
    }
    catch (Exception localException)
    {
      break label210;
    }
    Log.d("XWebCoreContentProvider", "parseUri error parse targetVersion");
    break label223;
    paramUri = "";
    label223:
    i = -1;
    if ((i != -1) && (paramUri != null) && (!paramUri.isEmpty()))
    {
      locald.a = j;
      locald.c = i;
      locald.d = paramUri;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseUri result: ");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramUri);
      Log.d("XWebCoreContentProvider", ((StringBuilder)localObject).toString());
      return locald;
    }
    Log.d("XWebCoreContentProvider", "parseUri wrong params on get file");
    return locald;
    if (((List)localObject).size() == 2)
    {
      locald.a = j;
      paramUri = new StringBuilder();
      paramUri.append("parseUri result: ");
      paramUri.append(j);
      Log.d("XWebCoreContentProvider", paramUri.toString());
      return locald;
    }
    Log.d("XWebCoreContentProvider", "parseUri wrong params on test or report");
    return locald;
    label388:
    Log.d("XWebCoreContentProvider", "parseUri error parse opType");
    return locald;
    Log.d("XWebCoreContentProvider", "parseUri callerName invalid");
    return locald;
    Log.d("XWebCoreContentProvider", "parseUri strList invalid");
    return locald;
  }
  
  /* Error */
  private static Map<String, String> a(File paramFile)
  {
    // Byte code:
    //   0: new 120	java/util/HashMap
    //   3: dup
    //   4: invokespecial 121	java/util/HashMap:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore_1
    //   13: new 123	java/io/BufferedReader
    //   16: dup
    //   17: new 125	java/io/FileReader
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 128	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   25: invokespecial 131	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   28: astore_0
    //   29: aload_0
    //   30: invokevirtual 134	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore_1
    //   34: aload_1
    //   35: ifnull +105 -> 140
    //   38: aload_1
    //   39: invokevirtual 17	java/lang/String:isEmpty	()Z
    //   42: ifeq +6 -> 48
    //   45: goto -16 -> 29
    //   48: aload_1
    //   49: ldc 136
    //   51: invokevirtual 140	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   54: astore_1
    //   55: aload_1
    //   56: arraylength
    //   57: iconst_2
    //   58: if_icmpne -29 -> 29
    //   61: aload_1
    //   62: iconst_0
    //   63: aaload
    //   64: ifnull -35 -> 29
    //   67: aload_1
    //   68: iconst_0
    //   69: aaload
    //   70: invokevirtual 17	java/lang/String:isEmpty	()Z
    //   73: ifne -44 -> 29
    //   76: aload_1
    //   77: iconst_1
    //   78: aaload
    //   79: ifnull -50 -> 29
    //   82: aload_1
    //   83: iconst_1
    //   84: aaload
    //   85: invokevirtual 17	java/lang/String:isEmpty	()Z
    //   88: ifne -59 -> 29
    //   91: aload 4
    //   93: aload_1
    //   94: iconst_0
    //   95: aaload
    //   96: aload_1
    //   97: iconst_1
    //   98: aaload
    //   99: invokeinterface 146 3 0
    //   104: pop
    //   105: new 21	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   112: astore_2
    //   113: aload_2
    //   114: ldc 148
    //   116: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload_2
    //   121: aload_1
    //   122: iconst_0
    //   123: aaload
    //   124: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: ldc 61
    //   130: aload_2
    //   131: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 69	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: goto -108 -> 29
    //   140: aload_0
    //   141: invokestatic 153	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   144: aload 4
    //   146: areturn
    //   147: astore_1
    //   148: goto +66 -> 214
    //   151: astore_2
    //   152: goto +14 -> 166
    //   155: astore_2
    //   156: aload_1
    //   157: astore_0
    //   158: aload_2
    //   159: astore_1
    //   160: goto +54 -> 214
    //   163: astore_2
    //   164: aload_3
    //   165: astore_0
    //   166: aload_0
    //   167: astore_1
    //   168: new 21	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   175: astore_3
    //   176: aload_0
    //   177: astore_1
    //   178: aload_3
    //   179: ldc 155
    //   181: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload_0
    //   186: astore_1
    //   187: aload_3
    //   188: aload_2
    //   189: invokevirtual 158	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   192: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload_0
    //   197: astore_1
    //   198: ldc 61
    //   200: aload_3
    //   201: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 161	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: aload_0
    //   208: invokestatic 153	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   211: aload 4
    //   213: areturn
    //   214: aload_0
    //   215: invokestatic 153	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   218: goto +5 -> 223
    //   221: aload_1
    //   222: athrow
    //   223: goto -2 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	paramFile	File
    //   12	110	1	localObject1	Object
    //   147	10	1	localObject2	Object
    //   159	63	1	localObject3	Object
    //   112	19	2	localStringBuilder1	StringBuilder
    //   151	1	2	localException1	Exception
    //   155	4	2	localObject4	Object
    //   163	26	2	localException2	Exception
    //   10	191	3	localStringBuilder2	StringBuilder
    //   7	205	4	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   29	34	147	finally
    //   38	45	147	finally
    //   48	61	147	finally
    //   67	76	147	finally
    //   82	137	147	finally
    //   29	34	151	java/lang/Exception
    //   38	45	151	java/lang/Exception
    //   48	61	151	java/lang/Exception
    //   67	76	151	java/lang/Exception
    //   82	137	151	java/lang/Exception
    //   13	29	155	finally
    //   168	176	155	finally
    //   178	185	155	finally
    //   187	196	155	finally
    //   198	207	155	finally
    //   13	29	163	java/lang/Exception
  }
  
  public static void a() {}
  
  private static void a(Context paramContext, XWebCoreContentProvider.c paramc)
  {
    if (paramc == null) {
      return;
    }
    if (paramc.b.length() > 100) {
      str1 = paramc.b.substring(0, 99);
    } else {
      str1 = paramc.b;
    }
    Object localObject;
    if (paramc.c.b.length() > 100) {
      localObject = paramc.c.b.substring(0, 99);
    } else {
      localObject = paramc.c.b;
    }
    String str2;
    if (paramc.c.d.length() > 100) {
      str2 = paramc.c.d.substring(0, 99);
    } else {
      str2 = paramc.c.d;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramc.a);
    localStringBuilder.append(",");
    localStringBuilder.append(str1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramc.c.a);
    localStringBuilder.append(",");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(",");
    localStringBuilder.append(paramc.c.c);
    localStringBuilder.append(",");
    localStringBuilder.append(str2);
    String str1 = localStringBuilder.toString();
    if ((paramContext != null) && (!"com.tencent.mm".equals(paramc.b)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doReport need post to mm ");
      ((StringBuilder)localObject).append(str1);
      Log.d("XWebCoreContentProvider", ((StringBuilder)localObject).toString());
      paramContext = paramContext.getContentResolver();
      if (paramContext == null)
      {
        Log.e("XWebCoreContentProvider", "doReport content resolver is null");
        return;
      }
    }
    try
    {
      localObject = new ContentValues();
      ((ContentValues)localObject).put(String.valueOf(15625), str1);
      paramContext.insert(a("com.tencent.mm", paramc.b, 3, 0, ""), (ContentValues)localObject);
      return;
    }
    catch (Exception paramContext)
    {
      label333:
      break label333;
    }
    Log.d("XWebCoreContentProvider", "doReport error post to mm");
    return;
    if (h.N())
    {
      paramContext = new StringBuilder();
      paramContext.append("doReport ");
      paramContext.append(str1);
      Log.d("XWebCoreContentProvider", paramContext.toString());
      h.a(15625, str1);
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("doReport reporter not init, cache ");
    paramContext.append(str1);
    Log.d("XWebCoreContentProvider", paramContext.toString());
    paramContext = new XWebCoreContentProvider.b();
    paramContext.a = 15625;
    paramContext.b = str1;
    XWebCoreContentProvider.a.a(paramContext);
  }
  
  private static void a(Context paramContext, XWebCoreContentProvider.d paramd)
  {
    for (;;)
    {
      int i;
      try
      {
        paramContext = paramContext.getPackageManager().getPackagesForUid(Binder.getCallingUid());
        if (paramContext == null) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        i = 0;
        if (i < paramContext.length)
        {
          if (i != paramContext.length - 1)
          {
            localStringBuilder.append(paramContext[i]);
            localStringBuilder.append("+");
            break label123;
          }
          localStringBuilder.append(paramContext[i]);
          break label123;
        }
        paramContext = localStringBuilder.toString();
        if (!paramContext.isEmpty())
        {
          paramd.b = paramContext;
          return;
        }
      }
      catch (Exception paramContext)
      {
        paramd = new StringBuilder();
        paramd.append("tryRefillCallerName error ");
        paramd.append(paramContext.getMessage());
        Log.e("XWebCoreContentProvider", paramd.toString());
      }
      return;
      label123:
      i += 1;
    }
  }
  
  public int delete(@NonNull Uri paramUri, @Nullable String paramString, @Nullable String[] paramArrayOfString)
  {
    return 0;
  }
  
  @Nullable
  public String getType(@NonNull Uri paramUri)
  {
    return null;
  }
  
  @Nullable
  public Uri insert(@NonNull Uri paramUri, @Nullable ContentValues paramContentValues)
  {
    if ((paramContentValues != null) && (paramContentValues.size() != 0))
    {
      if (a(paramUri).a != 3)
      {
        Log.d("XWebCoreContentProvider", "insert wrong opType");
        return null;
      }
      paramUri = getContext();
      if (paramUri == null)
      {
        Log.e("XWebCoreContentProvider", "insert context is null");
        return null;
      }
      if (!"com.tencent.mm".equals(paramUri.getPackageName()))
      {
        Log.e("XWebCoreContentProvider", "insert current not mm, return");
        return null;
      }
      Log.d("XWebCoreContentProvider", "insert start report");
      paramUri = paramContentValues.valueSet().iterator();
      while (paramUri.hasNext())
      {
        paramContentValues = (Map.Entry)paramUri.next();
        try
        {
          int i = Integer.parseInt((String)paramContentValues.getKey());
          paramContentValues = (String)paramContentValues.getValue();
          if ((!h.a(i)) || (paramContentValues == null) || (paramContentValues.isEmpty())) {
            continue;
          }
          boolean bool = h.N();
          if (bool)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("insert report ");
            ((StringBuilder)localObject).append(i);
            ((StringBuilder)localObject).append(" ");
            ((StringBuilder)localObject).append(paramContentValues);
            Log.d("XWebCoreContentProvider", ((StringBuilder)localObject).toString());
            h.a(i, paramContentValues);
            continue;
          }
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("insert reporter not init, cache ");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(paramContentValues);
          Log.d("XWebCoreContentProvider", ((StringBuilder)localObject).toString());
          localObject = new XWebCoreContentProvider.b();
          ((XWebCoreContentProvider.b)localObject).a = i;
          ((XWebCoreContentProvider.b)localObject).b = paramContentValues;
          XWebCoreContentProvider.a.a((XWebCoreContentProvider.b)localObject);
        }
        catch (Exception paramContentValues)
        {
          label304:
          break label304;
        }
        Log.d("XWebCoreContentProvider", "insert parse error");
      }
      return null;
    }
    Log.d("XWebCoreContentProvider", "insert values is null or empty");
    return null;
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  @Nullable
  public ParcelFileDescriptor openFile(@NonNull Uri paramUri, @NonNull String paramString)
  {
    XWebCoreContentProvider.d locald = a(paramUri);
    XWebCoreContentProvider.c localc = new XWebCoreContentProvider.c();
    localc.a = -1;
    localc.c = locald;
    Context localContext = getContext();
    if (localContext == null)
    {
      Log.e("XWebCoreContentProvider", "openFile context is null");
      localc.a = -2;
      a(null, localc);
      return null;
    }
    a(localContext, locald);
    paramUri = localContext.getPackageName();
    localc.b = paramUri;
    paramString = new StringBuilder();
    paramString.append("openFile current package: ");
    paramString.append(paramUri);
    Log.d("XWebCoreContentProvider", paramString.toString());
    if (!XWalkEnvironment.isProvider(paramUri))
    {
      Log.e("XWebCoreContentProvider", "openFile current is not provider");
      localc.a = -3;
      a(localContext, localc);
      return null;
    }
    int i = locald.a;
    if (i != 1)
    {
      if (i != 2)
      {
        Log.d("XWebCoreContentProvider", "openFile invalid uri");
        localc.a = -1;
        a(localContext, localc);
        return null;
      }
      paramUri = new StringBuilder();
      paramUri.append("openFile request from ");
      paramUri.append(locald.b);
      Log.d("XWebCoreContentProvider", paramUri.toString());
      paramString = new File(XWalkEnvironment.getPatchFileListConfig(localContext, locald.c));
      paramUri = paramString;
      if (!paramString.exists())
      {
        paramString = new File(XWalkEnvironment.getDownloadZipFileListConfig(localContext, locald.c));
        paramUri = paramString;
        if (!paramString.exists())
        {
          paramUri = new StringBuilder();
          paramUri.append("openFile cannot find listConfigFile of ver ");
          paramUri.append(locald.c);
          Log.d("XWebCoreContentProvider", paramUri.toString());
          localc.a = -4;
          a(localContext, localc);
          return null;
        }
      }
      if (locald.d.equals("filelist.config"))
      {
        if (XWalkEnvironment.readAvailableVersionFromSP(localContext) == -1)
        {
          Log.d("XWebCoreContentProvider", "openFile can not get current version");
          localc.a = -8;
          a(localContext, localc);
          return null;
        }
        Log.d("XWebCoreContentProvider", "openFile return listConfigFile");
        localc.a = 1;
        a(localContext, localc);
        return ParcelFileDescriptor.open(paramUri, 268435456);
      }
      paramUri = a(paramUri);
      if ((paramUri != null) && (paramUri.size() != 0))
      {
        if (paramUri.containsKey(locald.d))
        {
          if (locald.d.equals("base.apk")) {
            paramUri = new File(XWalkEnvironment.getDownloadApkPath(localContext, locald.c));
          } else {
            paramUri = new File(XWalkEnvironment.getExtractedCoreFile(localContext, locald.c, locald.d));
          }
          if (paramUri.exists())
          {
            paramString = new StringBuilder();
            paramString.append("openFile return file ");
            paramString.append(locald.d);
            Log.d("XWebCoreContentProvider", paramString.toString());
            localc.a = 0;
            a(localContext, localc);
            return ParcelFileDescriptor.open(paramUri, 268435456);
          }
          paramUri = new StringBuilder();
          paramUri.append("openFile file not exist ");
          paramUri.append(locald.d);
          Log.d("XWebCoreContentProvider", paramUri.toString());
          localc.a = -6;
          a(localContext, localc);
          return null;
        }
        paramUri = new StringBuilder();
        paramUri.append("openFile caller attempt to get file ");
        paramUri.append(locald.d);
        Log.d("XWebCoreContentProvider", paramUri.toString());
        localc.a = -7;
        a(localContext, localc);
        return null;
      }
      Log.e("XWebCoreContentProvider", "openFile fileMap is null or empty");
      localc.a = -5;
      a(localContext, localc);
      return null;
    }
    paramUri = new StringBuilder();
    paramUri.append("openFile test msg from ");
    paramUri.append(locald.b);
    Log.d("XWebCoreContentProvider", paramUri.toString());
    localc.a = 2;
    a(localContext, localc);
    return null;
  }
  
  @Nullable
  public Cursor query(@NonNull Uri paramUri, @Nullable String[] paramArrayOfString1, @Nullable String paramString1, @Nullable String[] paramArrayOfString2, @Nullable String paramString2)
  {
    return null;
  }
  
  public int update(@NonNull Uri paramUri, @Nullable ContentValues paramContentValues, @Nullable String paramString, @Nullable String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.XWebCoreContentProvider
 * JD-Core Version:    0.7.0.1
 */