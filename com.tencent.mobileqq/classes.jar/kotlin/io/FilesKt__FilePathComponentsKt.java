package kotlin.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"isRooted", "", "Ljava/io/File;", "(Ljava/io/File;)Z", "root", "getRoot", "(Ljava/io/File;)Ljava/io/File;", "rootName", "", "getRootName", "(Ljava/io/File;)Ljava/lang/String;", "getRootLength", "", "getRootLength$FilesKt__FilePathComponentsKt", "subPath", "beginIndex", "endIndex", "toComponents", "Lkotlin/io/FilePathComponents;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/io/FilesKt")
class FilesKt__FilePathComponentsKt
{
  @NotNull
  public static final File getRoot(@NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$root");
    return new File(FilesKt.getRootName(paramFile));
  }
  
  private static final int getRootLength$FilesKt__FilePathComponentsKt(@NotNull String paramString)
  {
    CharSequence localCharSequence = (CharSequence)paramString;
    int i = StringsKt.indexOf$default(localCharSequence, File.separatorChar, 0, false, 4, null);
    if (i == 0)
    {
      if ((paramString.length() > 1) && (paramString.charAt(1) == File.separatorChar))
      {
        i = StringsKt.indexOf$default(localCharSequence, File.separatorChar, 2, false, 4, null);
        if (i >= 0)
        {
          i = StringsKt.indexOf$default(localCharSequence, File.separatorChar, i + 1, false, 4, null);
          if (i >= 0) {
            return i + 1;
          }
          return paramString.length();
        }
      }
      return 1;
    }
    if ((i > 0) && (paramString.charAt(i - 1) == ':')) {
      return i + 1;
    }
    if ((i == -1) && (StringsKt.endsWith$default(localCharSequence, ':', false, 2, null))) {
      return paramString.length();
    }
    return 0;
  }
  
  @NotNull
  public static final String getRootName(@NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$rootName");
    String str = paramFile.getPath();
    Intrinsics.checkExpressionValueIsNotNull(str, "path");
    paramFile = paramFile.getPath();
    Intrinsics.checkExpressionValueIsNotNull(paramFile, "path");
    int i = getRootLength$FilesKt__FilePathComponentsKt(paramFile);
    if (str != null)
    {
      paramFile = str.substring(0, i);
      Intrinsics.checkExpressionValueIsNotNull(paramFile, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      return paramFile;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  public static final boolean isRooted(@NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$isRooted");
    paramFile = paramFile.getPath();
    Intrinsics.checkExpressionValueIsNotNull(paramFile, "path");
    return getRootLength$FilesKt__FilePathComponentsKt(paramFile) > 0;
  }
  
  @NotNull
  public static final File subPath(@NotNull File paramFile, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$subPath");
    return FilesKt.toComponents(paramFile).subPath(paramInt1, paramInt2);
  }
  
  @NotNull
  public static final FilePathComponents toComponents(@NotNull File paramFile)
  {
    Intrinsics.checkParameterIsNotNull(paramFile, "$this$toComponents");
    paramFile = paramFile.getPath();
    Intrinsics.checkExpressionValueIsNotNull(paramFile, "path");
    int i = getRootLength$FilesKt__FilePathComponentsKt(paramFile);
    String str = paramFile.substring(0, i);
    Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    paramFile = paramFile.substring(i);
    Intrinsics.checkExpressionValueIsNotNull(paramFile, "(this as java.lang.String).substring(startIndex)");
    paramFile = (CharSequence)paramFile;
    if (paramFile.length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramFile = CollectionsKt.emptyList();
    }
    else
    {
      Object localObject = (Iterable)StringsKt.split$default(paramFile, new char[] { File.separatorChar }, false, 0, 6, null);
      paramFile = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramFile.add(new File((String)((Iterator)localObject).next()));
      }
      paramFile = (List)paramFile;
    }
    return new FilePathComponents(new File(str), paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.io.FilesKt__FilePathComponentsKt
 * JD-Core Version:    0.7.0.1
 */