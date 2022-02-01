package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.Arrays;
import kotlin.jvm.JvmField;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import org.jetbrains.annotations.NotNull;

public final class JvmMetadataVersion
  extends BinaryVersion
{
  public static final JvmMetadataVersion.Companion Companion = new JvmMetadataVersion.Companion(null);
  @JvmField
  @NotNull
  public static final JvmMetadataVersion INSTANCE = new JvmMetadataVersion(new int[] { 1, 1, 16 });
  @JvmField
  @NotNull
  public static final JvmMetadataVersion INVALID_VERSION = new JvmMetadataVersion(new int[0]);
  private final boolean isStrictSemantics;
  
  public JvmMetadataVersion(@NotNull int... paramVarArgs)
  {
    this(paramVarArgs, false);
  }
  
  public JvmMetadataVersion(@NotNull int[] paramArrayOfInt, boolean paramBoolean)
  {
    super(Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length));
    this.isStrictSemantics = paramBoolean;
  }
  
  public boolean isCompatible()
  {
    int i = getMajor();
    boolean bool3 = false;
    boolean bool2;
    if (i == 1)
    {
      bool2 = bool3;
      if (getMinor() == 0) {}
    }
    else
    {
      boolean bool1;
      if (this.isStrictSemantics) {
        bool1 = isCompatibleTo((BinaryVersion)INSTANCE);
      } else if ((getMajor() == 1) && (getMinor() <= 4)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      bool2 = bool3;
      if (bool1) {
        bool2 = true;
      }
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion
 * JD-Core Version:    0.7.0.1
 */