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
class FilesKt__UtilsKt
  extends FilesKt__FileTreeWalkKt
{
  public static final boolean copyRecursively(@NotNull File paramFile1, @NotNull File paramFile2, boolean paramBoolean, @NotNull Function2<? super File, ? super IOException, ? extends OnErrorAction> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile1, "$this$copyRecursively");
    Intrinsics.checkParameterIsNotNull(paramFile2, "target");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "onError");
    if (!paramFile1.exists()) {
      return (OnErrorAction)paramFunction2.invoke(paramFile1, new NoSuchFileException(paramFile1, null, "The source file doesn't exist.", 2, null)) != OnErrorAction.TERMINATE;
    }
    for (;;)
    {
      int i;
      try
      {
        Iterator localIterator = FilesKt.walkTopDown(paramFile1).onFail((Function2)new FilesKt__UtilsKt.copyRecursively.2(paramFunction2)).iterator();
        if (localIterator.hasNext())
        {
          Object localObject1 = (File)localIterator.next();
          if (!((File)localObject1).exists())
          {
            if ((OnErrorAction)paramFunction2.invoke(localObject1, new NoSuchFileException((File)localObject1, null, "The source file doesn't exist.", 2, null)) != OnErrorAction.TERMINATE) {
              continue;
            }
            return false;
          }
          Object localObject2 = new File(paramFile2, FilesKt.toRelativeString((File)localObject1, paramFile1));
          if (((File)localObject2).exists())
          {
            if (!((File)localObject1).isDirectory()) {
              break label335;
            }
            if (!((File)localObject2).isDirectory())
            {
              break label335;
              if (((File)localObject2).isDirectory())
              {
                if (FilesKt.deleteRecursively((File)localObject2)) {
                  break label345;
                }
                break label339;
              }
              if (((File)localObject2).delete()) {
                break label345;
              }
              break label339;
              if (i != 0)
              {
                if ((OnErrorAction)paramFunction2.invoke(localObject2, new FileAlreadyExistsException((File)localObject1, (File)localObject2, "The destination file already exists.")) != OnErrorAction.TERMINATE) {
                  continue;
                }
                return false;
              }
            }
          }
          if (((File)localObject1).isDirectory())
          {
            ((File)localObject2).mkdirs();
            continue;
          }
          if (FilesKt.copyTo$default((File)localObject1, (File)localObject2, paramBoolean, 0, 4, null).length() == ((File)localObject1).length()) {
            continue;
          }
          localObject1 = (OnErrorAction)paramFunction2.invoke(localObject1, new IOException("Source file wasn't copied completely, length of destination file differs."));
          localObject2 = OnErrorAction.TERMINATE;
          if (localObject1 != localObject2) {
            continue;
          }
          return false;
        }
        else
        {
          return true;
        }
      }
      catch (TerminateException paramFile1)
      {
        return false;
      }
      label335:
      if (!paramBoolean)
      {
        label339:
        i = 1;
        continue;
        label345:
        i = 0;
      }
    }
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
    //   16: ifeq +251 -> 267
    //   19: aload_1
    //   20: invokevirtual 85	java/io/File:exists	()Z
    //   23: ifeq +47 -> 70
    //   26: iload_2
    //   27: ifeq +28 -> 55
    //   30: aload_1
    //   31: invokevirtual 147	java/io/File:delete	()Z
    //   34: ifeq +6 -> 40
    //   37: goto +33 -> 70
    //   40: new 149	kotlin/io/FileAlreadyExistsException
    //   43: dup
    //   44: aload_0
    //   45: aload_1
    //   46: ldc 192
    //   48: invokespecial 154	kotlin/io/FileAlreadyExistsException:<init>	(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V
    //   51: checkcast 188	java/lang/Throwable
    //   54: athrow
    //   55: new 149	kotlin/io/FileAlreadyExistsException
    //   58: dup
    //   59: aload_0
    //   60: aload_1
    //   61: ldc 151
    //   63: invokespecial 154	kotlin/io/FileAlreadyExistsException:<init>	(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V
    //   66: checkcast 188	java/lang/Throwable
    //   69: athrow
    //   70: aload_0
    //   71: invokevirtual 141	java/io/File:isDirectory	()Z
    //   74: ifeq +27 -> 101
    //   77: aload_1
    //   78: invokevirtual 157	java/io/File:mkdirs	()Z
    //   81: ifeq +5 -> 86
    //   84: aload_1
    //   85: areturn
    //   86: new 194	kotlin/io/FileSystemException
    //   89: dup
    //   90: aload_0
    //   91: aload_1
    //   92: ldc 196
    //   94: invokespecial 197	kotlin/io/FileSystemException:<init>	(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V
    //   97: checkcast 188	java/lang/Throwable
    //   100: athrow
    //   101: aload_1
    //   102: invokevirtual 201	java/io/File:getParentFile	()Ljava/io/File;
    //   105: astore 4
    //   107: aload 4
    //   109: ifnull +9 -> 118
    //   112: aload 4
    //   114: invokevirtual 157	java/io/File:mkdirs	()Z
    //   117: pop
    //   118: new 203	java/io/FileInputStream
    //   121: dup
    //   122: aload_0
    //   123: invokespecial 206	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   126: checkcast 208	java/io/Closeable
    //   129: astore 7
    //   131: aconst_null
    //   132: checkcast 188	java/lang/Throwable
    //   135: astore 5
    //   137: aload 5
    //   139: astore 4
    //   141: aload 7
    //   143: checkcast 203	java/io/FileInputStream
    //   146: astore 9
    //   148: aload 5
    //   150: astore 4
    //   152: new 210	java/io/FileOutputStream
    //   155: dup
    //   156: aload_1
    //   157: invokespecial 211	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   160: checkcast 208	java/io/Closeable
    //   163: astore 8
    //   165: aload 5
    //   167: astore 4
    //   169: aconst_null
    //   170: checkcast 188	java/lang/Throwable
    //   173: astore 6
    //   175: aload 6
    //   177: astore_0
    //   178: aload 8
    //   180: checkcast 210	java/io/FileOutputStream
    //   183: astore 4
    //   185: aload 6
    //   187: astore_0
    //   188: aload 9
    //   190: checkcast 213	java/io/InputStream
    //   193: aload 4
    //   195: checkcast 215	java/io/OutputStream
    //   198: iload_3
    //   199: invokestatic 220	kotlin/io/ByteStreamsKt:copyTo	(Ljava/io/InputStream;Ljava/io/OutputStream;I)J
    //   202: pop2
    //   203: aload 5
    //   205: astore 4
    //   207: aload 8
    //   209: aload 6
    //   211: invokestatic 226	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   214: aload 7
    //   216: aload 5
    //   218: invokestatic 226	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   221: aload_1
    //   222: areturn
    //   223: astore_1
    //   224: goto +8 -> 232
    //   227: astore_1
    //   228: aload_1
    //   229: astore_0
    //   230: aload_1
    //   231: athrow
    //   232: aload 5
    //   234: astore 4
    //   236: aload 8
    //   238: aload_0
    //   239: invokestatic 226	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   242: aload 5
    //   244: astore 4
    //   246: aload_1
    //   247: athrow
    //   248: astore_0
    //   249: goto +9 -> 258
    //   252: astore_0
    //   253: aload_0
    //   254: astore 4
    //   256: aload_0
    //   257: athrow
    //   258: aload 7
    //   260: aload 4
    //   262: invokestatic 226	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   265: aload_0
    //   266: athrow
    //   267: new 87	kotlin/io/NoSuchFileException
    //   270: dup
    //   271: aload_0
    //   272: aconst_null
    //   273: ldc 89
    //   275: iconst_2
    //   276: aconst_null
    //   277: invokespecial 92	kotlin/io/NoSuchFileException:<init>	(Ljava/io/File;Ljava/io/File;Ljava/lang/String;ILkotlin/jvm/internal/DefaultConstructorMarker;)V
    //   280: checkcast 188	java/lang/Throwable
    //   283: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	paramFile1	File
    //   0	284	1	paramFile2	File
    //   0	284	2	paramBoolean	boolean
    //   0	284	3	paramInt	int
    //   105	156	4	localObject	Object
    //   135	108	5	localThrowable1	Throwable
    //   173	37	6	localThrowable2	Throwable
    //   129	130	7	localCloseable1	java.io.Closeable
    //   163	74	8	localCloseable2	java.io.Closeable
    //   146	43	9	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   178	185	223	finally
    //   188	203	223	finally
    //   230	232	223	finally
    //   178	185	227	java/lang/Throwable
    //   188	203	227	java/lang/Throwable
    //   141	148	248	finally
    //   152	165	248	finally
    //   169	175	248	finally
    //   207	214	248	finally
    //   236	242	248	finally
    //   246	248	248	finally
    //   256	258	248	finally
    //   141	148	252	java/lang/Throwable
    //   152	165	252	java/lang/Throwable
    //   169	175	252	java/lang/Throwable
    //   207	214	252	java/lang/Throwable
    //   236	242	252	java/lang/Throwable
    //   246	248	252	java/lang/Throwable
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
    paramString2 = new StringBuilder();
    paramString2.append("Unable to create temporary directory ");
    paramString2.append(paramString1);
    paramString2.append('.');
    throw ((Throwable)new IOException(paramString2.toString()));
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
    for (boolean bool = true;; bool = false)
    {
      if (!paramFile.hasNext()) {
        return bool;
      }
      File localFile = (File)paramFile.next();
      if (((localFile.delete()) || (!localFile.exists())) && (bool)) {
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
      if (str != null)
      {
        int i = str.hashCode();
        if (i != 46)
        {
          if ((i == 1472) && (str.equals("..")))
          {
            if ((!localList.isEmpty()) && ((Intrinsics.areEqual(((File)CollectionsKt.last(localList)).getName(), "..") ^ true)))
            {
              localList.remove(localList.size() - 1);
              continue;
            }
            localList.add(localFile);
          }
        }
        else {
          if (str.equals(".")) {
            continue;
          }
        }
      }
      localList.add(localFile);
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
    Object localObject = (CharSequence)paramFile1;
    int i;
    if (((CharSequence)localObject).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i == 0) && (!StringsKt.endsWith$default((CharSequence)localObject, File.separatorChar, false, 2, null)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramFile1);
      ((StringBuilder)localObject).append(File.separatorChar);
      ((StringBuilder)localObject).append(paramFile2);
      return new File(((StringBuilder)localObject).toString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramFile1);
    ((StringBuilder)localObject).append(paramFile2);
    return new File(((StringBuilder)localObject).toString());
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
    if (localFilePathComponents.getSize() == 0) {
      paramFile1 = new File("..");
    } else {
      paramFile1 = localFilePathComponents.subPath(0, localFilePathComponents.getSize() - 1);
    }
    return FilesKt.resolve(FilesKt.resolve(localFilePathComponents.getRoot(), paramFile1), paramFile2);
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
    if ((Intrinsics.areEqual(paramFile1.getRoot(), paramFile2.getRoot()) ^ true)) {
      return false;
    }
    if (paramFile1.getSize() < paramFile2.getSize()) {
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
    Object localObject = toRelativeStringOrNull$FilesKt__UtilsKt(paramFile1, paramFile2);
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("this and base files have different roots: ");
    ((StringBuilder)localObject).append(paramFile1);
    ((StringBuilder)localObject).append(" and ");
    ((StringBuilder)localObject).append(paramFile2);
    ((StringBuilder)localObject).append('.');
    throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString()));
  }
  
  private static final String toRelativeStringOrNull$FilesKt__UtilsKt(@NotNull File paramFile1, File paramFile2)
  {
    Object localObject = normalize$FilesKt__UtilsKt(FilesKt.toComponents(paramFile1));
    paramFile2 = normalize$FilesKt__UtilsKt(FilesKt.toComponents(paramFile2));
    if ((Intrinsics.areEqual(((FilePathComponents)localObject).getRoot(), paramFile2.getRoot()) ^ true)) {
      return null;
    }
    int k = paramFile2.getSize();
    int m = ((FilePathComponents)localObject).getSize();
    int i = 0;
    int j = Math.min(m, k);
    while ((i < j) && (Intrinsics.areEqual((File)((FilePathComponents)localObject).getSegments().get(i), (File)paramFile2.getSegments().get(i)))) {
      i += 1;
    }
    paramFile1 = new StringBuilder();
    j = k - 1;
    if (j >= i) {
      for (;;)
      {
        if (Intrinsics.areEqual(((File)paramFile2.getSegments().get(j)).getName(), "..")) {
          return null;
        }
        paramFile1.append("..");
        if (j != i) {
          paramFile1.append(File.separatorChar);
        }
        if (j == i) {
          break;
        }
        j -= 1;
      }
    }
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