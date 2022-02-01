package kotlin.reflect;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/KCallable;", "R", "Lkotlin/reflect/KAnnotatedElement;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isFinal", "isFinal$annotations", "isOpen", "isOpen$annotations", "isSuspend", "isSuspend$annotations", "name", "", "getName", "()Ljava/lang/String;", "parameters", "", "Lkotlin/reflect/KParameter;", "getParameters", "()Ljava/util/List;", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "typeParameters$annotations", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "visibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "call", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "callBy", "", "(Ljava/util/Map;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract interface KCallable<R>
  extends KAnnotatedElement
{
  public abstract R call(@NotNull Object... paramVarArgs);
  
  public abstract R callBy(@NotNull Map<KParameter, ? extends Object> paramMap);
  
  @NotNull
  public abstract String getName();
  
  @NotNull
  public abstract List<KParameter> getParameters();
  
  @NotNull
  public abstract KType getReturnType();
  
  @NotNull
  public abstract List<KTypeParameter> getTypeParameters();
  
  @Nullable
  public abstract KVisibility getVisibility();
  
  public abstract boolean isAbstract();
  
  public abstract boolean isFinal();
  
  public abstract boolean isOpen();
  
  public abstract boolean isSuspend();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.reflect.KCallable
 * JD-Core Version:    0.7.0.1
 */