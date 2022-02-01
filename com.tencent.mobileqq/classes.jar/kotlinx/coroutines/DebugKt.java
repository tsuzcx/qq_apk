package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"ASSERTIONS_ENABLED", "", "getASSERTIONS_ENABLED", "()Z", "COROUTINE_ID", "Ljava/util/concurrent/atomic/AtomicLong;", "getCOROUTINE_ID", "()Ljava/util/concurrent/atomic/AtomicLong;", "DEBUG", "getDEBUG", "DEBUG_PROPERTY_NAME", "", "DEBUG_PROPERTY_VALUE_AUTO", "DEBUG_PROPERTY_VALUE_OFF", "DEBUG_PROPERTY_VALUE_ON", "RECOVER_STACK_TRACES", "getRECOVER_STACK_TRACES", "STACKTRACE_RECOVERY_PROPERTY_NAME", "assert", "", "value", "Lkotlin/Function0;", "resetCoroutineId", "kotlinx-coroutines-core"}, k=2, mv={1, 1, 16})
public final class DebugKt
{
  private static final boolean ASSERTIONS_ENABLED = CoroutineId.class.desiredAssertionStatus();
  @NotNull
  private static final AtomicLong COROUTINE_ID;
  private static final boolean DEBUG;
  @NotNull
  public static final String DEBUG_PROPERTY_NAME = "kotlinx.coroutines.debug";
  @NotNull
  public static final String DEBUG_PROPERTY_VALUE_AUTO = "auto";
  @NotNull
  public static final String DEBUG_PROPERTY_VALUE_OFF = "off";
  @NotNull
  public static final String DEBUG_PROPERTY_VALUE_ON = "on";
  private static final boolean RECOVER_STACK_TRACES;
  @NotNull
  public static final String STACKTRACE_RECOVERY_PROPERTY_NAME = "kotlinx.coroutines.stacktrace.recovery";
  
  static
  {
    String str = SystemPropsKt.systemProp("kotlinx.coroutines.debug");
    boolean bool2 = false;
    boolean bool1;
    if (str != null)
    {
      int i = str.hashCode();
      if (i == 0) {
        break label93;
      }
      if (i == 3551) {
        break label81;
      }
      if (i != 109935) {
        if ((i != 3005871) || (!str.equals("auto"))) {
          break label145;
        }
      }
    }
    else
    {
      bool1 = ASSERTIONS_ENABLED;
      break label104;
    }
    if (str.equals("off"))
    {
      bool1 = false;
      label81:
      if (str.equals("on")) {
        label93:
        if (str.equals(""))
        {
          bool1 = true;
          label104:
          DEBUG = bool1;
          bool1 = bool2;
          if (DEBUG)
          {
            bool1 = bool2;
            if (SystemPropsKt.systemProp("kotlinx.coroutines.stacktrace.recovery", true)) {
              bool1 = true;
            }
          }
          RECOVER_STACK_TRACES = bool1;
          COROUTINE_ID = new AtomicLong(0L);
          return;
        }
      }
    }
    label145:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("System property 'kotlinx.coroutines.debug' has unrecognized value '");
    localStringBuilder.append(str);
    localStringBuilder.append('\'');
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString().toString()));
  }
  
  @InlineOnly
  private static final void jdMethod_assert(Function0<Boolean> paramFunction0)
  {
    if (getASSERTIONS_ENABLED())
    {
      if (((Boolean)paramFunction0.invoke()).booleanValue()) {
        return;
      }
      throw ((Throwable)new AssertionError());
    }
  }
  
  public static final boolean getASSERTIONS_ENABLED()
  {
    return ASSERTIONS_ENABLED;
  }
  
  @NotNull
  public static final AtomicLong getCOROUTINE_ID()
  {
    return COROUTINE_ID;
  }
  
  public static final boolean getDEBUG()
  {
    return DEBUG;
  }
  
  public static final boolean getRECOVER_STACK_TRACES()
  {
    return RECOVER_STACK_TRACES;
  }
  
  public static final void resetCoroutineId()
  {
    COROUTINE_ID.set(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.DebugKt
 * JD-Core Version:    0.7.0.1
 */