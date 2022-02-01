package kotlin.reflect.jvm.internal.calls;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "", "(Ljava/lang/String;I)V", "CALL_BY_NAME", "POSITIONAL_CALL", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public enum AnnotationConstructorCaller$CallMode
{
  static
  {
    CallMode localCallMode1 = new CallMode("CALL_BY_NAME", 0);
    CALL_BY_NAME = localCallMode1;
    CallMode localCallMode2 = new CallMode("POSITIONAL_CALL", 1);
    POSITIONAL_CALL = localCallMode2;
    $VALUES = new CallMode[] { localCallMode1, localCallMode2 };
  }
  
  private AnnotationConstructorCaller$CallMode() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.CallMode
 * JD-Core Version:    0.7.0.1
 */