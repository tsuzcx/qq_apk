package kotlin.coroutines.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;

@Retention(RetentionPolicy.RUNTIME)
@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/jvm/internal/DebugMetadata;", "", "version", "", "sourceFile", "", "lineNumbers", "", "localNames", "", "spilled", "indexToLabel", "methodName", "className", "c", "()Ljava/lang/String;", "i", "()[I", "l", "n", "()[Ljava/lang/String;", "m", "f", "s", "v", "()I", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@kotlin.annotation.Target(allowedTargets={kotlin.annotation.AnnotationTarget.CLASS})
@SinceKotlin(version="1.3")
public @interface DebugMetadata
{
  @JvmName(name="c")
  String c() default "";
  
  @JvmName(name="f")
  String f() default "";
  
  @JvmName(name="i")
  int[] i() default {};
  
  @JvmName(name="l")
  int[] l() default {};
  
  @JvmName(name="m")
  String m() default "";
  
  @JvmName(name="n")
  String[] n() default {};
  
  @JvmName(name="s")
  String[] s() default {};
  
  @JvmName(name="v")
  int v() default 1;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.coroutines.jvm.internal.DebugMetadata
 * JD-Core Version:    0.7.0.1
 */