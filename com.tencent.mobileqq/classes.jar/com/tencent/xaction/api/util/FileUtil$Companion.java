package com.tencent.xaction.api.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/util/FileUtil$Companion;", "", "()V", "TAG", "", "getChildFiles", "Ljava/util/ArrayList;", "dir", "includeDir", "", "loadFile", "fileWithPath", "loadPngs", "", "filePath", "prefix", "(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public final class FileUtil$Companion
{
  /* Error */
  @JvmStatic
  @Nullable
  public final String a(@Nullable String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +21 -> 22
    //   4: aload_1
    //   5: checkcast 48	java/lang/CharSequence
    //   8: invokeinterface 52 1 0
    //   13: ifne +11 -> 24
    //   16: iconst_1
    //   17: istore_2
    //   18: iload_2
    //   19: ifeq +10 -> 29
    //   22: aconst_null
    //   23: areturn
    //   24: iconst_0
    //   25: istore_2
    //   26: goto -8 -> 18
    //   29: new 54	java/io/File
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore_1
    //   38: aload_1
    //   39: invokevirtual 61	java/io/File:isDirectory	()Z
    //   42: ifne +10 -> 52
    //   45: aload_1
    //   46: invokevirtual 64	java/io/File:exists	()Z
    //   49: ifne +73 -> 122
    //   52: ldc 66
    //   54: new 68	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   61: ldc 71
    //   63: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: invokevirtual 61	java/io/File:isDirectory	()Z
    //   70: invokevirtual 78	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   73: ldc 80
    //   75: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_1
    //   79: invokevirtual 64	java/io/File:exists	()Z
    //   82: invokevirtual 78	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   85: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 90	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   91: pop
    //   92: aconst_null
    //   93: areturn
    //   94: astore_1
    //   95: ldc 66
    //   97: new 68	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   104: ldc 92
    //   106: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_1
    //   110: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 90	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   119: pop
    //   120: aconst_null
    //   121: areturn
    //   122: new 97	java/io/FileInputStream
    //   125: dup
    //   126: aload_1
    //   127: invokespecial 100	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   130: astore_1
    //   131: aload_1
    //   132: checkcast 102	java/io/InputStream
    //   135: astore_1
    //   136: new 68	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   143: astore_3
    //   144: new 104	java/io/BufferedReader
    //   147: dup
    //   148: new 106	java/io/InputStreamReader
    //   151: dup
    //   152: aload_1
    //   153: invokespecial 109	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   156: checkcast 111	java/io/Reader
    //   159: invokespecial 114	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   162: astore 4
    //   164: new 116	kotlin/jvm/internal/Ref$ObjectRef
    //   167: dup
    //   168: invokespecial 117	kotlin/jvm/internal/Ref$ObjectRef:<init>	()V
    //   171: astore 5
    //   173: aload 4
    //   175: invokevirtual 120	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   178: astore 6
    //   180: aload 5
    //   182: aload 6
    //   184: putfield 124	kotlin/jvm/internal/Ref$ObjectRef:element	Ljava/lang/Object;
    //   187: aload 6
    //   189: ifnull +84 -> 273
    //   192: aload_3
    //   193: aload 5
    //   195: getfield 124	kotlin/jvm/internal/Ref$ObjectRef:element	Ljava/lang/Object;
    //   198: checkcast 126	java/lang/String
    //   201: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: ldc 128
    //   206: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: goto -37 -> 173
    //   213: astore_3
    //   214: ldc 66
    //   216: new 68	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   223: ldc 130
    //   225: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_3
    //   229: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 90	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   238: pop
    //   239: aload_1
    //   240: invokevirtual 133	java/io/InputStream:close	()V
    //   243: aconst_null
    //   244: areturn
    //   245: astore_1
    //   246: ldc 66
    //   248: new 68	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   255: ldc 135
    //   257: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload_1
    //   261: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 90	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   270: pop
    //   271: aconst_null
    //   272: areturn
    //   273: aload_1
    //   274: invokevirtual 133	java/io/InputStream:close	()V
    //   277: aload_3
    //   278: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: areturn
    //   282: astore_1
    //   283: ldc 66
    //   285: new 68	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   292: ldc 137
    //   294: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload_1
    //   298: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 90	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   307: pop
    //   308: goto -31 -> 277
    //   311: astore_1
    //   312: ldc 66
    //   314: new 68	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   321: ldc 137
    //   323: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload_1
    //   327: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   330: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokestatic 90	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   336: pop
    //   337: goto -94 -> 243
    //   340: astore_3
    //   341: aload_1
    //   342: invokevirtual 133	java/io/InputStream:close	()V
    //   345: aload_3
    //   346: athrow
    //   347: astore_1
    //   348: ldc 66
    //   350: new 68	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   357: ldc 137
    //   359: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload_1
    //   363: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   366: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 90	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   372: pop
    //   373: goto -28 -> 345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	this	Companion
    //   0	376	1	paramString	String
    //   17	9	2	i	int
    //   143	50	3	localStringBuilder	StringBuilder
    //   213	65	3	localIOException	java.io.IOException
    //   340	6	3	localObject	Object
    //   162	12	4	localBufferedReader	java.io.BufferedReader
    //   171	23	5	localObjectRef	kotlin.jvm.internal.Ref.ObjectRef
    //   178	10	6	str	String
    // Exception table:
    //   from	to	target	type
    //   29	38	94	java/lang/NullPointerException
    //   144	173	213	java/io/IOException
    //   173	187	213	java/io/IOException
    //   192	210	213	java/io/IOException
    //   122	131	245	java/io/FileNotFoundException
    //   273	277	282	java/io/IOException
    //   239	243	311	java/io/IOException
    //   144	173	340	finally
    //   173	187	340	finally
    //   192	210	340	finally
    //   214	239	340	finally
    //   341	345	347	java/io/IOException
  }
  
  @JvmStatic
  @Nullable
  public final ArrayList<String> a(@Nullable String paramString, boolean paramBoolean)
  {
    Object localObject1 = new File(paramString);
    paramString = new ArrayList();
    localObject1 = ((File)localObject1).listFiles();
    for (;;)
    {
      int i;
      try
      {
        int j = localObject1.length;
        i = 0;
        if (i < j)
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
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return paramString;
      i += 1;
    }
  }
  
  @JvmStatic
  @Nullable
  public final String[] a(@Nullable String paramString1, @NotNull String paramString2)
  {
    String[] arrayOfString = null;
    Intrinsics.checkParameterIsNotNull(paramString2, "prefix");
    Object localObject2 = new File(paramString1);
    Object localObject1 = arrayOfString;
    if (((File)localObject2).exists())
    {
      if (((File)localObject2).isDirectory()) {
        break label46;
      }
      localObject1 = arrayOfString;
    }
    label46:
    do
    {
      do
      {
        return localObject1;
        localObject2 = ((Companion)this).a(paramString1, false);
        localObject1 = arrayOfString;
      } while (localObject2 == null);
      localObject1 = arrayOfString;
    } while (((ArrayList)localObject2).size() <= 0);
    arrayOfString = new String[((ArrayList)localObject2).size()];
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString1).append(File.separator).append(paramString2);
    paramString1 = ((StringBuilder)localObject1).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "pathBuilder.toString()");
    int j = ((ArrayList)localObject2).size();
    int i = 0;
    for (;;)
    {
      localObject1 = arrayOfString;
      if (i >= j) {
        break;
      }
      paramString2 = StringCompanionObject.INSTANCE;
      paramString2 = new Object[1];
      paramString2[0] = Integer.valueOf(i + 1);
      paramString2 = String.format(paramString1, Arrays.copyOf(paramString2, paramString2.length));
      Intrinsics.checkExpressionValueIsNotNull(paramString2, "java.lang.String.format(format, *args)");
      arrayOfString[i] = paramString2;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.util.FileUtil.Companion
 * JD-Core Version:    0.7.0.1
 */