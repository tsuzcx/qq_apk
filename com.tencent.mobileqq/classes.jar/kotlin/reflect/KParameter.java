package kotlin.reflect;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/KParameter;", "Lkotlin/reflect/KAnnotatedElement;", "index", "", "getIndex", "()I", "isOptional", "", "()Z", "isVararg", "isVararg$annotations", "()V", "kind", "Lkotlin/reflect/KParameter$Kind;", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "name", "", "getName", "()Ljava/lang/String;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "Kind", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract interface KParameter
  extends KAnnotatedElement
{
  public abstract int getIndex();
  
  @NotNull
  public abstract KParameter.Kind getKind();
  
  @Nullable
  public abstract String getName();
  
  @NotNull
  public abstract KType getType();
  
  public abstract boolean isOptional();
  
  public abstract boolean isVararg();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.reflect.KParameter
 * JD-Core Version:    0.7.0.1
 */