package com.tencent.xaction.api.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;
import com.tencent.xaction.openapi.api.IXAEngine;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/util/FileUtil$Companion;", "", "()V", "TAG", "", "deleteDir", "", "dir", "Ljava/io/File;", "getAbsFilePath", "context", "Landroid/content/Context;", "path", "root", "engine", "Lcom/tencent/xaction/openapi/api/IXAEngine;", "getAssertFilePath", "fileName", "getChildFiles", "Ljava/util/ArrayList;", "includeDir", "getRealFileName", "baseDir", "absFileName", "isAssertsFile", "filePath", "loadAssertFilePathList", "", "r", "Landroid/content/res/Resources;", "(Ljava/lang/String;Landroid/content/res/Resources;)[Ljava/lang/String;", "loadFile", "fileWithPath", "loadFileInputStream", "Ljava/io/InputStream;", "loadFromAssetsFile", "fname", "loadPngs", "prefix", "(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "md5File", "file", "bytes", "", "readFile", "instream", "readZipFile", "zipfile", "filename", "replaceAsserts", "unZipFile", "zipFilePath", "isClear", "", "folderPath", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class FileUtil$Companion
{
  @NotNull
  public final File a(@Nullable String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString2, "absFileName");
    Object localObject1 = (CharSequence)paramString2;
    Object localObject3 = new Regex("/");
    int i = 0;
    localObject1 = ((Collection)((Regex)localObject3).split((CharSequence)localObject1, 0)).toArray(new String[0]);
    if (localObject1 != null)
    {
      localObject3 = (String[])localObject1;
      paramString1 = new File(paramString1);
      localObject1 = (String)null;
      if (localObject3.length > 1)
      {
        int j = localObject3.length;
        while (i < j - 1)
        {
          paramString2 = localObject3[i];
          try
          {
            localObject1 = Charset.forName("8859_1");
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "Charset.forName(charsetName)");
            if (paramString2 != null)
            {
              localObject1 = paramString2.getBytes((Charset)localObject1);
              Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.String).getBytes(charset)");
              Charset localCharset = Charset.forName("GB2312");
              Intrinsics.checkExpressionValueIsNotNull(localCharset, "Charset.forName(charsetName)");
              localObject1 = new String((byte[])localObject1, localCharset);
              paramString2 = (String)localObject1;
            }
            else
            {
              throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException1)
          {
            localUnsupportedEncodingException1.printStackTrace();
            paramString1 = new File(paramString1, paramString2);
            i += 1;
          }
        }
        if (!paramString1.exists()) {
          paramString1.mkdirs();
        }
        paramString2 = localObject3[(localObject3.length - 1)];
        try
        {
          Object localObject2 = Charset.forName("8859_1");
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "Charset.forName(charsetName)");
          if (paramString2 != null)
          {
            localObject2 = paramString2.getBytes((Charset)localObject2);
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "(this as java.lang.String).getBytes(charset)");
            localObject3 = Charset.forName("GB2312");
            Intrinsics.checkExpressionValueIsNotNull(localObject3, "Charset.forName(charsetName)");
            localObject2 = new String((byte[])localObject2, (Charset)localObject3);
            paramString2 = (String)localObject2;
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException2)
        {
          localUnsupportedEncodingException2.printStackTrace();
        }
        return new File(paramString1, paramString2);
      }
      return new File(paramString1, paramString2);
    }
    paramString1 = new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    for (;;)
    {
      throw paramString1;
    }
  }
  
  @Nullable
  public final String a(@NotNull Context paramContext, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "fileName");
    File localFile2 = paramContext.getCacheDir();
    Intrinsics.checkExpressionValueIsNotNull(localFile2, "context.cacheDir");
    if (!localFile2.exists()) {
      localFile2.mkdirs();
    }
    File localFile1 = new File(localFile2, paramString);
    localFile2 = new File(new File(localFile2, paramString).getParent());
    if (!localFile2.exists()) {
      localFile2.mkdirs();
    }
    if (!localFile1.exists())
    {
      if (!localFile1.createNewFile()) {
        return null;
      }
    }
    else if (localFile1.length() > 10) {
      return localFile1.getAbsolutePath();
    }
    if (AssetsUtils.a(paramContext.getAssets(), paramString, localFile1.getAbsolutePath())) {
      return localFile1.getAbsolutePath();
    }
    return null;
  }
  
  @Nullable
  public final String a(@NotNull Context paramContext, @NotNull String paramString1, @Nullable String paramString2, @NotNull IXAEngine paramIXAEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString1, "path");
    Intrinsics.checkParameterIsNotNull(paramIXAEngine, "engine");
    Companion localCompanion = (Companion)this;
    boolean bool = localCompanion.a(paramString1);
    if (bool) {
      paramString1 = localCompanion.a(paramString1);
    } else {
      paramString1 = FilePathUtil.a.a(paramString1, paramString2, paramIXAEngine);
    }
    paramString2 = paramString1;
    if (bool)
    {
      if (paramString1 == null) {
        Intrinsics.throwNpe();
      }
      paramContext = localCompanion.a(paramContext, paramString1);
      paramString2 = paramContext;
      if (paramContext == null) {
        return null;
      }
    }
    return paramString2;
  }
  
  @Nullable
  public final String a(@NotNull Context paramContext, @NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "zipFilePath");
    long l = System.currentTimeMillis();
    Object localObject1 = new File(paramString);
    if (!((File)localObject1).exists()) {
      return null;
    }
    paramContext = paramContext.getCacheDir();
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context.cacheDir");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(String.valueOf(((File)localObject1).lastModified()));
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(((File)localObject1).length());
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(((File)localObject1).getName());
    paramContext = new File(paramContext, ((StringBuilder)localObject2).toString());
    if (!paramContext.exists())
    {
      paramContext.mkdirs();
      localObject1 = (Companion)this;
      localObject2 = paramContext.getAbsolutePath();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "outFile.absolutePath");
      ((Companion)localObject1).a(paramString, (String)localObject2);
    }
    else if (paramBoolean)
    {
      localObject1 = (Companion)this;
      ((Companion)localObject1).a(paramContext);
      paramContext.mkdirs();
      localObject2 = paramContext.getAbsolutePath();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "outFile.absolutePath");
      ((Companion)localObject1).a(paramString, (String)localObject2);
    }
    paramString = new StringBuilder();
    paramString.append("FileUtil elapse:");
    paramString.append(System.currentTimeMillis() - l);
    paramString.append("   absolutePath:");
    paramString.append(paramContext.getAbsolutePath());
    Log.v("FileUtil", paramString.toString());
    return paramContext.getAbsolutePath();
  }
  
  /* Error */
  @JvmStatic
  @Nullable
  public final String a(@NotNull InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 272
    //   4: invokestatic 85	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   7: new 224	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   14: astore_2
    //   15: new 274	java/io/InputStreamReader
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 277	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   23: astore_3
    //   24: new 279	java/io/BufferedReader
    //   27: dup
    //   28: aload_3
    //   29: checkcast 281	java/io/Reader
    //   32: invokespecial 284	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   35: astore 4
    //   37: new 286	kotlin/jvm/internal/Ref$ObjectRef
    //   40: dup
    //   41: invokespecial 287	kotlin/jvm/internal/Ref$ObjectRef:<init>	()V
    //   44: astore 5
    //   46: aload 4
    //   48: invokevirtual 290	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: astore 6
    //   53: aload 5
    //   55: aload 6
    //   57: putfield 294	kotlin/jvm/internal/Ref$ObjectRef:element	Ljava/lang/Object;
    //   60: aload 6
    //   62: ifnull +27 -> 89
    //   65: aload_2
    //   66: aload 5
    //   68: getfield 294	kotlin/jvm/internal/Ref$ObjectRef:element	Ljava/lang/Object;
    //   71: checkcast 102	java/lang/String
    //   74: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_2
    //   79: ldc_w 296
    //   82: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: goto -40 -> 46
    //   89: aload_3
    //   90: invokevirtual 299	java/io/InputStreamReader:close	()V
    //   93: aload 4
    //   95: invokevirtual 300	java/io/BufferedReader:close	()V
    //   98: aload_1
    //   99: invokevirtual 303	java/io/InputStream:close	()V
    //   102: goto +37 -> 139
    //   105: astore_1
    //   106: new 224	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   113: astore_3
    //   114: aload_3
    //   115: ldc_w 305
    //   118: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload_3
    //   123: aload_1
    //   124: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: ldc_w 261
    //   131: aload_3
    //   132: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 311	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   138: pop
    //   139: aload_2
    //   140: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: areturn
    //   144: astore_2
    //   145: goto +79 -> 224
    //   148: astore_2
    //   149: new 224	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   156: astore_3
    //   157: aload_3
    //   158: ldc_w 313
    //   161: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_3
    //   166: aload_2
    //   167: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: ldc_w 261
    //   174: aload_3
    //   175: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 311	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   181: pop
    //   182: aload_1
    //   183: invokevirtual 303	java/io/InputStream:close	()V
    //   186: aconst_null
    //   187: areturn
    //   188: astore_1
    //   189: new 224	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   196: astore_2
    //   197: aload_2
    //   198: ldc_w 305
    //   201: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload_2
    //   206: aload_1
    //   207: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: ldc_w 261
    //   214: aload_2
    //   215: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 311	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   221: pop
    //   222: aconst_null
    //   223: areturn
    //   224: aload_1
    //   225: invokevirtual 303	java/io/InputStream:close	()V
    //   228: goto +37 -> 265
    //   231: astore_1
    //   232: new 224	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   239: astore_3
    //   240: aload_3
    //   241: ldc_w 305
    //   244: invokevirtual 236	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload_3
    //   249: aload_1
    //   250: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: ldc_w 261
    //   257: aload_3
    //   258: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 311	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   264: pop
    //   265: goto +5 -> 270
    //   268: aload_2
    //   269: athrow
    //   270: goto -2 -> 268
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	this	Companion
    //   0	273	1	paramInputStream	InputStream
    //   14	126	2	localStringBuilder1	StringBuilder
    //   144	1	2	localObject1	Object
    //   148	19	2	localIOException	java.io.IOException
    //   196	73	2	localStringBuilder2	StringBuilder
    //   23	235	3	localObject2	Object
    //   35	59	4	localBufferedReader	java.io.BufferedReader
    //   44	23	5	localObjectRef	kotlin.jvm.internal.Ref.ObjectRef
    //   51	10	6	str	String
    // Exception table:
    //   from	to	target	type
    //   98	102	105	java/io/IOException
    //   15	46	144	finally
    //   46	60	144	finally
    //   65	86	144	finally
    //   89	98	144	finally
    //   149	182	144	finally
    //   15	46	148	java/io/IOException
    //   46	60	148	java/io/IOException
    //   65	86	148	java/io/IOException
    //   89	98	148	java/io/IOException
    //   182	186	188	java/io/IOException
    //   224	228	231	java/io/IOException
  }
  
  @JvmStatic
  @NotNull
  public final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    return StringsKt.replace$default(paramString, "/asserts/", "", false, 4, null);
  }
  
  @JvmStatic
  @Nullable
  public final ArrayList<String> a(@Nullable String paramString, boolean paramBoolean)
  {
    Object localObject1 = new File(paramString);
    paramString = new ArrayList();
    localObject1 = ((File)localObject1).listFiles();
    int i = 0;
    try
    {
      int j = localObject1.length;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "childDirList[i]");
        if (((File)localObject2).isDirectory())
        {
          if (paramBoolean)
          {
            localObject2 = localObject1[i];
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "childDirList[i]");
            paramString.add(((File)localObject2).getCanonicalPath());
          }
          localObject2 = (Companion)this;
          Object localObject3 = localObject1[i];
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "childDirList[i]");
          localObject2 = ((Companion)localObject2).a(localObject3.getCanonicalPath(), paramBoolean);
          if (localObject2 == null) {
            Intrinsics.throwNpe();
          }
          paramString.addAll((Collection)localObject2);
        }
        else
        {
          localObject2 = localObject1[i];
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "childDirList[i]");
          paramString.add(((File)localObject2).getCanonicalPath());
        }
        i += 1;
      }
      return paramString;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "zipFilePath");
    Intrinsics.checkParameterIsNotNull(paramString2, "folderPath");
    Object localObject1 = new File(paramString2);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdir();
    }
    paramString1 = new ZipFile(paramString1);
    localObject1 = paramString1.entries();
    Object localObject2 = (ZipEntry)null;
    localObject2 = new byte[1024];
    while (((Enumeration)localObject1).hasMoreElements())
    {
      Object localObject3 = (ZipEntry)((Enumeration)localObject1).nextElement();
      if (localObject3 == null) {
        Intrinsics.throwNpe();
      }
      if (((ZipEntry)localObject3).getName() != null)
      {
        Object localObject4 = ((ZipEntry)localObject3).getName();
        Intrinsics.checkExpressionValueIsNotNull(localObject4, "ze.name");
        if (!StringsKt.contains$default((CharSequence)localObject4, (CharSequence)"../", false, 2, null)) {
          if (((ZipEntry)localObject3).isDirectory())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(paramString2);
            ((StringBuilder)localObject4).append(((ZipEntry)localObject3).getName());
            localObject3 = ((StringBuilder)localObject4).toString();
            localObject4 = Charset.forName("8859_1");
            Intrinsics.checkExpressionValueIsNotNull(localObject4, "Charset.forName(charsetName)");
            if (localObject3 != null)
            {
              localObject3 = ((String)localObject3).getBytes((Charset)localObject4);
              Intrinsics.checkExpressionValueIsNotNull(localObject3, "(this as java.lang.String).getBytes(charset)");
              localObject4 = Charset.forName("GB2312");
              Intrinsics.checkExpressionValueIsNotNull(localObject4, "Charset.forName(charsetName)");
              new File(new String((byte[])localObject3, (Charset)localObject4)).mkdir();
            }
            else
            {
              throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
          }
          else
          {
            localObject4 = (Companion)this;
            String str = ((ZipEntry)localObject3).getName();
            Intrinsics.checkExpressionValueIsNotNull(str, "ze.name");
            if (!((Companion)localObject4).a(paramString2, str).exists())
            {
              str = ((ZipEntry)localObject3).getName();
              Intrinsics.checkExpressionValueIsNotNull(str, "ze.name");
              localObject4 = (OutputStream)new BufferedOutputStream((OutputStream)new FileOutputStream(((Companion)localObject4).a(paramString2, str)));
              localObject3 = (InputStream)new BufferedInputStream(paramString1.getInputStream((ZipEntry)localObject3));
              for (;;)
              {
                int i = ((InputStream)localObject3).read((byte[])localObject2, 0, 1024);
                if (i == -1) {
                  break;
                }
                ((OutputStream)localObject4).write((byte[])localObject2, 0, i);
              }
              ((InputStream)localObject3).close();
              ((OutputStream)localObject4).close();
            }
          }
        }
      }
    }
    paramString1.close();
  }
  
  @JvmStatic
  public final boolean a(@NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "dir");
    if (paramFile.isDirectory())
    {
      String[] arrayOfString = paramFile.list();
      Intrinsics.checkExpressionValueIsNotNull(arrayOfString, "children");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (!((Companion)this).a(new File(paramFile, arrayOfString[i]))) {
          return false;
        }
        i += 1;
      }
    }
    return paramFile.delete();
  }
  
  @JvmStatic
  public final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    return StringsKt.contains$default((CharSequence)paramString, (CharSequence)"/asserts/", false, 2, null);
  }
  
  @JvmStatic
  @Nullable
  public final String[] a(@NotNull String paramString, @NotNull Resources paramResources)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    Intrinsics.checkParameterIsNotNull(paramResources, "r");
    paramResources = paramResources.getAssets().list(((Companion)this).a(paramString));
    if (paramResources != null)
    {
      int i = paramResources.length;
      int j = 0;
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i ^ 0x1) != 0)
      {
        String[] arrayOfString = new String[paramResources.length];
        int k = paramResources.length;
        i = 0;
        while (j < k)
        {
          String str = paramResources[j];
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append('/');
          localStringBuilder.append(str);
          arrayOfString[i] = localStringBuilder.toString();
          j += 1;
          i += 1;
        }
        return arrayOfString;
      }
    }
    return null;
  }
  
  @JvmStatic
  @Nullable
  public final String[] a(@Nullable String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString2, "prefix");
    Object localObject2 = new File(paramString1);
    boolean bool = ((File)localObject2).exists();
    String[] arrayOfString = null;
    Object localObject1 = arrayOfString;
    if (bool)
    {
      if (!((File)localObject2).isDirectory()) {
        return null;
      }
      localObject2 = ((Companion)this).a(paramString1, false);
      localObject1 = arrayOfString;
      if (localObject2 != null)
      {
        if (((ArrayList)localObject2).size() <= 0) {
          return null;
        }
        arrayOfString = new String[((ArrayList)localObject2).size()];
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append(paramString2);
        paramString1 = ((StringBuilder)localObject1).toString();
        Intrinsics.checkExpressionValueIsNotNull(paramString1, "pathBuilder.toString()");
        int k = ((ArrayList)localObject2).size();
        int j;
        for (int i = 0;; i = j)
        {
          localObject1 = arrayOfString;
          if (i >= k) {
            break;
          }
          paramString2 = StringCompanionObject.INSTANCE;
          paramString2 = new Object[1];
          j = i + 1;
          paramString2[0] = Integer.valueOf(j);
          paramString2 = String.format(paramString1, Arrays.copyOf(paramString2, paramString2.length));
          Intrinsics.checkExpressionValueIsNotNull(paramString2, "java.lang.String.format(format, *args)");
          arrayOfString[i] = paramString2;
        }
      }
    }
    return localObject1;
  }
  
  @JvmStatic
  @Nullable
  public final String b(@Nullable String paramString)
  {
    if (paramString != null)
    {
      int i;
      if (((CharSequence)paramString).length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return null;
      }
      try
      {
        paramString = new File(paramString);
        if ((!paramString.isDirectory()) && (paramString.exists())) {
          try
          {
            paramString = new FileInputStream(paramString);
            paramString = (InputStream)paramString;
            return ((Companion)this).a(paramString);
          }
          catch (FileNotFoundException paramString)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("new FileInputStream error=");
            localStringBuilder.append(paramString);
            Log.e("FileUtil", localStringBuilder.toString());
            return null;
          }
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("file.isDirectory()=");
        localStringBuilder.append(paramString.isDirectory());
        localStringBuilder.append(", file.exists()=");
        localStringBuilder.append(paramString.exists());
        Log.e("FileUtil", localStringBuilder.toString());
        return null;
      }
      catch (NullPointerException paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("new File error=");
        localStringBuilder.append(paramString);
        Log.e("FileUtil", localStringBuilder.toString());
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.api.util.FileUtil.Companion
 * JD-Core Version:    0.7.0.1
 */