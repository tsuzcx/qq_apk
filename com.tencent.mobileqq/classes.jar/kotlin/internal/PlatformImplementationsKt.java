package kotlin.internal;

import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
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
    if (i >= 65544) {}
    try
    {
      localObject2 = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "Class.forName(\"kotlin.in…entations\").newInstance()");
      if (localObject2 == null) {}
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      Object localObject2;
      Object localObject1;
      label47:
      ClassLoader localClassLoader;
      StringBuilder localStringBuilder;
      break label128;
    }
    try
    {
      localObject1 = (PlatformImplementations)localObject2;
    }
    catch (ClassCastException localClassCastException1)
    {
      break label47;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
    localObject2 = localObject2.getClass().getClassLoader();
    localClassLoader = PlatformImplementations.class.getClassLoader();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Instance classloader: ");
    localStringBuilder.append(localObject2);
    localStringBuilder.append(", base type classloader: ");
    localStringBuilder.append(localClassLoader);
    localObject1 = new ClassCastException(localStringBuilder.toString()).initCause((Throwable)localObject1);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
    throw ((Throwable)localObject1);
    try
    {
      label128:
      localObject2 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "Class.forName(\"kotlin.in…entations\").newInstance()");
      if (localObject2 == null) {}
    }
    catch (ClassNotFoundException localClassNotFoundException2)
    {
      label165:
      break label246;
    }
    try
    {
      localObject1 = (PlatformImplementations)localObject2;
    }
    catch (ClassCastException localClassCastException2)
    {
      break label165;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
    localObject2 = localObject2.getClass().getClassLoader();
    localClassLoader = PlatformImplementations.class.getClassLoader();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Instance classloader: ");
    localStringBuilder.append(localObject2);
    localStringBuilder.append(", base type classloader: ");
    localStringBuilder.append(localClassLoader);
    localObject1 = new ClassCastException(localStringBuilder.toString()).initCause((Throwable)localObject1);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
    throw ((Throwable)localObject1);
    label246:
    if (i >= 65543) {}
    try
    {
      localObject2 = Class.forName("kotlin.internal.jdk7.JDK7PlatformImplementations").newInstance();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "Class.forName(\"kotlin.in…entations\").newInstance()");
      if (localObject2 == null) {}
    }
    catch (ClassNotFoundException localClassNotFoundException3)
    {
      break label370;
    }
    try
    {
      localObject1 = (PlatformImplementations)localObject2;
    }
    catch (ClassCastException localClassCastException3)
    {
      break label289;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
    label289:
    localObject2 = localObject2.getClass().getClassLoader();
    localClassLoader = PlatformImplementations.class.getClassLoader();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Instance classloader: ");
    localStringBuilder.append(localObject2);
    localStringBuilder.append(", base type classloader: ");
    localStringBuilder.append(localClassLoader);
    localObject1 = new ClassCastException(localStringBuilder.toString()).initCause((Throwable)localObject1);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
    throw ((Throwable)localObject1);
    try
    {
      label370:
      localObject2 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "Class.forName(\"kotlin.in…entations\").newInstance()");
      if (localObject2 == null) {}
    }
    catch (ClassNotFoundException localClassNotFoundException4)
    {
      label407:
      label488:
      break label488;
    }
    try
    {
      localObject1 = (PlatformImplementations)localObject2;
    }
    catch (ClassCastException localClassCastException4)
    {
      break label407;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
    localObject2 = localObject2.getClass().getClassLoader();
    localClassLoader = PlatformImplementations.class.getClassLoader();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Instance classloader: ");
    localStringBuilder.append(localObject2);
    localStringBuilder.append(", base type classloader: ");
    localStringBuilder.append(localClassLoader);
    localObject1 = new ClassCastException(localStringBuilder.toString()).initCause((Throwable)localObject1);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
    throw ((Throwable)localObject1);
    localObject1 = new PlatformImplementations();
    IMPLEMENTATIONS = (PlatformImplementations)localObject1;
  }
  
  @PublishedApi
  @SinceKotlin(version="1.2")
  public static final boolean apiVersionIsAtLeast(int paramInt1, int paramInt2, int paramInt3)
  {
    return KotlinVersion.CURRENT.isAtLeast(paramInt1, paramInt2, paramInt3);
  }
  
  /* Error */
  private static final int getJavaVersion()
  {
    // Byte code:
    //   0: ldc 145
    //   2: invokestatic 151	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   5: astore 4
    //   7: aload 4
    //   9: ifnull +147 -> 156
    //   12: aload 4
    //   14: checkcast 153	java/lang/CharSequence
    //   17: astore 5
    //   19: aload 5
    //   21: bipush 46
    //   23: iconst_0
    //   24: iconst_0
    //   25: bipush 6
    //   27: aconst_null
    //   28: invokestatic 159	kotlin/text/StringsKt:indexOf$default	(Ljava/lang/CharSequence;CIZILjava/lang/Object;)I
    //   31: istore_2
    //   32: iload_2
    //   33: ifge +14 -> 47
    //   36: aload 4
    //   38: invokestatic 165	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   41: istore_0
    //   42: iload_0
    //   43: ldc 166
    //   45: imul
    //   46: ireturn
    //   47: iload_2
    //   48: iconst_1
    //   49: iadd
    //   50: istore_3
    //   51: aload 5
    //   53: bipush 46
    //   55: iload_3
    //   56: iconst_0
    //   57: iconst_4
    //   58: aconst_null
    //   59: invokestatic 159	kotlin/text/StringsKt:indexOf$default	(Ljava/lang/CharSequence;CIZILjava/lang/Object;)I
    //   62: istore_1
    //   63: iload_1
    //   64: istore_0
    //   65: iload_1
    //   66: ifge +9 -> 75
    //   69: aload 4
    //   71: invokevirtual 171	java/lang/String:length	()I
    //   74: istore_0
    //   75: aload 4
    //   77: ifnull +69 -> 146
    //   80: aload 4
    //   82: iconst_0
    //   83: iload_2
    //   84: invokevirtual 175	java/lang/String:substring	(II)Ljava/lang/String;
    //   87: astore 5
    //   89: aload 5
    //   91: ldc 177
    //   93: invokestatic 61	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   96: aload 4
    //   98: ifnull +38 -> 136
    //   101: aload 4
    //   103: iload_3
    //   104: iload_0
    //   105: invokevirtual 175	java/lang/String:substring	(II)Ljava/lang/String;
    //   108: astore 4
    //   110: aload 4
    //   112: ldc 177
    //   114: invokestatic 61	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   117: aload 5
    //   119: invokestatic 165	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   122: istore_0
    //   123: aload 4
    //   125: invokestatic 165	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   128: istore_1
    //   129: iload_0
    //   130: ldc 166
    //   132: imul
    //   133: iload_1
    //   134: iadd
    //   135: ireturn
    //   136: new 65	kotlin/TypeCastException
    //   139: dup
    //   140: ldc 179
    //   142: invokespecial 71	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   145: athrow
    //   146: new 65	kotlin/TypeCastException
    //   149: dup
    //   150: ldc 179
    //   152: invokespecial 71	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   155: athrow
    //   156: ldc 180
    //   158: ireturn
    //   159: astore 4
    //   161: ldc 180
    //   163: ireturn
    //   164: astore 4
    //   166: ldc 180
    //   168: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   41	92	0	i	int
    //   62	73	1	j	int
    //   31	53	2	k	int
    //   50	54	3	m	int
    //   5	119	4	str	java.lang.String
    //   159	1	4	localNumberFormatException1	java.lang.NumberFormatException
    //   164	1	4	localNumberFormatException2	java.lang.NumberFormatException
    //   17	101	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   36	42	159	java/lang/NumberFormatException
    //   117	129	164	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.internal.PlatformImplementationsKt
 * JD-Core Version:    0.7.0.1
 */