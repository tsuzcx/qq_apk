package kotlin.internal;

import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "apiVersionIsAtLeast", "", "major", "", "minor", "patch", "castToBaseType", "T", "", "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "getJavaVersion", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class PlatformImplementationsKt
{
  @JvmField
  @NotNull
  public static final PlatformImplementations IMPLEMENTATIONS;
  
  static
  {
    int i = getJavaVersion();
    Object localObject;
    if (i >= 65544) {
      try
      {
        localObject = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "Class.forName(\"kotlin.in…entations\").newInstance()");
        if (localObject == null)
        {
          ClassLoader localClassLoader;
          try
          {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
          }
          catch (ClassCastException localClassCastException1)
          {
            localObject = localObject.getClass().getClassLoader();
            localClassLoader = PlatformImplementations.class.getClassLoader();
            Throwable localThrowable1 = new ClassCastException("Instance classloader: " + localObject + ", base type classloader: " + localClassLoader).initCause((Throwable)localClassCastException1);
            Intrinsics.checkExpressionValueIsNotNull(localThrowable1, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
            throw localThrowable1;
          }
          try
          {
            Throwable localThrowable2;
            localObject = Class.forName("kotlin.internal.jdk7.JDK7PlatformImplementations").newInstance();
            Intrinsics.checkExpressionValueIsNotNull(localObject, "Class.forName(\"kotlin.in…entations\").newInstance()");
            if (localObject == null)
            {
              try
              {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
              }
              catch (ClassCastException localClassCastException3)
              {
                localObject = localObject.getClass().getClassLoader();
                localClassLoader = PlatformImplementations.class.getClassLoader();
                localThrowable3 = new ClassCastException("Instance classloader: " + localObject + ", base type classloader: " + localClassLoader).initCause((Throwable)localClassCastException3);
                Intrinsics.checkExpressionValueIsNotNull(localThrowable3, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                throw localThrowable3;
              }
              IMPLEMENTATIONS = localPlatformImplementations;
            }
          }
          catch (ClassNotFoundException localClassNotFoundException3)
          {
            try
            {
              localObject = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
              Intrinsics.checkExpressionValueIsNotNull(localObject, "Class.forName(\"kotlin.in…entations\").newInstance()");
              if (localObject == null)
              {
                try
                {
                  throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                }
                catch (ClassCastException localClassCastException4)
                {
                  localObject = localObject.getClass().getClassLoader();
                  localClassLoader = PlatformImplementations.class.getClassLoader();
                  localThrowable4 = new ClassCastException("Instance classloader: " + localObject + ", base type classloader: " + localClassLoader).initCause((Throwable)localClassCastException4);
                  Intrinsics.checkExpressionValueIsNotNull(localThrowable4, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                  throw localThrowable4;
                }
                localPlatformImplementations = new PlatformImplementations();
              }
            }
            catch (ClassNotFoundException localClassNotFoundException4) {}
          }
        }
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        try
        {
          localObject = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
          Intrinsics.checkExpressionValueIsNotNull(localObject, "Class.forName(\"kotlin.in…entations\").newInstance()");
          if (localObject == null)
          {
            try
            {
              throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            catch (ClassCastException localClassCastException2)
            {
              localObject = localObject.getClass().getClassLoader();
              localClassLoader = PlatformImplementations.class.getClassLoader();
              localThrowable2 = new ClassCastException("Instance classloader: " + localObject + ", base type classloader: " + localClassLoader).initCause((Throwable)localClassCastException2);
              Intrinsics.checkExpressionValueIsNotNull(localThrowable2, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
              throw localThrowable2;
            }
            if (i < 65543) {}
          }
        }
        catch (ClassNotFoundException localClassNotFoundException2) {}
      }
    }
    for (;;)
    {
      Throwable localThrowable3;
      Throwable localThrowable4;
      return;
      PlatformImplementations localPlatformImplementations = (PlatformImplementations)localObject;
      continue;
      localPlatformImplementations = (PlatformImplementations)localObject;
      continue;
      localPlatformImplementations = (PlatformImplementations)localObject;
      continue;
      localPlatformImplementations = (PlatformImplementations)localObject;
    }
  }
  
  @PublishedApi
  @SinceKotlin(version="1.2")
  public static final boolean apiVersionIsAtLeast(int paramInt1, int paramInt2, int paramInt3)
  {
    return KotlinVersion.CURRENT.isAtLeast(paramInt1, paramInt2, paramInt3);
  }
  
  private static final int getJavaVersion()
  {
    int i = 65542;
    String str2 = System.getProperty("java.specification.version");
    int k;
    if (str2 != null)
    {
      k = StringsKt.indexOf$default((CharSequence)str2, '.', 0, false, 6, null);
      if (k >= 0) {}
    }
    else
    {
      try
      {
        i = Integer.parseInt(str2);
        i *= 65536;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        for (;;)
        {
          i = 65542;
        }
      }
      return i;
    }
    int j = StringsKt.indexOf$default((CharSequence)str2, '.', k + 1, false, 4, null);
    i = j;
    if (j < 0) {
      i = str2.length();
    }
    if (str2 == null) {
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    String str1 = str2.substring(0, k);
    Intrinsics.checkExpressionValueIsNotNull(str1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    if (str2 == null) {
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    str2 = str2.substring(k + 1, i);
    Intrinsics.checkExpressionValueIsNotNull(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    try
    {
      i = Integer.parseInt(str1);
      j = Integer.parseInt(str2);
      return i * 65536 + j;
    }
    catch (NumberFormatException localNumberFormatException2) {}
    return 65542;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.internal.PlatformImplementationsKt
 * JD-Core Version:    0.7.0.1
 */