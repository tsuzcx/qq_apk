package com.tencent.xaction.api.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.Log;
import com.tencent.xaction.log.QLog;
import com.tencent.xaction.openapi.api.IXAEngine;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/util/FileUtil$Companion;", "", "()V", "TAG", "", "deleteDir", "", "dir", "Ljava/io/File;", "getAbsFileInputStream", "Ljava/io/InputStream;", "resources", "Landroid/content/res/Resources;", "src", "engine", "Lcom/tencent/xaction/openapi/api/IXAEngine;", "getAbsFilePath", "context", "Landroid/content/Context;", "path", "root", "getAssertFilePath", "fileName", "getChildFiles", "Ljava/util/ArrayList;", "includeDir", "getRealFileName", "baseDir", "absFileName", "isAssertsFile", "filePath", "loadAssertFilePathList", "", "r", "(Ljava/lang/String;Landroid/content/res/Resources;)[Ljava/lang/String;", "loadFile", "fileWithPath", "loadFileInputStream", "loadFromAssetsFile", "fname", "loadPngs", "prefix", "(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "md5File", "file", "bytes", "", "readFile", "instream", "readZipFile", "zipfile", "filename", "replaceAsserts", "unZipFile", "zipFilePath", "isClear", "", "folderPath", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class FileUtil$Companion
{
  @JvmStatic
  @Nullable
  public final InputStream a(@NotNull Resources paramResources, @NotNull String paramString, @Nullable IXAEngine paramIXAEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramResources, "resources");
    Intrinsics.checkParameterIsNotNull(paramString, "src");
    Companion localCompanion = (Companion)this;
    if (localCompanion.b(paramString)) {
      return paramResources.getAssets().open(localCompanion.a(paramString));
    }
    paramResources = null;
    if (paramIXAEngine != null)
    {
      paramResources = FilePathUtil.a.a(paramString, "$PARENT_ROOT", paramIXAEngine);
      paramString = new StringBuilder();
      paramString.append("animFile path=");
      paramString.append(paramResources);
      QLog.b("XA_FilePathUtil", 2, paramString.toString(), null);
      return (InputStream)new FileInputStream(paramResources);
    }
    if (new File(paramString).exists()) {
      paramResources = (InputStream)new FileInputStream(paramString);
    }
    return paramResources;
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
    boolean bool = localCompanion.b(paramString1);
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
      ((Companion)localObject1).b(paramString, (String)localObject2);
    }
    else if (paramBoolean)
    {
      localObject1 = (Companion)this;
      ((Companion)localObject1).a(paramContext);
      paramContext.mkdirs();
      localObject2 = paramContext.getAbsolutePath();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "outFile.absolutePath");
      ((Companion)localObject1).b(paramString, (String)localObject2);
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
    //   1: ldc 251
    //   3: invokestatic 87	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: new 121	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   13: astore_2
    //   14: new 253	java/io/InputStreamReader
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 256	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   22: astore_3
    //   23: new 258	java/io/BufferedReader
    //   26: dup
    //   27: aload_3
    //   28: checkcast 260	java/io/Reader
    //   31: invokespecial 263	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   34: astore 4
    //   36: new 265	kotlin/jvm/internal/Ref$ObjectRef
    //   39: dup
    //   40: invokespecial 266	kotlin/jvm/internal/Ref$ObjectRef:<init>	()V
    //   43: astore 5
    //   45: aload 4
    //   47: invokevirtual 269	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   50: astore 6
    //   52: aload 5
    //   54: aload 6
    //   56: putfield 273	kotlin/jvm/internal/Ref$ObjectRef:element	Ljava/lang/Object;
    //   59: aload 6
    //   61: ifnull +27 -> 88
    //   64: aload_2
    //   65: aload 5
    //   67: getfield 273	kotlin/jvm/internal/Ref$ObjectRef:element	Ljava/lang/Object;
    //   70: checkcast 215	java/lang/String
    //   73: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_2
    //   78: ldc_w 275
    //   81: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: goto -40 -> 45
    //   88: aload_3
    //   89: invokevirtual 278	java/io/InputStreamReader:close	()V
    //   92: aload 4
    //   94: invokevirtual 279	java/io/BufferedReader:close	()V
    //   97: aload_1
    //   98: invokevirtual 280	java/io/InputStream:close	()V
    //   101: goto +36 -> 137
    //   104: astore_1
    //   105: new 121	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   112: astore_3
    //   113: aload_3
    //   114: ldc_w 282
    //   117: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload_3
    //   122: aload_1
    //   123: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: ldc 241
    //   129: aload_3
    //   130: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 288	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   136: pop
    //   137: aload_2
    //   138: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: areturn
    //   142: astore_2
    //   143: goto +77 -> 220
    //   146: astore_2
    //   147: new 121	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   154: astore_3
    //   155: aload_3
    //   156: ldc_w 290
    //   159: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload_3
    //   164: aload_2
    //   165: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: ldc 241
    //   171: aload_3
    //   172: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 288	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   178: pop
    //   179: aload_1
    //   180: invokevirtual 280	java/io/InputStream:close	()V
    //   183: aconst_null
    //   184: areturn
    //   185: astore_1
    //   186: new 121	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   193: astore_2
    //   194: aload_2
    //   195: ldc_w 282
    //   198: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload_2
    //   203: aload_1
    //   204: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: ldc 241
    //   210: aload_2
    //   211: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 288	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   217: pop
    //   218: aconst_null
    //   219: areturn
    //   220: aload_1
    //   221: invokevirtual 280	java/io/InputStream:close	()V
    //   224: goto +36 -> 260
    //   227: astore_1
    //   228: new 121	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   235: astore_3
    //   236: aload_3
    //   237: ldc_w 282
    //   240: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload_3
    //   245: aload_1
    //   246: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: ldc 241
    //   252: aload_3
    //   253: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 288	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   259: pop
    //   260: goto +5 -> 265
    //   263: aload_2
    //   264: athrow
    //   265: goto -2 -> 263
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	Companion
    //   0	268	1	paramInputStream	InputStream
    //   13	125	2	localStringBuilder1	StringBuilder
    //   142	1	2	localObject1	Object
    //   146	19	2	localIOException	java.io.IOException
    //   193	71	2	localStringBuilder2	StringBuilder
    //   22	231	3	localObject2	Object
    //   34	59	4	localBufferedReader	java.io.BufferedReader
    //   43	23	5	localObjectRef	kotlin.jvm.internal.Ref.ObjectRef
    //   50	10	6	str	String
    // Exception table:
    //   from	to	target	type
    //   97	101	104	java/io/IOException
    //   14	45	142	finally
    //   45	59	142	finally
    //   64	85	142	finally
    //   88	97	142	finally
    //   147	179	142	finally
    //   14	45	146	java/io/IOException
    //   45	59	146	java/io/IOException
    //   64	85	146	java/io/IOException
    //   88	97	146	java/io/IOException
    //   179	183	185	java/io/IOException
    //   220	224	227	java/io/IOException
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
  public final String b(@Nullable String paramString, @NotNull Resources paramResources)
  {
    Intrinsics.checkParameterIsNotNull(paramResources, "r");
    Object localObject = null;
    String str2 = (String)null;
    String str1 = str2;
    try
    {
      paramString = paramResources.getAssets().open(paramString);
      str1 = str2;
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      for (;;)
      {
        str1 = str2;
        int i = paramString.read();
        if (i == -1) {
          break;
        }
        str1 = str2;
        localByteArrayOutputStream.write(i);
      }
      str1 = str2;
      paramResources = localByteArrayOutputStream.toByteArray();
      str1 = str2;
      localByteArrayOutputStream.close();
      str1 = str2;
      paramString.close();
      paramString = str2;
      str1 = str2;
      if (Build.VERSION.SDK_INT >= 19)
      {
        str1 = str2;
        Intrinsics.checkExpressionValueIsNotNull(paramResources, "buff");
        str1 = str2;
        paramString = StandardCharsets.UTF_8;
        str1 = str2;
        Intrinsics.checkExpressionValueIsNotNull(paramString, "StandardCharsets.UTF_8");
        str1 = str2;
        paramString = new String(paramResources, paramString);
      }
      paramResources = localObject;
      if (paramString != null)
      {
        str1 = paramString;
        paramResources = (CharSequence)paramString;
        str1 = paramString;
        paramResources = new Regex("\\r\\n").replace(paramResources, "\n");
      }
      return paramResources;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return str1;
  }
  
  public final void b(@NotNull String paramString1, @NotNull String paramString2)
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
            if (!((Companion)localObject4).c(paramString2, str).exists())
            {
              str = ((ZipEntry)localObject3).getName();
              Intrinsics.checkExpressionValueIsNotNull(str, "ze.name");
              localObject4 = (OutputStream)new BufferedOutputStream((OutputStream)new FileOutputStream(((Companion)localObject4).c(paramString2, str)));
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
  public final boolean b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    return StringsKt.contains$default((CharSequence)paramString, (CharSequence)"/asserts/", false, 2, null);
  }
  
  @NotNull
  public final File c(@Nullable String paramString1, @NotNull String paramString2)
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
  
  @JvmStatic
  @Nullable
  public final String c(@Nullable String paramString, @NotNull Resources paramResources)
  {
    Intrinsics.checkParameterIsNotNull(paramResources, "r");
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
      Companion localCompanion = (Companion)this;
      if (localCompanion.b(paramString)) {
        return localCompanion.b(localCompanion.a(paramString), paramResources);
      }
      try
      {
        paramString = new File(paramString);
        if ((!paramString.isDirectory()) && (paramString.exists())) {
          try
          {
            paramString = new FileInputStream(paramString);
            return localCompanion.a((InputStream)paramString);
          }
          catch (FileNotFoundException paramString)
          {
            paramResources = new StringBuilder();
            paramResources.append("new FileInputStream error=");
            paramResources.append(paramString);
            Log.e("FileUtil", paramResources.toString());
            return null;
          }
        }
        paramResources = new StringBuilder();
        paramResources.append("file.isDirectory()=");
        paramResources.append(paramString.isDirectory());
        paramResources.append(", file.exists()=");
        paramResources.append(paramString.exists());
        Log.e("FileUtil", paramResources.toString());
        return null;
      }
      catch (NullPointerException paramString)
      {
        paramResources = new StringBuilder();
        paramResources.append("new File error=");
        paramResources.append(paramString);
        Log.e("FileUtil", paramResources.toString());
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.api.util.FileUtil.Companion
 * JD-Core Version:    0.7.0.1
 */