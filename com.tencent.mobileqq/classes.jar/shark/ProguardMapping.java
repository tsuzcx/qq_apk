package shark;

import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/ProguardMapping;", "", "()V", "obfuscatedToClearNamesMap", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "addMapping", "", "obfuscatedName", "clearName", "deobfuscateClassName", "obfuscatedClassName", "deobfuscateFieldName", "obfuscatedClass", "obfuscatedField", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class ProguardMapping
{
  private final LinkedHashMap<String, String> a = new LinkedHashMap();
  
  @NotNull
  public final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "obfuscatedClassName");
    String str = (String)this.a.get(paramString);
    if (str != null) {
      paramString = str;
    }
    return paramString;
  }
  
  @NotNull
  public final String a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "obfuscatedClass");
    Intrinsics.checkParameterIsNotNull(paramString2, "obfuscatedField");
    LinkedHashMap localLinkedHashMap = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append('.');
    localStringBuilder.append(paramString2);
    paramString1 = (String)localLinkedHashMap.get(localStringBuilder.toString());
    if (paramString1 != null) {
      return paramString1;
    }
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.ProguardMapping
 * JD-Core Version:    0.7.0.1
 */