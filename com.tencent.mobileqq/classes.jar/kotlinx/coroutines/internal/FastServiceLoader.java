package kotlinx.coroutines.internal;

import java.io.BufferedReader;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/FastServiceLoader;", "", "()V", "PREFIX", "", "createInstanceOf", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "baseClass", "Ljava/lang/Class;", "serviceClass", "getProviderInstance", "S", "name", "loader", "Ljava/lang/ClassLoader;", "service", "(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Object;", "load", "", "loadMainDispatcherFactory", "loadMainDispatcherFactory$kotlinx_coroutines_core", "loadProviders", "loadProviders$kotlinx_coroutines_core", "parse", "url", "Ljava/net/URL;", "parseFile", "r", "Ljava/io/BufferedReader;", "use", "R", "Ljava/util/jar/JarFile;", "block", "Lkotlin/Function1;", "(Ljava/util/jar/JarFile;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class FastServiceLoader
{
  public static final FastServiceLoader INSTANCE = new FastServiceLoader();
  private static final String PREFIX = "META-INF/services/";
  
  private final MainDispatcherFactory createInstanceOf(Class<MainDispatcherFactory> paramClass, String paramString)
  {
    try
    {
      paramClass = (MainDispatcherFactory)paramClass.cast(Class.forName(paramString, true, paramClass.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
      return paramClass;
    }
    catch (ClassNotFoundException paramClass)
    {
      label33:
      break label33;
    }
    return null;
  }
  
  private final <S> S getProviderInstance(String paramString, ClassLoader paramClassLoader, Class<S> paramClass)
  {
    paramString = Class.forName(paramString, false, paramClassLoader);
    if (paramClass.isAssignableFrom(paramString)) {
      return paramClass.cast(paramString.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
    }
    paramClassLoader = new StringBuilder();
    paramClassLoader.append("Expected service of class ");
    paramClassLoader.append(paramClass);
    paramClassLoader.append(", but found ");
    paramClassLoader.append(paramString);
    throw ((Throwable)new IllegalArgumentException(paramClassLoader.toString().toString()));
  }
  
  private final <S> List<S> load(Class<S> paramClass, ClassLoader paramClassLoader)
  {
    try
    {
      List localList = loadProviders$kotlinx_coroutines_core(paramClass, paramClassLoader);
      return localList;
    }
    catch (Throwable localThrowable)
    {
      label9:
      break label9;
    }
    return CollectionsKt.toList((Iterable)ServiceLoader.load(paramClass, paramClassLoader));
  }
  
  /* Error */
  private final List<String> parse(URL paramURL)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 144	java/net/URL:toString	()Ljava/lang/String;
    //   4: astore_2
    //   5: aload_2
    //   6: ldc 146
    //   8: iconst_0
    //   9: iconst_2
    //   10: aconst_null
    //   11: invokestatic 152	kotlin/text/StringsKt:startsWith$default	(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
    //   14: ifeq +188 -> 202
    //   17: aload_2
    //   18: ldc 154
    //   20: aconst_null
    //   21: iconst_2
    //   22: aconst_null
    //   23: invokestatic 158	kotlin/text/StringsKt:substringAfter$default	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Object;)Ljava/lang/String;
    //   26: bipush 33
    //   28: aconst_null
    //   29: iconst_2
    //   30: aconst_null
    //   31: invokestatic 162	kotlin/text/StringsKt:substringBefore$default	(Ljava/lang/String;CLjava/lang/String;ILjava/lang/Object;)Ljava/lang/String;
    //   34: astore_1
    //   35: aload_2
    //   36: ldc 164
    //   38: aconst_null
    //   39: iconst_2
    //   40: aconst_null
    //   41: invokestatic 158	kotlin/text/StringsKt:substringAfter$default	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Object;)Ljava/lang/String;
    //   44: astore_2
    //   45: new 166	java/util/jar/JarFile
    //   48: dup
    //   49: aload_1
    //   50: iconst_0
    //   51: invokespecial 169	java/util/jar/JarFile:<init>	(Ljava/lang/String;Z)V
    //   54: astore 5
    //   56: aconst_null
    //   57: checkcast 122	java/lang/Throwable
    //   60: astore_3
    //   61: aload_3
    //   62: astore_1
    //   63: new 171	java/io/BufferedReader
    //   66: dup
    //   67: new 173	java/io/InputStreamReader
    //   70: dup
    //   71: aload 5
    //   73: new 175	java/util/zip/ZipEntry
    //   76: dup
    //   77: aload_2
    //   78: invokespecial 176	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   81: invokevirtual 180	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   84: ldc 182
    //   86: invokespecial 185	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   89: checkcast 187	java/io/Reader
    //   92: invokespecial 190	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   95: checkcast 192	java/io/Closeable
    //   98: astore 6
    //   100: aload_3
    //   101: astore_1
    //   102: aconst_null
    //   103: checkcast 122	java/lang/Throwable
    //   106: astore 4
    //   108: aload 4
    //   110: astore_2
    //   111: aload 6
    //   113: checkcast 171	java/io/BufferedReader
    //   116: astore_1
    //   117: aload 4
    //   119: astore_2
    //   120: getstatic 59	kotlinx/coroutines/internal/FastServiceLoader:INSTANCE	Lkotlinx/coroutines/internal/FastServiceLoader;
    //   123: aload_1
    //   124: invokespecial 195	kotlinx/coroutines/internal/FastServiceLoader:parseFile	(Ljava/io/BufferedReader;)Ljava/util/List;
    //   127: astore 7
    //   129: aload_3
    //   130: astore_1
    //   131: aload 6
    //   133: aload 4
    //   135: invokestatic 201	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   138: aload 5
    //   140: invokevirtual 204	java/util/jar/JarFile:close	()V
    //   143: aload 7
    //   145: areturn
    //   146: astore_1
    //   147: aload_1
    //   148: athrow
    //   149: astore 4
    //   151: goto +8 -> 159
    //   154: astore_1
    //   155: aload_1
    //   156: astore_2
    //   157: aload_1
    //   158: athrow
    //   159: aload_3
    //   160: astore_1
    //   161: aload 6
    //   163: aload_2
    //   164: invokestatic 201	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   167: aload_3
    //   168: astore_1
    //   169: aload 4
    //   171: athrow
    //   172: astore_2
    //   173: goto +8 -> 181
    //   176: astore_2
    //   177: aload_2
    //   178: astore_1
    //   179: aload_2
    //   180: athrow
    //   181: aload 5
    //   183: invokevirtual 204	java/util/jar/JarFile:close	()V
    //   186: aload_2
    //   187: athrow
    //   188: astore_2
    //   189: aload_1
    //   190: ifnonnull +5 -> 195
    //   193: aload_2
    //   194: athrow
    //   195: aload_1
    //   196: aload_2
    //   197: invokestatic 210	kotlin/ExceptionsKt:addSuppressed	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   200: aload_1
    //   201: athrow
    //   202: new 171	java/io/BufferedReader
    //   205: dup
    //   206: new 173	java/io/InputStreamReader
    //   209: dup
    //   210: aload_1
    //   211: invokevirtual 214	java/net/URL:openStream	()Ljava/io/InputStream;
    //   214: invokespecial 217	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   217: checkcast 187	java/io/Reader
    //   220: invokespecial 190	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   223: checkcast 192	java/io/Closeable
    //   226: astore_3
    //   227: aconst_null
    //   228: checkcast 122	java/lang/Throwable
    //   231: astore_2
    //   232: aload_2
    //   233: astore_1
    //   234: aload_3
    //   235: checkcast 171	java/io/BufferedReader
    //   238: astore 4
    //   240: aload_2
    //   241: astore_1
    //   242: getstatic 59	kotlinx/coroutines/internal/FastServiceLoader:INSTANCE	Lkotlinx/coroutines/internal/FastServiceLoader;
    //   245: aload 4
    //   247: invokespecial 195	kotlinx/coroutines/internal/FastServiceLoader:parseFile	(Ljava/io/BufferedReader;)Ljava/util/List;
    //   250: astore 4
    //   252: aload_3
    //   253: aload_2
    //   254: invokestatic 201	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   257: aload 4
    //   259: areturn
    //   260: astore_2
    //   261: goto +8 -> 269
    //   264: astore_2
    //   265: aload_2
    //   266: astore_1
    //   267: aload_2
    //   268: athrow
    //   269: aload_3
    //   270: aload_1
    //   271: invokestatic 201	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   274: aload_2
    //   275: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	this	FastServiceLoader
    //   0	276	1	paramURL	URL
    //   4	160	2	localObject1	Object
    //   172	1	2	localObject2	Object
    //   176	11	2	localThrowable1	Throwable
    //   188	9	2	localThrowable2	Throwable
    //   231	23	2	localThrowable3	Throwable
    //   260	1	2	localObject3	Object
    //   264	11	2	localThrowable4	Throwable
    //   60	210	3	localObject4	Object
    //   106	28	4	localThrowable5	Throwable
    //   149	21	4	localObject5	Object
    //   238	20	4	localObject6	Object
    //   54	128	5	localJarFile	java.util.jar.JarFile
    //   98	64	6	localCloseable	java.io.Closeable
    //   127	17	7	localList	List
    // Exception table:
    //   from	to	target	type
    //   138	143	146	java/lang/Throwable
    //   111	117	149	finally
    //   120	129	149	finally
    //   157	159	149	finally
    //   111	117	154	java/lang/Throwable
    //   120	129	154	java/lang/Throwable
    //   63	100	172	finally
    //   102	108	172	finally
    //   131	138	172	finally
    //   161	167	172	finally
    //   169	172	172	finally
    //   179	181	172	finally
    //   63	100	176	java/lang/Throwable
    //   102	108	176	java/lang/Throwable
    //   131	138	176	java/lang/Throwable
    //   161	167	176	java/lang/Throwable
    //   169	172	176	java/lang/Throwable
    //   181	186	188	java/lang/Throwable
    //   234	240	260	finally
    //   242	252	260	finally
    //   267	269	260	finally
    //   234	240	264	java/lang/Throwable
    //   242	252	264	java/lang/Throwable
  }
  
  private final List<String> parseFile(BufferedReader paramBufferedReader)
  {
    Set localSet = (Set)new LinkedHashSet();
    String str;
    for (;;)
    {
      str = paramBufferedReader.readLine();
      if (str == null) {
        break label217;
      }
      str = StringsKt.substringBefore$default(str, "#", null, 2, null);
      if (str == null) {
        break label206;
      }
      str = StringsKt.trim((CharSequence)str).toString();
      CharSequence localCharSequence = (CharSequence)str;
      int k = 0;
      int i = 0;
      while (i < localCharSequence.length())
      {
        char c = localCharSequence.charAt(i);
        int j;
        if ((c != '.') && (!Character.isJavaIdentifierPart(c))) {
          j = 0;
        } else {
          j = 1;
        }
        if (j == 0)
        {
          i = 0;
          break label129;
        }
        i += 1;
      }
      i = 1;
      label129:
      if (i == 0) {
        break;
      }
      i = k;
      if (localCharSequence.length() > 0) {
        i = 1;
      }
      if (i != 0) {
        localSet.add(str);
      }
    }
    paramBufferedReader = new StringBuilder();
    paramBufferedReader.append("Illegal service provider class name: ");
    paramBufferedReader.append(str);
    throw ((Throwable)new IllegalArgumentException(paramBufferedReader.toString().toString()));
    label206:
    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    label217:
    return CollectionsKt.toList((Iterable)localSet);
  }
  
  /* Error */
  private final <R> R use(@NotNull java.util.jar.JarFile paramJarFile, kotlin.jvm.functions.Function1<? super java.util.jar.JarFile, ? extends R> paramFunction1)
  {
    // Byte code:
    //   0: aconst_null
    //   1: checkcast 122	java/lang/Throwable
    //   4: astore_3
    //   5: aload_2
    //   6: aload_1
    //   7: invokeinterface 268 2 0
    //   12: astore_2
    //   13: iconst_1
    //   14: invokestatic 274	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   17: aload_1
    //   18: invokevirtual 204	java/util/jar/JarFile:close	()V
    //   21: iconst_1
    //   22: invokestatic 277	kotlin/jvm/internal/InlineMarker:finallyEnd	(I)V
    //   25: aload_2
    //   26: areturn
    //   27: astore_1
    //   28: aload_1
    //   29: athrow
    //   30: astore_2
    //   31: goto +8 -> 39
    //   34: astore_2
    //   35: aload_2
    //   36: astore_3
    //   37: aload_2
    //   38: athrow
    //   39: iconst_1
    //   40: invokestatic 274	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   43: aload_1
    //   44: invokevirtual 204	java/util/jar/JarFile:close	()V
    //   47: iconst_1
    //   48: invokestatic 277	kotlin/jvm/internal/InlineMarker:finallyEnd	(I)V
    //   51: aload_2
    //   52: athrow
    //   53: astore_1
    //   54: aload_3
    //   55: ifnonnull +5 -> 60
    //   58: aload_1
    //   59: athrow
    //   60: aload_3
    //   61: aload_1
    //   62: invokestatic 210	kotlin/ExceptionsKt:addSuppressed	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   65: aload_3
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	FastServiceLoader
    //   0	67	1	paramJarFile	java.util.jar.JarFile
    //   0	67	2	paramFunction1	kotlin.jvm.functions.Function1<? super java.util.jar.JarFile, ? extends R>
    //   4	62	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	21	27	java/lang/Throwable
    //   5	13	30	finally
    //   37	39	30	finally
    //   5	13	34	java/lang/Throwable
    //   43	47	53	java/lang/Throwable
  }
  
  @NotNull
  public final List<MainDispatcherFactory> loadMainDispatcherFactory$kotlinx_coroutines_core()
  {
    if (!FastServiceLoaderKt.getANDROID_DETECTED()) {
      return load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
    }
    try
    {
      localArrayList = new ArrayList(2);
    }
    catch (Throwable localThrowable)
    {
      ArrayList localArrayList;
      Object localObject;
      label65:
      break label134;
    }
    try
    {
      localObject = (MainDispatcherFactory)MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      break label65;
    }
    localObject = null;
    if (localObject != null) {
      localArrayList.add(localObject);
    }
    label134:
    try
    {
      localObject = (MainDispatcherFactory)MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
    }
    catch (ClassNotFoundException localClassNotFoundException2)
    {
      label115:
      break label115;
    }
    localObject = null;
    if (localObject != null) {
      localArrayList.add(localObject);
    }
    localObject = (List)localArrayList;
    return localObject;
    return load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
  }
  
  @NotNull
  public final <S> List<S> loadProviders$kotlinx_coroutines_core(@NotNull Class<S> paramClass, @NotNull ClassLoader paramClassLoader)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("META-INF/services/");
    ((StringBuilder)localObject1).append(paramClass.getName());
    localObject1 = Collections.list(paramClassLoader.getResources(((StringBuilder)localObject1).toString()));
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.util.Collections.list(this)");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (URL)((Iterator)localObject2).next();
      CollectionsKt.addAll((Collection)localObject1, (Iterable)INSTANCE.parse((URL)localObject3));
    }
    localObject1 = CollectionsKt.toSet((Iterable)localObject1);
    if ((((Collection)localObject1).isEmpty() ^ true))
    {
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        ((Collection)localObject1).add(INSTANCE.getProviderInstance((String)localObject3, paramClassLoader, paramClass));
      }
      return (List)localObject1;
    }
    paramClass = (Throwable)new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    for (;;)
    {
      throw paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.FastServiceLoader
 * JD-Core Version:    0.7.0.1
 */