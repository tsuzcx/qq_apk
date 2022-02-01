package kotlin.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"extension", "", "Ljava/io/File;", "getExtension", "(Ljava/io/File;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath", "nameWithoutExtension", "getNameWithoutExtension", "createTempDir", "prefix", "suffix", "directory", "createTempFile", "copyRecursively", "", "target", "overwrite", "onError", "Lkotlin/Function2;", "Ljava/io/IOException;", "Lkotlin/io/OnErrorAction;", "copyTo", "bufferSize", "", "deleteRecursively", "endsWith", "other", "normalize", "", "normalize$FilesKt__UtilsKt", "Lkotlin/io/FilePathComponents;", "relativeTo", "base", "relativeToOrNull", "relativeToOrSelf", "resolve", "relative", "resolveSibling", "startsWith", "toRelativeString", "toRelativeStringOrNull", "toRelativeStringOrNull$FilesKt__UtilsKt", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/io/FilesKt")
public class FilesKt__UtilsKt
  extends FilesKt__FileTreeWalkKt
{
  public static final boolean copyRecursively(@NotNull File paramFile1, @NotNull File paramFile2, boolean paramBoolean, @NotNull Function2<? super File, ? super IOException, ? extends OnErrorAction> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile1, "$this$copyRecursively");
    Intrinsics.checkParameterIsNotNull(paramFile2, "target");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "onError");
    if (!paramFile1.exists())
    {
      if ((OnErrorAction)paramFunction2.invoke(paramFile1, new NoSuchFileException(paramFile1, null, "The source file doesn't exist.", 2, null)) != OnErrorAction.TERMINATE) {}
      for (paramBoolean = true;; paramBoolean = false) {
        return paramBoolean;
      }
    }
    try
    {
      Iterator localIterator = FilesKt.walkTopDown(paramFile1).onFail((Function2)new FilesKt__UtilsKt.copyRecursively.2(paramFunction2)).iterator();
      Object localObject1;
      Object localObject2;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject1 = (File)localIterator.next();
          if (!((File)localObject1).exists())
          {
            if ((OnErrorAction)paramFunction2.invoke(localObject1, new NoSuchFileException((File)localObject1, null, "The source file doesn't exist.", 2, null)) == OnErrorAction.TERMINATE) {
              return false;
            }
          }
          else
          {
            localObject2 = new File(paramFile2, FilesKt.toRelativeString((File)localObject1, paramFile1));
            if (((File)localObject2).exists())
            {
              if (!((File)localObject1).isDirectory()) {
                break label343;
              }
              if (!((File)localObject2).isDirectory()) {
                break label343;
              }
            }
          }
        }
      }
      for (;;)
      {
        label192:
        if (i != 0)
        {
          if ((OnErrorAction)paramFunction2.invoke(localObject2, new FileAlreadyExistsException((File)localObject1, (File)localObject2, "The destination file already exists.")) != OnErrorAction.TERMINATE) {
            break;
          }
          return false;
        }
        label343:
        do
        {
          if (((File)localObject2).isDirectory())
          {
            if (FilesKt.deleteRecursively((File)localObject2)) {
              break label353;
            }
            i = 1;
            break label192;
          }
          if (((File)localObject2).delete()) {
            break label359;
          }
          i = 1;
          break label192;
          if (((File)localObject1).isDirectory())
          {
            ((File)localObject2).mkdirs();
            break;
          }
          if (FilesKt.copyTo$default((File)localObject1, (File)localObject2, paramBoolean, 0, 4, null).length() == ((File)localObject1).length()) {
            break;
          }
          localObject1 = (OnErrorAction)paramFunction2.invoke(localObject1, new IOException("Source file wasn't copied completely, length of destination file differs."));
          localObject2 = OnErrorAction.TERMINATE;
          if (localObject1 != localObject2) {
            break;
          }
          return false;
          return true;
        } while (paramBoolean);
        int i = 1;
        continue;
        label353:
        i = 0;
        continue;
        label359:
        i = 0;
      }
      return false;
    }
    catch (TerminateException paramFile1) {}
  }
  
  /* Error */
  @NotNull
  public static final File copyTo(@NotNull File paramFile1, @NotNull File paramFile2, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 190
    //   3: invokestatic 77	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: ldc 78
    //   9: invokestatic 77	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokevirtual 85	java/io/File:exists	()Z
    //   16: ifne +20 -> 36
    //   19: new 87	kotlin/io/NoSuchFileException
    //   22: dup
    //   23: aload_0
    //   24: aconst_null
    //   25: ldc 89
    //   27: iconst_2
    //   28: aconst_null
    //   29: invokespecial 92	kotlin/io/NoSuchFileException:<init>	(Ljava/io/File;Ljava/io/File;Ljava/lang/String;ILkotlin/jvm/internal/DefaultConstructorMarker;)V
    //   32: checkcast 188	java/lang/Throwable
    //   35: athrow
    //   36: aload_1
    //   37: invokevirtual 85	java/io/File:exists	()Z
    //   40: ifeq +44 -> 84
    //   43: iload_2
    //   44: ifne +18 -> 62
    //   47: new 143	kotlin/io/FileAlreadyExistsException
    //   50: dup
    //   51: aload_0
    //   52: aload_1
    //   53: ldc 145
    //   55: invokespecial 148	kotlin/io/FileAlreadyExistsException:<init>	(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V
    //   58: checkcast 188	java/lang/Throwable
    //   61: athrow
    //   62: aload_1
    //   63: invokevirtual 154	java/io/File:delete	()Z
    //   66: ifne +18 -> 84
    //   69: new 143	kotlin/io/FileAlreadyExistsException
    //   72: dup
    //   73: aload_0
    //   74: aload_1
    //   75: ldc 192
    //   77: invokespecial 148	kotlin/io/FileAlreadyExistsException:<init>	(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V
    //   80: checkcast 188	java/lang/Throwable
    //   83: athrow
    //   84: aload_0
    //   85: invokevirtual 141	java/io/File:isDirectory	()Z
    //   88: ifeq +25 -> 113
    //   91: aload_1
    //   92: invokevirtual 157	java/io/File:mkdirs	()Z
    //   95: ifne +114 -> 209
    //   98: new 194	kotlin/io/FileSystemException
    //   101: dup
    //   102: aload_0
    //   103: aload_1
    //   104: ldc 196
    //   106: invokespecial 197	kotlin/io/FileSystemException:<init>	(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V
    //   109: checkcast 188	java/lang/Throwable
    //   112: athrow
    //   113: aload_1
    //   114: invokevirtual 201	java/io/File:getParentFile	()Ljava/io/File;
    //   117: astore 4
    //   119: aload 4
    //   121: ifnull +9 -> 130
    //   124: aload 4
    //   126: invokevirtual 157	java/io/File:mkdirs	()Z
    //   129: pop
    //   130: new 203	java/io/FileInputStream
    //   133: dup
    //   134: aload_0
    //   135: invokespecial 206	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   138: checkcast 208	java/io/Closeable
    //   141: astore 5
    //   143: aconst_null
    //   144: checkcast 188	java/lang/Throwable
    //   147: astore 4
    //   149: aload 5
    //   151: checkcast 203	java/io/FileInputStream
    //   154: astore 7
    //   156: new 210	java/io/FileOutputStream
    //   159: dup
    //   160: aload_1
    //   161: invokespecial 211	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   164: checkcast 208	java/io/Closeable
    //   167: astore 6
    //   169: aconst_null
    //   170: checkcast 188	java/lang/Throwable
    //   173: astore_0
    //   174: aload 6
    //   176: checkcast 210	java/io/FileOutputStream
    //   179: astore 8
    //   181: aload 7
    //   183: checkcast 213	java/io/InputStream
    //   186: aload 8
    //   188: checkcast 215	java/io/OutputStream
    //   191: iload_3
    //   192: invokestatic 220	kotlin/io/ByteStreamsKt:copyTo	(Ljava/io/InputStream;Ljava/io/OutputStream;I)J
    //   195: pop2
    //   196: aload 6
    //   198: aload_0
    //   199: invokestatic 226	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   202: aload 5
    //   204: aload 4
    //   206: invokestatic 226	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   209: aload_1
    //   210: areturn
    //   211: astore_0
    //   212: aload_0
    //   213: athrow
    //   214: astore_1
    //   215: aload 6
    //   217: aload_0
    //   218: invokestatic 226	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   221: aload_1
    //   222: athrow
    //   223: astore_0
    //   224: aload_0
    //   225: athrow
    //   226: astore_1
    //   227: aload 5
    //   229: aload_0
    //   230: invokestatic 226	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   233: aload_1
    //   234: athrow
    //   235: astore_1
    //   236: aload 4
    //   238: astore_0
    //   239: goto -12 -> 227
    //   242: astore_1
    //   243: goto -28 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	paramFile1	File
    //   0	246	1	paramFile2	File
    //   0	246	2	paramBoolean	boolean
    //   0	246	3	paramInt	int
    //   117	120	4	localObject	Object
    //   141	87	5	localCloseable1	java.io.Closeable
    //   167	49	6	localCloseable2	java.io.Closeable
    //   154	28	7	localFileInputStream	java.io.FileInputStream
    //   179	8	8	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   174	196	211	java/lang/Throwable
    //   212	214	214	finally
    //   149	174	223	java/lang/Throwable
    //   196	202	223	java/lang/Throwable
    //   215	223	223	java/lang/Throwable
    //   224	226	226	finally
    //   149	174	235	finally
    //   196	202	235	finally
    //   215	223	235	finally
    //   174	196	242	finally
  }
  
  @NotNull
  public static final File createTempDir(@NotNull String paramString1, @Nullable String paramString2, @Nullable File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "prefix");
    paramString1 = File.createTempFile(paramString1, paramString2, paramFile);
    paramString1.delete();
    if (paramString1.mkdir())
    {
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "dir");
      return paramString1;
    }
    throw ((Throwable)new IOException("Unable to create temporary directory " + paramString1 + '.'));
  }
  
  @NotNull
  public static final File createTempFile(@NotNull String paramString1, @Nullable String paramString2, @Nullable File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "prefix");
    paramString1 = File.createTempFile(paramString1, paramString2, paramFile);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "File.createTempFile(prefix, suffix, directory)");
    return paramString1;
  }
  
  public static final boolean deleteRecursively(@NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$deleteRecursively");
    paramFile = ((Sequence)FilesKt.walkBottomUp(paramFile)).iterator();
    boolean bool = true;
    if (paramFile.hasNext())
    {
      File localFile = (File)paramFile.next();
      if (((localFile.delete()) || (!localFile.exists())) && (bool)) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    return bool;
  }
  
  public static final boolean endsWith(@NotNull File paramFile1, @NotNull File paramFile2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile1, "$this$endsWith");
    Intrinsics.checkParameterIsNotNull(paramFile2, "other");
    FilePathComponents localFilePathComponents1 = FilesKt.toComponents(paramFile1);
    FilePathComponents localFilePathComponents2 = FilesKt.toComponents(paramFile2);
    if (localFilePathComponents2.isRooted()) {
      return Intrinsics.areEqual(paramFile1, paramFile2);
    }
    int i = localFilePathComponents1.getSize() - localFilePathComponents2.getSize();
    if (i < 0) {
      return false;
    }
    return localFilePathComponents1.getSegments().subList(i, localFilePathComponents1.getSize()).equals(localFilePathComponents2.getSegments());
  }
  
  public static final boolean endsWith(@NotNull File paramFile, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$endsWith");
    Intrinsics.checkParameterIsNotNull(paramString, "other");
    return FilesKt.endsWith(paramFile, new File(paramString));
  }
  
  @NotNull
  public static final String getExtension(@NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$extension");
    paramFile = paramFile.getName();
    Intrinsics.checkExpressionValueIsNotNull(paramFile, "name");
    return StringsKt.substringAfterLast(paramFile, '.', "");
  }
  
  @NotNull
  public static final String getInvariantSeparatorsPath(@NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$invariantSeparatorsPath");
    if (File.separatorChar != '/')
    {
      paramFile = paramFile.getPath();
      Intrinsics.checkExpressionValueIsNotNull(paramFile, "path");
      return StringsKt.replace$default(paramFile, File.separatorChar, '/', false, 4, null);
    }
    paramFile = paramFile.getPath();
    Intrinsics.checkExpressionValueIsNotNull(paramFile, "path");
    return paramFile;
  }
  
  @NotNull
  public static final String getNameWithoutExtension(@NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$nameWithoutExtension");
    paramFile = paramFile.getName();
    Intrinsics.checkExpressionValueIsNotNull(paramFile, "name");
    return StringsKt.substringBeforeLast$default(paramFile, ".", null, 2, null);
  }
  
  @NotNull
  public static final File normalize(@NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$normalize");
    Object localObject = FilesKt.toComponents(paramFile);
    paramFile = ((FilePathComponents)localObject).getRoot();
    localObject = (Iterable)normalize$FilesKt__UtilsKt(((FilePathComponents)localObject).getSegments());
    String str = File.separator;
    Intrinsics.checkExpressionValueIsNotNull(str, "File.separator");
    return FilesKt.resolve(paramFile, CollectionsKt.joinToString$default((Iterable)localObject, (CharSequence)str, null, null, 0, null, null, 62, null));
  }
  
  private static final List<File> normalize$FilesKt__UtilsKt(@NotNull List<? extends File> paramList)
  {
    List localList = (List)new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      File localFile = (File)paramList.next();
      String str = localFile.getName();
      if (str == null) {}
      do
      {
        do
        {
          for (;;)
          {
            localList.add(localFile);
            break;
            switch (str.hashCode())
            {
            }
          }
        } while (!str.equals("."));
        break;
      } while (!str.equals(".."));
      if ((!localList.isEmpty()) && ((Intrinsics.areEqual(((File)CollectionsKt.last(localList)).getName(), "..") ^ true))) {
        localList.remove(localList.size() - 1);
      } else {
        localList.add(localFile);
      }
    }
    return localList;
  }
  
  private static final FilePathComponents normalize$FilesKt__UtilsKt(@NotNull FilePathComponents paramFilePathComponents)
  {
    return new FilePathComponents(paramFilePathComponents.getRoot(), normalize$FilesKt__UtilsKt(paramFilePathComponents.getSegments()));
  }
  
  @NotNull
  public static final File relativeTo(@NotNull File paramFile1, @NotNull File paramFile2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile1, "$this$relativeTo");
    Intrinsics.checkParameterIsNotNull(paramFile2, "base");
    return new File(FilesKt.toRelativeString(paramFile1, paramFile2));
  }
  
  @Nullable
  public static final File relativeToOrNull(@NotNull File paramFile1, @NotNull File paramFile2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile1, "$this$relativeToOrNull");
    Intrinsics.checkParameterIsNotNull(paramFile2, "base");
    paramFile1 = toRelativeStringOrNull$FilesKt__UtilsKt(paramFile1, paramFile2);
    if (paramFile1 != null) {
      return new File(paramFile1);
    }
    return null;
  }
  
  @NotNull
  public static final File relativeToOrSelf(@NotNull File paramFile1, @NotNull File paramFile2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile1, "$this$relativeToOrSelf");
    Intrinsics.checkParameterIsNotNull(paramFile2, "base");
    paramFile2 = toRelativeStringOrNull$FilesKt__UtilsKt(paramFile1, paramFile2);
    if (paramFile2 != null) {
      paramFile1 = new File(paramFile2);
    }
    return paramFile1;
  }
  
  @NotNull
  public static final File resolve(@NotNull File paramFile1, @NotNull File paramFile2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile1, "$this$resolve");
    Intrinsics.checkParameterIsNotNull(paramFile2, "relative");
    if (FilesKt.isRooted(paramFile2)) {
      return paramFile2;
    }
    paramFile1 = paramFile1.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramFile1, "this.toString()");
    int i;
    if (((CharSequence)paramFile1).length() == 0)
    {
      i = 1;
      if ((i == 0) && (!StringsKt.endsWith$default((CharSequence)paramFile1, File.separatorChar, false, 2, null))) {
        break label102;
      }
    }
    label102:
    for (paramFile1 = new File(paramFile1 + paramFile2);; paramFile1 = new File(paramFile1 + File.separatorChar + paramFile2))
    {
      return paramFile1;
      i = 0;
      break;
    }
  }
  
  @NotNull
  public static final File resolve(@NotNull File paramFile, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$resolve");
    Intrinsics.checkParameterIsNotNull(paramString, "relative");
    return FilesKt.resolve(paramFile, new File(paramString));
  }
  
  @NotNull
  public static final File resolveSibling(@NotNull File paramFile1, @NotNull File paramFile2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile1, "$this$resolveSibling");
    Intrinsics.checkParameterIsNotNull(paramFile2, "relative");
    FilePathComponents localFilePathComponents = FilesKt.toComponents(paramFile1);
    if (localFilePathComponents.getSize() == 0) {}
    for (paramFile1 = new File("..");; paramFile1 = localFilePathComponents.subPath(0, localFilePathComponents.getSize() - 1)) {
      return FilesKt.resolve(FilesKt.resolve(localFilePathComponents.getRoot(), paramFile1), paramFile2);
    }
  }
  
  @NotNull
  public static final File resolveSibling(@NotNull File paramFile, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$resolveSibling");
    Intrinsics.checkParameterIsNotNull(paramString, "relative");
    return FilesKt.resolveSibling(paramFile, new File(paramString));
  }
  
  public static final boolean startsWith(@NotNull File paramFile1, @NotNull File paramFile2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile1, "$this$startsWith");
    Intrinsics.checkParameterIsNotNull(paramFile2, "other");
    paramFile1 = FilesKt.toComponents(paramFile1);
    paramFile2 = FilesKt.toComponents(paramFile2);
    if ((Intrinsics.areEqual(paramFile1.getRoot(), paramFile2.getRoot()) ^ true)) {}
    while (paramFile1.getSize() < paramFile2.getSize()) {
      return false;
    }
    return paramFile1.getSegments().subList(0, paramFile2.getSize()).equals(paramFile2.getSegments());
  }
  
  public static final boolean startsWith(@NotNull File paramFile, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$startsWith");
    Intrinsics.checkParameterIsNotNull(paramString, "other");
    return FilesKt.startsWith(paramFile, new File(paramString));
  }
  
  @NotNull
  public static final String toRelativeString(@NotNull File paramFile1, @NotNull File paramFile2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile1, "$this$toRelativeString");
    Intrinsics.checkParameterIsNotNull(paramFile2, "base");
    String str = toRelativeStringOrNull$FilesKt__UtilsKt(paramFile1, paramFile2);
    if (str != null) {
      return str;
    }
    throw ((Throwable)new IllegalArgumentException("this and base files have different roots: " + paramFile1 + " and " + paramFile2 + '.'));
  }
  
  private static final String toRelativeStringOrNull$FilesKt__UtilsKt(@NotNull File paramFile1, File paramFile2)
  {
    Object localObject = normalize$FilesKt__UtilsKt(FilesKt.toComponents(paramFile1));
    paramFile2 = normalize$FilesKt__UtilsKt(FilesKt.toComponents(paramFile2));
    if ((Intrinsics.areEqual(((FilePathComponents)localObject).getRoot(), paramFile2.getRoot()) ^ true)) {}
    int k;
    int m;
    int i;
    for (;;)
    {
      return null;
      k = paramFile2.getSize();
      m = ((FilePathComponents)localObject).getSize();
      int j = Math.min(m, k);
      i = 0;
      while ((i < j) && (Intrinsics.areEqual((File)((FilePathComponents)localObject).getSegments().get(i), (File)paramFile2.getSegments().get(i)))) {
        i += 1;
      }
      paramFile1 = new StringBuilder();
      j = k - 1;
      if (j < i) {
        break;
      }
      while (!Intrinsics.areEqual(((File)paramFile2.getSegments().get(j)).getName(), ".."))
      {
        paramFile1.append("..");
        if (j != i) {
          paramFile1.append(File.separatorChar);
        }
        if (j == i) {
          break label180;
        }
        j -= 1;
      }
    }
    label180:
    if (i < m)
    {
      if (i < k) {
        paramFile1.append(File.separatorChar);
      }
      paramFile2 = (Iterable)CollectionsKt.drop((Iterable)((FilePathComponents)localObject).getSegments(), i);
      localObject = (Appendable)paramFile1;
      String str = File.separator;
      Intrinsics.checkExpressionValueIsNotNull(str, "File.separator");
      CollectionsKt.joinTo$default(paramFile2, (Appendable)localObject, (CharSequence)str, null, null, 0, null, null, 124, null);
    }
    return paramFile1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.io.FilesKt__UtilsKt
 * JD-Core Version:    0.7.0.1
 */