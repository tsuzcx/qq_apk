package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public final class RenderingUtilsKt
{
  @NotNull
  public static final String render(@NotNull FqNameUnsafe paramFqNameUnsafe)
  {
    Intrinsics.checkParameterIsNotNull(paramFqNameUnsafe, "$this$render");
    paramFqNameUnsafe = paramFqNameUnsafe.pathSegments();
    Intrinsics.checkExpressionValueIsNotNull(paramFqNameUnsafe, "pathSegments()");
    return renderFqName(paramFqNameUnsafe);
  }
  
  @NotNull
  public static final String render(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "$this$render");
    if (shouldBeEscaped(paramName))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      paramName = paramName.asString();
      Intrinsics.checkExpressionValueIsNotNull(paramName, "asString()");
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(String.valueOf('`'));
      localStringBuilder2.append(paramName);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder1.append('`');
      return localStringBuilder1.toString();
    }
    paramName = paramName.asString();
    Intrinsics.checkExpressionValueIsNotNull(paramName, "asString()");
    return paramName;
  }
  
  @NotNull
  public static final String renderFqName(@NotNull List<Name> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "pathSegments");
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Name localName = (Name)paramList.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(".");
      }
      localStringBuilder.append(render(localName));
    }
    paramList = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramList, "StringBuilder().apply(builderAction).toString()");
    return paramList;
  }
  
  private static final boolean shouldBeEscaped(@NotNull Name paramName)
  {
    boolean bool2 = paramName.isSpecial();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    paramName = paramName.asString();
    Intrinsics.checkExpressionValueIsNotNull(paramName, "asString()");
    if (!KeywordStringsGenerated.KEYWORDS.contains(paramName))
    {
      paramName = (CharSequence)paramName;
      int i = 0;
      while (i < paramName.length())
      {
        char c = paramName.charAt(i);
        int j;
        if ((!Character.isLetterOrDigit(c)) && (c != '_')) {
          j = 1;
        } else {
          j = 0;
        }
        if (j != 0)
        {
          i = 1;
          break label102;
        }
        i += 1;
      }
      i = 0;
      label102:
      if (i == 0) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.RenderingUtilsKt
 * JD-Core Version:    0.7.0.1
 */