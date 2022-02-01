package kotlin.reflect.jvm.internal.impl.metadata.builtins;

import java.util.Arrays;
import kotlin.jvm.JvmField;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import org.jetbrains.annotations.NotNull;

public final class BuiltInsBinaryVersion
  extends BinaryVersion
{
  public static final BuiltInsBinaryVersion.Companion Companion = new BuiltInsBinaryVersion.Companion(null);
  @JvmField
  @NotNull
  public static final BuiltInsBinaryVersion INSTANCE = new BuiltInsBinaryVersion(new int[] { 1, 0, 7 });
  @JvmField
  @NotNull
  public static final BuiltInsBinaryVersion INVALID_VERSION = new BuiltInsBinaryVersion(new int[0]);
  
  public BuiltInsBinaryVersion(@NotNull int... paramVarArgs)
  {
    super(Arrays.copyOf(paramVarArgs, paramVarArgs.length));
  }
  
  public boolean isCompatible()
  {
    return isCompatibleTo((BinaryVersion)INSTANCE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion
 * JD-Core Version:    0.7.0.1
 */