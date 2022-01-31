package kotlin;

import java.lang.annotation.Annotation;
import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmName;

@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
@java.lang.annotation.Target({java.lang.annotation.ElementType.TYPE})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/Metadata;", "", "kind", "", "metadataVersion", "", "bytecodeVersion", "data1", "", "", "data2", "extraString", "packageName", "extraInt", "bv", "()[I", "d1", "()[Ljava/lang/String;", "d2", "xi", "()I", "xs", "()Ljava/lang/String;", "k", "mv", "pn", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@kotlin.annotation.Target(allowedTargets={kotlin.annotation.AnnotationTarget.CLASS})
@SinceKotlin(version="1.3")
public @interface Metadata
{
  @JvmName(name="bv")
  int[] bv() default {};
  
  @JvmName(name="d1")
  String[] d1() default {};
  
  @JvmName(name="d2")
  String[] d2() default {};
  
  @JvmName(name="k")
  int k() default 1;
  
  @JvmName(name="mv")
  int[] mv() default {};
  
  @JvmName(name="pn")
  String pn() default "";
  
  @JvmName(name="xi")
  int xi() default 0;
  
  @JvmName(name="xs")
  String xs() default "";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.Metadata
 * JD-Core Version:    0.7.0.1
 */