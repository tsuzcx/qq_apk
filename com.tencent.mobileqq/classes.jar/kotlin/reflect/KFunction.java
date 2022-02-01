package kotlin.reflect;

import kotlin.Function;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/KFunction;", "R", "Lkotlin/reflect/KCallable;", "Lkotlin/Function;", "isExternal", "", "isExternal$annotations", "()V", "()Z", "isInfix", "isInfix$annotations", "isInline", "isInline$annotations", "isOperator", "isOperator$annotations", "isSuspend", "isSuspend$annotations", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract interface KFunction<R>
  extends Function<R>, KCallable<R>
{
  public abstract boolean isExternal();
  
  public abstract boolean isInfix();
  
  public abstract boolean isInline();
  
  public abstract boolean isOperator();
  
  public abstract boolean isSuspend();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.reflect.KFunction
 * JD-Core Version:    0.7.0.1
 */