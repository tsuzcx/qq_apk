package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.Map;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

public final class KotlinClassHeader$Kind$Companion
{
  @JvmStatic
  @NotNull
  public final KotlinClassHeader.Kind getById(int paramInt)
  {
    KotlinClassHeader.Kind localKind = (KotlinClassHeader.Kind)KotlinClassHeader.Kind.access$getEntryById$cp().get(Integer.valueOf(paramInt));
    if (localKind != null) {
      return localKind;
    }
    return KotlinClassHeader.Kind.UNKNOWN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind.Companion
 * JD-Core Version:    0.7.0.1
 */