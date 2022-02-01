package kotlin;

import kotlin.jvm.JvmField;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/_Assertions;", "", "()V", "ENABLED", "", "ENABLED$annotations", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@PublishedApi
public final class _Assertions
{
  @JvmField
  public static final boolean ENABLED;
  public static final _Assertions INSTANCE;
  
  static
  {
    _Assertions local_Assertions = new _Assertions();
    INSTANCE = local_Assertions;
    ENABLED = local_Assertions.getClass().desiredAssertionStatus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin._Assertions
 * JD-Core Version:    0.7.0.1
 */