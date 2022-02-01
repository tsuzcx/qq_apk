package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.Arrays;
import kotlin.jvm.JvmField;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import org.jetbrains.annotations.NotNull;

public final class JvmBytecodeBinaryVersion
  extends BinaryVersion
{
  public static final JvmBytecodeBinaryVersion.Companion Companion = new JvmBytecodeBinaryVersion.Companion(null);
  @JvmField
  @NotNull
  public static final JvmBytecodeBinaryVersion INSTANCE = new JvmBytecodeBinaryVersion(new int[] { 1, 0, 3 });
  @JvmField
  @NotNull
  public static final JvmBytecodeBinaryVersion INVALID_VERSION = new JvmBytecodeBinaryVersion(new int[0]);
  
  public JvmBytecodeBinaryVersion(@NotNull int... paramVarArgs)
  {
    super(Arrays.copyOf(paramVarArgs, paramVarArgs.length));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmBytecodeBinaryVersion
 * JD-Core Version:    0.7.0.1
 */