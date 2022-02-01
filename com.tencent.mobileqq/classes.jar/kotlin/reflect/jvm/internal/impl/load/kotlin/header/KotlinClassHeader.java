package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmBytecodeBinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KotlinClassHeader
{
  @NotNull
  private final JvmBytecodeBinaryVersion bytecodeVersion;
  @Nullable
  private final String[] data;
  private final int extraInt;
  private final String extraString;
  @Nullable
  private final String[] incompatibleData;
  @NotNull
  private final KotlinClassHeader.Kind kind;
  @NotNull
  private final JvmMetadataVersion metadataVersion;
  @Nullable
  private final String packageName;
  @Nullable
  private final String[] strings;
  
  public KotlinClassHeader(@NotNull KotlinClassHeader.Kind paramKind, @NotNull JvmMetadataVersion paramJvmMetadataVersion, @NotNull JvmBytecodeBinaryVersion paramJvmBytecodeBinaryVersion, @Nullable String[] paramArrayOfString1, @Nullable String[] paramArrayOfString2, @Nullable String[] paramArrayOfString3, @Nullable String paramString1, int paramInt, @Nullable String paramString2)
  {
    this.kind = paramKind;
    this.metadataVersion = paramJvmMetadataVersion;
    this.bytecodeVersion = paramJvmBytecodeBinaryVersion;
    this.data = paramArrayOfString1;
    this.incompatibleData = paramArrayOfString2;
    this.strings = paramArrayOfString3;
    this.extraString = paramString1;
    this.extraInt = paramInt;
    this.packageName = paramString2;
  }
  
  @Nullable
  public final String[] getData()
  {
    return this.data;
  }
  
  @Nullable
  public final String[] getIncompatibleData()
  {
    return this.incompatibleData;
  }
  
  @NotNull
  public final KotlinClassHeader.Kind getKind()
  {
    return this.kind;
  }
  
  @NotNull
  public final JvmMetadataVersion getMetadataVersion()
  {
    return this.metadataVersion;
  }
  
  @Nullable
  public final String getMultifileClassName()
  {
    String str = this.extraString;
    int i;
    if (this.kind == KotlinClassHeader.Kind.MULTIFILE_CLASS_PART) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return str;
    }
    return null;
  }
  
  @NotNull
  public final List<String> getMultifilePartNames()
  {
    String[] arrayOfString = this.data;
    int i;
    if (this.kind == KotlinClassHeader.Kind.MULTIFILE_CLASS) {
      i = 1;
    } else {
      i = 0;
    }
    List localList = null;
    if (i == 0) {
      arrayOfString = null;
    }
    if (arrayOfString != null) {
      localList = ArraysKt.asList(arrayOfString);
    }
    if (localList != null) {
      return localList;
    }
    return CollectionsKt.emptyList();
  }
  
  @Nullable
  public final String[] getStrings()
  {
    return this.strings;
  }
  
  public final boolean isPreRelease()
  {
    return (this.extraInt & 0x2) != 0;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.kind);
    localStringBuilder.append(" version=");
    localStringBuilder.append(this.metadataVersion);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader
 * JD-Core Version:    0.7.0.1
 */