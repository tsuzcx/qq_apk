package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import org.jetbrains.annotations.NotNull;

public class Flags$BooleanFlagField
  extends Flags.FlagField<Boolean>
{
  public Flags$BooleanFlagField(int paramInt)
  {
    super(paramInt, 1, null);
  }
  
  @NotNull
  public Boolean get(int paramInt)
  {
    int i = this.offset;
    boolean bool = true;
    if ((paramInt & 1 << i) == 0) {
      bool = false;
    }
    Boolean localBoolean = Boolean.valueOf(bool);
    if (localBoolean == null) {
      $$$reportNull$$$0(0);
    }
    return localBoolean;
  }
  
  public int toFlags(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue()) {
      return 1 << this.offset;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField
 * JD-Core Version:    0.7.0.1
 */