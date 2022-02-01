package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.FlagField;

public final class JvmFlags
{
  public static final JvmFlags INSTANCE = new JvmFlags();
  private static final Flags.BooleanFlagField IS_MOVED_FROM_INTERFACE_COMPANION = Flags.FlagField.booleanFirst();
  
  public final Flags.BooleanFlagField getIS_MOVED_FROM_INTERFACE_COMPANION()
  {
    return IS_MOVED_FROM_INTERFACE_COMPANION;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmFlags
 * JD-Core Version:    0.7.0.1
 */